package hajjproject;


import java.io.*;
import java.util.Scanner;

//This is a Hajj Reservation System. It allows the pilgrim to book a Hajj reservation.
public class HajjReservationSystem 
        
{   
    public static void main(String[] args) throws FileNotFoundException, IOException
    {   
        System.out.println("Welcome to your hajj booking!");
        System.out.println("--------------------------------------------------");
        
        Reservation newReservation = new Reservation();
        newReservation.createReservation();
    //The writeFile method, it writes all user information.
    
    System.out.println("\n--------------------------------------------------");
        System.out.println("                Confirm Your Information               ");
        System.out.println("--------------------------------------------------");
    }
}