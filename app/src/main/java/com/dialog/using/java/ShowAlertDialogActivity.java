package com.dialog.using.java;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.button.MaterialButton;

public class ShowAlertDialogActivity extends AppCompatActivity {

    private static final String TAG = ShowAlertDialogActivity.class.getSimpleName();

    private MaterialButton showDialogMaterialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_alert_dialog);
        initializeView();
        initializeObject();
        setOnClickListener();
    }

    protected void initializeView() {
        showDialogMaterialButton = findViewById(R.id.showDialogMaterialButton);
    }

    protected void initializeObject() {
    }

    protected void setOnClickListener() {
        showDialogMaterialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customProgressDialog(ShowAlertDialogActivity.this);
            }
        });
    }

    public void progressDialog(Activity activity) {
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Content Loading");
        progressDialog.dismiss();
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    public void progressDialogWithNumber(Activity activity) {
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Content Loading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();

        progressDialog.setProgress(40);
    }

    public void customProgressDialog(Activity activity) {
        ProgressDialog progressDialog = new CustomProgressDialog(activity, "Loading....");
        progressDialog.show();
    }
}