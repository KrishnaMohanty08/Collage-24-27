import java.io.*;
import java.util.Scanner;

public class l8p3_5386 {

    public static void main(String[] args) {
        
        int lineCount=1;
        int wordCount=0;
        int charCount=1;
        
        try{
            File myFile=new File("hello.txt");

            Scanner read=new Scanner(myFile);


            while(read.hasNext()){
                String data=read.nextLine();
                String words[]=data.split(" ");

                for(String word:words){
                    wordCount++;
                }
                charCount+=data.length();
                lineCount++;
            }
            
            System.out.println("number of lines:"+lineCount);
            System.out.println("number of words:"+wordCount);
            System.out.println("number of lines:"+charCount);

            read.close();

        }catch(FileNotFoundException e){
            System.out.println("File not found recheck the name");
        }
        
    }
}
