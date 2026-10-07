import java.io.FileWriter;
import java.io.IOException;

public class try_write{
    public static void main(String[] args){
        try{
            FileWriter myWriter=new FileWriter(file.txt);
            myWriter.write("Hello i have been learning java");
            myWriter.close();
            System.out.println("File created successfully");
        }
    }
}