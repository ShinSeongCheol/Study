package chap07;

import java.util.Scanner;

public class chap07_03 {
    public static int binarySearch(int[] array, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();

        int result = binarySearch(array, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        } else {
            System.out.println(result + 1);
        }
    }
}
