import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Coding3 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sortArray(new int[] {6,1,4,2,3,7,9,8})));
        System.out.println(Arrays.toString(revArray(new int[] {1,2,3,4,5,6,7,8,9,10})));
        System.out.println(Arrays.toString(plusTwo(new int[] {10,20,30,40,50}, 70)));
        System.out.println(Arrays.toString(plusTwo(new String[] {"a","b","c"}, new String[] {"d","e","f"})));
        countChars("Software Engineer");
        System.out.println("======================================");
        System.out.println(countCharsMap("SoftwareEngineer"));
        System.out.println(countWholeWord("apple apple kiwi kiwi kiwi banana"));

    }
    public static int[] sortArray(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    int swap = num[i];
                    num[i] = num[j];
                    num[j] = swap;
                }
            }
        }
        return num;
    }
    public static int[] revArray(int[] num) {
        int j = num.length-1;
        for (int i = num.length/2; i>=0; i--) {
            int swap = num[i];
            num[i] = num[j-i];
            num[j-i] = swap;
        }
        return num;
    }
    public static int[] plusTwo(int[] num, int target) {
        int[] res = new int[2];
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                if (num[i] + num[j] == target) {
                    res[0] = num[i];
                    res[1] = num[j];
                }
            }
        }
        return res;
    }
    public static String[] plusTwo(String[] str, String[] str1) {
        String[] str2 = new String[str.length + str1.length];
        int i = 0;
        for (i = 0; i < str.length; i++) {
            str2[i] = str[i];
        }
        for (int j = 0; j < str1.length; j++) {
            str2[i] = str1[j];
            i++;
        }
        return str2;
    }
    public static void countChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    System.out.print(str.charAt(j));
                }
            }
        }
    }
    public static Map<Character,Integer> countCharsMap(String str) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (Character hold:str.toCharArray()) {
            if (map.containsKey(hold)) {
                map.put(hold, map.get(hold) + 1);
            }else {
                map.put(hold, 1);
            }
        }
        return map;
    }
    public static Map<String,Integer> countWholeWord(String str) {
        Map<String,Integer> map = new LinkedHashMap<>();
        String[] hold = str.split(" ");
        for (String word:hold) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }else {
                map.put(word, 1);
            }
        }
        return map;
    }
}
