import java.util.*;
class Edges {
    char v;
    int w;
    Edges(char v, int w){
        this.v=v;
        this.w=w;
    }
}

class Edge{
    char v;
    char p;
    int w;
    public Edge(char v, char p, int w) {
        this.v = v;
        this.p = p;
        this.w = w;
    }
}
public class Railway {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int n=5;

        Map<Character,List<Edges>> map=new HashMap<>();
        String l1;
        while( in.hasNextLine() && !(l1 =in.nextLine()).isEmpty()){

            char[]line= l1.toCharArray();

            if(!map.containsKey(line[0])){
                map.put(line[0],new ArrayList<>());
            }
            map.get(line[0]).add(new Edges(line[2],line[4]-'0'));
        }
        //System.out.println(map);

        PriorityQueue<Edge> pq=new PriorityQueue<>(Comparator.comparingInt(e->e.w));
        pq.add(new Edge('A','0',0));
        boolean[]visited=new boolean[n];
        int sum=0;
        while(!pq.isEmpty()){
            Edge e=pq.remove();
            char v=e.v;
            char p=e.p;
            int w=e.w;
            if(visited[v-'A']){
                continue;
            }
            visited[v-'A']=true;
            sum+=w;
            if(p!='0'){
                System.out.println(v+"--"+p+" = "+w);
            }

            for(Edges a:map.getOrDefault(v, Collections.emptyList())){
                char ngr=a.v;
                int wgt=a.w;
                if(!visited[ngr-'A']){
                    pq.offer(new Edge(ngr,v,wgt));
                }
            }
        }
        System.out.println("Minimum spanning tree cost: "+sum);
    }
}
