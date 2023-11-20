public class FindMedian {

    public static void main(String[] args){
        int[] one = {1, 2};
        int[] two = {3, 4};
        findMedianSortedArrays(one, two);
    }

    public static void print(Object o){
        System.out.println(o.toString());
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double one = getMedian(nums1);
        double two = getMedian(nums2);
        print(one);print(two);
        return (one + two)/2;
    }

    public static double getMedian(int[] arr){
        if(arr.length%2==0){
            double d = (double) arr[arr.length / 2];
            double dd = arr[(arr.length / 2) - 1];
            return (d+dd) / 2;
        }
        return arr[arr.length/2];
    }
}
