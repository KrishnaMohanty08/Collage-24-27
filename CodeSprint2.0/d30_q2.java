import java.util.*;
public class d30_q2{
  public static int minMana(int[] merlin,int[] morgana){
    int maxMorgana=Integer.MIN_VALUE;
    for(int power:morgana){
      maxMorgana=Math.max(maxMorgana,power);
    }int mana=0;
    for(int power : merlin){
      if(power <=maxMorgana){
        mana+=(maxMorgana+1-power);
      }
    }return mana;
  }
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] merlin=new int[n];
    for(int i=0;i<n;i++)merlin[i]=sc.nextInt();
    int m=sc.nextInt();
    int[] morgana=new int[m];
    for(int i=0;i<m;i++)morgana[i]=sc.nextInt();
    System.out.println(minMana(merlin,morgana));
  }
}