package howTo;

import java.util.LinkedList;
import java.util.List;

public class ParseNumber {

    List<Integer> parseInteger(int num) {
        LinkedList<Integer> result = new LinkedList<>();

        while (num > 1) {
            int digit = num % 10;
            num = num / 10;
            result.addFirst(digit);
        }

        return result;
    }

    //Not working!! 
    List<List<Integer>> parseDecimal(double num) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> integersList = new LinkedList<>();
        LinkedList<Integer> decimalList = new LinkedList<>();

        while (num > 1) {
            double digit = num % 10;
            num = num / 10;
            integersList.addFirst((int)digit);
        }
        result.add(integersList);

        System.out.println(num);
        while(num != 0){
            int tmp = (int)(num * 10);
            num = num - tmp;
        }


        return result;
    }

    public static void main(String[] args) {
        int num = 54321;
        ParseNumber p = new ParseNumber();
        System.out.println(p.parseInteger(num));
    }
}
