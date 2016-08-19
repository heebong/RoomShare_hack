package com.example.user.tcardv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by USER on 2016-07-25.
 */
public class Splash extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class); //일단은 Writing화면으로 넘어가게 해놨음, 후에 다른 화면으로 바꿔야 함
                startActivity(intent);
                finish();
            }
        }, 1000); //스플래쉬 화면을 ?초 동안 보여준 뒤, 로그인 화면으로 전환
    }
}
