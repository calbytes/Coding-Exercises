import java.util.*;

public class TwoCityScheduling {

    // https://leetcode.com/problems/two-city-scheduling/

    public class IndexCity{
        public int index;
        public char city;

        public IndexCity(int index, char city){
            this.index = index;
            this.city = city;
        }
    }

    public void addNodeToMap(Map<Integer, List<IndexCity>> map, int cost, IndexCity ic){
        if(map.containsKey(cost)){
            map.get(cost).add(ic);
        }else{
            List<IndexCity> list = new ArrayList<>();
            list.add(ic);
            map.put(cost, list);
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        Map<Integer, List<IndexCity>> costIndexMap = new TreeMap<>();
        for(int i = 0; i < costs.length; i++){
            IndexCity indexCityA = new IndexCity(i, 'a');
            IndexCity indexCityB = new IndexCity(i, 'b');
            addNodeToMap(costIndexMap, costs[i][0], indexCityA);
            addNodeToMap(costIndexMap, costs[i][1], indexCityB);
        }

        HashSet<Integer> userInCity = new HashSet<>();
        int pplInCityA = 0;
        int pplInCityB = 0;
        int maxPpl = costs.length/2;
        int totalCost = 0;

        for(int cost: costIndexMap.keySet()){
            List<IndexCity> icList = costIndexMap.get(cost);
            if(pplInCityA < maxPpl && pplInCityB < maxPpl){
                boolean isGoodCost = getNextCost(icList, userInCity, 'x');
            }else if(pplInCityA < maxPpl){
                boolean isGoodCost = getNextCost(icList, userInCity,'a');
            }else if(pplInCityB < maxPpl){
                boolean isGoodCost = getNextCost(icList, userInCity, 'b');
            }
        }



        return totalCost;
    }

    public boolean getNextCost(List<IndexCity> list, Set<Integer> userInCity, char c){
        if(c == 'x'){
            while(list != null || list.size() > 0){
                if(userInCity.contains(list.get(0).index)) list.remove(0);
                else{
                    userInCity.add(list.get(0).index);
                    return true;
                }
            }
        }else if(c == 'a'){
            while(list != null || list.size() > 0){

            }
        }else if(c == 'b'){
            while(list != null || list.size() > 0){

            }
        }

        return false;
    }

}
