package com.example.allrecord;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText mark1, mark2, mark3;
    TextView sum ,avg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        mark1 = findViewById(R.id.m1);
        mark2 = findViewById(R.id.m2);
        mark3 = findViewById(R.id.m3);
        sum = findViewById(R.id.su);
        avg = findViewById(R.id.av);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m1 = Integer.parseInt(mark1.getText().toString());
                int m2 = Integer.parseInt(mark2.getText().toString());
                int m3 = Integer.parseInt(mark3.getText().toString());
                int sumr = m1+m2+m3;
                sum.setText(Integer.toString(sumr));
                int avgr = sumr/3;
                avg.setText(Integer.toString(avgr));
            }
        });
    }
}