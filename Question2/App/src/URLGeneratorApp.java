/*
Title: URLGeneratorApp.java
Author: Miguel Angel Vinas
Date: 5th January, 2024
Purpose: Software Development TABA for National College Of Ireland
*/

import java.util.Scanner;

//App Class
public class URLGeneratorApp
{
    public static void main (String[] args)
    {
        //We are creating an instance of our URLGenerator class.
        URLGenerator urlGenerator = new URLGenerator();

        //We are going to get the company name from the user through the Scanner.
        //(I would have loved to use the JPane though!)
        Scanner scanner = new Scanner(System.in);

        //We want for the user to choose what he / she wants to do, either generate a URL or validate a URL.
        //And we want to create an infinite loop so the user HAS to make a valid choice!.
        //In order to do so we are going to use the while (true) construct.
        while (true)
        {
            //Here we are displaying the menu.
            System.out.println("Please choose an option.");
            System.out.println("1: Generate URLs.");
            System.out.println("2: Validate URLs.");
            System.out.println("3: Exit the program.");
            System.out.println("Enter either 1, 2 or 3, depending on what you want to do.");
            System.out.println("Thanks.");

            //We are storing the user's choice in an integer.
            int choice = scanner.nextInt();
            scanner.nextLine();

            //And we are going to perform the choice.
            if (choice == 1)
            {
                //We are going to execute the generateURLs method.
                generateURLs(urlGenerator, scanner);
            }
            else if (choice == 2)
            {
                //We are going to execute the validateURLs method.
                validateURLs(urlGenerator, scanner);
            }
            else if (choice == 3)
            {
                //We are going to exit the loop and end the program
                System.out.println ("Thank you very much for using Miguel Angel Vinas' program: THE VALIDATOR!");
                System.out.println ("See you soon!");
                System.out.println (" ");
                break;
            }
            else
            {
                //We are going to tell the user that the choice is not valid... and ask to enter a valid choice!.
                System.out.println ("It seems like you have tried to enter a choice that is not 1, 2 or 3.");
                System.out.println ("Please make a choice again.");
                System.out.println (" ");
            }
        }

        //We are closing the scanner because it is good practice. Thanks Francis!!
        scanner.close();
    }

    //This is the method to generate URLs.
    private static void generateURLs(URLGenerator urlGenerator, Scanner scanner)
    {
        //We are asking the user for the company name
        System.out.println ("Please, enter the company name that you want to generate a URL for: ");
        String companyName = scanner.nextLine();

        //We are going to set the company name.
        urlGenerator.setCompanyName(companyName);

        //We are going to generate the URL.
        urlGenerator.compute();

        //We are going to display the generated URL.
        System.out.println ("Here is your generated URL: " + urlGenerator.getGeneratedURL());
        System.out.println ("Thank you very much for using: THE GENERATOR!");
        System.out.println (" ");
    }

    //This is the method validate URLs
    //We are passing the URLGenerator and the scanner as parameters.
    private static void validateURLs (URLGenerator urlGenerator, Scanner scanner)
    {
        //We are asking the user for the number of URLs to validate.
        System.out.print("Enter the number of URLs to validate: ");
        int numberOfURLs = scanner.nextInt();
        scanner.nextLine();

        //We are creating an array to store the number of URLs that the user wants to validate.
        String[] urls = new String[numberOfURLs];

        //We are asking the user to input each URL.
        for (int i = 0; i < numberOfURLs; i++)
        {
            System.out.print("Enter URL " + (i + 1) + ": ");
            urls[i] = scanner.nextLine();
        }

        //And we are validating the URLs.
        boolean[] validationResults = urlGenerator.validateGoogleURLs(urls);

        //And after that validating them, we are displaying the validation results.
        System.out.println("Validation results:");
        for (int i = 0; i < numberOfURLs; i++)
        {
            System.out.println("URL " + (i + 1) + ": " + validationResults[i]);
            System.out.println (" ");
        }
    }
}