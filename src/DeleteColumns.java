import com.sun.jdi.ClassType;

public class DeleteColumns {
//LeetCode, 944. Delete Columns to Make Sorted

    DeleteColumns(){
        String[] strs = {"zyx", "wvu", "tsr"};
        int ans = minDeletionSize(strs);
        print(this.getClass().getSimpleName());
        print("ans: " + ans);
    }

    public int minDeletionSize(String[] strs) {
        int row = 0;
        int col;
        int delCol = 0;

        int strLen = strs.length;
        int strsLen = strs[0].length();


        while(row < strLen-1){
            col = 0;
            while(col < strsLen){
                print(strs[row].charAt(col) + " > " + strs[row+1].charAt(col));
                if(strs[row].charAt(col) > strs[row+1].charAt(col)){
                    delCol++;
                    col = 0;
                    row++;
                    break;
                }
                col++;
            }
            row++;
        }
        return delCol;
    }

    public static void print(Object obj){
        System.out.println(obj.toString());
    }
}
