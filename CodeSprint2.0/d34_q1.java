import java.util.*;
public class d34_q1{
  public static void main(String args[]){
    int n=Integer.parseInt(args[0]);
    boolean[] isPrime=new boolean[n];
    Arrays.fill(isPrime,true);
    isPrime[0]=isPrime[1]=false;
    for(int i=2;i*i<n;i++){
      if(isPrime[i]){
        for(int j=i*i;j<n;j+=i){
          isPrime[j]=false;
        }
      }
    }
    ArrayList<Integer> primes=new ArrayList<>();
    for(int i=2;i<n;i++){
      if(isPrime[i])primes.add(i);
    }
    ArrayList<Integer> Sprime=new ArrayList<>();
    for(int i=0;i<primes.size();i++){
      int pos=i+1;
      if(isPrime[pos]){
        Sprime.add(primes.get(i));
      }
    }
    System.out.println(Sprime);
  }
}