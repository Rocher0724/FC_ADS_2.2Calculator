package calculator.android.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import static calculator.android.com.calculator.R.id.area_layout_vertical;
import static calculator.android.com.calculator.R.id.layout_length;
import static calculator.android.com.calculator.R.id.length_layout_vertical;
import static calculator.android.com.calculator.R.id.weight_layout_vertical;

public class UnitActivity extends AppCompatActivity {
    Button btnLength, btnArea, btnWeight;
    LinearLayout layout_length_vertical, layout_area_vertical, layout_weight_vertical;
    Spinner fromL, toL, fromA, toA, fromW, toW;
    String lengthArr[] = {"m" , "in", "ft"};
    String areaArr[] = {"m^2" , "ha", "평"};
    String weightArr[] = {"kg", "oz" , "t"};

    EditText etL,etA,etW;

    TextView unitPreL, unitResultL, textResultL;
    TextView unitPreA, unitResultA, textResultA;
    TextView unitPreW, unitResultW, textResultW;

    //버튼을 통한 레이아웃 이동.
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            layout_length_vertical.setVisibility(View.GONE);
            layout_area_vertical.setVisibility(View.GONE);
            layout_weight_vertical.setVisibility(View.GONE);
            switch (v.getId()) {
                case R.id.btnLength:
                    layout_length_vertical.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnArea:
                    layout_area_vertical.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnWeight:
                    layout_weight_vertical.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);

        //1. 위젯 가져오기
        btnLength = (Button) findViewById(R.id.btnLength);
        btnArea = (Button) findViewById(R.id.btnArea);
        btnWeight = (Button) findViewById(R.id.btnWeight);

        layout_length_vertical = (LinearLayout) findViewById(length_layout_vertical);
        layout_area_vertical = (LinearLayout) findViewById(R.id.area_layout_vertical);
        layout_weight_vertical = (LinearLayout) findViewById(R.id.weight_layout_vertical);

        unitPreL = (TextView) findViewById(R.id.unitPreL);
        unitPreA = (TextView) findViewById(R.id.unitPreA);
        unitPreW = (TextView) findViewById(R.id.unitPreW);
        unitResultL = (TextView) findViewById(R.id.unitResultL);
        unitResultA = (TextView) findViewById(R.id.unitResultA);
        unitResultW = (TextView) findViewById(R.id.unitResultW);
        textResultL = (TextView) findViewById(R.id.textResultL);
        textResultA = (TextView) findViewById(R.id.textResultA);
        textResultW = (TextView) findViewById(R.id.textResultW);

        etL = (EditText) findViewById(R.id.editTextL);
        etA = (EditText) findViewById(R.id.editTextA);
        etW = (EditText) findViewById(R.id.editTextW);

        fromA = (Spinner) findViewById(R.id.fromSp_A);
        toA = (Spinner) findViewById(R.id.toSp_A);
        fromL = (Spinner) findViewById(R.id.fromSp_L);
        toL = (Spinner) findViewById(R.id.toSp_L);
        fromW = (Spinner) findViewById(R.id.fromSp_W);
        toW = (Spinner) findViewById(R.id.toSp_W);

        adaptable(fromL, lengthArr);
        adaptable(fromA, areaArr);
        adaptable(fromW, weightArr);
        adaptable(toL, lengthArr);
        adaptable(toA, areaArr);
        adaptable(toW, weightArr);

        itemSelectListener(fromL, layout_length_vertical);
        itemSelectListener(fromA, layout_area_vertical);
        itemSelectListener(fromW, layout_weight_vertical);
        itemSelectListener(toL, layout_length_vertical);
        itemSelectListener(toA, layout_area_vertical);
        itemSelectListener(toW, layout_weight_vertical);

        // 2. 버튼 리스너 등록
        btnLength.setOnClickListener(clickListener);
        btnArea.setOnClickListener(clickListener);
        btnWeight.setOnClickListener(clickListener);


    }

    // arrayadapter에 집어넣는 함수. 지저분해서 이쪽으로 빼냈다.
    private void adaptable(Spinner spinner, String[] array){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, array);
        spinner.setAdapter(adapter);
    }
    // spinner의 item을 select하면 감지하는 함수
    private void itemSelectListener(Spinner spinner, LinearLayout linearName) {
        switch(linearName.getId()) {
            case R.id.length_layout_vertical:
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                unitPreL.setText("meter");
                                break;
                            case 1:
                                unitPreL.setText("inch");
                                break;
                            case 2:
                                unitPreL.setText("feet");
                                break;
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                break;
            case R.id.area_layout_vertical:
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                unitPreL.setText("m^2");
                                break;
                            case 1:
                                unitPreL.setText("Ha");
                                break;
                            case 2:
                                unitPreL.setText("평");
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                break;
            case R.id.weight_layout_vertical:
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                unitPreL.setText("kg");
                                break;
                            case 1:
                                unitPreL.setText("oz");
                                break;
                            case 2:
                                unitPreL.setText("t");
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                break;
        }

    }

}
