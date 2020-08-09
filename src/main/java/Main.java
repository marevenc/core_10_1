import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Main {

    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
//        CloseableHttpClient httpClient = HttpClientBuilder.create()
//                .setDefaultRequestConfig(RequestConfig.custom()
//                        .setConnectTimeout(5000)
//                        .setSocketTimeout(30000)
//                        .setRedirectsEnabled(false)
//                        .build())
//                .build();

        //HttpGet request = new HttpGet("https://cat-fact.herokuapp.com/facts");

//        CloseableHttpResponse response = httpClient.execute(request);
//        Arrays.stream(response.getAllHeaders()).forEach(System.out::println);
        try {
            String jsonStr = readUrl("https://cat-fact.herokuapp.com/facts");
            System.out.println(jsonStr);
            Map<String, Collection<Post>> all = mapper.readValue(jsonStr, new TypeReference<Map<String, Collection<Post>>>(){});
            Collection<Post> posts = all.get("all");
            posts.forEach(System.out::println);
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
