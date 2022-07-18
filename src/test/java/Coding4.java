import java.util.*;

public class Coding4 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[] {5,1,3,6,2,7,8,10,9})));
        System.out.println(revString("apple"));
        System.out.println(revStrWord("Java is cool"));
        System.out.println(Arrays.toString(revArray(new int[] {9,8,7,6,5,4,3,2,1})));
        List<Integer> numbers = Arrays.asList(9,8,7,6,5,4,3,2,1);
        System.out.println(revList(numbers));
        System.out.println(revInt(321));
        countChars("apple");
        System.out.println(remDupStr("apple"));
        List<Integer> numbers_2 = Arrays.asList(1,1,2,2,3,3,4,4,5,5);
        System.out.println(remDupList(numbers_2));
        int[] numbers_3 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(findMax(numbers_3));
        System.out.println(pollyndrom("civic"));
        System.out.println(annagramm("apple", "lappe"));
        System.out.println(Arrays.toString(plusTwo(new int[] {10,20,30,40,50,60}, 70)));
        System.out.println(Arrays.toString(plusStr(new String[] {"a","b","c"}, new String[] {"d","e","f"})));
        System.out.println(countIntChars("apple"));

        int i = 10; //20
        int j = 20; //10
        int swap = i;
        i = j;
        j = swap;
        System.out.println(i + " " + j);


    }
    public static int[] sortArray(int[] num) {
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
    public static String revString(String str) {
        String empty = "";
        for (int i = str.length()-1; i >0; i--) {
            empty += str.charAt(i);
        }
        return empty;
    }
    public static String revStrWord(String str) {
        String empty = "";
        String[] word = str.split(" ");
        for (int i = word.length-1; i>=0; i--) {
            empty += word[i] + " ";
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
    public static List<Integer> revList(List<Integer> path) {
        List<Integer> list = new ArrayList<>();
        for (int i = path.size()-1; i>=0; i--) {
            list.add(path.get(i));
        }
        return list;
    }
    public static String revInt(int num) {
        String empty = "";
        String conv = String.valueOf(num);
        for (int i = conv.length()-1; i>=0; i--) {
            empty += conv.charAt(i);
        }
        return empty;
    }
    public static void countChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    System.out.println(str.charAt(j));
                }
            }
        }
    }
    public static String remDupStr(String str) {
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
    public static int findMax(int[] num) {
        int max = num[0];
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
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
        for (int i = str.length()-1; i >=0; i--) {
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
    public static int[] plusTwo(int[] num, int target) {
        int[] res = new int[2];
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] + num[j] == target) {
                    res[0] = num[i];
                    res[1] = num[j];
                }
            }
        }
        return res;
    }
    public static String[] plusStr(String[] str, String[] str2) {
        int i = 0;
        String[] result = new String[str.length + str2.length];
        for (i = 0; i < str.length; i++) {
            result[i] = str[i];
        }
        for (int j = 0; j < str2.length; j++) {
            result[i] = str2[j];
            i++;
        }
        return result;
    }
    public static Map<Character,Integer> countIntChars(String str) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (Character hold:str.toCharArray()) {
            if (map.containsKey(hold)) {
                map.put(hold, map.get(hold) +1);
            }else {
                map.put(hold, 1);
            }
        }
        return map;
    }
}
