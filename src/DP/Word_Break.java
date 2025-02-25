package DP;

import java.util.*;

public class Word_Break {


    public boolean dfs(String s, List<String> wordDict, HashSet<String> notMatchedSet) {
        if (s.isEmpty()) {
            return true;
        }
        if (notMatchedSet.contains(s)) {
            return false;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                boolean matched = dfs(s.substring(word.length()), wordDict, notMatchedSet);
                if (matched) {
                    return true;
                } else {
                    notMatchedSet.add(s.substring(word.length()));
                }
            }
        }
        return false;
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> notMatchedSet = new HashSet<>();
        return dfs(s, wordDict, notMatchedSet);
    }
}
