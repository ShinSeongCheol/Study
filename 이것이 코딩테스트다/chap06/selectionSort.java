package chap06;

public class selectionSort {
    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[minIndex] > array[j]) {
                    int temp = array[minIndex];
                    array[minIndex] = array[j];
                    array[j] = temp;
                }
            }
        }

        for(int i : array)
            System.out.println(i);
    }
}
