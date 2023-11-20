import java.util.ArrayList;
import java.util.List;

public class Binary {

    public static void main(String[] args){



//        List<int[]> combinations = generate(10, 3);
//        for (int[] combination : combinations) {
//            System.out.println(Arrays.toString(combination));
//        }
//        System.out.printf("generated %d combinations of %d items from %d ", combinations.size(), 10, 3);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<int[]> combinations = generate(nums.length, 3);
        List<List<Integer>> listList = new ArrayList<List<Integer>>();


        for(int[] combination: combinations){
            int sum = 0;
            for(int i: combination){
                sum += nums[i];
            }
            if(sum==0){
                List<Integer> list = new ArrayList<>();
                for(int i: combination) list.add(nums[i]);
                listList.add(list);
            }
        }
        return listList;
    }

    public static void adder(ArrayList<String> strs){
        strs.add("hello");
    }


    public static List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n-1, 0);
        return combinations;
    }

    public static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }

    public static void print(Object o){
        System.out.println(o.toString());
    }
}
