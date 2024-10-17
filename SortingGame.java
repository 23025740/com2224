import java.util.Scanner;

public class SortingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Accept 10 integers from the user
        int[] array = new int[10];
        System.out.println("Enter 10 integers separated by spaces:");
        for (int i = 0; i < 10; i++) {
            array[i] = scanner.nextInt();
        }

        // Step 2: Prompt the user to choose a sorting algorithm
        System.out.println("Choose a sorting algorithm:");
        System.out.println("1: Bubble Sort");
        System.out.println("2: Insertion Sort");
        System.out.println("3: Selection Sort");
        System.out.println("4: Quick Sort");
        System.out.println("5: Merge Sort");
        int choice = scanner.nextInt();

        // Step 3: Execute the chosen sorting algorithm
        switch (choice) {
            case 1:
                bubbleSort(array);
                break;
            case 2:
                insertionSort(array);
                break;
            case 3:
                selectionSort(array);
                break;
            case 4:
                quickSort(array, 0, array.length - 1, 1);
                break;
            case 5:
                mergeSort(array, 0, array.length - 1, 1);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Step 4: Display the final sorted array
        System.out.println("Sorted array:");
        displayArray(array);
    }

    // Utility method to display the array
    public static void displayArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Bubble Sort implementation with iteration output
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("Pass " + (i + 1) + ":");
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                // Display the array after each swap
                displayArray(array);
            }
        }
    }

    // Insertion Sort implementation with iteration output
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.println("Pass " + i + ":");
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
            // Display the array after each insertion step
            displayArray(array);
        }
    }

    // Selection Sort implementation with iteration output
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println("Pass " + (i + 1) + ":");
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            // Display the array after each selection step
            displayArray(array);
        }
    }

    // Quick Sort implementation with iteration output
    public static void quickSort(int[] array, int low, int high, int pass) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            System.out.println("Pass " + pass + ":");
            displayArray(array);
            quickSort(array, low, pivotIndex - 1, pass + 1);
            quickSort(array, pivotIndex + 1, high, pass + 1);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    // Merge Sort implementation with iteration output
    public static void mergeSort(int[] array, int left, int right, int pass) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, pass + 1);
            mergeSort(array, mid + 1, right, pass + 1);
            merge(array, left, mid, right);
            System.out.println("Pass " + pass + ":");
            displayArray(array);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}