import java.util.*;

public class Delivery_from_Warehouse {
    public static void dijkstra(List<List<int[]>> list,int src,int n){
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(e->e[1]));
        pq.add(new int[]{src,0});

        int[] dist =new int[n];
        int INF=(int)1e8;
        Arrays.fill(dist,INF);
        dist[src]=0;

        while(!pq.isEmpty()){
            int[]curr=pq.poll();
            int v=curr[0];
            int w=curr[1];
            if(w> dist[v])continue;
            for(int[]e:list.get(v)){
                int ng=e[0];
                int nw=e[1];
                if(dist[ng]>w+nw){
                    dist[ng]=w+nw;
                    pq.add(new int[]{ng, dist[ng]});
                }
            }
        }
        System.out.println("Shortest distances from source "+ src + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("To " + i + ": " + dist[i]);
        }
    }
    public static void main(String[] args) {
        int n=6;
        int src=0;
        List<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        int[][] roads = {
                {0, 1, 7},
                {0, 2, 9},
                {0, 5, 14},
                {1, 2, 10},
                {1, 3, 15},
                {2, 3, 11},
                {2, 5, 2},
                {3, 4, 6},
                {4, 5, 9}
        };
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            list.get(u).add(new int[]{v, w});
            list.get(v).add(new int[]{u, w});
        }
        dijkstra(list,src,n);
    }
}
