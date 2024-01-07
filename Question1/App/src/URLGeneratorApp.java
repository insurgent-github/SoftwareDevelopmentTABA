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

        //We are closing the scanner because it is good practice. Thanks Francis!!
        scanner.close();
    }

}