package com.example.jokeprovider;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.JokeMachine;
import com.example.batman.myapplication.backend.myApi.MyApi;

import java.io.IOException;

public class JokeActivity extends AppCompatActivity {

    public static final String INTENT_JOKE = "INTENT_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        setTitle("Random Joke");

        TextView textView = (TextView) findViewById(R.id.jokeText);
        String joke = getIntent().getStringExtra(INTENT_JOKE);
        textView.setText(joke);
    }
}
