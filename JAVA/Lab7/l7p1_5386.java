import java.util.*;

public class l7p1_5386{

    StringBuilder sb = new StringBuilder();

    void caseChange(String str){

        for(char c : str.toCharArray()){
            sb.append(Character.isUpperCase(c)?Character.toLowerCase(c):Character.toUpperCase(c));
        }
        System.out.println(sb.toString());
    }

    StringBuilder reverse(String word){
        StringBuilder Revword= new StringBuilder();

        for(int i=0;i<word.length();i++){
            Revword.append(word.charAt(word.length()-i-1));

        }
        return Revword;
    }

    boolean isPalindrome(String word){
        String Rev=reverse(word).toString();
        return word.equals(Rev);
    }

    int found(String word,char c){
        int notFound=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==c)return i; 
        }
        return notFound;
    }
    
    void check(String word){

        System.out.println("Number of word"+word.length());

        word=word.toLowerCase();
        
        int vowel=0;
        int consonant=0;
        int number =0;

        for(int i=0;i<word.length();i++){
            char c= word.charAt(i);
            if((c>65 || c<90)||(c>97 && c<122)||(c>48 && c<57)){
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    vowel++;
                }
                else consonant++;
                if(c>48 && c<57){
                    number++;
                }
            }
            
        }
        System.out.println("vowel :"+vowel);
        System.out.println("consonant :"+consonant);
        System.out.println("number :"+number);
        
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        l7p1_5386 obj = new l7p1_5386();

        String str=sc.nextLine();        
        obj.caseChange(str);

        String word=sc.nextLine();
        obj.reverse(word);

        System.out.println(word.compareTo(str));

        System.out.println("Str+word :"+str.concat(word));

        System.out.println("isPalindrome :"+obj.isPalindrome(word));

        System.out.println("is found char =h :"+obj.found(word,'h'));

        obj.check(word);
    }
}