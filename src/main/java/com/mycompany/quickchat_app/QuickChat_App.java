/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.quickchat_app;


import java.util.Scanner;

/**
 *
 * @author Ashlyn Whittaker
 */

public class QuickChat_App {

    private static Storedmessagemanager Storedmessagesmanager;
 
    public static void main(String[] args) {
        //create an object for scanner class
        Scanner input = new Scanner(System.in);
        
        //create message object
        Message message = new Message();
        
        message.runQuickChat(input);

Storedmessagesmanager = new Storedmessagemanager();

        Login login =new Login();

        //Declaring variables
        String firstName, secondName, userName, password, cellPhoneNumber;

        //ask user to input
        System.out.println("Please enter your firstName:");
        firstName = input.nextLine();
        System.out.println("Please enter your secondName:");
        secondName = input.nextLine();
        System.out.println("Please enter your userName:");
        userName = input.nextLine();
        //validate
        if (login.checkuserName(userName)) {
            System.out.println("username successfully captured:");
        } else {
            System.out.println("incorrectly formatted:");
        }

        System.out.println("Please enter your password:");
        password = input.nextLine();
        //validate
         if (login.checkPasswordComplexity(password)) {
            System.out.println("Password sucessfully captured");
             
         }else{
             System.out.println("Password not correctly formatted ,please ensure that password contains atleast eight charactes long , a number and special character");
         }
                
        System.out.println("Please enter your cellPhoneNumber:");
        cellPhoneNumber = input.nextLine();
        //validate   
        if (login.checkCellphoneNumber(cellPhoneNumber)) {
            System.out.println("Cellphone number successfully added.");
        } else {
            System.out.println("Cellphone number incorrect.");
        }

        //display the registration class 
        System.out.println(login.registerUser(firstName, secondName, userName, cellPhoneNumber));

        //declare temporary variables to allow user to login 
        String loginUsername, loginPassword;

        System.out.println("***********LOGIN***********");
        System.out.println("Please enter your login username:");
        loginUsername = input.nextLine();
        System.out.println("Please enter your login password:");
        loginPassword = input.nextLine();
       System.out.println(login.returnLoginStatus(firstName, secondName, userName, password, loginUsername, loginPassword));
            
    }
} 

   


    
         
    
       
     

    
    

   
    
