public class Minesweeper{

    private int rowLen;
    private int colLen;
    private int[] rowDelta = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    private int[] colDelta = new int[]{-1, 0, 1, -1, 1, 1, 0, -1};

    public static void main(String[] args){
        Minesweeper minesweeper = new Minesweeper();
        char[][] M =    {{'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'M', 'E', 'E'},
                         {'E', 'E', 'E', 'E', 'E'},
                         {'E', 'E', 'E', 'E', 'E'}};

        print("pre-click:");
        printMap(M);

        int[] click = new int[]{3,0};
        minesweeper.updateBoard(M, click);

        print("\nresult:");
        printMap(M);
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null || click == null || click.length != 2 || board.length < 1) return board;

        rowLen = board.length;
        colLen = board[0].length;
        int row = click[0];
        int col = click[1];

        if(isPosSafe(board, row, col)){
            if(board[row][col] == 'M'){
                board[row][col] = 'X';
                return board;
            }

            char adjMines = countAdjMines(board, row, col);

            if(adjMines == '0'){
                board[row][col] = 'B';
                revealAdjMines(board, row, col);
            }else{
                board[row][col] = adjMines;
            }
        }

        return board;
    }

    private void revealAdjMines(char[][] board, int row, int col){
        for(int i = 0; i < 8; i++){
            int x = row + rowDelta[i];
            int y = col + colDelta[i];

            if(isPosSafe(board, x, y)){
                if(board[x][y] == 'E'){
                    char adjMines = countAdjMines(board, x, y);
                    if(adjMines == '0'){
                        board[x][y] = 'B';
                        revealAdjMines(board, x, y);
                    }else{
                        board[x][y] = adjMines;
                    }
                }
            }
        }
    }

    private char countAdjMines(char[][] board, int row, int col){
        int adjMines = 0;

        for(int i = 0; i < 8; i++){
            int x = row + rowDelta[i];
            int y = col + colDelta[i];

            if(isPosSafe(board, x, y)){
                if(board[x][y] == 'M') adjMines++;
            }
        }

        char ans = (char)(adjMines+'0');
        return ans;
    }

    private boolean isPosSafe(char[][] board, int row, int col){
        if(row < 0 || row >= rowLen || col < 0 || col >= colLen) return false;

        return true;
    }




    public static void print(Object o){
        System.out.println(o.toString());
    }

    public static void printMap(char[][] M){
        for(char[] charArr: M){
            for(char c: charArr) System.out.print(c+", ");
            System.out.print("\n");
        }
    }
}