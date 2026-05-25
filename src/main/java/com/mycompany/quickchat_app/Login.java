/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat_app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ashlyn Whittaker
 */
class Login {
    //Methode to validate the username
    boolean checkuserName(String username){
        return username.contains("_") && username.length() <= 5;
        
    } 
     //Method that validates tp store cellphone number   
     boolean checkCellphoneNumber(String cellphonenumber){
         
        //declare a variable to store the pattern 
         String regex = "^(\\+27|0)[6-8][0-9]{8}$";
         
         //Pattern object to compile my regex pattern
         Pattern pattern =Pattern.compile(regex);
         
         //Matcher object to compare the cellphone to the pattern
         Matcher matcher = pattern.matcher(cellphonenumber);
         
         //Return true if cellphone number matches the pattern 
         return matcher.matches();
     } 
     boolean checkPasswordComplexity(String password){
         
         //declare a variable to store the pattern
        String regex = "^(0-9)[A-Z][@#$%&*]{8}$"; 
        return password.contains("@#$%&*") && password.length() >=8;
         
     }
        
     //Method to return registration statues   
    String registerUser(String firstName, String secondName, String username, String cellphonenumber){
        if(checkuserName(username) && checkCellphoneNumber(cellphonenumber)){
           return"User sucessfully registered";
        }else{
            System.out.println("Username, password or cellphonenumber incorrectly formatted");
            System.exit(0);
            return null;
        }
    }
  // Method to validate login
     public boolean loginUser(String username, String password, String loginUsername, String loginPassword) {
    return username.equals(loginUsername) && password.equals(loginPassword);
 }
    
public String returnLoginStatus(String firstName,String  lastName,String username,String  password,String loginUsername,String loginPassword) {
    if (loginUser(username, password, loginUsername, loginPassword)) {
        return "Welcome " + firstName + ", " + lastName + " to QuickChat" + ". It is nice to see you.";
    } else {
        return "Username or password incorrect, please try again.";
    }
}
    }
     
        
     
    
