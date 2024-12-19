package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
   public static List<String> buildApartmentsList(List<Home> apartments, int n) {
       List<Home> tempList = new ArrayList<>(apartments);
       tempList.sort(Comparator.comparing(Home::getArea));

       List<String> sortedList = new ArrayList<>();

       for (int i = 0; i < n; i++) {
           sortedList.add(tempList.get(i).toString());
       }
       return sortedList;
   }

    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));
        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result);
    }
}
// END
