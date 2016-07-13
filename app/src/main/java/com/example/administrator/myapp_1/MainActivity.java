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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

//              子类
public class MainActivity extends AppCompatActivity {   // AppCompatActivity为旧版本提供兼容性支持

    private static final String TAG="MyAPP_1";  // 定义TAG为私有，静态，常亮为工程名"MyAPP_1"

    //定义消息提示变量
    private Toast toast;

    //定义控件变量
    private Button      mTrueButton;        // 正确键
    private Button      mFalseButton;       // 错误键
    private Button      mNextButton;        // 下翻建
    private ImageButton mPrewButton;        // 上翻键
    private TextView    mQuestionTextView;  // 文本

    // 定义普通变量
    private int      question;

    //问题数组索引
    private int mCurrentIndex=0;

    //定义问题数组(类数组)
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_1,true),
            new Question(R.string.question_2,false),
            new Question(R.string.question_3,true),
            new Question(R.string.question_4,false),
            new Question(R.string.question_5,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //为上面的onCreate添加日志输出代码
        Toast.makeText(this, R.string.onCreate,Toast.LENGTH_SHORT).show();
        setContentView(R.layout.main);

        findViews();        // 获取所有控件对象
        updateQuestion();   // 显示问题

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toast.makeText(MainActivity.this, R.string.bNext, Toast.LENGTH_SHORT).show();
                mCurrentIndex = (mCurrentIndex+1) % mQuestionBank.length;//在length范围内递增索引
                updateQuestion(); //显示问题
            }
        });

        mPrewButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // if(mCurrentIndex<1) mCurrentIndex=5; (这行可用)
                if(mCurrentIndex<1) mCurrentIndex=mQuestionBank.length;
                mCurrentIndex = (mCurrentIndex-1) % mQuestionBank.length;//在length范围内递增索引

                updateQuestion(); //显示问题
            }
        });

    }
    
    // 获取控件对象方法
    private void findViews() {
        mQuestionTextView =(TextView) findViewById(R.id.question_text_view);
        //获取那三个Button对象
        mTrueButton  = (Button) findViewById(R.id.btn1);
        mFalseButton = (Button) findViewById(R.id.btn2);
        mNextButton  = (Button) findViewById(R.id.next);
        mPrewButton  = (ImageButton) findViewById(R.id.imageButton);
    }

    // 更新显示题目方法
    private void updateQuestion() {
        question=mQuestionBank[mCurrentIndex].getTextResId();   //取得数组ID资源
        mQuestionTextView.setText(question);                    //显示数组内容
    }

    //　判断答案方法
    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int mssageResId=0;

        if(userPressedTrue == answerIsTrue) {
            mssageResId = R.string.correct;
        }
        else {
            mssageResId = R.string.incorrect;
        }

        toast.makeText(this, mssageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, R.string.onStop,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, R.string.onDestroy,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, R.string.onPause,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, R.string.onStart,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, R.string.onRestart,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, R.string.onResume,Toast.LENGTH_SHORT).show();
    }
}
