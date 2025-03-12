import java.util.*;

public class l7p2_5386 {

    StringBuilder Revword= new StringBuilder();

    void reverse(String word){
        for(int i=0;i<word.length();i++){
            Revword.append(word.charAt(word.length()-i-1));

        }
        System.out.println(Revword);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();

        l7p2_5386 obj=new l7p2_5386();
        obj.reverse(word);
    }
}
