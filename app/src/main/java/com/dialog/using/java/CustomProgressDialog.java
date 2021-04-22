package com.dialog.using.java;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomProgressDialog extends ProgressDialog {

    private Animation animRotate;

    private ImageView imageView;
    private TextView textView;

    private String message;

    public CustomProgressDialog(Activity activity, String message) {
        super(activity);
        this.message = message;
        this.animRotate = AnimationUtils.loadAnimation(activity, R.anim.rotate);

        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setIndeterminate(true);
        setCancelable(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_dialog);

        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);

        textView.setText(message);
    }

    @Override
    public void show() {
        super.show();
        imageView.startAnimation(animRotate);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        animRotate.cancel();
    }
}
