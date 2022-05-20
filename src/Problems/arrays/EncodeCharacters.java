package Problems.arrays;

public class EncodeCharacters {

    public static String getEncode(String str){
        StringBuilder result = new StringBuilder();

        int count = 1;
        for(int i = 0 ; i < str.length(); i++){
            char currChar = str.charAt(i);

            if(i+1 < str.length() && currChar == str.charAt(i+1)){
                count++;
            } else {
                result.append(currChar);
                result.append(count);
                count = 1;
            }
        }

        return result.toString();
    } 

    public static String getDecode(String str){
        StringBuilder result = new StringBuilder();

        char currChar = ' ';
        for(char ch : str.toCharArray()){
            if(Character.isAlphabetic(ch)){
              currChar = ch;  
            } else if(Character.isDigit(ch) && Character.isDefined(currChar)) {
                for(int i = 0; i<Integer.parseInt(String.valueOf(ch)); i++){
                    result.append(currChar);
                }
            }
        }

        return result.toString();
    }

    public static void main(String [] args) {
        System.out.println(getEncode("aaabbc"));
        System.out.println(getEncode(""));
        System.out.println(getEncode("aaaaaa"));
        System.out.println(getEncode("a"));
        System.out.println(getEncode("aabaaa"));

        System.out.println(getDecode("a3b2c1"));
    }
}
