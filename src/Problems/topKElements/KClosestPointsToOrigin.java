package Problems.topKElements;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    static class Point {
        int[] coordinates;
        int dist;

        Point(int[] c, int d) {
            this.dist = d;
            this.coordinates = c;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>((a, b) -> b.dist - a.dist);

        for (int[] point : points) {
            int euclDist = point[0] * point[0] + point[1] * point[1];
            Point currPoint = new Point(point, euclDist);

            maxHeap.add(currPoint);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }

        }

        int[][] result = new int[k][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll().coordinates;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {
            {3,3},{5,-1},{-2,4}
        };
        int k = 2;
        
        System.out.println(kClosest(points, k));
    }
}
