package pornnatcha.newbmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText HeightInput,WeightInput;
    private Button CalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HeightInput = (EditText) findViewById(R.id.height_edit_text);
        WeightInput = (EditText) findViewById(R.id.weight_edit_text);
        CalButton = (Button) findViewById(R.id.cal_button);
        CalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Double.valueOf(HeightInput.getText().toString());
                double weight = Double.valueOf(WeightInput.getText().toString());

                Double BMI = weight / ((height/100) * (height/100));
                String BMIText = getBMItext(BMI); // แปลงค่า BMI จาก double to String
               // String result = String.format("ค่า BMI ที่ได้คือ %.1fc\n\n อยู่ในเกณฑ์ : %S",BMI,BMIText);

                Intent intent = new Intent(MainActivity.this,Result_BMI.class);
                intent.putExtra("bmi_value",BMI);
                intent.putExtra("bmi_text",BMIText);
                startActivity(intent);

            }
        });




    }

    private String getBMItext(Double bmi) {
        String BMIText = "";
        if(bmi < 18.5){
            BMIText = "น้ำหนักน้อยกว่าปกติ";
        }else if (bmi<25){
            BMIText = "น้ำหนักปกติ";
        }else if (bmi<30){
            BMIText = "น้ำหนักมากกว่าปกติ";
        }else{
            BMIText = "อ้วน";
        }
        return BMIText;
    }
}
