package hajjproject;

import java.util.Scanner;

//This is the second class, it allows the user choose their desired campaign choice.
public class CampaignChoice 
{
    //Fields
    private int campChoice;
    final int campA = 10000;
    final int campB = 7000;
    final int campC = 5000;
    int finalprice;   
    
    Scanner scan = new Scanner (System.in);
    
    //Constructor that takes all arguments.
    public CampaignChoice(int campChoice, int finalprice,final int campA, final int campB, final int campC) 
    {
        this.campChoice = campChoice;
        this.finalprice = finalprice;        
    }
    
    //Constructor that takes no arguments.
    public CampaignChoice()
    {
        campChoice=0;
        finalprice = 0;
    }
   
    //This is a copy constructor, used in another class.
    public CampaignChoice (CampaignChoice pilgrimCamp){
        this.campChoice = pilgrimCamp.campChoice;
        this.finalprice = pilgrimCamp.finalprice;        
    }

    //Next are setters and getters
    public void setChoice(int campChoice)
    {
        try{
            System.out.println("Please enter (1) if you choose campaign A: " +campA+ "SR");
        System.out.println("Please enter (2) if you choose campaign B: " +campB+ "SR");
        System.out.println("Please enter (3) if you choose campaign C: " +campC+ "SR");
        System.out.print("Your choice is: ");
        int inputcampChoice = scan.nextInt();    
        while(inputcampChoice!= 1 && inputcampChoice!= 2 && inputcampChoice != 3){
            System.out.print("Your choice is invalid, please try again: ");
            inputcampChoice= scan.nextInt();
        }
        this.campChoice = inputcampChoice;
        return;
        
        
    }
        catch(Exception e){
            System.out.println("enter number");
            scan.next();
            
            
        }
         setChoice(0);
            return;
        
    }
       
    //campType is a method that returns the user's choice as String, it is used in the getChoice method.
    public String campType(){
        if (campChoice == 1)
        {
            return "Campaign (A)";
        }
        else if(campChoice == 2)
        {
            return "Campaign (B)";
        }
        else
        {
            return "Campaign (C)";
        }   
    }
    
    public String getChoice()
    {
        return campType();
    }

    public void setFinalPrice (int price)
    {
        if(this.campChoice== 1)
        {
            price=campA;
        }
        else if(this.campChoice== 2)
        {
            price=campB;
        }
        else if(this.campChoice== 3)
        {
            price = campC;
        }
        finalprice = price;
    }
    
    public int getFinalPrice()
    {
        return finalprice;
    }
   
    //String method returning all information of this class.
    public String toString()
    {
        String text = "\nYour campaign choice is: " +getChoice()
                    +"\nYour final price is: "+getFinalPrice();                              
        return text;
    }
}