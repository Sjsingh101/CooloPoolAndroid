package com.coolopool.coolopool.Backend.Model;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {

    Context context;
    Activity activity;

    FirebaseFirestore db;

    public UserDatabase(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
        init();
    }

    private void init(){ db = FirebaseFirestore.getInstance(); }

    public void addUserToDatabase(User user) {
        // Add a new document with a generated ID
        db.collection("users").document(user.getUid()).set(user);


    }

}
