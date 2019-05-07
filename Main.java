package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String tweet = read("Please enter a tweet:");
        System.out.println(check(tweet));
        if(check(tweet).equals("Length Correct")){
            System.out.println(hashtag(tweet));
            System.out.println(mentions(tweet));
            System.out.println(links(tweet));
        }
    }

    //Method to make grabbing user input easier
    public static String read(String print){
        Scanner s = new Scanner(System.in);
        System.out.println(print);
        String text = s.nextLine();
        s.close();
        return text; //Returns user input
    }

    //Method to check if tweet is correct length
    public static String check(String tweet){
        Boolean len = tweet.length()<=280;
        if(len){
            return "Length Correct";
        }
        else {
            return "Excess Characters: "+ (tweet.length()-280); //Returns the amount of characters over the limit.
        }
    }

    //Method for counting amount of hashtags
    public static String hashtag(String tweet){
        int tags = 0;
        String[] tweak = tweet.split(" ");
        for(int i=0;i<tweak.length;i++){
            if(tweak[i].toLowerCase().contains("#")){
                int place = tweak[i].indexOf("#");
                if(!tweak[i].equals("#") && tweak[i].charAt(place+1) != ' ')
                    tags++;
            }
        }
        return "Number of Hashtags: "+tags; //Returns the amount of hashtags in the tweet
    }

    //Method to count amount of mentions
    public static String mentions(String tweet){
        int tags = 0;
        String[] tweak = tweet.split(" ");
        for(int i=0;i<tweak.length;i++){
            if(tweak[i].toLowerCase().contains("@")){
                int place = tweak[i].indexOf("@");
                if(!tweak[i].equals("@") && tweak[i].charAt(place+1) != ' ')
                    tags++;
            }
        }
        return "Number of Attributions: "+tags;
    }

    //Method to count links
    public static String links(String tweet){
        int tags = 0;
        String[] tweak = tweet.split(" ");
        for(int i=0;i<tweak.length;i++){
            if(tweak[i].toLowerCase().contains("http://") || tweak[i].toLowerCase().contains("https://")){
                int place = tweak[i].indexOf("http://");
                int place2 = tweak[i].indexOf("https://");
                if((!tweak[i].toLowerCase().equals("http://") || !tweak[i].toLowerCase().equals("https://")) && (tweak[i].charAt(place+1) != ' '|| tweak[i].charAt(place2+1) != ' '))
                    tags++;
            }
        }
        return "Number of Links: "+tags;
    }

}