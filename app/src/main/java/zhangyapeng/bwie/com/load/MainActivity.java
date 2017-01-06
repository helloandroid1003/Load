package zhangyapeng.bwie.com.load;

import android.os.Environment;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import view.Circe;

public class MainActivity extends AppCompatActivity {

    private Circe circe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circe = (Circe) findViewById(R.id.ci);
        new Thread(){
            @Override
            public void run() {
                super.run();
                int count=0;
                while(count<=100){
                    SystemClock.sleep(500);
                    circe.addrest(100,count++);
                }
            }
        }.start();


    }
}
