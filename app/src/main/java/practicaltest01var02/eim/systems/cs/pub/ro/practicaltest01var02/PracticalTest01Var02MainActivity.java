package practicaltest01var02.eim.systems.cs.pub.ro.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PracticalTest01Var02MainActivity extends AppCompatActivity {

    private Button plusButton = null;
    private Button minusButton = null;
    private Button navigateButton = null;
    private EditText firstNumber = null;
    private EditText secondNumber = null;
    private TextView result = null;
    private final static int SECONDARY_ACTIVITY_RESULT_CODE = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECONDARY_ACTIVITY_RESULT_CODE) {
            Toast.makeText(this, "Activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_main);

        //get ref
        plusButton = (Button) findViewById(R.id.button_plus);
        minusButton = (Button) findViewById(R.id.button_minus);
        navigateButton = (Button) findViewById(R.id.button_navigate);

        firstNumber = (EditText) findViewById(R.id.text_first);
        secondNumber = (EditText) findViewById(R.id.text_second);

        result = (TextView) findViewById(R.id.text_result);

        PrimaryListener listener = new PrimaryListener();
        plusButton.setOnClickListener(listener);
        minusButton.setOnClickListener(listener);
        navigateButton.setOnClickListener(listener);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            String first = savedInstanceState.getString("firstNo");
            String second = savedInstanceState.getString("secondNo");
            Toast.makeText(getApplicationContext(), first + " " + second, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("firstNo", firstNumber.getText().toString());
        outState.putString("secondNo", secondNumber.getText().toString());
    }

    class PrimaryListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            int firstNo;
            int secondNo;
            int res;
            String op = null;
            String tip = "right";

            switch (v.getId()) {
                case R.id.button_plus:
                    try {
                        firstNo = Integer.parseInt(firstNumber.getText().toString());
                        secondNo = Integer.parseInt(secondNumber.getText().toString());
                        res = firstNo + secondNo;
                        result.setText(firstNo + " + " + secondNo + " = " + res);
                        op = "+";
                    } catch (NumberFormatException ex) {
                        Toast.makeText(PracticalTest01Var02MainActivity.this, "One of the numbers is invalid", Toast.LENGTH_LONG).show();
                        tip = "wrong";
                        ex.printStackTrace();
                    }
                    break;
                case R.id.button_minus:
                    try {
                        firstNo = Integer.parseInt(firstNumber.getText().toString());
                        secondNo = Integer.parseInt(secondNumber.getText().toString());
                        res = firstNo - secondNo;
                        result.setText(firstNo + " - " + secondNo + " = " + res);
                        op = "-";
                    } catch (NumberFormatException ex) {
                        Toast.makeText(PracticalTest01Var02MainActivity.this, "One of the numbers is invalid", Toast.LENGTH_LONG).show();
                        tip = "wrong";
                        ex.printStackTrace();
                    }
                    break;
                case R.id.button_navigate:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02SecondaryActivity.class);
                    intent.putExtra("rezultat", result.getText().toString() + " " + tip);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_RESULT_CODE);
                    break;
            }
        }
    }

}

