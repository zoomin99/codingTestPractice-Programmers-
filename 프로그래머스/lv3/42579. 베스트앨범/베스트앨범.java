import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    class Song implements Comparable<Song> {
        int num;
        int playTimes;

        public Song(int num, int playTimes) {
            this.num = num;
            this.playTimes = playTimes;
        }

        @Override
        public int compareTo(Song o) {
            return o.playTimes - this.playTimes;
        }
    }

    class GenreType implements Comparable<GenreType> {
        ArrayList<Song> songList = new ArrayList<Song>();
        int totalPlayTimes;

        void setTotalPlayTimes() {
            int totalPlayTimes = 0;
            for (Song song : songList) {
                totalPlayTimes += song.playTimes;
            }
            this.totalPlayTimes = totalPlayTimes;
        }

        @Override
        public int compareTo(GenreType o) {
            return o.totalPlayTimes - this.totalPlayTimes;
        }

        @Override
        public String toString() {
            return "GenreType{" +
                    "songList=" + songList +
                    ", totalPlayTimes=" + totalPlayTimes +
                    '}';
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> genreMap = new HashMap<String, Integer>();
        ArrayList<Song> songList = new ArrayList<Song>();
        ArrayList<GenreType> genreTypeList = new ArrayList<GenreType>();

        int count = 0;
        for (int i = 0; i < genres.length; i++) {
            if (!(genreMap.containsKey(genres[i]))) {
                genreMap.put(genres[i], count);
                genreTypeList.add(new GenreType());
                genreTypeList.get(count).songList.add(new Song(i, plays[i]));
                count++;
            } else {
                int index = 0;
                for (String key : genreMap.keySet()) {
                    if (genres[i].equals(key)) {
                        index = genreMap.get(key);
                    }
                }
                genreTypeList.get(index).songList.add(new Song(i, plays[i]));
            }
        }

        for (GenreType genreType : genreTypeList) {
            Collections.sort(genreType.songList);
            genreType.setTotalPlayTimes();
        }

        Collections.sort(genreTypeList);


        ArrayList<Integer> answerList = new ArrayList<Integer>();


        for (GenreType genreType : genreTypeList) {
            answerList.add(genreType.songList.get(0).num);
            if (genreType.songList.size() != 1) {
                answerList.add(genreType.songList.get(1).num);
            }
        }

        int[] answer = answerList.stream()
                .mapToInt(i -> i)
                .toArray();


        return answer;
    }
}