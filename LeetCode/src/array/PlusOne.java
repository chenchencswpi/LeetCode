package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public static void main(String[] args) {}

}

class PlusOneSolution {
    /**
     * Use LinkedList to store the result. Since we do not know if the result array's length is longer than input array's,
     * we cannot modify the input array directly.
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<>();
        int current = 0;

        for (int index = digits.length - 1; index >= 0; index--) {
            if (index == digits.length - 1) {
                current += 1;
            }
            current += digits[index];
            list.addFirst(current % 10);
            current /= 10;
        }

        if (current != 0) {
            list.addFirst(current);
        }

        int[] res = new int[list.size()];
        int index = 0;

        while (!list.isEmpty()) {
            res[index++] = list.poll();
        }

        return res;
    }



}

