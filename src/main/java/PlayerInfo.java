package src.main.java;

public class PlayerInfo {
    private String id;
    
    private String name;
    
    private int rating;

    private String char_short;

    private String character;

    private int match_count;

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public String getChar_short() {
        return char_short;
    }

    public String getCharacter() {
        return character;
    }  

    public int getMatch_count() {
        return match_count;
    }

    public String toString() {
        return "PlayerInfo [id=" + id + ", name=" + name + ", rating=" + rating + ", char_short=" + char_short
                + ", character=" + character + ", match_count=" + match_count + "]";
    }

}
