package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<List<Integer>> permute(List<Integer> al) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(al, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(List<Integer> al, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == al.size()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < al.size(); i++) {
                if (tempList.contains(al.get(i))) continue; // element already exists, skip
                tempList.add(al.get(i));
                backtrack(al, tempList, result);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);

        List<List<Integer>> permutations = permute(al);

        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
