import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        try {
            String jsonStr = readUrl("https://cat-fact.herokuapp.com/facts");
            Map<String, Collection<Post>> all = mapper.readValue(jsonStr, new TypeReference<Map<String, Collection<Post>>>(){});
            Collection<Post> posts = all.get("all");

            posts.stream().filter(value -> value.getUpvotes() != 0)
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
