class ShortestDistance505 {
    //505 The Maze II, wrong answer, because the problem requires the ball to roll until it hits a wall.
    public static int shortestDistance;

    public ShortestDistance505(){
        int[][] maze = new int[][] {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0,4};
        int[] destination = new int[]{4,4};
        int answer = shortestDistance(maze, start, destination);
        System.out.println(answer);
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze[0].length][maze.length];
        nextMove(maze, start[0], start[1], destination, 0, visited);
        return ((shortestDistance == 0) ? -1 : shortestDistance);
    }

    public static void nextMove(int[][] maze, int x, int y, int[] destination, int jumps, boolean[][] visited){
        if(x < 0 || x >= maze[0].length || y < 0 || y >= maze.length) return;
        if(maze[x][y] == 1 || visited[x][y]) return;

        if(destination[0] == x && destination[1] == y){
            if(shortestDistance == 0){
                shortestDistance = jumps;
            }
            else if(jumps < shortestDistance){
                shortestDistance = jumps;
            }
            return;
        }

        visited[x][y] = true;

        nextMove(maze, x-1, y, destination, jumps+1, visited);
        nextMove(maze, x, y+1, destination, jumps+1, visited);
        nextMove(maze, x+1, y, destination, jumps+1, visited);
        nextMove(maze, x, y-1, destination, jumps+1, visited);

        visited[x][y] = false;
    }
}