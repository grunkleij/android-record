package com.example.allrecord;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {
    private TextView textViewFormat1, textViewFormat2,
            textViewFormat3, textViewFormat4, textViewFormat5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewFormat1 = findViewById(R.id.textViewFormat1);
        textViewFormat2 = findViewById(R.id.textViewFormat2);
        textViewFormat3 = findViewById(R.id.textViewFormat3);
        textViewFormat4 = findViewById(R.id.textViewFormat4);
        textViewFormat5 = findViewById(R.id.textViewFormat5);
        Date currentDate = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("EEEE,MMMM dd, yyyy hh:mm:ss a z", Locale.getDefault());
        textViewFormat1.setText(format1.format(currentDate));
        SimpleDateFormat format2 = new
                SimpleDateFormat("MM/dd/yy", Locale.getDefault());
        textViewFormat2.setText(format2.format(currentDate));
        SimpleDateFormat format3 = new SimpleDateFormat("MMMM, dd, yyyy", Locale.getDefault());
                textViewFormat3.setText(format3.format(currentDate));
        SimpleDateFormat format4 = new SimpleDateFormat("hh:mma", Locale.getDefault());
                textViewFormat4.setText(format4.format(currentDate));
        SimpleDateFormat format5 = new
                SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        textViewFormat5.setText(format5.format(currentDate));
    }
}