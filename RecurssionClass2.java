import java.util.*;

public class RecurssionClass2 {
    public static boolean[] map = new boolean[26];
    public static void removeDuplicate(String str, int index, String newString){
        if(index == str.length()){
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(index);
        if(map[currChar -'a'] == true){
            removeDuplicate(str, index+1, newString);
        }else{
            newString += currChar;
            map[currChar - 'a'] = true;
            removeDuplicate(str, index+1, newString);
        }
    }
    
    public static void subSequences(String str, int index, String newString){
        if(index == str.length()){
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(index);
        
        subSequences(str, index+1, newString+currChar);
        subSequences(str, index+1, newString);
    }

    public static void uniqueSubSequences(String str, int index, String newString, HashSet<String> set){
        if(index == str.length()){
            if(set.contains(newString)){
                return;
            }
            else{
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        char currChar = str.charAt(index);
        
        uniqueSubSequences(str, index+1, newString+currChar, set);
        uniqueSubSequences(str, index+1, newString, set);
    }

    public static String[] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void printComb(String str, int index, String combinition){
        if(index == str.length()){
            System.out.println(combinition); 
            return;
        }
        char currChar = str.charAt(index);
        String mapping = keypad[currChar - '0'];

        for(int i=0; i<mapping.length(); i++){
            printComb(str, index+1, combinition+mapping.charAt(i));
        }
    }
    public static void main(String[] args) {
        // String str = "abbccda";
        // removeDuplicate(str, 0, "");

        // String str = "ABC";
        // subSequences(str, 0, "");

        // String str = "AAA";
        // HashSet<String> set = new HashSet<>();
        // uniqueSubSequences(str, 0, "", set);

        String str = "23";
        printComb(str, 0, "");
    }
}
