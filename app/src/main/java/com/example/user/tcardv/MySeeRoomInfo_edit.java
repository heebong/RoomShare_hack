package com.example.user.tcardv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by USER on 2016-07-29.
 */
public class MySeeRoomInfo_edit extends AppCompatActivity {
    public int count = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myseeroominfo2);

        // Data 객체를 받을 Intent 생성
        Intent intent = getIntent();
        final Data data = (Data)intent.getSerializableExtra("data");

        ImageView get_img = (ImageView)findViewById(R.id.my2_info_imgview);
        EditText get_title = (EditText) findViewById(R.id.my2_info_title);
        EditText get_address = (EditText) findViewById(R.id.my2_info_address);
        EditText get_price = (EditText) findViewById(R.id.my2_info_price);
        EditText get_living_people = (EditText) findViewById(R.id.my2_info_living_people);
        EditText get_recruit_people = (EditText) findViewById(R.id.my2_info_recruit_people);
        EditText get_content = (EditText) findViewById(R.id.my2_info_content);

        get_title.setText(data.title);
        get_address.setText(data.address);
        get_price.setText(data.price);
        get_living_people.setText(String.valueOf(data.living_people));
        get_recruit_people.setText(String.valueOf(data.recruit_people));
        get_content.setText(data.content);

        //EditText는 스트링이 아니라서 getText().toString()으로 스트링을 받아야한다.
        String title = get_title.getText().toString();
        String address = get_address.getText().toString();
        String price = get_price.getText().toString();
        String lip = get_living_people.getText().toString();
        String recp = get_recruit_people.getText().toString();
        String content = get_content.getText().toString();

        //스트링이라 이렇게 함.
        data.title = title;
        data.address = address;
        data.price = price;
        data.living_people = lip;
        data.recruit_people = recp;
        data.content = content;

        data.setData(title,address,price,lip,recp,content);



        // 스크랩 버튼 추가
        final Button saveb= (Button)findViewById(R.id.my_info2_savebutton);
        saveb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //scrap_btn.setSelected(true);
                Intent intent = new Intent(MySeeRoomInfo_edit.this, MySeeRoomInfo_show.class);
                intent.putExtra("data",data);
                startActivity(intent);
                finish();
            }
        });
    }
}
