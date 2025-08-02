import java.util.*;

public class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int fruit : basket1) count.put(fruit, count.getOrDefault(fruit, 0) + 1);
        for (int fruit : basket2) count.put(fruit, count.getOrDefault(fruit, 0) - 1);

        List<Integer> extras = new ArrayList<>();
        int minFruit = Integer.MAX_VALUE;

        for (int key : count.keySet()) {
            int freq = count.get(key);
            if (freq % 2 != 0) return -1; 
            int times = Math.abs(freq) / 2;
            for (int i = 0; i < times; i++) {
                extras.add(key);
            }
            minFruit = Math.min(minFruit, key);
        }

        Collections.sort(extras);

        long cost = 0;
        for (int i = 0; i < extras.size() / 2; i++) {
            cost += Math.min(extras.get(i), 2 * minFruit);
        }

        return cost;
    }
}
