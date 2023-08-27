package com.example.todocopy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TimePicker;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
//    ViewPagerAdapter viewPagerAdapter;
    ViewPagerAdapter  viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//    final androidx.fragment.app
//            .FragmentManager mFragmentManager
//            = getSupportFragmentManager();
//    final androidx.fragment.app
//            .FragmentTransaction mFragmentTransaction
//            = mFragmentManager.beginTransaction();
//    final FragmentAll mFragment
//            = new FragmentAll();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidx.appcompat.widget.Toolbar toolbar =findViewById(R.id.toolbar);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarfor);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                openTextDialog(/*builder,input*/);
            }
        });
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }
    public void openTextDialog(/*AlertDialog.Builder builder,EditText input*/){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setView(R.layout.dialogtext);
        final ScrollView myScroll = new ScrollView(this);
        final LinearLayout inputs = new LinearLayout(this);
        inputs.setOrientation(LinearLayout.VERTICAL);
//        inputs.
//        inputs.
        inputs.setHorizontalGravity(RelativeLayout.CENTER_VERTICAL);
        final EditText input = new EditText(this);
        final EditText input1 = new EditText(this);
//        simpleDatePiker = (DatePicker)findViewById(R.id.simpleDatePicker);
        final DatePicker input2 = new DatePicker(this);
        final TimePicker input3 = new TimePicker(this);
        input.setText("Task title");
        input1.setText("Description");
        final androidx.fragment.app
                .FragmentManager mFragmentManager
                = getSupportFragmentManager();
        final androidx.fragment.app
                .FragmentTransaction mFragmentTransaction
                = mFragmentManager.beginTransaction();
        final FragmentAll mFragment
                = new FragmentAll();
        inputs.addView(input);
        inputs.addView(input1);
        inputs.addView(input2);
        inputs.addView(input3);
        myScroll.addView(inputs);
        builder.setView(myScroll);
        builder.setTitle("Add task");
        Log.d("*****INPUT*****","Task input:"+ input);
        String text = "itamar";
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            String m_Text ="Itamar Almog";
            String m1_text = " ";
            String m2_text = " ";
            String m3_text = " ";
            int y,m,d;
            int hour,minutes;
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                m1_text = input1.getText().toString();

                m = input2.getMonth();
                d = input2.getDayOfMonth();
                y = input2.getYear();
                m+=1;

                m2_text = d+ "." + m + "." +y;

                hour = input3.getHour();
                minutes  = input3.getMinute();

                m3_text = hour + ":" + minutes;

                Log.d("*****INPUT*****","Task Title:"+ m_Text+ " " + m1_text + " " +m2_text + " " + m3_text);
                TaskData taskData = new TaskData();
                taskData.setTaskTitle(m_Text);
                taskData.setTaskDes(m1_text);
                taskData.setYear(y);
                taskData.setMonth(m);
                taskData.setDay(d);
                taskData.setHour(hour);
                taskData.setMinutes(minutes);
                taskData.setActive(true);
                String s = taskData.toString();
                Bundle bundle = new Bundle();
//                bundle.putString("message", s);
                bundle.putString("massageObj",s);

                // Set Fragmentclass Arguments
//                FragmentAll fragobj = new FragmentAll();
//                fragobj.setArguments(bundle);
                mFragment.setArguments(bundle);
                mFragmentTransaction.add(R.id.recycler_view,mFragment);
                mFragmentTransaction.commit();


            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked");
    }
    @Override
}