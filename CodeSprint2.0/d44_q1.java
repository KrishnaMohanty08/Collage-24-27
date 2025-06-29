import java.util.*;
public class d44_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    sc.nextLine();
    String[] words=new String[n];
    for(int i=0;i<n;i++){
      words[i]=sc.nextLine().trim();
    }System.out.println(maxProduct(words));
  }
  public static int maxProduct(String[] words){
    int n=words.length;
    int[] bitmask=new int[n];
    int[] lengths=new int[n];
    for(int i=0;i<n;i++){
      int mask=0;
      for(char c:words[i].toCharArray()){
        mask |= (1<<(c-'a'));
      }bitmask[i]=mask;
      lengths[i]=words[i].length();
    }
    int maxProduct=0;
    for(int i=0;i<n;i++){
      for(int j=i+1;j<n;j++){
        if((bitmask[i] & bitmask[j])==0){
          maxProduct=Math.max(maxProduct,lengths[i]*lengths[j]);
        }
      }
    }
    return maxProduct;
  }
}