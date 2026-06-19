package hashmatique;



import java.util.HashMap;
import java.util.Set;

public class Hashmatique {

    public static void main(String[] args) {

        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("Starlight", "Far away, this ship is taking me far away");
        trackList.put("Uprising", "They will not force us");
        trackList.put("Madness", "I need your love");
        trackList.put("Time Is Running Out", "I think I'm drowning");

        String lyrics = trackList.get("Uprising");

        System.out.println("One Song:");
        System.out.println("Uprising: " + lyrics);

        System.out.println();

        System.out.println("All Tracks:");

        Set<String> keys = trackList.keySet();

        for (String key : keys) {
            System.out.println(key + ": " + trackList.get(key));
        }
    }
}