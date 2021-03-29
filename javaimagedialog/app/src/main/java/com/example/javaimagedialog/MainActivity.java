package com.example.javaimagedialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle("Custom Dialog");

        TextView tv = (TextView) dialog.findViewById(R.id.text);
        tv.setText("Hello. This is a Custom Dialog !");

        ImageView iv = (ImageView) dialog.findViewById(R.id.image);
        iv.setImageResource(R.drawable.icon);

        dialog.show();
    }
}
