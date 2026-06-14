/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat_app;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Ashlyn Whittaker
 */
public class Storedmessagemanager {

    public Storedmessagemanager() {
    }
    
    
    private static class JSONParser {

        public JSONParser() {
        }
    }

    private static class messageHashes {

        private static void add(String hash) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static String get(int i) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static boolean remove(String hash) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public messageHashes() {
        }
    }

public class QuickChatPart3 {

}
       
public class StoredMessagesManager {

}
private ArrayList<String> sentMessages = new ArrayList<>();
    private ArrayList<String> storedMessages = new ArrayList<>();
    
    private ArrayList<String> disregardedMessages = new ArrayList<>();
   
    private ArrayList<String> messageIDs = new ArrayList<>();
    // Add a message with option: 1=Send, 2=Store, 3=Disregard
    public void addMessage(String recipient, String message, int option) {
        String messageID = generateMessageID();
        String hash = createMessageHash(messageID, message);
        messageIDs.add(messageID);
        messageHashes.add(hash);

        switch (option) {
            case 1 -> {
                sentMessages.add(message);
                System.out.println("Message successfully sent.");
            }
            case 2 -> {
                storedMessages.add("Recipient: " + recipient + " | Message: " + message);
                System.out.println("Message successfully stored.");
            }
            case 3 -> {
                disregardedMessages.add(message);
                System.out.println("Message disregarded.");
            }
            default -> System.out.println("Invalid option.");
        }
    }

    // Generate ID and Hash
    private String generateMessageID() {
        return String.valueOf((long) (Math.random() * 1_000_000_0000L));
    }

    private String createMessageHash(String id, String msg) {
        String[] words = msg.split(" ");
        String first = words[0].toUpperCase();
        String last = words[words.length - 1].toUpperCase();
        return id.substring(0, 2) + ":0:" + first + last;
    }

    // Menu Features
    public void displayStoredMessages() {
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages.");
        } else {
            for (String msg : storedMessages) {
                System.out.println(msg);
            }
        }
    }

    public void displayLongestMessage() {
        String longest = storedMessages.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("None");
        System.out.println("Longest stored message: " + longest);
    }

    public void searchByMessageID(String id) {
        int index = messageIDs.indexOf(id);
        if (index != -1 && index < sentMessages.size()) {
            System.out.println("Message found: " + sentMessages.get(index));
        } else {
            System.out.println("Message ID not found.");
        }
    }

    public void searchByRecipient(String recipient) {
        boolean found = false;
        for (String msg : storedMessages) {
            if (msg.contains(recipient)) {
                System.out.println("Found: " + msg);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No messages for recipient: " + recipient);
        }
    }

    public void deleteByHash(String hash) {
        if (messageHashes.remove(hash)) {
            System.out.println("Message successfully deleted using hash.");
        } else {
            System.out.println("Hash not found.");
        }
    }

    public void displayReport() {
        System.out.println("\nMessage Report:");
        for (int i = 0; i < sentMessages.size(); i++) {
            System.out.println("Message Hash: " + messageHashes.get(i));
            System.out.println("Message ID: " + messageIDs.get(i));
            System.out.println("Message: " + sentMessages.get(i));
            System.out.println("----------------------");
        }
    }
}

    
    

