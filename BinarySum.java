import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BinarySum {
    public static void main(String[] args){

        long sum = 0;
        String file = "Excercise17_02.dat";

        try(DataInputStream binary = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))){

        while(true){
            try{
                int binaryNumber = binary.readInt();
                sum += binaryNumber;
            }
            catch(EOFException e){
                break;
            }
        }

    }
    catch(FileNotFoundException e){
        System.out.println("Could not find the file: " + file);
        return;
    }
    catch(IOException e){
        System.out.println("Could not read file: " + file);
        return;
    }

    System.out.println("The sum of the integers is: " + sum);

}
}