import java.util.Arrays;

public class binarySearch {
    public static int binarySearchh(  int arr[], int down ,int top, int floor) {
        int A = down;
        int b = top;
        int x = floor;
        int mid = (A + b) / 2;
//        System.out.println(Arrays.toString(arr));
        if(x > b){
            System.out.println("Element not present");
            return 1;
        }
        if(arr[mid] == x){
            System.out.println("Element found at index "
                    + mid);
            return mid;
        }
        if(arr[mid] > x){
            binarySearchh( arr, A, mid-1 ,x);
        } else {
            return binarySearchh(arr ,mid + 1 , b , x);
        }


        return 1;
    }
    public static int findflo(int arr[] , int down , int top , int floor){
        int A = down;
        int b = top;
        int x = floor;
        int mid = (A + b) / 2;
        if(x > b || x < A){
            System.out.println("Element not present");
            return 1;
        }
        while (arr[mid] != x){
            if(arr[mid] > x){
                b = arr[mid];
                mid = (A + b) / 2;
            } else if ( arr[mid] < x){
                A = arr[mid] ;
                mid = (A + b) / 2;
            }
        }
        System.out.println("Element found at index "
                + arr[mid]);
        return -1;
    }

    public static void main(String args[]) {

        int top = 10 ;
        int down = 0;
        int arr[] = new int[top + 1];
        for (int i = 0; i <= top; i++) {
            arr[i] = i ;
        }
        //binarySearchh(arr , down , top , 1);
        findflo(arr , down , top , 3);
//
    }
}
