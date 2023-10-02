import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class twoCitySchedCost {
    public static void main(String[] args){
        twoCitySchedCost c = new twoCitySchedCost();
        c.twoCitySchedCost(null);
    }
    public int twoCitySchedCost(int[][] costs) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < costs.length; i++){
            if(map.get(costs[i][0]) == null){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(costs[i][0]);
                map.put(costs[i][0], list);
            }else{
                map.get(costs[i][0]).add(i);
            }

            if(map.get(costs[i][1]) == null){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(costs[i][1]);
                map.put(costs[i][1], list);
            }else{
                map.get(costs[i][1]).add(i);
            }

        }

        int sumA = 0;
        int sumB = 0;

        int nA = costs.length/2;
        int nB = nA;

        Set<Integer> taken = new HashSet<>();

        for(int cost : map.keySet()){
            ArrayList<Integer> list = map.get(cost);
            while(nA > 0 && nB > 0){
                for(int i : list){
                    if(taken.contains(i)) continue;
                    if(nA > 0){
                        //add to suma, continue;
                    }else if(nB >0){
                        //add to sumb, continue;
                    }
                    //add i to taken;
                    if(nA == 0 && nB == 0) return sumA+sumB;
                }

            }
        }

        return 0;
    }
}
