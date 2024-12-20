package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(Map<String, String> map) {
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            tempMap.put(entry.getValue(), entry.getKey());
        }
        map.clear();

        for (Entry<String, String> entry : tempMap.entrySet()) {
            map.put(String.valueOf(entry.getKey()), entry.getValue());
        }
    }
}
// END
