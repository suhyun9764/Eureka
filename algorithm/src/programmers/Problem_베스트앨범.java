package programmers;

import java.util.*;

public class Problem_베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] play = {500,600,150,800,2500};
        Solution solution = new Solution();
        int[] answer = solution.solution(genres, play);
        System.out.println(Arrays.toString(answer));
    }

    /*
    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
     */
    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            List<Genre> genreList = new ArrayList<>();
            Set<String> genreSet = new HashSet<>();
            for (int i=0;i< genres.length;i++) {
                String genre = genres[i];
                int playNumber = plays[i];
                // 이미 장르가 저장된지 확인
                if(!genreSet.contains(genre)) {
                    // 장르가 없다면 추가
                    genreSet.add(genre);
                    genreList.add(new Genre(genre));
                }
                // 장르에 해당 음악 넣기
                for (Genre currentGenre : genreList) {
                    if(currentGenre.name.equals(genre))
                        currentGenre.addMusic(new Music(i,playNumber));
                }
            }

            // 4. genreList 총 재생횟수가 많은 순으로 정렬
            Collections.sort(genreList, new Comparator<Genre>() {
                @Override
                public int compare(Genre o1, Genre o2) {
                    return o2.getTotalPlayNumber()-o1.getTotalPlayNumber();
                }
            });

            List<Integer> bestAlbum = new ArrayList<>();
            // 5. genreList 순회하며 장많이 재생된 노래(같다면 고유번호가 낮은순으로)부터 answer에 담기
            for (Genre genre : genreList) {
                PriorityQueue<Music> musicList = genre.getMusicList();
                if (musicList.size()==1){
                    bestAlbum.add(musicList.poll().id);
                    continue;
                }

                for(int i=0;i<2;i++){
                    bestAlbum.add(musicList.poll().id);
                }
            }
            int[] answer = new int[bestAlbum.size()];
            for(int i=0;i<answer.length;i++){
                answer[i] = bestAlbum.get(i);
            }
            return answer;
        }

        static class Music{
            int id;
//            Genres genres;
            int playNumber;

            public Music(int id, int playNumber) {
                this.id = id;
//                this.genres = genres;
                this.playNumber = playNumber;
            }
        }

        static class Genre {
            String name;
            PriorityQueue<Music> musicList = new PriorityQueue<>(new Comparator<Music>() {
                @Override
                public int compare(Music o1, Music o2) {
                    if(o1.playNumber== o2.playNumber)
                        return o1.id- o2.id;

                    return o2.playNumber-o1.playNumber;
                }
            });

            public Genre(String name) {
                this.name = name;
            }

            public void addMusic(Music music){
                musicList.add(music);
            }

            public int getTotalPlayNumber(){
                return musicList.stream()
                        .mapToInt(x -> x.playNumber)
                        .sum();
            }

            public PriorityQueue<Music> getMusicList() {
                return musicList;
            }
        }
    }
}
