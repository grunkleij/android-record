package com.example.alertdialogapp;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    private Button showAlertButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showAlertButton = findViewById(R.id.showAlertButton);
        showAlertButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }
    private void showAlertDialog() {
        AlertDialog.Builder builder = new
                AlertDialog.Builder(MainActivity.this);
        builder.setTitle("This is an Alert!");
        builder.setMessage("Do you want to close this dialog?");
        builder.setPositiveButton("Yes", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton("No", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }}