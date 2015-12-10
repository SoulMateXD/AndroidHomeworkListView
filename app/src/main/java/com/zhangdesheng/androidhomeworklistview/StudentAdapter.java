package com.zhangdesheng.androidhomeworklistview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2015/12/10.
 */
public class StudentAdapter extends ArrayAdapter<Student> {/*这个Adapter并不是Activity，他只是一个类，因此它不存在上下文，不能当context用*/

    private  int resourceId;

    public StudentAdapter(Context context, int resource, List<Student> objects){
        super (context, resource, objects);
        resourceId = resource;

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){   /*每开一个新的student，就会重新跑一次这个方法*/
        final Student student = getItem(position);
        ViewHolder  viewholder;
        if(convertView == null) {              /*convertView : 将之前加载好的布局，控件等等进行缓存，以便之后可以重用*/
            convertView = LayoutInflater.from(getContext()).inflate(resourceId, null);/*加载list的布局*//*将一个XML的格式转化成了一个view的我们能用的格式*/
            viewholder = new ViewHolder();
            viewholder.studentAge = (TextView)convertView.findViewById(R.id.student_age);
            viewholder.studentGrade=(TextView)convertView.findViewById(R.id.student_grade);
            viewholder.studentName=(TextView)convertView.findViewById(R.id.student_name);     /*这样就只用找一次控件的位置了*/
            convertView.setTag(viewholder);
        }
        else {
            viewholder = (ViewHolder)convertView.getTag();                /*将上次找到的控件的位置给这次的对象*/
        }
        viewholder.studentName.setText(student.getName());            /*这里将得到的值给XML让它显示*/
        viewholder.studentAge.setText(student.getAge() + "");         /*setView set的是一个字符串，如果要用数就得加""*/
        viewholder.studentGrade.setText(student.getGrade() +"");      /*这里通过viewholder来存储，调用XML中的控件*/

        convertView.setOnClickListener(new View.OnClickListener() {     /*这里就代表我正在操作的position，可以直接在这里设置监听器*/
            @Override                          /*一般来说，TextView跳转的界面都是同一个Activity*/
            public void onClick(View v) {
                String data = "正在跳转";  /* Toast.makeText(StudentAdapter.this, data , Toast...）这样子用是错的，因为这里的Adapter不是个Activity，他只是个类，没有上下文。*/
                Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();   /*Adapter不是context，getcontext得到的Activity才是context*/
                Intent intent = new Intent(getContext(),Student1.class);    /*每一个getContext（）就是一个单独的活动  暂时这么理解*/
                intent.putExtra("name",student.getName());
                getContext().startActivity(intent);     /*这里在使用startActivity的时候必须用getContext来调用，否则编译器不知道你是在哪个上下文启动了intent*/

            }
        });
        return convertView;

    }
    class ViewHolder {
        TextView studentName;
        TextView studentAge;
        TextView studentGrade;


    }
}
