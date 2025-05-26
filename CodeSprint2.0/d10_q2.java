import java.util.*;

public class d10_q2{
  private final String[] keypad={
    "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
  };
  public List<String> ListPad(String nums){
    List<String> arrWords =new ArrayList<>();
    if(nums==null||nums.length()==0)return arrWords;
    backtrack(arrWords,new StringBuilder(),nums,0);
    return arrWords;
  }
  private void backtrack(List<String> arrWords,StringBuilder current,String nums,int i){
    if(i == nums.length()){
      arrWords.add(current.toString());
      return;
    }
    String letters=keypad[nums.charAt(i)-'0'];
    for(char c:letters.toCharArray()){
      current.append(c);
      backtrack(arrWords,current,nums,i+1);
      current.deleteCharAt(current.length()-1);
    }
  }
  public static void main(String args[]){
    d10_q2 ans=new d10_q2();
    Scanner sc=new Scanner(System.in);
    String digits=sc.nextLine();
    List<String> combination=ans.ListPad(digits);
    System.out.println(combination);
  }
}