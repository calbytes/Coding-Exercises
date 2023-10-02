import com.sun.jdi.ClassType;

public class DeleteColumns {
//LeetCode, 944. Delete Columns to Make Sorted

    DeleteColumns(){
        String[] strs = {"rrjk","furt","guzm"};
                //{"zyx", "wvu", "tsr"};
        int ans = minDeletionSize(strs);
        print("ans: " + ans);
    }

    public int minDeletionSize(String[] strs) {
        int strsLen = strs.length;
        int strLen = strs[0].length();

        int delCol = 0;
        int col = 0;
        while(col < strLen){
            //print("col: " + col);
            int row = 0;
            while(row < strsLen-1){
                //print("row: " + row);
                if(strs[row].charAt(col) > strs[row+1].charAt(col)){
                    //print(strs[row].charAt(col) + " > " + strs[row+1].charAt(col));
                    delCol++;
                    row = strsLen;
                }else {
                    row++;
                }
            }
            col++;
        }

        return delCol;
    }

    public static void print(Object obj){
        System.out.println(obj.toString());
    }
}
