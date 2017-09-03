package tw.com.frankchang.houli.classno_06_bmi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    TextView tvHeight, tvWidth, tvBMI;
    ImageButton imgbtnReturn;
    double Height, Width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        findviewer();
        unBundle();
    }

    void findviewer(){
        tvHeight = (TextView)findViewById(R.id.textView);
        tvWidth = (TextView)findViewById(R.id.textView2);
        tvBMI = (TextView)findViewById(R.id.textView3);

        imgbtnReturn = (ImageButton)findViewById(R.id.imageButton);
        imgbtnReturn.setOnClickListener(imgbtnOnClicker);
    }

    void unBundle(){
        Bundle bdData = getIntent().getExtras();
        Height = bdData.getDouble("Height");
        Width = bdData.getDouble("Width");

        //計算
        double dBMI = 0.0;

        //BMI = 體重(公斤) / 身高2(公尺2)
        dBMI = Height / (Width * Width);

        //塞值
        tvHeight.setText(String.valueOf(Height));
        tvWidth.setText(String.valueOf(Width));

        tvBMI.setText(String.format("%.2f",dBMI));
    }

    View.OnClickListener imgbtnOnClicker = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            BmiActivity.this.finish();
        }
    };
}
