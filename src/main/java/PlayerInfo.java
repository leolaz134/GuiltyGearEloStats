
import java.util.List;
//If new fields are added to the JSON response that are not in this class, 
//ignore them during deserialization
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
//Root Object that maps to JSON response
public class PlayerInfo {
    private long id;
    
    private String name;
    
    private List<Ratings> ratings;

    private String platform;

    private int top_global;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Ratings> getRatings() {
        return ratings;
    }

    public String getPlatform() {
        return platform;
    }

    public int getTop_global() {
        return top_global;
    }
}



