package jp.techacademy.kiyoshi.ooyama.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mText = (TextView) findViewById(R.id.text1);

    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.button1){
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("Aisatsu", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        //条件判断
                        int jikan = hourOfDay * 60;
                        int fun = minute;
                        int total =jikan+fun;
                        if (total >= 120 && total <= 599){
                            mText.setText("おはよう");
                        } else if (total >= 600 && total <= 1079){
                            mText.setText("こんにちは");
                        } else if(total >= 1080 && total <= 1439){
                            mText.setText("こんばんは");
                        } else if(total >= 0 && total <= 119){
                            mText.setText("こんばんは");
                        }

                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}
