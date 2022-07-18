import java.util.*;
import java.util.function.Function;

public class Coding2 {

    public static void main(String[] args) {

        System.out.println(revStr("apple"));
        System.out.println(revWord("Java is cool"));
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(revList(list));
        System.out.println(revConInt(12345));
        System.out.println(remDup("apple"));
        System.out.println(Arrays.toString(revArray(new int[] {1,2,3,4,5,6,7,8,9,10})));
        System.out.println(Arrays.toString(plusTwo(new int[] {10,20,30,40,50,60}, 70)));
        System.out.println(Arrays.toString(sortArray(new int[] {3,1,4,2,8,5,6,9})));
        countSameChars("Software Engineer");
        System.out.println("===============================");
        int[] num = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(findMax(num));
        System.out.println(pollyndrom("civic"));
        System.out.println(annagram("apple", "pelap"));
        System.out.println(countCharsMap("apple"));

    }
    public static String revStr(String str) {
        String empty = "";
        for (int i = str.length()-1; i>=0; i--) {
            empty += str.charAt(i);
        }
        return empty;
    }
    public static String revWord(String str) {
        String empty = "";
        String[] word = str.split(" ");
        for (int i = word.length-1; i>=0; i--) {
            empty += word[i] + " ";
        }
        return empty;
    }
    public static List<Integer> revList(List<Integer> path) {
        List<Integer> list = new ArrayList<>();
        for (int i = path.size()-1; i>=0; i--) {
            list.add(path.get(i));
        }
        return list;
    }
    public static String revConInt(int num) {
        String empty = "";
        String hold = String.valueOf(num);
        for (int i = hold.length()-1; i>=0; i--) {
            empty += hold.charAt(i);
        }
        return empty;
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

    public static String remDup(String str) {
        String empty = "";
        for (int i = 0; i < str.length(); i++) {
            String hold = String.valueOf(str.charAt(i));
            if (!empty.contains(hold)) {
                empty += hold;
            }
        }
        return empty;
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
    public static int[] sortArray(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if (num[i] > num[j]) {
                    int swap = num[i];
                    num[i] = num[j];
                    num[j] = swap;
                }
            }
        }
        return num;
    }
    public static void countSameChars(String str) {
        for (int i = 0; i < str.length()-1; i++) {
            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    System.out.print(str.charAt(j));
                }

            }
        }
    }
    public static int findMax(int[] num) {
        int max = num[0];
        for (int i = 0; i < num.length; i++) {
            if (max < num[i]) {
                max = num[i];
            }
        }
        int secondMax = Integer.MIN_VALUE;
        for (int hold:num) {
            if (hold > secondMax && hold < max) {
                secondMax = hold;
            }
        }
        return secondMax;
    }
    public static boolean pollyndrom(String str) {
        String empty = "";
        for (int i = str.length()-1; i>=0; i--) {
            empty += str.charAt(i);
        }
        return empty.equals(str);
    }
    public static boolean annagram(String str, String str2) {
        if (str.length() != str2.length()) {
            return false;
        }
        char[] ch = str.toCharArray();
        char[] ch2 = str2.toCharArray();

        Arrays.sort(ch);
        Arrays.sort(ch2);

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] !=ch2[i]) {
                return false;
            }
        }
        return true;
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
}