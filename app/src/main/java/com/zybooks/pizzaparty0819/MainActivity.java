package com.zybooks.pizzaparty0819;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public final static int SLICES_PER_PIZZA = 8;

    private EditText mAmountEditText;
    private TextView mNumPizzasTextView;
    private RadioGroup mHowHungryRadioGroup;

  @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      // Assign the widgets to fields
      mAmountEditText = findViewById(R.id.AmountEditText);
      mNumPizzasTextView = findViewById(R.id.answerTextView);
      mHowHungryRadioGroup = findViewById(R.id.hungryRadioGroup);
      // ATTENTION: This was auto-generated to handle app links.
      Intent appLinkIntent = getIntent();
      String appLinkAction = appLinkIntent.getAction();
      Uri appLinkData = appLinkIntent.getData();
  }

    //FloatingActionButton calc = findViewById(R.id.calcButton);
   // View.OnClickListener listener = new View.OnClickListener() {
    //    @Override

        public void onClick(View view) {

            // Get the text that was typed into the EditText
            String numAttendStr = mAmountEditText.getText().toString();

            // Convert the text into an integer
            int numAttend = Integer.parseInt(numAttendStr);

            // Determine how many slices on average each person will eat
            int slicesPerPerson = 0;
            int checkedId = mHowHungryRadioGroup.getCheckedRadioButtonId();
            if (checkedId == R.id.lightRadioButton) {
                slicesPerPerson = 2;
            } else if (checkedId == R.id.mediumRadioButton) {
                slicesPerPerson = 3;
            } else if (checkedId == R.id.ravenousRadioButton) {
                slicesPerPerson = 4;
            }

            // Calculate and show the number of pizzas needed
            int totalPizzas = (int) Math.ceil(numAttend * slicesPerPerson / (double) SLICES_PER_PIZZA);
            mNumPizzasTextView.setText("Total pizzas: " + totalPizzas);

            Log.i("Pizza Party", "Your Calculation is Complete!");

      //      calc.setOnClickListener(listener);
        }
    }







