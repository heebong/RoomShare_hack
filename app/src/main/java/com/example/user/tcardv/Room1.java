package com.example.user.tcardv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Room1 extends AppCompatActivity {
    public int count = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room1);

        ImageView room1_info_imgview = (ImageView)findViewById(R.id.room1_info_imgview);
        TextView room1_info_title = (TextView)findViewById(R.id.room1_info_title);
        TextView room1_info_price = (TextView)findViewById(R.id.room1_info_price);
        TextView room1_info_living_people = (TextView)findViewById(R.id.room1_info_living_people);
        TextView room1_info_recruit_people = (TextView)findViewById(R.id.room1_info_recruit_people);
        TextView room1_info_content = (TextView)findViewById(R.id.room1_info_content);
        TextView room1_info_address = (TextView)findViewById(R.id.room1_info_address);

        //room1_info_address.setVisibility(View.GONE);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
        room1_info_imgview.setImageResource(intent.getIntExtra("img", 0));
        room1_info_title.setText(intent.getStringExtra("title"));
        room1_info_price.setText(intent.getStringExtra("price"));
        room1_info_content.setText(intent.getStringExtra("content"));
        room1_info_address.setText(intent.getStringExtra("address"));
        room1_info_living_people.setText(intent.getStringExtra("living_people"));
        room1_info_recruit_people.setText(intent.getStringExtra("recruit_people"));


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