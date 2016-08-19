package com.example.user.tcardv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //리스트 선언.
    ArrayList<Main> al = new ArrayList<Main>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.realmain);

        //툴바 등록. writing.xml랑 splash.xml을 제외하곤 툴바 사용.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //플로팅 액션 버튼(글쓰기 버튼) 이벤트 등록
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Writing.class);
                startActivity(intent);
            }
        });

        //메인 프래그먼트 기본값으로 설정.
        Fragment fragment = new MainFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content,fragment);
        ft.commit();


        /*//리사이클러 연결
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true); //크기 고정
        recyclerView.setLayoutManager(layoutManager);

        //리사이클러 아이템 추가
        List<Recycler_item> items=new ArrayList<>();
        Recycler_item[] item=new Recycler_item[5];
        item[0]=new Recycler_item(R.drawable.room1,"숙대 정문 바로 앞 20평 1명 구해요","청파로 어쩌구 저쩌구","1달 30만원","1명");
        item[1]=new Recycler_item(R.drawable.room2,"지지고 앞에 위치 15평 1명 구해요","청파로 어쩌구 저쩌구","1달 20만원","2명");
        item[2]=new Recycler_item(R.drawable.room3,"숙대 정문 바로 앞 20평 1명 구해요","청파로 어쩌구 저쩌구","1달 30만원","1명");
        item[3]=new Recycler_item(R.mipmap.a,"지지고 앞에 위치 15평 1명 구해요","청파로 어쩌구 저쩌구","1달 20만원","2명");
        item[4]=new Recycler_item(R.mipmap.a,"숙대 정문 바로 앞 20평 1명 구해요","청파로 어쩌구 저쩌구","1달 30만원","1명");

        for(int i=0;i<5;i++) {items.add(item[i]); } //아이템 등록
        //recyclerView.setOnItemClickListener(mListViewItemClickListener);


        recyclerView.setAdapter(new RecyclerAdapter(getApplicationContext(),items,R.layout.realmain)); //리사이클러 어뎁터*/


        //리스트에 데이터 추가 저장.
        al.add(new Main("숙명여자대학교 정문 앞, 3분 거리에 위치한 빌라", R.drawable.room1, "1달 20만원", "숙대 국어국문학과 학생입니다. 룸메는 역시 숙대생으로 구하고 있고요, 쾌적한 환경에서 같이 사실 분, 성격 좋으신 분 구합니다~ 카톡 id2016으로 연락주세요~","서울시 용산구 청파로 3가 한강그린빌라 202호", "1명", "1명"));
        al.add(new Main("숙대입구역 근처 후암동에서 살 사람 구합니다~", R.drawable.room2, "1달 40만원", "지금은 2명이서 거주하고 있습니다. 관심있으신 분 01080600000으로 연락주세요^^","서울시 용산구 후암동 252-4 현대그린빌라 401호", "2명", "1명"));
        al.add(new Main("숙명여자대학교 근처, 도보로 30분 이내", R.drawable.room3, "1달 45만원", "평수는 25평입니다. 관심있으신 분 연락바랍니다. 카톡아이디 id0000","서울시 용산구 청파로 2가 무지개아파트 101동 901호", "1명", "1명"));
        al.add(new Main("숙대 근처 빌라에서 같이 사실 분 구합니다~", R.drawable.room4, "1달 30만원", "빌라가 너무 넓어요 ㅠㅠ 같이 살 분 구해요! 벽지같은거 리모델링 해서 완전 깨끗해요!!!","서울시 용산구 청파로 1가 정원빌라 108호", "1명", "1명"));
        al.add(new Main("숙대 바로 옆 효창공원역 빌라에서 같이 살 한 분 구합니다. 숙대생으로요!", R.drawable.room5, "1달 30만원", "35평이나 되는 큰 빌라입니다. 관심있으신 분은 01088889898으로 연락주세요, 더 자세히 설명드리겠습니다!","서울시 용산구 효창공원역 3번 출구 상원빌라 222호", "3명", "1명"));
        al.add(new Main("숙대 옆 후암동 아파트에 같이 살 사람 구합니다~", R.drawable.room6, "1달 45만원", "아파트라 시원한 공기를 마실 수 있어요~ 여름에도 시원합니다. 07078998788로 연락주세요!","서울시 용산구 후암동 상동아파트 101동 120호", "1명", "1명"));

        //어뎁터 연결.
        MyAdapter adapter = new MyAdapter(
                getApplicationContext(), // 현재화면의 제어권자
                R.layout.row,  // 리스트뷰의 한행의 레이아웃
                al);         // 데이터

        ListView lv = (ListView)findViewById(R.id.listView1);
        lv.setAdapter(adapter);

        /*if(Writing.data != null)
        {
            al.add(new Main(Writing.data.title, R.drawable.room7, Writing.data.price , Writing.data.content ,Writing.data.address , Writing.data.living_people, Writing.data.recruit_people));
            MyAdapter adapter2 = new MyAdapter(
                    getApplicationContext(), // 현재화면의 제어권자
                    R.layout.row,  // 리스트뷰의 한행의 레이아웃
                    al);         // 데이터
            lv.setAdapter(adapter2);
        }*/
        //클릭시 데이터 넘김.
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 상세정보 화면으로 이동하기(인텐트 날리기)
                // 1. 다음화면을 만든다
                // 2. AndroidManifest.xml 에 화면을 등록한다
                // 3. Intent 객체를 생성하여 날린다)
                Intent intent = new Intent(getApplicationContext(), Room1.class); // 다음넘어갈 화면

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
        });

        //네비게이션 드로어. 나도 잘 모름. 걍 긁음
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    //몰라 오버라이드. 아마 네비랑 연관있는 듯.
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //옵션 메뉴 버튼.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //우측 상단 옵션메뉴버튼.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"새로고침",Toast.LENGTH_SHORT).show();

            if(Writing.data != null)
            {
                al.add(new Main(Writing.data.title, R.drawable.room7, Writing.data.price , Writing.data.content ,Writing.data.address , Writing.data.living_people, Writing.data.recruit_people));
                MyAdapter adapter2 = new MyAdapter(
                        getApplicationContext(), // 현재화면의 제어권자
                        R.layout.row,  // 리스트뷰의 한행의 레이아웃
                        al);         // 데이터
                ListView lv = (ListView)findViewById(R.id.listView1);
                lv.setAdapter(adapter2);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //네비게이션 리스트 눌렸을 때.
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        selectDrawerItem(item);
        return true;
    }

    public void selectDrawerItem (MenuItem item) {
        int id = item.getItemId();

        Fragment fragment = null;
        String title = getString(R.string.app_name);

        if (id == R.id.nav_scrap) {
            fragment = new ScrapFragment();
            title = "스크랩";
        } else if (id == R.id.nav_mine) {
            /*fragment = new MinewriteFragment();
            title = "내가 작성한 글";*/
            if (Writing.data != null)
            {
                Intent intent = new Intent(MainActivity.this, MySeeRoomInfo_show.class);
                intent.putExtra("data",Writing.data);
                startActivity(intent);
            } else {
                fragment = new MinewriteFragment();
                title = "내가 작성한 글";
            }
        } else if (id == R.id.nav_home) {
            fragment = new MainFragment();//메인으로 이동.
            /*Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
            finish();*/
        }

        //프래그먼트가 재배치되게 = 넘어가게 만듦.
        if(fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content,fragment);
            ft.commit();
        }
        //타이틀 설정.
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}

//리스트 클래스
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

        //room1_info_address.setVisibility(View.GONE);
        room1_info_living_people.setVisibility(View.GONE);
        //room1_info_recruit_people.setVisibility(View.GONE);
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
}
