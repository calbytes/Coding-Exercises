import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5};

        int i = 0;
        for(List<Integer> list : permute(nums)){
            System.out.println(list.toString());
            i++;
        }
        System.out.println(i);
    }

    public static List<List<Integer>> lists = new ArrayList<List<Integer>>();

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums){
            list.add(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        permutate(list, ans);

        return lists;
    }

    public static void permutate(ArrayList<Integer> nums, ArrayList<Integer> ans){
        if(nums.size() == 0){
            lists.add(ans);
            return;
        }

        ArrayList<Integer> numsDup;
        numsDup = duplicate(nums);

        for(int i = 0; i < nums.size(); i++){

            ArrayList<Integer> ansDup = new ArrayList<>();
            ansDup.addAll(ans);
            ansDup.add(nums.get(i));
            numsDup.remove(i);

            permutate(numsDup, ansDup);

            numsDup = duplicate(nums);

        }
    }

    public static ArrayList<Integer> duplicate(ArrayList<Integer> b){
        return (ArrayList) b.clone();
    }
}
