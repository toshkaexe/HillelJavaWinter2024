package scout24;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class Scout24 {

    public static String bestInGenre(String genre) {
        String baseUrl = "https://jsonmock.hackerrank.com/api/tvseries";
        int currentPage = 1;
        double highestRating = Double.MIN_VALUE;
        String lowestName = "";
        String highestRatedShow = "";

        try {
            while (true) {
                URL url = new URL(baseUrl + "?page=" + currentPage);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray data = jsonResponse.getJSONArray("data");

                for (int i = 0; i < data.length(); i++) {
                    JSONObject series = data.getJSONObject(i);
                    String seriesGenre = series.getString("genre");
                    if (seriesGenre.contains(genre)) {
                        double imdbRating = series.getDouble("imdb_rating");
                        String seriesName = series.getString("name");
                        if (imdbRating > highestRating || (imdbRating == highestRating && seriesName.compareTo(lowestName) < 0)) {
                            highestRating = imdbRating;
                            lowestName = seriesName;
                            highestRatedShow = seriesName;
                        }
                    }
                }

                int totalPages = jsonResponse.getInt("total_pages");
                if (currentPage >= totalPages) {
                    break;
                } else {
                    currentPage++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return highestRatedShow;
    }

    public static void main(String[] args) {
        String genre = "Action";
        String bestSeries = bestInGenre(genre);
        System.out.println(bestSeries);
    }
}

