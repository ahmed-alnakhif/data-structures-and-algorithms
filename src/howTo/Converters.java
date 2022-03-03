package howTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converters {

  public static void ListToArray() {
    List<Integer> intList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    int[] intArray = intList.stream().mapToInt(i -> i).toArray();

    List<String> stringList = new ArrayList<String>(Arrays.asList("Apple", "Orange", "Banana"));
    String[] stringArray = stringList.stream().toArray(String[]::new);
  }

  public static void ArrayToList() {
    int[] intArray = { 1, 2, 3, 4, 5 };
    List<Integer> intList = Arrays.stream(intArray).boxed().collect(Collectors.toList());

    String[] stringArray = { "Apple", "Orange", "Banana" };
    List<String> stringList = Arrays.asList(stringArray);
  }

  public static void main(String[] args) {
    
  }
}
