package FIT.ORDENAMIENTO;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int [] expectedArray, int lengthArray){

        if(lengthArray < 2 ){
            return;
        }

        int mid = lengthArray / 2;
        int[] l = new int[mid];
        int[] r = new int[lengthArray - mid];

        for(int i = 0; i < mid; i++){
            l[i] = expectedArray[i];
        }


        for(int i = mid; i < lengthArray; i++){
            r[i - mid] = expectedArray[i];
        }

        mergeSort(l, mid);
        mergeSort(r, lengthArray - mid);
        merge(expectedArray, l, r, mid, lengthArray - mid);
    }

    private static void merge(int original[], int left[], int[] right, int l, int r){
       int i = 0, j = 0, k = 0;

       while(i < l && j < r){
           if(left[i] <= right[j]){
               original[k++] = left[i++];
           } else {
               original[k++] = right[j++];
           }
       }

       while(i < l){
           original[k++] = left[i++];
       }

       while(j < r){
           original[k++] = right[j++];
       }
    }

    public static void main(String[] args) {
        int arr[] =  {5,4,1,2,3,6,7,10,9};
        MergeSort.mergeSort(arr,arr.length );
        System.out.println(Arrays.toString(arr));

    }
}
