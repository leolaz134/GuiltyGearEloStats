
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
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

        //This is done synchronously rather than asynchronously
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        //response.body is the string of info, bodyHandlers handle what is returned in response body

        //Parsing JSON into objects
        ObjectMapper objectMapper = new ObjectMapper();

        //Prints out raw json data
        // PlayerInfo playerInfo = objectMapper.readValue(response.body(), PlayerInfo.class);
        // System.out.println(playerInfo);

        // prints out pretty Json data thats legible
        // Object json = objectMapper.readValue(response.body(), Object.class);
        // String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        // System.out.println(prettyJson);

        //Gets json data and maps it to a PlayerInfo object and prints out some variables
        PlayerInfo playerInfo = objectMapper.readValue(response.body(), PlayerInfo.class);
        System.out.println("Player Name: " + playerInfo.getName());
        System.out.println("This User Plays: ");
        List<Ratings> ratings = playerInfo.getRatings();
        for(Ratings rating : ratings){ 
            if(rating.getRating() > 10000000){
                System.out.println(" Character: " + rating.getCharacter() + " | Rating: " + (rating.getRating() - 10000000));
            } else{
                System.out.println(" Character: " + rating.getCharacter() + " | Rating: " + rating.getRating());
            }
        }



        scanner.close();
    }
}
