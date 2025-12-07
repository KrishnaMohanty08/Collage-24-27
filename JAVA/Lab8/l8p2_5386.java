import java.util.Scanner;
import java.io.File;
import java.io.*;

class CopyFile{
    public void character(){
        try{

            File file1 =new File("hello.txt");
            FileWriter file2 =new FileWriter("copied.txt");
            
            Scanner  reader=new Scanner(file1);

            while(reader.hasNextLine()){
                String data = reader.nextLine();
                file2.write(data+"\n");
            }
            file2.close();
            reader.close();
            System.out.println("Done Successfully");
        }catch(FileNotFoundException e){
            System.out.println("not found or read"+e.getMessage());
        }catch(IOException e){
            System.out.println("can't write"+e.getMessage());
        }
    }

    public void bytes(){
        try{

            FileInputStream fin =new FileInputStream("hello.txt");
            FileOutputStream file2 =new FileOutputStream("copied.txt");
            
            byte[] buffer =new byte[1024];
            int bytesRead;

            while((bytesRead=fin.read(buffer))!=-1){
                file2.write(buffer,0,bytesRead);
            }
            file2.close();
            fin.close();
            
        }catch(IOException e){
            System.out.println("can't write"+e.getMessage());
        }
    }

}
public class l8p2_5386 {
    
    public static void main(String[] args) {
        CopyFile copy=new CopyFile();
        copy.character();
        copy.bytes();
    }
}
