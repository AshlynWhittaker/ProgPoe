/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat_app;

import java.util.Random;

/**
 *
 * @author Ashlyn Whittaker
 */
public class Message {
    public static boolean checkMessageID(String messageID) {
    return messageID.length() <= 10;
}
// Method to check if recipient cell number is valid
public static String checkRecipientCell(String cellNumber) {
    if (cellNumber.length() <= 10 && cellNumber.startsWith("+")) {
        return "Cell phone number successfully captured.";
    } else {
        return "Cell phone number is incorrectly formatted or does not contain an international code.";
    }
}
// Method to create message hash
public static String createMessageHash(String messageID, int messageNum, String message) {
    String[] words = message.split(" ");
    String firstWord = words[0].toUpperCase();
    String lastWord = words[words.length - 1].toUpperCase();
    return messageID.substring(0, 2) + ":" + messageNum + ":" + firstWord + lastWord;
}

// Method to send, store, or disregard message
public static String SentMessage(int choice) {
    switch (choice) {
        case 1:
            return "Message successfully sent.";
        case 2:
            return "Press 0 to delete the message.";
        case 3:
            return "Message successfully stored.";
        default:
            return "Invalid choice.";
    }
}
// Method to print all messages
public static void printMessages(String[][] messages, int count) {
    System.out.println("\n=== Sent Messages ===");
    for (int i = 0; i < count; i++) {
        System.out.println("Message ID: " + messages[i][0]);
        System.out.println("Message Hash: " + messages[i][1]);
        System.out.println("Recipient: " + messages[i][2]);
        System.out.println("Message: " + messages[i][3]);
        System.out.println("-----------------------------");
    }
}

// Method to return total messages sent
public static int returnTotalMessages(int count) {
    return count;
}
// Main logic continuation (uses your existing Scanner input)
public static void runQuickChat(java.util.Scanner input) {
   
        
       
    String correctUsername = "user";
    String correctPassword = "1234";
    boolean loggedIn = false;

    System.out.println("==== QuickChat Login ====");
    System.out.print("Enter username: ");
    String username = input.nextLine();

    System.out.print("Enter password: ");
    String password = input.nextLine();

    if (username.equals(correctUsername) && password.equals(correctPassword)) {
        loggedIn = true;
        System.out.println("Login successful");
    } else {
        System.out.println("Invalid username or password. Exiting program.");
        return;
    }

    if (loggedIn) {
        System.out.println("Welcome to QuickChat.");
    }

    System.out.print("How many messages do you want to send? ");
    int maxMessages = input.nextInt();
    input.nextLine();

    String[][] messages = new String[maxMessages][4];
    int messageCount = 0;
    int choice;

    do {
        
        Random rand = new Random();
        
        System.out.println("\n=== Menu ===");
        System.out.println("Option 1: Send message");
        System.out.println("Option 2: Show recently sent messages");
        System.out.println("Option 3: Quit");
        System.out.print("Choose an option: ");
        choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            if (messageCount < maxMessages) {
                String messageID = String.valueOf(rand.nextInt(900000000) + 100000000);
                System.out.print("Enter recipient number (include + code): ");
                String recipient = input.nextLine();
                System.out.println(checkRecipientCell(recipient));

                System.out.print("Enter your message: ");
                String msg = input.nextLine();

                if (msg.length() > 250) {
                    System.out.println("Message exceeds 250 characters; please reduce the size.");
                    continue;
                } else {
                    System.out.println("Message ready to send.");
                }

                String hash = createMessageHash(messageID, messageCount + 1, msg);

                System.out.println("\nChoose message action:");
                System.out.println("1 - Send Message");
                System.out.println("2 - Disregard Message");
                System.out.println("3 - Store Message");
                int action = input.nextInt();
                input.nextLine();

                System.out.println(SentMessage(action));

                if (action == 1 || action == 3) {
                    messages[messageCount][0] = messageID;
                    messages[messageCount][1] = hash;
                    messages[messageCount][2] = recipient;
                    messages[messageCount][3] = msg;
                    messageCount++;
                }

            } else {
                System.out.println("You have reached the limit of messages.");
            }

        } else if (choice == 2) {
            if (messageCount == 0) {
                System.out.println("Coming Soon");
            } else {
                printMessages(messages, messageCount);
            }

        } else if (choice == 3) {
            System.out.println("Goodbye!");
        } else {
            System.out.println("Invalid option. Try again.");
        }

    } while (choice != 3);

    System.out.println("\nTotal messages sent: " + returnTotalMessages(messageCount));
}
}
