package com.example.Batman.myapplication.backend;

import com.example.JokeMachine;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private JokeMachine jokeMachine;

    public MyBean() {
        jokeMachine = new JokeMachine();
    }

    public String getJoke() {
        return jokeMachine.getJoke();
    }
}