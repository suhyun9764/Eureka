package config;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.Set;

import static config.ConfigConstants.KAKAO_API_KEY;

public class BookCrawler {
    private static final BookCrawler instance = new BookCrawler();

    public static BookCrawler getInstance() {
        return instance;
    }

    public void crawl(Connection connection) {
        String[] searchQueries = generateSearchQueries();
        Set<String> ISBNs = new HashSet<>();
        try {
            for (String query : searchQueries) {
                for (int page = 1; page <= 200; page++) {
                    String jsonResponse = fetchBooksFromAPI(query, page);
                    if (jsonResponse == null) break; // API 응답 오류 시 중단
                    int insertedCount = saveBooksToDatabase(jsonResponse, connection, ISBNs);
                    if (insertedCount == 0) break; // 더 이상 데이터가 없으면 다음 검색어로
                }
            }
            connection.close();
            System.out.println("크롤링 완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String[] generateSearchQueries() {
        StringBuilder sb = new StringBuilder();
        for (char c = '가'; c <= '힣'; c += 30)
            sb.append(c).append(",");
        for (char c = 'A'; c <= 'Z'; c++)
            sb.append(c).append(",");
        for (int i = 0; i <= 9; i++)
            sb.append(i).append(",");

        return sb.toString().split(",");
    }

    // ✅ API 호출 - URL 인코딩 추가 + 응답 코드 확인
    private String fetchBooksFromAPI(String query, int page) {
        try {
            String encodedQuery = URLEncoder.encode(query, "UTF-8"); // 한글 URL 인코딩
            String apiUrl = "https://dapi.kakao.com/v3/search/book?query=" + encodedQuery + "&size=50&page=" + page;
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "KakaoAK " + KAKAO_API_KEY);

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                br.close();
                return response.toString();
            } else {
                System.err.println("❌ API 요청 실패: " + responseCode);
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                String errorResponse = br.readLine();
                System.err.println("Error Response: " + errorResponse);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ✅ 데이터 저장 - ISBN 검증 추가
    private int saveBooksToDatabase(String jsonResponse, Connection conn, Set<String> processedISBNs) {
        int insertedCount = 0;
        try {
            String sql = "INSERT INTO books (title, authors, publisher, isbn, datetime, price) VALUES (?, ?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE title=VALUES(title), authors=VALUES(authors), publisher=VALUES(publisher), datetime=VALUES(datetime), price=VALUES(price)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray documents = jsonObject.getJSONArray("documents");

            for (int i = 0; i < documents.length(); i++) {
                JSONObject book = documents.getJSONObject(i);
                String isbn = book.optString("isbn");

                // ✅ ISBN이 없는 경우 스킵
                if (isbn.isEmpty() || processedISBNs.contains(isbn)) {
                    continue;
                }

                processedISBNs.add(isbn);

                pstmt.setString(1, book.optString("title", "제목 없음"));
                pstmt.setString(2, String.join(", ", book.optJSONArray("authors") != null ? book.getJSONArray("authors").toList().toArray(new String[0]) : new String[]{"저자 미상"}));
                pstmt.setString(3, book.optString("publisher", "출판사 미상"));
                pstmt.setString(4, isbn);
                pstmt.setString(5, book.optString("datetime", "1970-01-01T00:00:00").replace("T", " ").substring(0, 19));
                pstmt.setInt(6, book.optInt("price", 0));

                pstmt.executeUpdate();
                insertedCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insertedCount;
    }
}
