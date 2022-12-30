package com.springBootDemo.springbootdemoall;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Checkvalidation {

    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public static void main(String[] args)
    {
        ArrayList<String> address = new ArrayList<>();

        address.add("review-team@geeksfo-----------rgeeks.org");
        address.add("writing.geeksforg-----eeks.org");

        for(String i : address){
            if (isValid(i))
                System.out.println(i + " - Yes");
            else
                System.out.println(i + " - No");
        }
    }
}
