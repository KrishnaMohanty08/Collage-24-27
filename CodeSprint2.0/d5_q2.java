import java.util.*;

public class d5_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    String word=sc.next();
    HashMap<Character,Integer> map=new HashMap<>();
    
    for(int i=0;i<word.length();i++){
      map.put(word.charAt(i),map.getOrDefault(word.charAt(i)+1,1));
    }
    int freq=-1;
    boolean balanced=true;
    for(int value:map.values()){
      if(freq==-1){
        freq=value;
      }else if(freq!=value){
        balanced=false;
        break;
      }
    }
    if(balanced==true){
      System.out.println("Aashriya smiles:emotional balance");
    }else{
      System.out.println("Aashriya wonders:these thoughts were scattered");
    }
    
  }
}