package com.zhangdesheng.androidhomeworklistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Student> studentList = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initStudents();
        StudentAdapter adapter = new StudentAdapter(MainActivity.this, R.layout.list_student, studentList);
        ListView listView = (ListView)findViewById(R.id.lise_view);
        listView.setAdapter(adapter);
    }

    private void initStudents(){
        int i=0;
        for(;i<10; i++) {
            Student student1 = new Student("第" + (i*3 + 1) + "个学生", 2015, 18);     /*将三个需要的信息传给student这个对象*/
            Student student2 = new Student("第" + (i*3 + 2) + "个学生", 2015, 18);
            Student student3 = new Student("第" + (i*3 + 3) + "个学生", 2015, 18);
            studentList.add(student1);
            studentList.add(student2);
            studentList.add(student3);
        }





    }



    @Override
    public void onClick(View v){

    }
}
