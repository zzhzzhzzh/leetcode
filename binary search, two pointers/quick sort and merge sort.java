//merge sort
// public class Solution {
//     /**
//      * @param A: an integer array
//      * @return: nothing
//      */
//     public void sortIntegers2(int[] A) {
//         if (A == null || A.length == 0) return;
//         int start = 0, end = A.length - 1;
//         int[] temp = new int[A.length];
//         mergeSort(A, start, end, temp);
//     }
//     public void mergeSort(int[] A, int start, int end, int[] temp) {
//         if (start >= end) return;
//         int mid = (start + end) / 2;
//         mergeSort(A, start, mid, temp);
//         mergeSort(A, mid + 1, end, temp);
//         merge(A, start, end, temp);
//     }
//     public void merge(int[] A, int start, int end, int[] temp) {
//         int mid = (start + end) / 2;
//         int index1 = start;
//         int index2 = mid + 1; 
//         int index = start;
//         while (index1 <= mid && index2 <= end ) {
//             if (A[index1] <= A[index2]) {
//                 temp[index++] = A[index1++]; 
//             } else {
//                 temp[index++] = A[index2++];
//             }
//         }
//         while (index1 <= mid) {
//             temp[index++] = A[index1++]; 
//         }
//         while (index2 <= end) {
//             temp[index++] = A[index2++];
//         }
//         while (start <= end) {
//             A[start] = temp[start];
//             start++;
//         }
//     }
// }

//quick sort
public class Solution {
    
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    public void quickSort(int[] A, int start, int end) {
        if (start >= end) return;
        int left = start, right = end;
        int mid = start + (end - start) / 2;
        int pivot = A[mid];
        
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        quickSort(A, start, right);
        quickSort(A, left, end);
        
    }
}

//heap sort
public class Solution {

    public void sortIntegers2(int[] A) {
        
    }
}
