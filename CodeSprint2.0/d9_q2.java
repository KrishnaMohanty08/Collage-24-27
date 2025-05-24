import java.util.*;

public class d9_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    String pattern=sc.next();
    String logStream=sc.next();
    ArrayList<Integer> freq=new ArrayList<>();

    int l=pattern.length();
    
    for(int i=0;i<=logStream.length()-l;i++){
      String word =logStream.substring(i,i+l);
      if(anagram(word,pattern)){
        freq.add(i);
        }
    }System.out.print(freq);
  }
  public static boolean anagram(String word,String pattern){
    boolean ana=false;
    String smallWord =word.toLowerCase();
    String smallPattern=word.toLowerCase();
    char[] arr1=smallWord.toCharArray();
    char[] arr2=smallPattern.toCharArray();

    Arrays.sort(arr1);
    Arrays.sort(arr2);
    
    if(Arrays.equals(arr1,arr2))ana=true;
    else ana=false;
    
    return ana;
  }
}