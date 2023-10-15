package ru.test.t1.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceT1 {

    public List<Map.Entry<Character, Integer>> countCharacter(String string) {
        HashMap<Character, Integer> unsortedResult = new HashMap<>();
        for (Character character : string.toCharArray()) {
            unsortedResult.put(character, unsortedResult.getOrDefault(character, 0) + 1);
        }
        unsortedResult.remove("\r".charAt(0));
        List<Map.Entry<Character, Integer>> sortedResult = new ArrayList<>(unsortedResult.entrySet());
        sortedResult.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        return sortedResult;
    }
}
