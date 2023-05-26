/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hajjproject;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author maial
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author maial
 */
public class FileClass  {

    
    private static FileClass instance = null;
    
    private FileClass(){
        
    }
    
    public static FileClass getInstance(){
        if(instance==null){
            instance = new FileClass();
        }
        return instance;
    }
    
    
    public static void writeFile(PilgrimInformation pilgrim, CampaignChoice choice, Payment pay) throws FileNotFoundException, IOException
    { 
        try {
            FileWriter outputhajj = new FileWriter("Hajj Application.txt",true);
                    outputhajj.write(pilgrim.toString());
        outputhajj.write(choice.toString());
        outputhajj.write(pay.toString()); 
        outputhajj.close(); //close file 
} catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}           
    }  
       
    //The readFile method, it reads all user information, prints it to the console.
    public static void readFile() throws FileNotFoundException
    {
        String line;
        File read = new File("Hajj Application.txt"); 
        Scanner scan_file = new Scanner(read);  
        //Keep reading while the file still has information to read.
        while(scan_file.hasNext())
        {
            line = scan_file.nextLine();
            System.out.println(line);
        }
        //Close the file.
        scan_file.close();   
    }
}