/*
Title: URLGenerator.java
Author: Miguel Angel Vinas
Date: 5th January, 2024
Purpose: Software Development TABA for National College Of Ireland
*/

//Instantiable Class

public class URLGenerator
{
    //These are the variables that we are going to use
    private String companyName;
    private String generatedURL;

    //Here is our constructor. We are going to use to initialize this class.
    public URLGenerator()
    {
        companyName = "";
        generatedURL = "";
    }

    //Setter method to generate the company name.
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    //Getter method to return the generated URL.
    public String getGeneratedURL()
    {
        return generatedURL;
    }

    //This is our compute method to generate and create the URL.
    //We have several rules that we have to apply to generate and create the URL.
    //So we are going to break the compute method in the different rules before we create the URL.
    public void compute()
    {
        //Rule A = If the company name contains the word “Google” regardless of case, use “https”. Otherwise use “http”
        //We are going to use a ternary operator (? :) to determine the protocol.
        //We are converting the companyName string to a lowercase and checking if the companyName contains a substring "google"
        //By using the ternary operator (? :), if the companyName contains google then we are setting https, else we are using http.
        //In other words, our condition to be true is that the companyName contains google, if that's true we assign https, else we assign http.
        String protocol = (companyName.toLowerCase().contains("google")) ? "https" : "http";

        //Rule B = Remove any instances of Inc., Ltd., or LLC, from the company name.
        //We are going to generate the hostname by calling the generateHostname() method.
        //This method is going to be responsible for generating the hostname based on the rule above.
        //The result is stored in the hostname variable so we can use it later.
        String hostname = generateHostname();

        //Rule F = Count the number of pairs of consonants next to each other in the company name.
        //If there are no pairs the path name should be “index”, 1-3 consonant pairs contain “contactDetails”, 3+ pairs “basket”
        //We are going to generate the path by calling the generatePath() method.
        //This method is going to be responsible for generating the path based on the rule above.
        //The result is stored in the path variable so we can use it later.
        String path = generatePath();

        //We are going to construct the URL now, based on the code and rules above.
        generatedURL = protocol + "://" + hostname + "/" + path;
    }

    //Method to generate the hostname.


    private String generateHostname()
    {
        //Rule C = Eliminate all spaces between the words in the company name and replace them with hyphens e.g., ‘-’.
        String processedName = companyName.replaceAll("\\s+", "-");

        //Rule B = Remove any instances of Inc., Ltd., or LLC, from the company name.
        processedName = processedName.replaceAll("(?i)\\b(?:Inc\\.|Ltd\\.|LLC)\\b", "");

        //Count the vowels and append either .com or .ie based on the number of vowels in the name.
        int vowelCount = countVowels (processedName);
        processedName += (vowelCount % 2 == 0) ? ".com" : ".ie";

        return processedName;
    }

    //Method to count vowels.
    private int countVowels (String input)
    {
        //This is our string where we put all the vowels in lowercase and uppercase.
        String vowels = "aeiouAEIOU";
        //And we initialize a counter to count them.
        int count = 0;
        //We are getting the length of the string that has been inputted.
        int length = input.length();

        //And we are iterating through each character of the string
        for (int i = 0; i < length; i++)
        {
            //We are checking if the current character is a vowel by checking if it is in the input substring.
            if (vowels.contains (input.substring(i, i +1)))
            {
                //If it is, we increment the count.
                count++;
            }
        }
        //And we return the count of the vowels in the string inputted.
        return count;
    }
    //Method to generate the path
    private String generatePath()
    {
        //Count the pairs of consecutive consonants to determine the path.
        int pairCount = countConsonantPairs();

        if (pairCount == 0)
        {
            return "index";
        }
        else if (pairCount <= 3)
        {
            return "contactDetails";
        }
        else
        {
            return "basket";
        }
    }

    //Method to count pairs of consecutive consonants.
    //It is similar to the countvowels method.
    private int countConsonantPairs()
    {
        //We are defining a string that contains all the consonants in lowercase and uppercase.
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";

        //And we are initializing our counter to count the pairs of consecutive consonants.
        int pairCount = 0;

        //We are getting the length of the string.
        int length = companyName.length();

        //And we are iterating through each character.
        for (int i = 0; i < length -1; i++)
        {
            //We are extracting the current character and the next character from the string
            String currentChar = companyName.substring(i, i +1);
            String nextChar = companyName.substring(i + 1, i +2);

            //And we are checking if both (current and next characters) are consonants by checking our "consonants" string.
            if (consonants.contains(currentChar) && consonants.contains(nextChar))
            {
                //If both are, we are incrementing the count of pairs of consonants.
                pairCount++;
            }
        }
        //And we are returning the total count of pairs of consecutive consonants.
        return pairCount;
    }

}
