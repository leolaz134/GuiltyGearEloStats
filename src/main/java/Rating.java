//sub object for rating details
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rating{
    private int rating;
    
    private String character;

    private int match_count;

    public int getRating() {
        return rating;
    }

    public String getCharacter() {
        return character;
    }

    public int getMatch_count() {
        return match_count;
    }

}