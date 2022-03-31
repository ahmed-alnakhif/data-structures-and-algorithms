package Companies.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a map Map<String, List<String>> userSongs with user names as keys and a
 * list of all the songs that the user has listened to as values.
 * 
 * Also given a map Map<String, List<String>> songGenres, with song genre as
 * keys and a list of all the songs within that genre as values. The song can
 * only belong to only one genre.
 * 
 * The task is to return a map Map<String, List<String>>, where the key is a
 * user name and the value is a list of the user's favorite genre(s). Favorite
 * genre is the most listened to genre. A user can have more than one favorite
 * genre if he/she has listened to the same number of songs per each of the
 * genres.
 * 
 * Input:
 * userSongs = {
 * "David": ["song1", "song2", "song3", "song4", "song8"],
 * "Emma": ["song5", "song6", "song7"]
 * },
 * songGenres = {
 * "Rock": ["song1", "song3"],
 * "Dubstep": ["song7"],
 * "Techno": ["song2", "song4"],
 * "Pop": ["song5", "song6"],
 * "Jazz": ["song8", "song9"]
 * }
 * 
 * Output: {
 * "David": ["Rock", "Techno"],
 * "Emma": ["Pop"]
 * }
 * 
 * Explanation:
 * David has 2 Rock, 2 Techno and 1 Jazz song. So he has 2 favorite genres.
 * Emma has 2 Pop and 1 Dubstep song. Pop is Emma's favorite genre
 */

public class FavoriteGenres {

    //T: O(U*(G + S),  S: O(S)
    public Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs,
            Map<String, List<String>> songGenres) {
        Map<String, List<String>> result = new HashMap<>();
        Map<String, String> songToGenre = new HashMap<>();

        //O(S + G)
        for (String genre : songGenres.keySet()) {
            for (String song : songGenres.get(genre)) {
                songToGenre.put(song, genre);
            }
        }


        //O(U * S)
        for (String user : userSongs.keySet()) {
            Map<String, Integer> countMap = new HashMap<>();
            int max = 0;

            for (String song : userSongs.get(user)) {
                String genre = songToGenre.get(song);
                if (genre != null) {
                    countMap.put(genre, countMap.getOrDefault(genre, 0) + 1);
                    max = Math.max(max, countMap.get(genre));
                }
            }

            result.put(user, new ArrayList<>());

            for (String genre : countMap.keySet()) {
                if (max == countMap.get(genre)) {
                    result.get(user).add(genre);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FavoriteGenres f = new FavoriteGenres();

        Map<String, List<String>> userSongs1 = new HashMap<>();
        userSongs1.put("David", List.of("song1", "song2", "song3", "song4",
                "song8"));
        userSongs1.put("Emma", List.of("song5", "song6", "song7"));
        Map<String, List<String>> songGenres1 = new HashMap<>();
        songGenres1.put("Rock", List.of("song1", "song3"));
        songGenres1.put("Dubstep", List.of("song7"));
        songGenres1.put("Techno", List.of("song2", "song4"));
        songGenres1.put("Pop", List.of("song5", "song6"));
        songGenres1.put("Jazz", List.of("song8", "song9"));
        System.out.println(f.favoriteGenres(userSongs1, songGenres1));

        Map<String, List<String>> userSongs2 = new HashMap<>();
        userSongs2.put("David", List.of("song1", "song2"));
        userSongs2.put("Emma", List.of("song5", "song6"));
        Map<String, List<String>> songGenres2 = new HashMap<>();

        System.out.println(f.favoriteGenres(userSongs2, songGenres2));
    }
}
