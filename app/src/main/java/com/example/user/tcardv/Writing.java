package com.example.user.tcardv;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Writing extends AppCompatActivity {

    final int REQ_CODE_SELECT_IMAGE=100;
    static Data data;

    private EditText title_text, address_text, price_text, recruit_people_text, living_people_text, content_text;
    private Button writing_complete_btn, writing_cancel_btn;
    private ImageButton photo_imgbtn;
    private ImageView photo_imgview;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);

        //화면회전금지
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        photo_imgbtn = (ImageButton)findViewById(R.id.photo_imgbtn);
        photo_imgview = (ImageView)findViewById(R.id.photo_imgview);
        title_text = (EditText)findViewById(R.id.title_text);
        address_text = (EditText)findViewById(R.id.address_text);
        price_text = (EditText)findViewById(R.id.price_text);
        recruit_people_text = (EditText)findViewById(R.id.recruit_people_text);
        living_people_text = (EditText)findViewById(R.id.living_people_text);
        writing_complete_btn = (Button)findViewById(R.id.writing_complete_btn);
        writing_cancel_btn = (Button)findViewById(R.id.writing_cancel_btn);
        content_text = (EditText) findViewById(R.id.content_text);
        btnClickEvent();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Toast.makeText(getBaseContext(), "resultCode : "+resultCode,Toast.LENGTH_SHORT).show();
        if(requestCode == REQ_CODE_SELECT_IMAGE)
        {
            if(resultCode== Activity.RESULT_OK)
            {
                try {
                    //Uri에서 이미지 이름을 얻어온다.
                    String name_Str = getImageNameToUri(data.getData());

                    //이미지 데이터를 비트맵으로 받아온다.
                    Bitmap image_bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    ImageView image = (ImageView)findViewById(R.id.photo_imgview);
                    //배치해놓은 ImageView에 set
                    image.setImageBitmap(image_bitmap);

                    Toast.makeText(getBaseContext(), name_Str+" 업로드 완료",Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getImageNameToUri(Uri data)
    {
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(data, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        String imgPath = cursor.getString(column_index);
        String imgName = imgPath.substring(imgPath.lastIndexOf("/")+1);

        return imgName;
    }

    public void btnClickEvent(){
        photo_imgbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQ_CODE_SELECT_IMAGE);
            }
        });

        //글쓰기 취소 버튼을 눌렀을 때
        writing_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //글쓰기 완료 버튼을 눌렀을 때
        writing_complete_btn.setOnClickListener(new View.OnClickListener() {
            //제목 확인
            @Override
            public void onClick(View v) {
                if (title_text.getText().toString().length() == 0) {
                    Toast.makeText(Writing.this, "제목을 입력하세요.", Toast.LENGTH_SHORT).show();
                    title_text.requestFocus();
                    return;
                }

                if (address_text.getText().toString().length() == 0) {
                    Toast.makeText(Writing.this, "주소를 입력하세요.", Toast.LENGTH_SHORT).show();
                    address_text.requestFocus();
                    return;
                }

                if (living_people_text.getText().toString().length() == 0) {
                    Toast.makeText(Writing.this, "현재거주 인원을 입력하세요.", Toast.LENGTH_SHORT).show();
                    living_people_text.requestFocus();
                    return;
                }

                if (recruit_people_text.getText().toString().length() == 0) {
                    Toast.makeText(Writing.this, "모집 인원을 입력하세요.", Toast.LENGTH_SHORT).show();
                    recruit_people_text.requestFocus();
                    return;
                }

                if (price_text.getText().toString().length() == 0) {
                    Toast.makeText(Writing.this, "가격을 입력하세요.", Toast.LENGTH_SHORT).show();
                    price_text.requestFocus();
                    return;
                }

                if (content_text.getText().toString().length() == 0) {
                    Toast.makeText(Writing.this, "내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                    content_text.requestFocus();
                    return;
                }

                else {

                    String title = title_text.getText().toString();
                    String address = address_text.getText().toString();
                    String price = price_text.getText().toString();
                    String living_people = (living_people_text.getText().toString());
                    String recruit_people = (recruit_people_text.getText().toString());
                    String content = content_text.getText().toString();


                    // Data 객체 생성
                    /*Data*/ data = new Data(title, address, price,living_people, recruit_people, content);

                    /*리스트에 추가하자*/

                    // Intent에 Data객체 저장
                    Intent intent = new Intent(Writing.this, SeeRoomInfo.class);
                    intent.putExtra("data", data);

                    // Activity 전환
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}