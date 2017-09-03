package tw.com.frankchang.houli.classno_06_bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etHeight, etWidth;
//    Button btnBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviewer();
    }

    void findviewer(){
        etHeight = (EditText)findViewById(R.id.editText);
        etWidth = (EditText)findViewById(R.id.editText2);

        /*btnBMI = (Button)findViewById(R.id.button);
        btnBMI.setOnClickListener(btnOnClicker);*/
    }

    /*View.OnClickListener btnOnClicker = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //此次範例不使用
        }
    };*/

    public void OnClick(View v){
        //此次採用 XML 程式自動建立 OnClickListener 的 OnClick(View v) 的方式
        //※不建議使用此方法，因程式不會永遠都由同一人維護，換人維護會容易產生不明白此段程式用途的情況！

        double dHeight = 0.0, dWidth = 0.0;

        //建立意圖物件
        Intent it = new Intent();
        //設定意圖（切換目前頁面到目標頁面）
        it.setClass(MainActivity.this, BmiActivity.class);

        //設定廣播（不明確意圖；呼叫其它APP頁面，例如：LINE）
        //it.setAction("想呼叫頁面的 Activity");

        try{
            dHeight = Double.parseDouble(etHeight.getText().toString());
            dWidth = Double.parseDouble(etWidth.getText().toString());
        }
        catch (NumberFormatException e){

            return;
        }
        Bundle bdData = new Bundle();
        bdData.putDouble("Height", dHeight);
        bdData.putDouble("Width", dWidth);
        it.putExtras(bdData);
        //執行
        startActivity(it);
    }
}
