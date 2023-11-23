public class PensAndPencils {
//LeetCode, 2240. Number of Ways to Buy Pens and Pencils

    public PensAndPencils(){
        long ways = waysToBuyPensPencils(20, 10, 5);
        Main.print("ans: " + ways);
    }

    long ways = 0;
    int cost1 = 0;
    int cost2 = 0;
    int total = 0;

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ways = 0;
        int pens = 0;
        int pencils = 0;

        while(pens*cost1 <= total){
            while(pencils*cost2 <= total){
                if(pens*cost1 + pencils*cost2 <= total){
                    Main.print(pens+", "+pencils);
                    ways++;
                }
                pencils++;
            }
            pens++;
            pencils = 0;
        }

        return ways;
    }

    /*
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        this.cost1 = cost1;
        this.cost2 = cost2;
        this.total = total;

        dfs(0, 0);
        return ways;
    }

    public void dfs(int pens, int pencils){
        if((cost1*pens + cost2*pencils) > total) return;
        Main.print("pens: " + pens + ", pencils: " + pencils);
        ways++;

        dfs(pens+1, pencils);
        dfs(pens, pencils+1);
    }
     */
}
