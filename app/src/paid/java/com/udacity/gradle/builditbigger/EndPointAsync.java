package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.example.batman.myapplication.backend.myApi.MyApi;
import com.example.batman.myapplication.backend.myApi.model.MyBean;
import com.example.jokeprovider.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;


public class EndPointAsync extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi mJokeApi = null;
    private Context mContext;
    private String mResult;
    private ProgressBar mProgressBar;

    private static final String TAG = "EndPointAsync";

    public EndPointAsync(Context mContext, ProgressBar mProgressBar) {
        this.mContext = mContext;
        this.mProgressBar = mProgressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected final String doInBackground(Pair<Context, String>... params) {
        if (mJokeApi == null) {
            String root_url_api = mContext.getString(R.string.root_url_api);
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(root_url_api);
            mJokeApi = builder.build();
        }
        try {
            return mJokeApi.sayJoke(new MyBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mProgressBar.setVisibility(View.GONE);
        mResult = s;
        startJokeActivity();
    }

    private void startJokeActivity() {
        Intent intent = new Intent(mContext, JokeActivity.class);
        intent.putExtra(JokeActivity.INTENT_JOKE, mResult);
        mContext.startActivity(intent);
    }
}
