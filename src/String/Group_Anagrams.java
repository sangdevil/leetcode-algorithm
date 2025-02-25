package String;

import java.util.*;

class Group_Anagrams {

    public String arrangeString(String str) {
        char[] charArray = str.toCharArray();

        Arrays.sort(charArray);
        return new String(charArray);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> hashStringList = new ArrayList<>();
        for (String str : strs) {
            String arranged = arrangeString(str);
            if (map.containsKey(arranged)) {
                map.get(arranged).add(str);
            } else {
                ArrayList<String> target = new ArrayList<>();
                target.add(str);
                map.put(arranged, target);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}