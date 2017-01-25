package calculator.android.com.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // 1. 위젯을 정의한다.
    Intent intent;
    Button btnCal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main); //

        // 2. 정의된 위젯변수에 xml의 위젯 id를 가져와서 담아준다.
        btnCal = (Button) findViewById(R.id.btnCal);
        // 3. 위젯변수를 리스너에 달아준다.
        btnCal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnCal:
                intent = new Intent(this, CalculatorActivity.class);
                startActivity(intent);
        }
    }
}