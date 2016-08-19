package com.example.user.tcardv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by USER on 2016-07-29.
 */
public class MySeeRoomInfo_show extends AppCompatActivity {
    //public int count = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myseeroominfo);

        // Data 객체를 받을 Intent 생성
        Intent intent = getIntent();
        final Data data = (Data)intent.getSerializableExtra("data");

        ImageView get_img = (ImageView)findViewById(R.id.my_info_imgview);
        TextView get_title = (TextView) findViewById(R.id.my_info_title);
        TextView get_address = (TextView) findViewById(R.id.my_info_address);
        TextView get_price = (TextView) findViewById(R.id.my_info_price);
        TextView get_living_people = (TextView) findViewById(R.id.my_info_living_people);
        TextView get_recruit_people = (TextView) findViewById(R.id.my_info_recruit_people);
        TextView get_content = (TextView) findViewById(R.id.my_info_content);

        get_title.setText(data.title);
        get_address.setText(data.address);
        get_price.setText(data.price);
        get_living_people.setText(String.valueOf(data.living_people));
        get_recruit_people.setText(String.valueOf(data.recruit_people));
        get_content.setText(data.content);

        // 스크랩 버튼 추가
        final Button editb = (Button)findViewById(R.id.my_info_editbutton);
        editb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //scrap_btn.setSelected(true);
                Intent intent = new Intent(MySeeRoomInfo_show.this, MySeeRoomInfo_edit.class);
                intent.putExtra("data",data);
                startActivity(intent);
                finish();
            }
        });
    }
}
