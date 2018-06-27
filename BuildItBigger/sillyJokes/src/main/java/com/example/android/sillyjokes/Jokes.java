package com.example.android.sillyjokes;

import java.util.Random;

public class Jokes {

    private String joke;
    private Random random = new Random();

    public String getJoke() {
        int numJoke = randInt(0,4);

        switch (numJoke){
            case 0:
                joke = "I poured root beer in a square glass.\n" +
                        "Now I just have beer.";
                break;
            case 1:
                joke = "My friend says to me: \"What rhymes with orange\"\n" +
                        "I said: \"no it doesn't\"\n";
                break;
            case 2:
                joke = "And God said to John, come forth and you shall be granted eternal life.\n" +
                        "But John came fifth and won a toaster.";
                break;
            case 3:
                joke = "What do you call a dog that does magic tricks?\n" +
                        "A labracadabrador.\n";
                break;
            case 4:
                joke = "People in Dubai don't like the Flintstones.\n" +
                        "But people in Abu Dhabi do!\n";
                break;
        }
        return joke;
    }
    // Taken from: https://stackoverflow.com/questions/2444019/
    // how-do-i-generate-a-random-integer-between-min-and-max-in-java/40984753
    private int randInt(int min, int max) {
        int randomNum = random.nextInt((max + 1 - min) + min);
        return randomNum;
    }
}
