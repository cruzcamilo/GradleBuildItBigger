package com.example.android.sillyjokes;

import java.util.Random;

public class Jokes {

    private Random random = new Random();
    private String [] jokes = new String[7];

    public Jokes(){
        jokes[0] = "I poured root beer in a square glass.\n" +
                "Now I just have beer.";
        jokes[1] = "My friend says to me: \"What rhymes with orange\"\n" +
                "I said: \"no it doesn't\"";
        jokes[2] = "And God said to John, come forth and you shall be granted eternal life.\n" +
                "But John came fifth and won a toaster.";
        jokes[3] = "What do you call a dog that does magic tricks?\n" +
                "A labracadabrador.";
        jokes[4] = "People in Dubai don't like the Flintstones.\n" +
                "But people in Abu Dhabi do!";
        jokes[5] = "What's the difference between a musician and a 14-inch pizza? \n" +
                "A 14-inch pizza can feed a family of four";
        jokes[6] = "Where did the music teacher leave her keys? \n" +
                "In the piano!";
    }

    public String getJoke() {
        int numJoke = random.nextInt(6);
        return jokes[numJoke];
    }
}