import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AdvertisementMessage {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        List<String> phrases = new ArrayList<>(Arrays.asList("Excellent product.", "Such a great product.", "I always use that product.",
                                                             "Best product of its category.",
                                                             "Exceptional product.", "I can’t live without this product."));
        List <String> events = new ArrayList<>(Arrays.asList("Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                                                             "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"));

        List<String> authors = new ArrayList<>(Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"));

        List<String> cities = new ArrayList<>(Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"));

        int n = Integer.parseInt(read.readLine());

        for (int i = 0; i < n; i++) {
            Collections.shuffle(phrases);
            Collections.shuffle(events);
            Collections.shuffle(authors);
            Collections.shuffle(cities);
            System.out.printf("%s %s %s – %s\n", phrases.get(0),events.get(0),authors.get(0),cities.get(0));
        }

    }
}
