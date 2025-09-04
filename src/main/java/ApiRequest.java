
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
//import java.util.concurrent.CompletableFuture;
import java.util.Scanner;
//import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

//Learn how to parse JSON in java

//mvn exec:java "-Dexec.mainClass=ApiRequest" (Do this command to run the code)
//Use 210611072342011231 to test (This is Zando's ID)

public class ApiRequest {
    //READ THROUGH API.YOML to see if there's anything else I can do
    public static void main(String[] args) throws IOException, InterruptedException{

        String baseURL = "https://puddle.farm/api/player/";
        //Maybe find way to display info based on name, maybe make another request to find ID from name
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please type below your Rating Update User ID: ");
        String userID = scanner.nextLine();

        String finalURL = baseURL + userID;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .GET()
        .header("accept", "application/json")
        .uri(URI.create(finalURL))
        .build(); 

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        //response.body is the string of info, bodyHandlers handle what is returned in response body

        //Parsing JSON into objects
        ObjectMapper objectMapper = new ObjectMapper();
        // PlayerInfo playerInfo = objectMapper.readValue(response.body(), PlayerInfo.class);
        // System.out.println(playerInfo);

       

        // Json makes output more legible
        Object json = objectMapper.readValue(response.body(), Object.class);
        String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        System.out.println(prettyJson);

        scanner.close();
    }
}
