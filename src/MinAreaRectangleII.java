import java.util.*;

public class MinAreaRectangleII {
    public double minAreaFreeRect(int[][] points) {
        Map<Double, List<int[]>> slopeLinesMap = new HashMap<>();
        Map<Integer, Set<Integer>> pointsMap = new HashMap<>();

        for(int i=0; i<points.length; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            addToPointsMap(pointsMap, x1, y1);

            for(int j=i+1; j+1<points.length; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                double slope = findSlope(x1, y1, x2, y2);
                int[] line = new int[4];
                line[0]=x1;
                line[1]=y1;
                line[2]=x2;
                line[3]=y2;

                if(slopeLinesMap.containsKey(slope)){
                    slopeLinesMap.get(slope).add(line);
                }else{
                    List<int[]> lines = new ArrayList<>();
                    lines.add(line);
                    slopeLinesMap.put(slope, lines);
                }
            }
        }

        double min = 0;

        for(double slope: slopeLinesMap.keySet()){
            double perpSlope = -1/slope;
            if(slopeLinesMap.containsKey(perpSlope)){
                List<int[]> lines = slopeLinesMap.get(slope);
                List<int[]> perpLines = slopeLinesMap.get(perpSlope);

                if(lines.size() > 1 && perpLines.size() > 1){
                    double minArea = findMinArea(slope, lines, perpSlope, perpLines, pointsMap);
                }

            }
        }

        return min;
    }

    public static void addToPointsMap(Map<Integer, Set<Integer>> pointsMap, int x, int y){
        if(pointsMap.containsKey(x)){
            pointsMap.get(x).add(y);
        }else{
            Set<Integer> set = new HashSet<>();
            pointsMap.put(x, set);
        }
    }

    public static double findMinArea(double slope, List<int[]> lines, double perpSlope, List<int[]> perpLines, Map<Integer, Set<Integer>> pointsMap){
        double min = 0;

        for(int i=0; i<lines.size(); i++){
            for(int j=0; j<perpLines.size(); j++){
                if(doesFourthPointExist(slope, lines.get(i), perpSlope, perpLines.get(j), pointsMap)){
                    double area = getArea(lines.get(i), perpLines.get(j));
                    if(area<min) min = area;
                }
            }
        }

        return min;
    }

    public static double getArea(int[] ab, int[] bc){
        double area = 0;

        return area;
    }

    public static boolean doesFourthPointExist(double slope, int[] ab, double perpSlope, int[] bc, Map<Integer, Set<Integer>> pointsMap){
        int abx1 = ab[0];
        int aby1 = ab[1];

        int abx2 = ab[2];
        int aby2 = ab[3];

        int bcx1 = bc[0];
        int bcy1 = bc[1];

        int bcx2 = bc[2];
        int bcy2 = bc[3];

        if(abx1 == bcx1 && aby1 == bcy1){
            int[] fourthPoint = calculateFourthPoint(perpSlope, abx2, aby2, slope, bcx2, bcy2);
        }else if(abx1 == bcx2 && aby1 == bcy2){

        }
        else if(abx2 == bcx1 && aby2 == bcy1){

        }else if(abx2 == bcx2 && aby2 == aby2){

        }

        return false;
    }

    public static int[] calculateFourthPoint(double slope1, int x1, int y1, double slope2, int x2, int y2){
        int[] fourthPoint = new int[4];



        return fourthPoint;
    }

    public static double findSlope(int x1, int y1, int x2, int y2){
        double xDelta = x1-x2;
        double yDelta = y1-y2;
        double slope = yDelta/xDelta;
        return slope;
    }
}





















