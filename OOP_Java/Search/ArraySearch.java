public class ArraySearch {
    //LINEAR
    public static int linearSearch_v1 (int [] arr, int target) {

        for (int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
            return -1;
    }

    public static int linearSearch_v2 (int [] arr, int target) {

        int pointer = 0;
        while (pointer < arr.length) {
            if(arr[pointer] == target) {
                return pointer;
            }
            pointer++;
        }
                return -1;
    }

    //BINARY
    public static int binarySearch_v1 ( int[] arr, int target) {
        int low = 0, high = arr.length - 1;
            while (high >= low) {
                int mid = (low + high)/2;

                if ( arr[mid] == target){
                    return mid;
                } else if (arr[mid] > target) {
                    high = mid - 1;
                } else if(arr[mid] < target) {
                    low = mid + 1; 
                }
            }
            return -1;
    }

    public static int binarySearch_v2 ( int[] arr, int target){

        int low = 0, high =arr.length-1;
        while (high>low) {
            int mid = (low + high)/2;
            if(arr[mid] < target) {
                low = mid + 1;
            } else { //arr[mid] >= target
                high = mid;
            }
        }
        if (arr[high] == target){ 
            return high;
        } else return -1;
    }



    public static void main(String [] args) {

        int[] data = { 62, 15, 78, 84, 119, 38, 26, 108, 91, 57};
        int[] sortedData = {15,26,38,57,57,62,78,84,84,91,108,119};

        System.out.println(binarySearch_v2(sortedData, 84));
        System.out.println(binarySearch_v2(sortedData, 85));

    }
}
