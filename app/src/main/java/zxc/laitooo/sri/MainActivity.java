package zxc.laitooo.sri;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.android.volley.Response;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import zxc.laitooo.sri.about.AboutSriActivity;
import zxc.laitooo.sri.about.AboutWebsiteActivity;
import zxc.laitooo.sri.about.ContactUsActivity;
import zxc.laitooo.sri.about.LogoStoryActivity;
import zxc.laitooo.sri.data.Constants;
import zxc.laitooo.sri.data.NetworkTask;
import zxc.laitooo.sri.data.QuestionTags;
import zxc.laitooo.sri.data.UserData;
import zxc.laitooo.sri.picasso.CircleTransformation;
import zxc.laitooo.sri.reputation.ReputationSystem;

public class
        MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    public static String[] strings = new String[]{"","",""};
    public static int currentText = 0;
    public static int countMessage = 3;
    private Menu m;
    static FragmentManager manager;
    static Fragment f;

    ArrayList<MemberSpace> myPostsList;
    ArrayList<Question> myQuestionsList;
    TabLayout tabLayout;

    static Context c;
    View headerLayout;


    boolean pressed;

    static TextSwitcher switcher;

    static ArrayList<MemberSpace> postsList;
    static MemberSpaceAdapter postsAdapter;

    static QuestionsAdapter questionsAdapter;
    static ArrayList<Question> questionList;

    boolean myPost = false;
    boolean myQuestion = false;

    int ppp = 0;

    ProgressBar progressBar;

    int level,following,followers;
    double reputation;
    ReputationSystem system;



    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    static NotificationManager notificationManager;

    final int[] icons = new int[] {
            R.drawable.icon_allien,
            R.drawable.icon_remote,
            R.drawable.icon_home,
            R.drawable.icon_car,
            R.drawable.icon_fire};

    static android.support.v7.app.ActionBar actionBar;

    TextView a1,a2,a3,a4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pressed = false;
        c = MainActivity.this;

        manager = getSupportFragmentManager();

        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);


        a1 = (TextView) findViewById(R.id.fab_text1);
        a2 = (TextView) findViewById(R.id.fab_text2);
        a3 = (TextView) findViewById(R.id.fab_text3);
        a4 = (TextView) findViewById(R.id.fab_text4);

        hideMenu();

        final FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_main);

        actionBar = getSupportActionBar();
        actionBar.setIcon(R.drawable.logo_new);

        strings[0] = getResources().getString(R.string.slogan1);
        strings[1] = getResources().getString(R.string.slogan2);
        strings[2] = getResources().getString(R.string.slogan3);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections postsAdapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                myPost = false;
                myQuestion = false;

                fab.setImageResource(android.R.drawable.ic_menu_add);
                hideMenu();
                pressed = false;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));

        tabLayout.getTabAt(0).setIcon(icons[0]);
        tabLayout.getTabAt(1).setIcon(icons[2]);
        tabLayout.getTabAt(2).setIcon(icons[3]);

        final View.OnClickListener newPost = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(),NewPostActivity.class),2332);
                fab.setImageResource(android.R.drawable.ic_menu_add);

                a4.setText("");
                pressed = false;

                hideMenu();
            }
        };

        final View.OnClickListener newQuestion = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(),NewQuestionActivity.class),2333);

                fab.setImageResource(android.R.drawable.ic_menu_add);

                pressed = false;

                hideMenu();
            }
        };

        final View.OnClickListener myPosts = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(2);
                //postsList.clear();
                UserData data = new UserData(MainActivity.this);
                Map<String,String> map = new HashMap<String, String>();
                map.put("id_user",String.valueOf(data.getId()));
                postsList.clear();
                NetworkTask task = new NetworkTask(true, Constants.MY_POSTS, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            JSONArray posts = object.getJSONArray("posts");
                            for (int i=0;i<posts.length();i++){
                                JSONObject post = posts.getJSONObject(i);
                                postsList.add(0,new MemberSpace(post.getInt("id"),post.getInt("id_user"),
                                        post.getString("image"),
                                        post.getString("username"),post.getString("date"),
                                        post.getString("time"),post.getString("content"),
                                        post.getInt("views")));
                            }
                            postsAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, MainActivity.this,map);
                task.executeTask();
                postsAdapter.notifyDataSetChanged();
                myPost = true;

                fab.setImageResource(android.R.drawable.ic_menu_add);

                pressed = false;

                hideMenu();
                ppp = 222;
            }
        };

        final View.OnClickListener myQuestions = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);
                questionList.clear();
                UserData data = new UserData(MainActivity.this);
                Map<String,String> map = new HashMap<String, String>();
                map.put("id_user",String.valueOf(data.getId()));
                myQuestionsList = new ArrayList<>();
                NetworkTask task = new NetworkTask(true, Constants.MY_QUESTIONS, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            JSONArray posts = object.getJSONArray("questions");
                            for (int i=0;i<posts.length();i++){
                                JSONObject ask = posts.getJSONObject(i);
                                questionList.add(0,new Question(ask.getInt("id"),ask.getInt("id_user"),
                                        ask.getString("image"),ask.getString("title"),
                                        ask.getString("username"),ask.getString("date"),
                                        ask.getString("time"),ask.getString("content"),
                                        ask.getInt("votes"),ask.getString("tags")));
                            }
                            questionsAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, MainActivity.this,map);
                task.executeTask();
                questionsAdapter.notifyDataSetChanged();
                myQuestion = true;

                fab.setImageResource(android.R.drawable.ic_menu_add);
                pressed = false;

                hideMenu();
                ppp = 111;
            }
        };



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int aa = tabLayout.getSelectedTabPosition();
                if (!pressed) {
                    fab.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
                    pressed = true;
                    if (aa == 0) {
                        a1.setText(getResources().getString(R.string.new_question));
                        a2.setText(getResources().getString(R.string.my_questions));
                        a3.setText(getResources().getString(R.string.new_post));
                        a4.setText(getResources().getString(R.string.my_posts));

                        a1.setOnClickListener(newQuestion);
                        a2.setOnClickListener(myQuestions);
                        a3.setOnClickListener(newPost);
                        a4.setOnClickListener(myPosts);

                        showMenu();

                    } else if (aa == 1) {
                        a1.setText(getResources().getString(R.string.new_post));
                        a2.setText(getResources().getString(R.string.new_question));
                        a3.setText(getResources().getString(R.string.my_posts));
                        a4.setText(getResources().getString(R.string.my_questions));

                        a1.setOnClickListener(newPost);
                        a2.setOnClickListener(newQuestion);
                        a3.setOnClickListener(myPosts);
                        a4.setOnClickListener(myQuestions);

                        showMenu();
                    } else if (aa == 2) {
                        a1.setText(getResources().getString(R.string.new_post));
                        a2.setText(getResources().getString(R.string.my_posts));
                        a3.setText(getResources().getString(R.string.new_question));
                        a4.setText(getResources().getString(R.string.my_questions));

                        a1.setOnClickListener(newPost);
                        a2.setOnClickListener(myPosts);
                        a3.setOnClickListener(newQuestion);
                        a4.setOnClickListener(myQuestions);

                        showMenu();
                    }
                } else {
                    pressed = false;
                    fab.setImageResource(android.R.drawable.ic_menu_add);
                    hideMenu();

                }
            }
        });



        headerLayout = navigationView.getHeaderView(0);
        progressBar = (ProgressBar)headerLayout.findViewById(R.id.progressbar);
        progressBar.setProgress(10);

        TextView t = (TextView)headerLayout.findViewById(R.id.drawer_reputation);
        TextView username = (TextView)headerLayout.findViewById(R.id.drawer_name);
        final TextView following_text = (TextView)headerLayout.findViewById(R.id.drawer_following);
        final TextView followers_text = (TextView)headerLayout.findViewById(R.id.drawer_followers);
        final TextView rep = (TextView)headerLayout.findViewById(R.id.drawer_reputation);


        UserData data = new UserData(MainActivity.this);
        username.setText(data.getUserName());
        ImageView profile = (ImageView)headerLayout.findViewById(R.id.drawer_image);

        if (data.getImageUrl().equals("no_profile")){
            Picasso.with(MainActivity.this)
                    .load(R.drawable.boy)
                    .error(R.drawable.logo)
                    .skipMemoryCache()
                    .into(profile);
        }else {
            Picasso.with(MainActivity.this)
                    .load(data.getImageUrl())
                    .skipMemoryCache()
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.logo)
                    .into(profile);
        }




        Map<String,String> map = new HashMap<>();
        map.put("id_user", String.valueOf(data.getId()));
        NetworkTask task = new NetworkTask(true, Constants.GET_REPUTATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    if (!object.getBoolean("error")){
                        level = object.getInt("level");
                        reputation = object.getDouble("points");
                        followers = object.getInt("followers");
                        following = object.getInt("following");
                        system = new ReputationSystem(reputation);
                        int a = (int)system.getMyThisLevelPoints();
                        int b = (int)system.getAllThisLevelPoints();
                        progressBar.setMax(b);
                        progressBar.setProgress(a);
                        following_text.setText("Following : " + following);
                        followers_text.setText("Followers : " + followers);
                        rep.setText("Reputation : " + reputation + "0");
                        //Toast.makeText(MainActivity.this, "a:" + a + " b:" + b, Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, object.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        },MainActivity.this,map,false);
        task.executeTask();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (myQuestion){
                questionList.clear();
                NetworkTask task = new NetworkTask(true, Constants.ALL_QUESTIONS, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            JSONArray posts = object.getJSONArray("questions");
                            for (int i=0;i<posts.length();i++){
                                JSONObject ask = posts.getJSONObject(i);
                                questionList.add(0,new Question(ask.getInt("id"),ask.getInt("id_user"),
                                        ask.getString("image"),ask.getString("title"),
                                        ask.getString("username"),ask.getString("date"),
                                        ask.getString("time"),ask.getString("content"),
                                        ask.getInt("votes"),ask.getString("tags")));
                            }
                            questionsAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, MainActivity.this, new HashMap<String, String>());
                task.executeTask();
                questionsAdapter.notifyDataSetChanged();
                myQuestion = false;
            }else if ((myPost)){
                postsList.clear();
                NetworkTask task = new NetworkTask(true, Constants.ALL_POSTS, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            JSONArray posts = object.getJSONArray("posts");
                            for (int i=0;i<posts.length();i++){
                                JSONObject post = posts.getJSONObject(i);
                                postsList.add(0,new MemberSpace(post.getInt("id"),post.getInt("id_user"),
                                        post.getString("image"),//post.getString("title"),
                                        post.getString("username"),post.getString("date"),
                                        post.getString("time"),post.getString("content"),
                                        post.getInt("views")));
                            }
                            postsAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, MainActivity.this, new HashMap<String, String>());
                task.executeTask();

                postsAdapter.notifyDataSetChanged();
                myPost = false;
            }else {
                super.onBackPressed();
            }
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        m = menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.mySearchView);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // new_language you specify actionBar parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.noti){
            Intent f = new Intent(getApplicationContext(),NotificationsActivity.class);
            startActivity(f);
        }else if (id == R.id.mySearchView){
            MenuItem rrr = m.findItem(R.id.noti);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.story){
            Intent f = new Intent(getApplicationContext(),LogoStoryActivity.class);
            startActivity(f);
        } else if (id == R.id.announ){
            Intent f = new Intent(getApplicationContext(),AnnouncementsActivity.class);
            startActivity(f);
        } else if (id == R.id.webinars) {
            Intent f = new Intent(getApplicationContext(),WebinarsActivity.class);
            startActivity(f);
        } else if (id == R.id.call) {
            Intent f = new Intent(getApplicationContext(),ContactUsActivity.class);
            startActivity(f);
        } else if (id == R.id.aboutSRF) {
            Intent f = new Intent(getApplicationContext(),AboutSriActivity.class);
            f.putExtra("laitooo",111);
            startActivity(f);
        } else if (id == R.id.ba3ati){
            Intent i = new Intent(getApplicationContext(),AboutWebsiteActivity.class);
            i.putExtra("Extra","ba3ati");
            startActivity(i);
        } else if (id == R.id.effective){
            Intent i = new Intent(getApplicationContext(),AboutWebsiteActivity.class);
            i.putExtra("Extra","effective");
            startActivity(i);
        } else if (id == R.id.reputation){
            Intent i = new Intent(getApplicationContext(),AboutWebsiteActivity.class);
            i.putExtra("Extra","reputation");
            startActivity(i);
        } else if (id == R.id.lumin){
            Intent i = new Intent(getApplicationContext(),AboutWebsiteActivity.class);
            i.putExtra("Extra","luminary");
            startActivity(i);
        } else if (id == R.id.log){
            MyDialog dialogss = new MyDialog(MainActivity.this,9);
            dialogss.show(getFragmentManager(), "My Dialog");
        }//else if (id == R.id.about1){
            //Toast.makeText(getApplicationContext(),"Sssssssss",Toast.LENGTH_SHORT).show();
        //}else if (id == R.id.about2){
          //  Toast.makeText(getApplicationContext(),"sddddd",Toast.LENGTH_SHORT).show();
        //}
        else {

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }

    public void LogoStory(View view) {
        Intent i = new Intent(getApplicationContext(),LogoStoryActivity.class);
        startActivity(i);
    }

    public void nominate(View view) {
        Intent i = new Intent(getApplicationContext(),NominateActivity.class);
        startActivity(i);
    }

    public void twitter(View view) {
        String link = getResources().getString(R.string.twitter_link);
        Uri uri = Uri.parse(link);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void facebook(View view){
        String link = getResources().getString(R.string.facebook_link);
        Uri uri = Uri.parse(link);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void youtube(View view){
        String link = getResources().getString(R.string.youtube_link);
        Uri uri = Uri.parse(link);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void more_luminaries(View view) {
        String link = getResources().getString(R.string.luminaries_link);
        Uri uri = Uri.parse(link);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void about_luminaries(View view) {
        Intent i = new Intent(getApplicationContext(),AboutWebsiteActivity.class);
        i.putExtra("Extra","luminary");
        startActivity(i);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return actionBar PlaceholderFragment (defined new_language actionBar static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }



        @Override
        public CharSequence getPageTitle(int position) {
            /*
            switch (position) {
                case 0:
                    return "Home";
                case 1:
                    return "Question";
                case 2:
                    return "NOtification";
                case 3:
                    return "Anoucments";
                case 4:
                    return "Spaces";
            }
            */
            return null;
        }
    }

    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns actionBar new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final Context c = getActivity();
            int num = getArguments().getInt(ARG_SECTION_NUMBER);
            if (num == 1) {

                questionList = new ArrayList<>();
                /*questionList.add(new Question(R.drawable.aaa, "Android Question","Laitooo san", "08:00", "My Video Player is too slow"));
                questionList.add(new Question(R.drawable.logo_c,"Japanese","Ali","11:00","How to learn japanese language fast"));
                questionList.add(new Question(R.drawable.ad,"the technology of nano and its advantages",
                        "Mohammed Hashim","08:00",
                        "Android Programming and nano technology together can make so big changes in our life it can make our phone unbreakable"));
                questionList.add(new Question(R.drawable.logo,"Novels","Ayman Izzeldin","14:00","What is the best of Agatha Cristy's Novels"));
                questionList.add(new Question(R.drawable.bac,"Psychology","Anfal ALi","17:00","How to read other gestures"));*/

                NetworkTask task = new NetworkTask(true, Constants.ALL_QUESTIONS, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            JSONArray posts = object.getJSONArray("questions");
                            for (int i=0;i<posts.length();i++){
                                JSONObject ask = posts.getJSONObject(i);
                                questionList.add(0,new Question(ask.getInt("id"),ask.getInt("id_user"),
                                        ask.getString("image"),ask.getString("title"),
                                        ask.getString("username"),ask.getString("date"),
                                        ask.getString("time"),ask.getString("content"),
                                        ask.getInt("votes"),ask.getString("tags")));
                            }
                            questionsAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            Toast.makeText(c, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, c, new HashMap<String, String>());
                task.executeTask();
                View rootView = inflater.inflate(R.layout.questions_recycler, container, false);
                /*FloatingActionButton f = (FloatingActionButton)rootView.findViewById(R.id.fab_main);
                f.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent f = new Intent(c,NewQuestionActivity.class);
                        startActivity(f);
                    }
                });*/
                RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_questions);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(c);
                recyclerView.setLayoutManager(layoutManager);
                questionsAdapter = new QuestionsAdapter(questionList,c);
                recyclerView.setAdapter(questionsAdapter);


                final QuestionTags questionTags = new QuestionTags(c);
                final ArrayList<String> spinnerList = questionTags.TAGS_NAMES;
                spinnerList.add(0,"Select a tag");
                Spinner spinnerTags = (Spinner)rootView.findViewById(R.id.spinner_tags);
                ArrayAdapter arrayAdapter = new ArrayAdapter(c,R.layout.spinner_tag_text,
                        spinnerList);
                spinnerTags.setAdapter(arrayAdapter);
                spinnerTags.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0) {
                            //Toast.makeText(c, "Please select something",
                            //        Toast.LENGTH_LONG).show();
                        }else {
                            final String selected = questionTags.getTagKey(spinnerList.get(position-1));
                            questionList.clear();
                            NetworkTask task = new NetworkTask(true, Constants.ALL_QUESTIONS, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String s) {
                                    try {
                                        JSONObject object = new JSONObject(s);
                                        JSONArray posts = object.getJSONArray("questions");
                                        for (int i=0;i<posts.length();i++){
                                            JSONObject ask = posts.getJSONObject(i);
                                            if (ask.getString("tags").contains(selected))
                                                questionList.add(0,new Question(ask.getInt("id"),ask.getInt("id_user"),
                                                        ask.getString("image"),ask.getString("title"),
                                                        ask.getString("username"),ask.getString("date"),
                                                        ask.getString("time"),ask.getString("content"),
                                                        ask.getInt("votes"),ask.getString("tags")));
                                        }
                                        questionsAdapter.notifyDataSetChanged();
                                    } catch (JSONException e) {
                                        Toast.makeText(c, e.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            }, c, new HashMap<String, String>());
                            task.executeTask();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });


                return rootView;


            }else if (num == 2) {

                View rootView = inflater.inflate(R.layout.home_screen, container, false);
                switcher = (TextSwitcher)rootView.findViewById(R.id.pronam);
                switcher.setFactory(new ViewSwitcher.ViewFactory() {
                    @Override
                    public View makeView() {
                        TextView t = new TextView(c);
                        t.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER);
                        t.setTextSize(28);
                        t.setTextColor(ContextCompat.getColor(c,R.color.colorPrimary));

                        return t;
                    }
                });
                Animation in = AnimationUtils.loadAnimation(c,android.R.anim.slide_in_left);
                Animation out = AnimationUtils.loadAnimation(c,android.R.anim.slide_out_right);
                switcher.setInAnimation(in);
                switcher.setOutAnimation(out);
                switcher.setCurrentText(strings[0]);

                runTimer();

                f = manager.findFragmentById(R.id.important);



                if(f == null){
                    manager.beginTransaction()
                            .add(R.id.important,importantAnnounementsFragment.showAnnouncements())
                            .commit();
                }

                android.app.Notification e = new NotificationCompat.Builder(c)
                        .setSmallIcon(R.mipmap.ic_l)
                        .setContentTitle("SRF")
                        .setAutoCancel(true)
                        .setContentText("are you a qualified researcher?")
                        .build();


                notificationManager.notify(0,e);

                final TextView numberUsers = (TextView)rootView.findViewById(R.id.numUsers);
                final TextView numberPublications = (TextView)rootView.findViewById(R.id.numPublications);
                final TextView numberQuestions = (TextView)rootView.findViewById(R.id.numQuestions);



                NetworkTask task = new NetworkTask(true, Constants.HOME_SCREEN_DATA, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            numberUsers.setText(String.valueOf(object.getInt("numUsers")));
                            numberQuestions.setText(String.valueOf(object.getInt("numQuestions")));
                        } catch (JSONException e) {
                            Toast.makeText(c, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, c,null);
                task.executeTask();



                return rootView;


            }else if (num == 3){


                View rootView = inflater.inflate(R.layout.recycler, container, false);
                RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.contain);
                /*FloatingActionButton f = (FloatingActionButton)rootView.findViewById(R.id.fab_main);
                f.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent f = new Intent(c,NewPostActivity.class);
                        startActivity(f);
                    }
                });*/
                postsList = new ArrayList<>();
                postsList.clear();
                NetworkTask task = new NetworkTask(true, Constants.ALL_POSTS, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            JSONArray posts = object.getJSONArray("posts");
                            for (int i=0;i<posts.length();i++){
                                JSONObject post = posts.getJSONObject(i);
                                postsList.add(0,new MemberSpace(post.getInt("id"),post.getInt("id_user"),
                                        post.getString("image"),//post.getString("title"),
                                        post.getString("username"),post.getString("date"),
                                        post.getString("time"),post.getString("content"),
                                        post.getInt("views")));
                            }
                            postsAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            Toast.makeText(c, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, c, new HashMap<String, String>());
                task.executeTask();
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(c);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setNestedScrollingEnabled(false);
                postsAdapter = new MemberSpaceAdapter(postsList,c);
                recyclerView.setAdapter(postsAdapter);

                return rootView;


            }else {
                View rootView = inflater.inflate(R.layout.recycler, container, false);
                return rootView;
            }
        }
    }

    public void Profile(View v){
        Intent o = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivity(o);
    }

    public static void runTimer() {
        final Handler myHandler = new Handler();
        myHandler.post(new Runnable() {
            @Override
            public void run() {

                currentText ++;
                if (currentText == countMessage){
                    currentText = 0;
                }
                switcher.setText(strings[currentText]);

                myHandler.postDelayed(this, 7000);
            }
        });
    }

    public void closeImportant(){
        manager.beginTransaction()
                .remove(manager.findFragmentById(R.id.important))
                .addToBackStack(null)
                .commit();
    }

    public void showMenu(){
        a1.setVisibility(View.VISIBLE);
        a2.setVisibility(View.VISIBLE);
        a3.setVisibility(View.VISIBLE);
        a4.setVisibility(View.VISIBLE);
    }

    public void hideMenu(){
        a1.setVisibility(View.GONE);
        a2.setVisibility(View.GONE);
        a3.setVisibility(View.GONE);
        a4.setVisibility(View.GONE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2332 && resultCode == RESULT_OK){
            UserData userData = new UserData(MainActivity.this);
            MemberSpace myNewPost = new MemberSpace(data.getIntExtra("id",0),userData.getId(),
                    userData.getImageUrl()//,data.getStringExtra("title")
                    ,userData.getUserName(),
                    data.getStringExtra("date"),data.getStringExtra("time"),
                    data.getStringExtra("content"),0);

            postsList.add(0,myNewPost);
            postsAdapter.notifyDataSetChanged();

            mViewPager.setCurrentItem(2);

        }else if (requestCode == 2333 && resultCode == RESULT_OK){
            UserData userData = new UserData(MainActivity.this);
            Question myNewQuestion = new Question(data.getIntExtra("id",0),userData.getId(),
                    userData.getImageUrl(),data.getStringExtra("title"),userData.getUserName(),
                    data.getStringExtra("date"),data.getStringExtra("time"),
                    data.getStringExtra("content"),0,data.getStringExtra("tags"));

            questionList.add(0,myNewQuestion);
            questionsAdapter.notifyDataSetChanged();

            mViewPager.setCurrentItem(0);

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar = (ProgressBar)headerLayout.findViewById(R.id.progressbar);
        progressBar.setProgress(10);
        TextView t = (TextView)headerLayout.findViewById(R.id.drawer_reputation);
        TextView username = (TextView)headerLayout.findViewById(R.id.drawer_name);
        UserData data = new UserData(MainActivity.this);
        username.setText(data.getUserName());
        ImageView profile = (ImageView)headerLayout.findViewById(R.id.drawer_image);

        if (data.getImageUrl().equals("no_profile")){
            Picasso.with(MainActivity.this)
                    .load(R.drawable.boy)
                    .error(R.drawable.logo)
                    .skipMemoryCache()
                    .transform(new CircleTransformation())
                    .into(profile);
        }else {
            Picasso.with(MainActivity.this)
                    .load(data.getImageUrl())
                    .skipMemoryCache()
                    .transform(new CircleTransformation())
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.logo)
                    .into(profile);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        progressBar = (ProgressBar)headerLayout.findViewById(R.id.progressbar);
        progressBar.setProgress(10);
        TextView t = (TextView)headerLayout.findViewById(R.id.drawer_reputation);
        TextView username = (TextView)headerLayout.findViewById(R.id.drawer_name);
        UserData data = new UserData(MainActivity.this);
        username.setText(data.getUserName());
        ImageView profile = (ImageView)headerLayout.findViewById(R.id.drawer_image);

        if (data.getImageUrl().equals("no_profile")){
            Picasso.with(MainActivity.this)
                    .load(R.drawable.boy)
                    .error(R.drawable.logo)
                    .skipMemoryCache()
                    .transform(new CircleTransformation())
                    .into(profile);
        }else {
            Picasso.with(MainActivity.this)
                    .load(data.getImageUrl())
                    .skipMemoryCache()
                    .transform(new CircleTransformation())
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.logo)
                    .into(profile);
        }
    }
}
