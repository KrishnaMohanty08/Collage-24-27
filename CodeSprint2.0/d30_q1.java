import java.util.*;

public class d30_q1{
  public static int countSlips(String path){
    Set<String> visited =new HashSet<>();
    int x=0,y=0;
    visited.add("0,0");
    int slips=0;
    for(char move:path.toCharArray()){
        if(move=='L')x--;
        else if(move=='R')x++;
        else if(move=='U')y++;
        else if(move =='D')y--;
        String pos=x+","+y;
          if(visited.contains(pos)){
            slips++;
          }else{
            visited.add(pos);
          }
    }return slips;
  }
  public static void main(String args[]){
    System.out.println(countSlips(args[0]));
  }
}