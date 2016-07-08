/*
* 使用匿名内层类之心得:
*                   1.不在xml中设置相应属性时用，如：xml中未设置android:onclick="btn_Click"，则用匿名内层
*                   2.匿名内层相关代码在onCreate(Bundle)中
*                   3.代码作为其传入参数
*                   4.该风格为推荐风格,可以少写些class
* */

package com.example.administrator.myapp_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//              子类
public class MainActivity extends AppCompatActivity {   // AppCompatActivity为旧版本提供兼容性支持

    private Button btn1,btn2;   // 定义控件变量(xml中的)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // 获取控件对象
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);

        /*注册控件对象，使用匿名内层类实现响应*/

        //为btn1注册监听，该监听器需实现View.OnClickListener接口
        btn1.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               //按钮在此响应
               //使用了匿名类,不能单写this,因为单this指代的是监听器View.OnClickListener而非活动
               Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
           }
        });

        //为btn2注册监听，该监听器需实现View.OnClickListener接口
        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //按钮在此响应
                Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
