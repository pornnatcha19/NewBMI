package pornnatcha.newbmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result_BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result__bmi);

        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("bmi_value", 0);
        String BMIText = intent.getStringExtra("bmi_text");

        String much = String.valueOf(String.format("%.2f", bmi));

        TextView t = (TextView) findViewById(R.id.BMICal);
        TextView t2 = (TextView) findViewById(R.id.BMIdetail);

        t.setText("ค่า BMI ที่ได้คือ" + much);
        t2.setText("อยู่ในเกณฑ์ " + BMIText);

        //ButtonB = (Button) findViewById(R.id.button_back);
    }
}
