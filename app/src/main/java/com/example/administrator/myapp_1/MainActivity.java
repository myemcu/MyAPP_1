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
import android.widget.Button;
import android.widget.TextView;

//              子类
public class MainActivity extends AppCompatActivity {   // AppCompatActivity为旧版本提供兼容性支持

    //private Button btn1,btn2;     // 定义控件变量(xml中的)

    //定义控件变量
    private Button   mTrueButton;   // 正确键
    private Button   mFalseButton;  // 错误键
    private Button   mTextButton;   // 下翻建

    private TextView mQuestionTextView; // 文本

    // 定义普通变量
    private int      question;

    //定义问题数组
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_1,true),
            new Question(R.string.question_2,false),
            new Question(R.string.question_3,true),
            new Question(R.string.question_4,false),
            new Question(R.string.question_5,true)
    };

    //问题数组索引
    private int mCurrentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //取得数组资源ID
        question=mQuestionBank[mCurrentIndex].getTextResId();

        //获取文本，设置需要输出的问题
        mQuestionTextView=(TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setText(question);
    }
}
