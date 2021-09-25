public class Solution {
    public static int[] solution(int[] l, int t) {
        int startIdx = -1;
        int endIdx = -1;
        
        for(int i = 0; i < l.length; i++) {
            int subTotal = l[i];
            int subEndIdx = i;
            while (subTotal < t && subEndIdx < l.length - 1) {
                subEndIdx += 1;
                subTotal += l[subEndIdx];
            }
            if (subTotal == t) {
                startIdx = i;
                endIdx = subEndIdx;
                break;
            }
        }
        
        int[] result = new int[2];
        result[0] = startIdx;
        result[1] = endIdx;
        return result;
    }
}