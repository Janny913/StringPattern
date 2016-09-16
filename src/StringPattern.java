import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 * Created by jianiyang on 16/9/15.
 */

/**
 *Problem Description: Given a Pattern and a dictionary, print out all the strings that match the pattern.
 *where a character in the pattern is mapped uniquely to a character in the dictionary ( this is what i was given first).
 * e.g. ("acc", <"cdf", "too", "paa", "hdfsa">) -> Output: "too", "paa"
 */

/**
 * The following is my algorithm and some test cases. For Time complexity, if we assume that the strings in the dictionary
 * have the equal length m, and the dictionary's size is n. Then it is O(n*m).
 */
public class StringPattern {
    public static List<String> stringPattern(String pattern, List<String> dict){
        List<String> res = new ArrayList<>();
        //corner case check
        if (dict == null || dict.size() == 0)
            return res;
        if (pattern == null || pattern.length() == 0)
            return res;

        String patternNum = encode(pattern);     //Encode pattern to particular digit sequence

        for (String s : dict){
            if (s.length() != pattern.length())  //Check if the length of pattern and string in dictionary are equal
                continue;                        //To avoid the bug like "abcdefghijk" has the same encode with "abcdefghijaa"
            if (encode(s).equals(patternNum))
                res.add(s);
        }

        return res;
    }

    private static String encode(String target){
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        int flag = 1;

        //When meeting a new char, put it and flag into map, increase flag by 1
        for (char c : target.toCharArray()){
            if (!map.containsKey(c)){
                map.put(c, flag++);
            }
            sb.append(map.get(c));
        }

        return sb.toString();
    }

    private static List<String> dictGenerator(String[] array){
        List<String> res = new ArrayList<>(Arrays.asList(array));
        return res;
    }

    public static void main(String[] args){
        String pattern = "acbc";
        String[] array_01 = {""};
        String[] array_02 = {"ACDC", "acbd", "CBaB", "abcdfs"};
        List<String> res_01 = stringPattern(pattern, dictGenerator(array_01));
        List<String> res_02 = stringPattern(pattern, dictGenerator(array_02));

        System.out.println("test_01:");
        for (String s : res_01){
            System.out.println(s);
        }

        System.out.println("test_02:");
        for (String s : res_02){
            System.out.println(s);
        }

    }
}
