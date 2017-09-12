/**
 * Created by bao on 9/6/17.
 * Implementation of Dijkstra algorithm
 */
import java.util.*;

public class dijkstraAlgo {

    static boolean allVisited(boolean[] visited){
        for (int i=0; i< visited.length; i++)
            if (!visited[i])
                return false;
        return true;
    }
    static void traceback(int[] p, int dest) {
        int parent = p[dest];
        while (parent != -1){
           System.out.print(parent + " ");
           parent = p[parent];
        }
        System.out.println();
    }

    static void dijkstra(int[][] w, int n, int s){
        boolean[] visited = new boolean[n];
        int[] d = new int[n];
        int[] p = new int[n];
        int oo = 10000000;
        int i,j, nearestV, minDist;
        for (i=0; i < n; i++)
            d[i] = oo;
        d[s] = 0;
        p[s] = -1;
        while (!allVisited(visited)){
            minDist = oo;
            nearestV = 0;
            for (i=0; i< n; i++){
                if (!visited[i] && d[i] < minDist){
                    minDist = d[i];
                    nearestV = i;
                }
            }
            visited[nearestV] = true;
            for (i=0; i< n; i++) {
                if (w[nearestV][i] > 0 && d[nearestV] + w[nearestV][i] < d[i]) {
                    d[i] = d[nearestV] + w[nearestV][i];
                    p[i] = nearestV;
                }
            }
        }
        for (i=0; i<n; i++){
            System.out.println("Shortest route from " + s+ " to " + i + " is " + d[i]);
            traceback(p, i);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int i,j,k,l;
        int[][] graph = new int[n][n];
        for (i=0; i< m; i++){
            j = sc.nextInt();
            k = sc.nextInt();
            l = sc.nextInt();
            graph[j][k] = l;
            graph[k][j] = l;
        }
        dijkstra(graph,n, s);
    }
}
