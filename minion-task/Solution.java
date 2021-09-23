import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static int[] solution(int[] data, int n) {
        if (n < 1) {
            return new int[0];
        }
        if (data.length <= n) {
            return data;
        }
        Map<Integer, Integer> dataCount = new HashMap<>();
        for (int countKey : data) {
            Integer countValue = dataCount.get(countKey);
            if (countValue == null) {
                countValue = 1
            } else {
                countValue += 1;
            }
            dataCount.put(countKey, countValue);
        }
        List<Integer> result = new ArrayList<>(data.length);
        for (int i : data) {
            Integer count = dataCount.get(i);
            if (count != null && count <= n) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}