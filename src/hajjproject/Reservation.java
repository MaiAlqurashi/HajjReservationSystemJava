/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hajjproject;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author maial
 */

//facade
public class Reservation {
    
    public Reservation(){
        
    }
     public static void createReservation() throws FileNotFoundException, IOException{
    int age = 0;
        String country = "" , iD = "", fullName = "";      
        
        
        //Calling first class without arguments
        PilgrimInformation pilgrim = new PilgrimInformation();
        //Prompt the user, then set the values
        System.out.print("Please enter your full name: ");             
        pilgrim.setFullName(fullName);
            
        System.out.print("Please enter your country: " );
        pilgrim.setCountry(country);
        
        System.out.print("Please enter your ID number: ");
        pilgrim.setID(iD);
        
        boolean vaccinated = true, isResident = true;        
        System.out.print("Please enter (1) if you are vaccinated, and (2) if you are NOT vaccinated: ");
        pilgrim.setVaccinate(vaccinated); 
        //Pilgrim has to be vaccinated at least 3 months prior
        //If pilgrim was not vaccinated, exit the system.
        if(pilgrim.vaccineChoice == 2)
        { 
            System.out.println("Sorry, you have to be vaccinated to go to hajj");
            System.exit(0);
        }
        
        System.out.print("Please enter (1) if you are a resident, and (2) if you are a visitor: ");
        pilgrim.setResidentOrVisitor(isResident);
        
        System.out.print("Please enter your age: ");
        pilgrim.setAge(age);
        //End of gathering first class information, set a booking number for the user.
        pilgrim.setBookingNumber();
        
        //Campaign Choice Section
        System.out.println("--------------------------------------------------");
        //Calling an object from the second class
        CampaignChoice choice = new CampaignChoice();
        int campChoice = 0;
        int price = 0;  
        choice.setChoice(campChoice);
        choice.setFinalPrice(price);
           
        //Payment Section
        System.out.println("--------------------------------------------------");
        //Calling an object from the third class
        Payment pay = new Payment("","", 0, 0 , choice, pilgrim);     
        
        String cardHolderName = "" , cardNumber = "";
        int cvv = 0;   
        //Prompt the user for payment information, then set.
        System.out.println("Please enter (1) if you choose visa");
        System.out.println("Please enter (2) if you choose mastercard");
        System.out.println("Please enter (3) if you choose paypal");
        System.out.println("Please enter (4) if you choose apple pay");
        System.out.print("Your choice is: ");
        pay.setpaymentMethod();
        
        System.out.print("Please enter Card Holder Full Name: ");        
        pay.setCardHolderFullName(cardHolderName); 
        
        System.out.print("Please enter Card Number: ");
        pay.setCardNumber(cardNumber);
        
        System.out.print("Please enter card CVV number (three digits at the back of the card): ");
        pay.setCvv(cvv);
        
        makeFile(pilgrim, choice, pay);
        
     }
        public static void makeFile(PilgrimInformation pilgrim, CampaignChoice choice, Payment pay) throws FileNotFoundException, IOException{
        //Calling the writteFile method, then reading from the file
        FileClass file = FileClass.getInstance();
        file.writeFile(pilgrim, choice, pay);
       
        System.out.println("\n--------------------------------------------------");
        System.out.println("                Confirm Your Information               ");
        System.out.println("--------------------------------------------------");
        //Calling the readFile method to print out all information.
        file.readFile();    
     }

}