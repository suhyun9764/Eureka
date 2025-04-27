import config.AppConfig;
import config.BookCrawler;
import config.ConfigConstants;

import java.sql.Connection;

public class Application {
    public static void main(String[] args) {
        BookCrawler bookCrawler = BookCrawler.getInstance();

        // 1. DB Connection 생성
        AppConfig appConfig = new AppConfig();
        Connection connection = appConfig.getDBConnection(ConfigConstants.DB_URL, ConfigConstants.DB_USER, ConfigConstants.DB_PASSWORD);

        bookCrawler.crawl(connection);
    }
}
