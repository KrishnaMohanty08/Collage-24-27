import java.util.*;
import java.io.IOException;
import java.io.File;

public class CreateFile {
    public static void main(String[] args) {
        try{
            File myObj =new File("./hellyKiity.txt");
            if(myObj.createNewFile()){
                System.out.println("File Created:" +myObj.getName());
            }
            else{
                System.out.println("File already exists.");
            }            
        }catch(IOException e){
            System.out.println("An error occured");
            System.out.println(e.getMessage());
        }
    }
}
