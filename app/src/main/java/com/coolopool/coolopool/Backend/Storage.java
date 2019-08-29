package com.coolopool.coolopool.Backend;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.coolopool.coolopool.Activity.SignUp2Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Storage {

    String PATH = "Users/profileImages/";

    Context context;
    Activity activity;

    Uri file;

    StorageReference reference;

    public Storage(Context context, Activity activity, Uri file) {
        this.context = context;
        this.activity = activity;
        this.file = file;
        init();
    }

    private void init(){ reference = FirebaseStorage.getInstance().getReference().child("Users/profileImages/"); }

    public void storeProfilePic(String userId){
        StorageReference profileImageRef = reference.child(userId);
        profileImageRef.putFile(file);
    }


}
