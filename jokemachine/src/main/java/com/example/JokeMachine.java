package com.example;

import java.util.Random;

public class JokeMachine {

    public String getJoke() {

        String[] jokesList = {
                "People don't get my puns. They think they're funny.",
                "The future, the present and the past walked into a bar. Things got a little tense.",
                "I have a few jokes about unemployed people but it doesn't matter none of them work.",
                "I can't believe I got fired from the calendar factory. All I did was take a day off.",
                "Did you hear about the guy who got hit in the head with a can of soda? He was lucky it was a soft drink.",
                "Q: What do you call the security outside of a Samsung Store? A: Guardians of the Galaxy."
        };

        Random random = new Random();
        int randomNum = random.nextInt(jokesList.length);

        return (jokesList[randomNum]);
    }
}