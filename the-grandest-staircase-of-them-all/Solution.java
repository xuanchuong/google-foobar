import java.util.Stack;

public class Solution {
    public static int solution(int n) {
        // Your code here
        CustomStack stack = new CustomStack();
        int brick = n - 1;
        int count = 0;
        int min = findMin(n);
        while(brick >= min) {
            stack.add(brick);
            brick -= 1;
            count += calculate(stack, n);
            stack.pop();
        }
        return count;
    }

    private static int calculate(CustomStack stack, int n) {
        System.out.println(stack);
        int stackTotal = stack.getTotal();
        if (stackTotal > n) {
            return n - stackTotal;
        }
        if (stackTotal == n) {
            System.out.println("count");
            return 1;
        }
        if (stack.peek() <= 1) {
            return 0;
        }
        int currentBrick = stack.peek() - 1;
        int count = 0;
        while (currentBrick >= 1) {
            stack.add(currentBrick);
            int result = calculate(stack, n);
            if (result >= 0) {
                count += result;
                currentBrick -= 1;
            } else {
                currentBrick += result;
            }
            stack.pop();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(20));
    }

    private static int findMin(int n) {
        int i = 1;
        int sum = 1;
        for (; i < n; i++) {
            sum += i;
            if (sum > n) {
                return i;
            }
        }
        return i;
    }
}

class CustomStack {
    private Stack<Integer> stack;
    private int total;

    CustomStack() {
        stack = new Stack<>();
        total = 0;
    }

    void add(Integer value) {
        stack.add(value);
        total += value;
    }

    void pop() {
        Integer value = stack.pop();
        total -= value;
    }

    Integer peek() {
        return stack.peek();
    }

    int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}