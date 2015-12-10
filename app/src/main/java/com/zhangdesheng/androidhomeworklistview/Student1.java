package com.zhangdesheng.androidhomeworklistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Student1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student1);

        final Intent intent = getIntent();
        String data = intent.getStringExtra("name");

        TextView name = (TextView)findViewById(R.id.tv_name);
        name.setText(""+data);

        TextView tuichu1 = (TextView) findViewById(R.id.tuichu1);
        tuichu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "我是从"+intent.getStringExtra("name")+"那里回来的";
                Toast.makeText(Student1.this, data, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Student1.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
