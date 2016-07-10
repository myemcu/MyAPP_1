/*
* 使用匿名内层类之心得:
*                   1.不在xml中设置相应属性时用，如：xml中未设置android:onclick="btn_Click"，则用匿名内层
*                   2.匿名内层相关代码在onCreate(Bundle)中
*                   3.代码作为其传入参数
*                   4.该风格为推荐风格,可以少写些class
* */

/*
* 在连接真机的情况下，点击"运行"，若手机无法加载则需要断开重连。
* */

package com.example.administrator.myapp_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//              子类
public class MainActivity extends AppCompatActivity {   // AppCompatActivity为旧版本提供兼容性支持

    //定义消息提示变量
    private Toast toast;

    //定义控件变量
    private Button   mTrueButton;   // 正确键
    private Button   mFalseButton;  // 错误键
    private Button   mNextButton;   // 下翻建

    private TextView mQuestionTextView; // 文本

    // 定义普通变量
    private int      question;

    //定义问题数组(类数组)
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

        //-显示初始界面，并用Java实现首行TextView文本显示----------------------
        //-显示的内容为类数组中的第一个String-----------------------------------

        //取得数组ID资源
        question=mQuestionBank[mCurrentIndex].getTextResId();   // 使用获取

        //获取文本对象，设置需要输出的问题
        mQuestionTextView=(TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setText(question);

        //-增加Button事件处理-----------------------------------------------
        findViews();

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toast.makeText(MainActivity.this, R.string.bNext, Toast.LENGTH_SHORT).show();
                mCurrentIndex = (mCurrentIndex+1) % mQuestionBank.length;//在length范围内递增索引
                int question = mQuestionBank[mCurrentIndex].getTextResId();
                mQuestionTextView.setText(question);
            }
        });

    }

    private void findViews() {
        //获取那三个Button对象
        mTrueButton  = (Button) findViewById(R.id.btn1);
        mFalseButton = (Button) findViewById(R.id.btn2);
        mNextButton  = (Button) findViewById(R.id.next);
    }
}
