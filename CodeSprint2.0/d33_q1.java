import java.util.*;
public class d33_q1{
  public static String splitS(int n,int k,int[] themes){
    Map<Integer,Integer> themeCounts=new HashMap<>();
    for(int theme:themes){
      themeCounts.put(theme,themeCounts.getOrDefault(theme,0)+1);
    }int uniqueThemes=themeCounts.size();

    int duplicate=0;
    for(int count:themeCounts.values()){
      if(count>=2){
        duplicate++;
      }
    }
    if(duplicate+(uniqueThemes-duplicate)/2>=k){
      return"YES";
    }else{
      return "NO";
    }
  }
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    int[] themes=new int[n];
    for(int i=0;i<n;i++){
      themes[i]=sc.nextInt();
    }
    System.out.println(splitS(n,k,themes));
  }
}