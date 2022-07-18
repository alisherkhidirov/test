import io.cucumber.java.it.Ma;

import java.util.*;

public class Coding {

    public static void main(String[] args) {

        int one = 1;
        int two = 2;

        int swap = one;
        one = two;
        two = swap;
        System.out.println("Two: " + one);
        System.out.println("One: " + two);
        System.out.println("====================");
        System.out.println(revString("apple"));
        System.out.println(revString2("kiwi"));
        System.out.println(revWord("Java is cool"));
        List<Integer> keep = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(revList(keep));
        System.out.println(Arrays.toString(revArray(new int[] {1,2,3,4,5,6,7,8,9,10})));
        System.out.println(remDupString("apple"));
        List<Integer> keep2 = Arrays.asList(1,1,2,4,4,6,7,7,10,10);
        System.out.println(remDupList(keep2));
        System.out.println(countChars("apple"));
        showCountChars("apple");
        System.out.println("========================");
        System.out.println(pollyndrom("anna"));
        System.out.println(annagramm("apple", "laepp"));
        System.out.println(convToString(1221));
        System.out.println(countCharsMap("apple"));
        System.out.println(countWordMap("love love java java java"));
        System.out.println(countCharsInString("apple"));
        int[] keep3 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(findMax(keep3));
        System.out.println(Arrays.toString(sortArray(new int[] {4,10,5,15,1})));
        System.out.println(Arrays.toString(plusTwo(new int[] {10,20,30,40,50,60}, 100)));
        System.out.println(Arrays.toString(sortArray2(new int[] {2,10,15,8})));
    }
    public static String revString(String str) {
        String empty = "";
        for (int i = str.length()-1; i>=0; i--) {
            empty += str.charAt(i);
        }
        return empty;
    }
    public static String revString2(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length()-1; i>=0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
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
    public static int[] revArray(int[] num) {
        int j = num.length-1;
        for (int i = num.length/2; i>=0; i--) {
            int swap = num[i];
            num[i] = num[j - i];
            num[j - i] = swap;
        }
        return num;
    }
    public static String remDupString(String str) {
        String empty = "";
        for (int i = 0; i < str.length(); i++) {
            String hold = String.valueOf(str.charAt(i));
            if (!empty.contains(hold)) {
                empty += hold;
            }
        }
        return empty;
    }
    public static List<Integer> remDupList(List<Integer> path) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            if (!list.contains(path.get(i))) {
                list.add(path.get(i));
            }
        }
        return list;
    }
    public static int countChars(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char hold = str.charAt(i);
            if (hold == 'a' || hold == 'p') {
                count++;
            }
        }
        return count;
    }
    public static void showCountChars(String str) {
        for (int i = 0; i < str.length()-1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    System.out.print(str.charAt(j));
                }
            }
        }
    }
    public static boolean pollyndrom(String str) {
        String empty = "";
        for (int i = str.length()-1; i>=0; i--) {
            empty += str.charAt(i);
        }
        return empty.equals(str);
    }
    public static boolean annagramm(String str, String str2) {
        if (str.length() != str2.length()) {
            return false;
        }
        char[] ch = str.toCharArray();
        char[] ch2 = str2.toCharArray();

        Arrays.sort(ch);
        Arrays.sort(ch2);

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean convToString(int num) {
        String empty = "";
        String hold = String.valueOf(num);
        for (int i = hold.length()-1; i>=0; i--) {
            empty += hold.charAt(i);
        }
        return empty.equals(hold);
    }
    public static int findMax(int[] num) {
        int max = num[0];
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if (max < num[i]) {
                max = num[i];
                index = i;
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
    public static Map<Character,Integer> countCharsMap(String str) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (Character chars:str.toCharArray()) {
            if (map.containsKey(chars)) {
                map.put(chars,map.get(chars) + 1);
            }else {
                map.put(chars,1);
            }
        }
        return map;
    }
    public static Map<String,Integer> countWordMap(String str) {
        String[] word = str.split(" ");
        Map<String,Integer> map = new LinkedHashMap<>();
        for (String hold:word) {
            if (map.containsKey(hold)) {
                map.put(hold,map.get(hold) + 1);
            }else {
                map.put(hold,1);
            }
        }
        return map;
    }
    public static String countCharsInString(String str) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (Character hold:str.toCharArray()) {
            if (map.containsKey(hold)) {
                map.put(hold,map.get(hold) + 1);
            }else {
                map.put(hold,1);
            }
        }
        String empty = "";
        for (Character hold2:str.toCharArray()) {
            empty += String.valueOf(hold2) + map.get(hold2) + " ";
        }
        return empty;
    }
    public static int[] sortArray(int[] num) {
        int count = 0;
        do {
            count = 0;
            for (int i = 0; i < num.length-1; i++) {
                if (num[i] > num[i + 1]) {
                    int swap = num[i];
                    num[i] = num[i + 1];
                    num[i + 1] = swap;
                    count++;
                }
            }
        }while (count !=0);
        return num;
    }
    public static int[] plusTwo(int[] num, int target) {
        int[] res = new int[2];
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] + num[j] == target) {
                    res[0] = num[i];
                    res[1] = num[j];
                    return res;
                }
            }
        }
        return res;
    }

    public static int[] sortArray2(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
        return num;
    }
}



