package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
   public static List<String> buildApartmentsList(List<Home> apartments, int n) {
       if (n > apartments.size()) {
           return new ArrayList<String>();
       }
       List<Home> tempList = new ArrayList<>(apartments);
       tempList.sort(Comparator.comparing(Home::getArea));

       List<String> sortedList = new ArrayList<>();

       for (int i = 0; i < n; i++) {
           sortedList.add(tempList.get(i).toString());
       }
       return sortedList;
   }
}
// END
