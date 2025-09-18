package com.example.differentlayout;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;
    private String currentNumber = "";
    private String leftOperand = "";
    private String rightOperand = "";
    private char currentOperator = ' ';
    private double result = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView = findViewById(R.id.resultTextView);
        setupNumberButtonListener(R.id.button_0);
        setupNumberButtonListener(R.id.button_1);
        setupNumberButtonListener(R.id.button_2);
        setupNumberButtonListener(R.id.button_3);
        setupNumberButtonListener(R.id.button_4);
        setupNumberButtonListener(R.id.button_5);
        setupNumberButtonListener(R.id.button_6);
        setupNumberButtonListener(R.id.button_7);
        setupNumberButtonListener(R.id.button_8);
        setupNumberButtonListener(R.id.button_9);
        setupNumberButtonListener(R.id.button_dot);
        setupOperatorButtonListener(R.id.button_add);
        setupOperatorButtonListener(R.id.button_subtract);
        setupOperatorButtonListener(R.id.button_multiply);
        setupOperatorButtonListener(R.id.button_divide);
        findViewById(R.id.button_clear).setOnClickListener(view ->
                clearCalculator());
        findViewById(R.id.button_equals).setOnClickListener(view ->
                calculateResult());
    }
    private void setupNumberButtonListener(int buttonId) {
        findViewById(buttonId).setOnClickListener(view -> {
            Button button = (Button) view;
            onNumberClick(button.getText().toString());
        });
    }
    private void setupOperatorButtonListener(int buttonId) {
        findViewById(buttonId).setOnClickListener(view -> {
            Button button = (Button) view;
            onOperatorClick(button.getText().charAt(0));
        });
    }
    private void onNumberClick(String number) {
        if (number.equals(".") && currentNumber.contains(".")) {
            return;
        }
        currentNumber += number;
        updateDisplay(currentNumber);
    }
    private void onOperatorClick(char operator) {
        if (currentNumber.isEmpty()) {
            return;
        }
        if (currentOperator != ' ') {
            calculateResult();
        }
        leftOperand = currentNumber;
        currentNumber = "";
        currentOperator = operator;
    }
    private void calculateResult() {
        if (leftOperand.isEmpty() || currentNumber.isEmpty()) {
            return;
        }
        rightOperand = currentNumber;
        double leftNum = Double.parseDouble(leftOperand);
        double rightNum = Double.parseDouble(rightOperand);
        switch (currentOperator) {
            case '+':
                result = leftNum + rightNum;
                break;
            case '-':
                result = leftNum - rightNum;
                break;
            case '*':
                result = leftNum * rightNum;
                break;
            case '/':
                if (rightNum != 0) {
                    result = leftNum / rightNum;
                } else {
                    updateDisplay("Error");
                    clearCalculatorState(false);
                    return;
                }
                break;
        }
        if (result == (long) result) {
            currentNumber = String.format("%d", (long) result);
        } else {
            currentNumber = String.format("%s", result);
        }
        updateDisplay(currentNumber);
        clearCalculatorState(true);
    }
    private void clearCalculator() {
        clearCalculatorState(true);
        updateDisplay("0");
    }
    private void clearCalculatorState(boolean clearDisplay) {
        if (clearDisplay) {
            currentNumber = "";
        }
        leftOperand = "";
        rightOperand = "";
        currentOperator = ' ';
    }
    private void updateDisplay(String text) {
        resultTextView.setText(text);
    }
}