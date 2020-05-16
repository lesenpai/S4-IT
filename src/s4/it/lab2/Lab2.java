/*
    Вариант 5
 */

package s4.it.lab2;

import s4.it.CustomUtils;

import java.util.Scanner;
import static java.lang.System.*;

public class Lab2 {
    public static void main(String[] args)
    {
        CustomUtils.printInFrame("Lab 2. Сортировка одномерных массивов и сортировка слова");
        Scanner in = new Scanner(System.in);
        int size;
        int found_index;
        // Get array size
        while(true)
        {
            try {
                out.print("Enter arrays size: ");
                size = Integer.parseInt(in.next());
                break;
            }
            catch (NumberFormatException e)
            {
                out.println("Size: invalid input");
                clearScreen();
            }
        }
        var arr1 = CreateArray(size, 1, 10);
        var arr2 = CreateArray(size, 1, 10);

        int x = 5;
        out.println("X = " + x);
        out.println("Array 1:");
        PrintArray(arr1);
        out.println("Array 2:");
        PrintArray(arr2);
        found_index = BarrierSearch(x, arr1);
        out.println("Barrier search: array 1: " + (found_index > -1 ? "found at " + found_index : "not found"));
        out.println("Array 2 (sorted by insertion method):");
        InsertionSort(arr2);
        PrintArray(arr2);
        found_index = BinarySearch(x, arr2, 0, arr2.length - 1);
        out.println("Binary search: array 2: " + (found_index > -1 ? "found at " + found_index : "not found"));
        out.println("Array 1 (sorted by smallest item selection method):");
        SmallestItemSelectionSort(arr1);
        PrintArray(arr1);
        // Merge 2 arrays
        out.println("Merge two arrays:");
        var merged_array = MergeSortedArrays(arr1, arr2);
        PrintArray(merged_array);
        out.print("Max element: ");
        var max = FindMax(merged_array);
        out.println(merged_array[max] + "[" + max + ']');
        // Word sort
        while (true)
        {
            out.print("Enter the word (or 'br' to break): ");
            String input = in.next();
            if(input.equals("br"))
                break;
            Character[] chars = input.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
            out.println("Word (sorted by bubble method):");
            BubbleSort(chars);
            PrintArray(chars);
        }
    }

    private static void PrintArray(Character[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            out.print(array[i] + "[" + i + ']');
        }
        out.println();
    }

    public static void PrintArray(Integer[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            out.print(array[i] + "[" + i + ']');
        }
        out.println();
    }

    public static void clearScreen()
    {
        for(int i = 0; i < 20; i++)
            System.out.println();
    }

    public static int BarrierSearch(Integer x, Integer[] arr)
    {
        if(arr.length == 0)
        {
            return -1;
        }
        int i;
        for(i = 0, arr[arr.length - 1] = x; !arr[i].equals(x); i++)
        {
        }
        if(i == arr.length - 1)
        {
            return -1;
        }
        return i;
    }

    public static int BinarySearch(int x, Integer[] a, int l, int r)
    {
        if (r >= l)
        {
            int mid = l + (r - l) / 2;
            // If the element is present at the middle itself
            if (a[mid] == x)
            {
                return mid;
            }
            // If element is smaller than mid, then it can only be present in left sub-array
            if (a[mid] > x)
            {
                return BinarySearch(x, a, l, mid - 1);
            }
            // Else the element can only be present in right sub-array
            return BinarySearch(x, a, mid + 1, r);
        }
        // We reach here when element is not present in array
        return -1;
    }

    public static void InsertionSort(Integer arr[])
    {
        int i, key, j, n = arr.length;
        for (i = 1; i < n; i++){
            key = arr[i];
            j = i - 1;
	        /* Move elements of arr[0..i-1], that are
	        greater than key, to one position ahead
	        of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void SmallestItemSelectionSort(Integer[] arr)
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum item in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
            {
                if (arr[j] < arr[min_idx])
                {
                    min_idx = j;
                }
            }
            // Swap the found minimum item with the first item
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    static void BubbleSort(Character[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    Character temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static Integer[] MergeSortedArrays(Integer[] a, Integer[] b) {
        Integer[] res = new Integer[a.length + b.length];
        int i = a.length - 1, j = b.length - 1, k = res.length;
        while (k > 0)
        {
            res[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
        }
        return res;
    }

    public static Integer[] CreateArray(int size, int min, int max)
    {
        if(size < 0)
        {
            return null;
        }
        if(size == 0)
        {
            return new Integer[0];
        }
        Integer[] array = new Integer[size];
        for(int i = 0; i < size; i++)
        {
            array[i] = CustomUtils.random(min, max);
        }
        return array;
    }

    public static int FindMax(Integer[] arr)
    {
        if(arr.length == 0)
        {
            return -1;
        }
        int max = arr[1];
        int max_i = 0;
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
                max_i = i;
            }
        }
        return max_i;
    }
}

