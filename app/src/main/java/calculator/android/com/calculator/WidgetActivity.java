package calculator.android.com.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WidgetActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    ToggleButton tb;
    CheckBox cbApple;
    CheckBox cbBanana;
    CheckBox cbCherry;
    RadioGroup radio;
    Spinner spinner;
    SeekBar seekbar;
//    String months[] = {"JAN", "FEB", "MAR" , "APR","MAY","JUN","JUL"};
    ArrayList<String> months;

    TextView seektv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        tb = (ToggleButton) findViewById(R.id.togBtn);
        // 토글 버튼용 리스너를 달아준다.
//        tb.setOnCheckedChangeListener(toggleListener);
        tb.setOnCheckedChangeListener(this); // 이전에 버튼 연결했던 방식.

        cbApple = (CheckBox) findViewById(R.id.appleChk);
//        cbApple.setOnCheckedChangeListener(this);
        cbBanana = (CheckBox) findViewById(R.id.bananaChk);
        cbCherry = (CheckBox) findViewById(R.id.cherryChk);



        radio = (RadioGroup) findViewById(R.id.rg);

        //라디오그룹 리스너 생성 및 등록 같이하기
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                switch(checkId) {
                    case R.id.antRadio:
                        Toast.makeText(WidgetActivity.this, "Ant 라디오 버튼", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bearRadio:
                        Toast.makeText(WidgetActivity.this, "Bear 라디오 버튼", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.catRadio:
                        Toast.makeText(WidgetActivity.this, "Cat 라디오 버튼", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

        // 3.스피너
        spinner = (Spinner) findViewById(R.id.sn);
        // 3.pre 스피너에 들어갈 데이터를 동적으로 정의하세요
        // 데이터는 올해부터 100년전까지
        months = new ArrayList<>();
        for(int index = 0 ; index < 100 ; index++) {
            months.add(index, 2017 - index + "");

        }
        // 3.1 스피너 데이터 등록
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, months);
                                                            //  ^ 컨텍스트     ^스피너에서 사용할 레이아웃    ,      ^ 배열데이터
        // 3.2 스피너에 아답터 등록
        spinner.setAdapter(adapter);
        // 3.3 스피너 리스너에 등록
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(WidgetActivity.this, "선택된 아이템 : " + months.get(position), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // 4. seekbar 등록 변경사항을 seektv에 보여준다.
        seekbar = (SeekBar) findViewById(R.id.sb);
        seektv = (TextView) findViewById(R.id.seekTv);

        // 4.1 seekbar에 리스터를 등록한다.
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // 4.1.2 seekbar를 움직이면 호출되는 함수
            @Override                  // prograss는 현재 위치를 숫자로 반환, fromUser는 유져에 의한 변화는 true, 코딩을통한 변화는 false
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seektv.setText(progress + "");// settext는 str을 받아야한다.
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    @Override
    public void onCheckedChanged(CompoundButton cb, boolean flag) {
        switch (cb.getId()) {
            case R.id.togBtn:
                // 화면에 뜨는 출력
                Toast.makeText(WidgetActivity.this, "토글됨 = " +flag, Toast.LENGTH_SHORT ).show();
                break;
            case R.id.appleChk:
                Toast.makeText(WidgetActivity.this, "사과 체크됨 = " +flag, Toast.LENGTH_SHORT ).show();
                break;
            case R.id.bananaChk:
                Toast.makeText(WidgetActivity.this, "바나나 체크됨 = " +flag, Toast.LENGTH_SHORT ).show();
                break;

        }
    }
}



//            // 토글 버튼용 리스터
//            CompoundButton.OnCheckedChangeListener toggleListener = new CompoundButton.OnCheckedChangeListener() {
//    @Override
//    public void onCheckedChanged(CompoundButton cb, boolean flag) {
//            switch (cb.getId()) {
//            case R.id.togBtn:
//            // 화면에 뜨는 출력
//            Toast.makeText(WidgetActivity.this, "토글됨 = " +flag, Toast.LENGTH_SHORT ).show();
//            break;
//            case R.id.appleChk:
//            Toast.makeText(WidgetActivity.this, "사과 체크됨 = " +flag, Toast.LENGTH_SHORT ).show();
//            break;
//            case R.id.bananaChk:
//            Toast.makeText(WidgetActivity.this, "바나나 체크됨 = " +flag, Toast.LENGTH_SHORT ).show();
//            break;
//
//            }
//       implement CompoundButton.OncheckedChangeListener 했을때는 이 메소드를 구현하게 되어있다 - 인터페이스
//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        Toast.makeText(WidgetActivity.this, "토글됨 = " +b, Toast.LENGTH_SHORT ).show();
//    }

