package hajjproject;

import java.util.Random; 
import java.util.Scanner; 

//This is the first class. This class gathers the user's personal information.
public class PilgrimInformation 
{
    //Fields
    private boolean residentOrVisitor;
    private String fullName;
    private String country;
    private int age;
    private boolean vaccinate;
    private String iD;
    int vaccineChoice;
    private int bookNum;
    Scanner scan = new Scanner (System.in);
    
    //Constructor that takes all arguments.
    public PilgrimInformation(boolean residentOrVisitor, String fullName, String country, int age, boolean vaccinate, String iD, int vaccineChoice, int bookNum) {
        this.residentOrVisitor = residentOrVisitor;
        this.fullName = fullName;
        this.country = country;
        this.age = age;
        this.vaccinate = vaccinate;
        this.iD = iD;
        this.vaccineChoice = vaccineChoice;
        this.bookNum = bookNum;
    }
  
    //Constructor that takes no arguments.
    public PilgrimInformation() 
    {
        residentOrVisitor = true;
        fullName = "";
        country = "";
        age = 0;
        vaccinate = true;
        iD = "";   
    }
    
    //This is a copy constructor, used in another class.
    public PilgrimInformation(PilgrimInformation personalInfo)
    { 
        this.residentOrVisitor = personalInfo.residentOrVisitor;
        this.fullName = personalInfo.fullName;
        this.country = personalInfo.country;
        this.age = personalInfo.age;
        this.vaccinate = personalInfo.vaccinate;
        this.iD = personalInfo.iD;
        this.bookNum = personalInfo.bookNum;
    }
    
    //Next are setters and getters
    public void setFullName(String fullName) 
    {
        fullName = scan.nextLine();
        if (fullName.length()<3){
            System.out.println("enter the full name again:");
            setFullName(fullName);
            
            
        }
        this.fullName = fullName;
        
    }
    
    public String getFullName() 
    {
        return fullName;
    }
   
    public void setCountry(String country) 
    {
        country = scan.nextLine();
        if (country.length()<3){
            System.out.println("enter the country again:");
            setCountry(country);}
        this.country = country;
        
    }
    
    public String getCountry() 
    {
        return country; 
    }
    
    public void setID(String iD)
    {
        iD = scan.nextLine();
        if (iD.length()!=10){
            System.out.println("enter the ID again:");
         
            setID(iD);}
        else {
            for (int i = 0; i < iD.length(); i++) {
            if (!Character.isDigit(iD.charAt(i)) ){

                System.out.println("Please all must be digit");
                setID(iD);
                break;
            }
                
            }
      
        }
             this.iD = iD;
    }    
    
    public String getID()
    {
        return iD;
    }
    
    //isResident is a method that returns the user's choice as boolean, it is used in the setResidentOrVisitor method.
    public boolean isResident(int choice)
    {       
        if(choice == 1)
        {
            return true;
        }
        
        else if(choice == 2)
        {
            return false;
        }
        
        else
        { //if chosen other than 1 or 2
            while(choice != 1 && choice!=2)
            {
                System.out.println("Wrong input");
                System.out.print("Try again: ");
                choice = scan.nextInt();
            }            
        }
        return false;
    }
    
    public void setResidentOrVisitor(boolean residentOrVisitor) 
    {        
        int choice = scan.nextInt();
        //setting the isResident boolean value to the variable
        this.residentOrVisitor = isResident(choice);
    }
        
    public String getResidentOrVisitor() 
    {
        if(residentOrVisitor == true){
            return "resident";
        }
        else
        {
            return "visitor";   
        } 
    }
   
    public void setAge(int age) 
    {
        age = scan.nextInt();
        this.age = age;
    }
    
    public int getAge() 
    {
        return age;
    }

    public void setVaccinate(boolean vaccine)
    {        
        vaccineChoice= scan.nextInt();
        
        if(vaccineChoice == 1)
        {
            vaccine = true;
        }
        else if(vaccineChoice == 2)
        {
            vaccine = false;
        }
        else
        {
            while(vaccineChoice != 1 && vaccineChoice!=2)
            {
                System.out.println("Wrong input");
                System.out.print("Try again: ");
                vaccineChoice = scan.nextInt(); 
            }        
        }
        this.vaccinate = vaccine;
    }
    
    public String getVaccinate()
    {
        if(vaccinate == true)
            return "Vaccinated";
        else
            return "NOT vaccinated";        
    }
    
    public int getBookNumber()
    {
        return bookNum;
    }   
    
    public void setBookingNumber()
    {	
	Random r = new Random();		
	int number=r.nextInt(50000);
	bookNum = number;
    }
    
    //String method returning all information of this class.
    public String toString()
    {
        return "\nYour full name is: " +getFullName()+ "\nYou are a: "+getResidentOrVisitor()+"\nYour ID is: "+iD+"\nYou are from: "+country+
                "\nYour age is: "+getAge()+"\nYou are: "+getVaccinate()+"\nYour booking number is: "+getBookNumber();
    }   
}