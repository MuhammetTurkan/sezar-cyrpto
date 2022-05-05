
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class CaesarCipherProgram {
        public static void main(String args[]) throws IOException {
        File file =new File("task.txt");
        String ciphertext = null;
        
        FileReader fileReader;
        char veriler [] = new char [ (int) file.length() ];
        try {
        	fileReader = new FileReader(file);
        	fileReader.read(veriler);
        	ciphertext = new String (veriler);
        }
        catch (FileNotFoundException e) {
        	System.out.println("Could not find the file you are looking for.. :\n"+ e.getMessage());
        }
        catch (IOException e) {
        	System.out.println("I Can't Read Data On The File You Are Looking For. \n" + e.getMessage());
        }
        
        String shiftString = null;
        File fileShift = new File("shift.txt");
        char shiftChar [] = new char [ (int) fileShift.length() ];
        try {
        	fileReader = new FileReader(fileShift);
        	fileReader.read(shiftChar);
        	shiftString = new String (shiftChar);
        }
        catch (FileNotFoundException e) {
        	System.out.println("Could not find the file you are looking for.. :\n"+ e.getMessage());
        }
        catch (IOException e) {
        	System.out.println("I Can't Read Data On The File You Are Looking For. \n" + e.getMessage());
        }
        int shift = Integer.parseInt(shiftString);
        shift = shift % 26 ; // mod alma 
        String decryptMessage = "";
        
        for(int i=0; i < ciphertext.length();i++)  

        {
            // Shift one character at a time
            char alphabet = ciphertext.charAt(i);
            // if alphabet lies between a and z 
            if(alphabet >= 'a' && alphabet <= 'z')
            {
                // shift alphabet
                alphabet = (char) (alphabet - shift);
            
                // shift alphabet lesser than 'a'
                if(alphabet < 'a') {
                    //reshift to starting position 
                    alphabet = (char) (alphabet-'a'+'z'+1);
                }
                decryptMessage = decryptMessage + alphabet;
            }    
                // if alphabet lies between A and Z
            else if(alphabet >= 'A' && alphabet <= 'Z')
            {
             // shift alphabet
                alphabet = (char) (alphabet - shift);
                
                //shift alphabet lesser than 'A'
                if (alphabet < 'A') {
                    // reshift to starting position 
                    alphabet = (char) (alphabet-'A'+'Z'+1);
                }
                decryptMessage = decryptMessage + alphabet;            
            }
            else 
            {
             decryptMessage = decryptMessage + alphabet;            
            } 
        }
        
        File decrypTask = new File ("decrypTask.txt");
        if (!decrypTask.exists()) {
        	decrypTask.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(decrypTask, false);
        BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
        bufferedWriter.write(decryptMessage);
        bufferedWriter.close();
    }
}
