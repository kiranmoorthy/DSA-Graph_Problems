import java.util.*;

public class Monkey {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k= in.nextInt();
        int j= in.nextInt();
        int m= in.nextInt();
        int p= in.nextInt();

        while(k>0 && j>0){
            if(k>=m){
                n--;
                k-=m;
            }
            else if(j>=p){
                n--;
                j-=p;
            }
            else {
                k-=m;
                j-=p;
            }
        }
        System.out.printf("Total number of monkeys sitting in the tree : %d",n);
    }
}