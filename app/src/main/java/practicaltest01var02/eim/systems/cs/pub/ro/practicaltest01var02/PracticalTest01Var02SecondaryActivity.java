package practicaltest01var02.eim.systems.cs.pub.ro.practicaltest01var02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PracticalTest01Var02SecondaryActivity extends AppCompatActivity {

    private TextView result = null;
    private Button correctButton = null;
    private Button incorrectButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_secondary);

        result = (TextView) findViewById(R.id.text_result2);
        correctButton = (Button) findViewById(R.id.button_correct);
        incorrectButton = (Button) findViewById(R.id.button_incorrect);
        SecondListener listener = new SecondListener();
        correctButton.setOnClickListener(listener);
        incorrectButton.setOnClickListener(listener);
    }

    private class SecondListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_correct:
                    setResult(RESULT_OK);
                    break;
                case R.id.button_incorrect:
                    setResult(RESULT_CANCELED);
                    break;
            }
            finish();
        }
    }
}
