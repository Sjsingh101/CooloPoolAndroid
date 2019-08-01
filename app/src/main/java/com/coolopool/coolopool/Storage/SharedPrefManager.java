package com.coolopool.coolopool.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "login_shared_pref";

    private static SharedPrefManager mInstance;
    private Context mCtx;

    private SharedPrefManager (Context mCtx) {
        this.mCtx = mCtx;
    }

    public static synchronized SharedPrefManager getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(mCtx);
        }
        return mInstance;
    }

    public int saveUser(String response){
        SharedPreferences.Editor editor = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE).edit();

        try {
            JSONObject loginJSON = new JSONObject(response);
            if(loginJSON.getInt("id") == 0)
                return 0;
            else {
                // also change "id" and "title" to respective parameters of the real JSON when get the url
                editor.putInt("status", loginJSON.getInt("id"));
                editor.putString("message", loginJSON.getString("title"));

                editor.apply();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 1;
    }
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("status" , -1) != -1;
    }

    public void clear() {
        SharedPreferences.Editor editor = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.apply();
    }
}
