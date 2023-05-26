package hajjproject;

import java.util.Scanner;

//This is the third class, it handles the payment information.
public class Payment 
{
    private String cardHolderFullName;
    private String cardNumber;
    private int cvv;
    private int paymentMethod;
    private CampaignChoice campChoice; 
    private PilgrimInformation pilgrimInfo;
    
    Scanner scan = new Scanner (System.in);

    //Constructors that takes all arguments.
    public Payment(String cardHolderFullName, String cardNumber, int cvv, int paymentMethod, CampaignChoice campChoice, PilgrimInformation pilgrimInfo) 
    {
        this.cardHolderFullName = cardHolderFullName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;       
        this.paymentMethod = paymentMethod;
        this.campChoice = new CampaignChoice(campChoice); 
        this.pilgrimInfo = new PilgrimInformation(pilgrimInfo);
    }
    
    //Constructor that takes no arguments.
    public Payment()
    {
        cardHolderFullName = "";
        cardNumber = null;
        cvv = 000;      
    }
    
    //Next are setters and getters
    public void setpaymentMethod()
    {   try{
        int paymentChoice = scan.nextInt();        
        scan.nextLine();
        
        while(paymentChoice != 1 && paymentChoice != 2 && paymentChoice != 3 && paymentChoice != 4)
        {
            
            System.out.print("Your choice is invalid, please try again: ");
            paymentChoice = scan.nextInt();
            scan.nextLine();
        }
        paymentMethod = paymentChoice;
        
    }
        catch(Exception e){
            System.out.println("enter the number ");
            
        }
        
    }

    //paymentMethod is a method that returns the user's choice as String, it is used in the getPaymentMethod method.
    public String paymentMethod()
    {
        if (paymentMethod == 1)
        {
            return "visa";
        }       
        else if(paymentMethod == 2)
        {
            return "mastercard";
        }
        else if(paymentMethod == 3)
        {
            return "paypal";
        }
        else
        {
            return "apple pay";
        }     
    }
    
    public String getPaymentMethod()
    {
        return paymentMethod();
    }
        
    public void setCardHolderFullName(String cardHolderFullName) 
    {
       
        cardHolderFullName = scan.nextLine();
        if (cardHolderFullName.length()<3){
            System.out.println("enter the full name in crdit card again:");
           }
        this.cardHolderFullName= cardHolderFullName;
        
    
        
    }

    public void setCardNumber(String cardNumber) 
    {
        
        cardNumber = scan.nextLine();
        
        if (cardNumber.length()<3)
        {
            System.out.println("enter the full number in crdit card:");
        }
        
        this.cardNumber = cardNumber;
    }

    public void setCvv(int cvv) 
    { 
        cvv = scan.nextInt();
        this.cvv = cvv; 
    }

    public String getCardHolderFullName() 
    {
        return cardHolderFullName;
    }

    public String getCardNumber() 
    {
        return cardNumber;
    }

    public int getCvv() 
    {
        return cvv;
    }
      
    //String method returning all information of this class.
    public String toString()
    {
        return "\nYour card name is: "+getCardHolderFullName()+ "\nYour card number is: "+
                getCardNumber()+ "\nYour cvv is: "+getCvv()+ "\nYour payment method is: "+getPaymentMethod();               
    }
}
