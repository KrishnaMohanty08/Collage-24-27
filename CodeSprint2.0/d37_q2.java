import java.util.*;

public class d37_q2{
  private static final String[] belowTwenty={
    "","One","Two","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"
  };
  private static final String[]  tens={
    "","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"
  };
  private static final String[] thousands={
    "", "Thousand","Million","Billion" 
    };
  public static void main(String args[]){
    System.out.println(numToWords(Integer.parseInt(args[0])));
  }
  public static String numToWords(int num){
    if(num==0)return "Zero";
    int i=0;
    StringBuilder result=new StringBuilder();
    while(num>0){
      int digits=num%1000;
      if(digits!=0){
        String words=helper(digits).trim();
        if(!thousands[i].isEmpty())words+=" "+thousands[i];
        result.insert(0,words+" ");
      }num/=1000;
        i++;
    }
    return result.toString().trim();
  }
  private static String helper(int num){
    if(num==0)return "";
    else if(num<20) return belowTwenty[num]+" ";
    else if(num<100) return tens[num/10]+(num%10!=0?" "+helper(num%10):" ");
    else return belowTwenty[num/100]+"Hundred"+(num%100!=0?" "+helper(num%100):" ");
  }
  
}