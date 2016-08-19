package com.example.user.tcardv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2016-07-28.
 */
public class MainFragment extends Fragment {
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    //리스트 선언.
    ArrayList<Main> al = new ArrayList<Main>();

    public MainFragment () {

    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//리사이클러 연결
        /*RecyclerView recyclerView=(RecyclerView)getView().findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity()); //getApplicationContext를 getActivity로 변경
        recyclerView.setHasFixedSize(true); //크기 고정
        recyclerView.setLayoutManager(layoutManager);

        //리사이클러 아이템 추가
        List<Recycler_item> items=new ArrayList<>();
        Recycler_item[] item=new Recycler_item[5];
        item[0]=new Recycler_item(R.mipmap.b,"숙대 정문 바로 앞 20평 1명 구해요","청파로 어쩌구 저쩌구","1달 30만원","1명");
        item[1]=new Recycler_item(R.mipmap.b,"지지고 앞에 위치 15평 1명 구해요","청파로 어쩌구 저쩌구","1달 20만원","2명");
        item[2]=new Recycler_item(R.mipmap.a,"숙대 정문 바로 앞 20평 1명 구해요","청파로 어쩌구 저쩌구","1달 30만원","1명");
        item[3]=new Recycler_item(R.mipmap.a,"지지고 앞에 위치 15평 1명 구해요","청파로 어쩌구 저쩌구","1달 20만원","2명");
        item[4]=new Recycler_item(R.mipmap.a,"숙대 정문 바로 앞 20평 1명 구해요","청파로 어쩌구 저쩌구","1달 30만원","1명");

        for(int i=0;i<5;i++) items.add(item[i]); //아이템 등록

        recyclerView.setAdapter(new RecyclerAdapter(getActivity(),items,R.layout.fragment_main)); //getApplicationContext를 getActivity로 변경*/
// Inflate the layout for this fragment

        /*//리스트에 데이터 추가 저장.
        al.add(new Main("숙명여자대학교 정문 앞, 3분 거리에 위치한 빌라", R.drawable.room1, "1달 20만원", "숙대 국어국문학과 학생입니다. 룸메는 역시 숙대생으로 구하고 있고요, 쾌적한 환경에서 같이 사실 분, 성격 좋으신 분 구합니다~ 카톡 id2016으로 연락주세요~","서울시 용산구 청파로 3가 한강그린빌라 202호", "1", "1"));
        al.add(new Main("제목2", R.drawable.room2, "가격2", "내용2","주소2", "1", "1"));
        al.add(new Main("제목3", R.drawable.room3, "가격3", "내용3","주소1", "1", "1"));
        al.add(new Main("제목4", R.drawable.room4, "가격4", "내용4","주소1", "1", "1"));
        al.add(new Main("제목5", R.drawable.room5, "가격5", "내용5","주소1", "1", "1"));
        al.add(new Main("제목6", R.drawable.room6, "가격6", "내용6","주소1", "1", "1"));

        //어뎁터 연결.
        MyAdapter adapter = new MyAdapter(
                getActivity(), // 현재화면의 제어권자
                R.layout.row,  // 리스트뷰의 한행의 레이아웃
                al);         // 데이터

        ListView lv = (ListView)getView().findViewById(R.id.listView1);
        lv.setAdapter(adapter);

        //클릭시 데이터 넘김.
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 상세정보 화면으로 이동하기(인텐트 날리기)
                // 1. 다음화면을 만든다
                // 2. AndroidManifest.xml 에 화면을 등록한다
                // 3. Intent 객체를 생성하여 날린다)
                Intent intent = new Intent(getActivity(), Room1.class); // 다음넘어갈 화면

                // intent 객체에 데이터를 실어서 보내기
                // 리스트뷰 클릭시 인텐트 (Intent) 생성하고 position 값을 이용하여 인텐트로 넘길값들을 넘긴다
                intent.putExtra("title", al.get(position).title);
                intent.putExtra("img", al.get(position).img);
                intent.putExtra("price", al.get(position).price);
                intent.putExtra("content", al.get(position).content);
                intent.putExtra("address", al.get(position).address);
                intent.putExtra("living_people", al.get(position).living_people);
                intent.putExtra("recruit_people", al.get(position).recruit_people);

                startActivity(intent);
            }
        });*/
        View view = inflater.inflate(R.layout.fragment_main,null);

        MyAdapter adapter = new MyAdapter(
                getActivity(), // 현재화면의 제어권자
                R.layout.row,  // 리스트뷰의 한행의 레이아웃
                al);

        ListView listview = (ListView)view.findViewById(R.id.listView1);
        listview.setAdapter(adapter);

        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}

/*//리스트 클래스
class Main {
    String title = ""; // 제목
    int img; // 사진
    String price = "";// 가격
    String content =""; // 내용
    String address="";
    String living_people="";
    String recruit_people="";

    public Main(String title, int img, String price, String content, String address, String living_people, String recruit_people) {
        super();
        this.title = title;
        this.img = img;
        this.price = price;
        this.content = content;
        this.address = address;
        this.living_people = living_people;
        this.recruit_people = recruit_people;
    }
    public Main() {}
}

class MyAdapter extends BaseAdapter { // 리스트 뷰의 아답타
    Context context;
    int layout;
    ArrayList<Main> al;
    LayoutInflater inf;
    public MyAdapter(Context context, int layout, ArrayList<Main> al) {
        this.context = context;
        this.layout = layout;
        this.al = al;
        inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return al.size();
    }
    @Override
    public Object getItem(int position) {
        return al.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = inf.inflate(layout, null);
        }
        ImageView room1_info_imgview = (ImageView)convertView.findViewById(R.id.imageView1);
        TextView room1_info_title = (TextView)convertView.findViewById(R.id.textView1);
        TextView room1_info_price = (TextView)convertView.findViewById(R.id.textView2);
        TextView room1_info_content = (TextView)convertView.findViewById(R.id.textView3);
        TextView room1_info_address = (TextView)convertView.findViewById(R.id.textView4);
        TextView room1_info_living_people = (TextView)convertView.findViewById(R.id.textView5);
        TextView room1_info_recruit_people = (TextView)convertView.findViewById(R.id.textView6);

        room1_info_address.setVisibility(View.GONE);
        room1_info_living_people.setVisibility(View.GONE);
        room1_info_recruit_people.setVisibility(View.GONE);
        room1_info_content.setVisibility(View.GONE);

        Main m = al.get(position);
        room1_info_imgview.setImageResource(m.img);
        room1_info_title.setText(m.title);
        room1_info_price.setText(m.price);
        room1_info_content.setText(m.content);
        room1_info_address.setText(m.address);
        room1_info_living_people.setText(m.living_people);
        room1_info_recruit_people.setText(m.recruit_people);

        return convertView;
    }
}*/
