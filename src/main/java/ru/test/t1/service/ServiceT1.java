package ru.test.t1.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceT1 {

    public List<Map.Entry<Character, Integer>> countCharacter(String string) {
        if (string == null) {
            return Collections.emptyList();
        }
        HashMap<Character, Integer> unsortedResult = new HashMap<>();
        for (Character character : string.toCharArray()) {
            unsortedResult.put(character, unsortedResult.getOrDefault(character, 0) + 1);
        }
        // Deleted because a newline creates 2 characters at once "\n" and "\r"
        unsortedResult.remove("\r".charAt(0));
        List<Map.Entry<Character, Integer>> sortedResult = new ArrayList<>(unsortedResult.entrySet());
        sortedResult.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        return sortedResult;
    }
}
