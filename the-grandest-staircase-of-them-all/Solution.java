import java.util.Stack;

public class Solution {
    public static int solution(int n) {
        // Your code here
        CustomStack stack = new CustomStack();
        int brick = n - 1;
        int count = 0;
        while(brick >= 2) {
            stack.add(brick);
            brick -= 1;
            count = calculate(stack, n, count);
            stack.pop();
        }
        return count;
    }

    private static int calculate(CustomStack stack, int n, int count) {
        System.out.println(stack);
        int stackTotal = stack.getTotal();
        if (stackTotal > n) {
            return count;
        }
        if (stackTotal == n) {
            System.out.println("count");
            return count + 1;
        }
        if (stack.peek() <= 1) {
            return count;
        }
        int currentBrick = stack.peek();
        while (currentBrick > 1) {
            currentBrick -= 1;
            stack.add(currentBrick);
            count = calculate(stack, n, count);
            stack.pop();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Solution.solution(13));
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