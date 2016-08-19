package com.example.user.tcardv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SeeRoomInfo extends AppCompatActivity {
    public int count = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeroominfo);

        // Data 객체를 받을 Intent 생성
        Intent intent = getIntent();
        Data data = (Data)intent.getSerializableExtra("data");

        ImageView get_img = (ImageView)findViewById(R.id.info_imgview);
        TextView get_title = (TextView) findViewById(R.id.info_title);
        TextView get_address = (TextView) findViewById(R.id.info_address);
        TextView get_price = (TextView) findViewById(R.id.info_price);
        TextView get_living_people = (TextView) findViewById(R.id.info_living_people);
        TextView get_recruit_people = (TextView) findViewById(R.id.info_recruit_people);
        TextView get_content = (TextView) findViewById(R.id.info_content);

        get_title.setText(data.title);
        get_address.setText(data.address);
        get_price.setText(data.price);
        get_living_people.setText(String.valueOf(data.living_people));
        get_recruit_people.setText(String.valueOf(data.recruit_people));
        get_content.setText(data.content);

        // 스크랩 버튼 추가
        final Button scrap_btn= (Button)findViewById(R.id.scrap_btn);
        scrap_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //scrap_btn.setSelected(true);
                if(count==0) {
                    scrap_btn.setSelected(true);
                    Toast.makeText(getBaseContext(), "스크랩 되었습니다!",Toast.LENGTH_SHORT).show();
                    count++; //count=1일 때, 버튼 활성화
                }
                else {
                    scrap_btn.setSelected(false);
                    Toast.makeText(getBaseContext(), "스크랩이 취소되었습니다.",Toast.LENGTH_SHORT).show();
                    count--; //count==0일 때, 버튼 비활성화
                }
            }
        });
    }
}
