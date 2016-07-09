package com.example.administrator.myapp_1;

/**
 * Created by Administrator on 2016/7/9.
 */
public class Question {
    private int mTextResId;         // 问题文本，(定义为int型 ，保存文本字符串的资源ID)
    private boolean mAnswerTrue;    // 问题答案。(这两个变量就是Question类中封装的数据)

    //特大注意,这个void不能凭自己想当然就乱加,这会造成主Activity中的Question数组无法通过编译;
    //即:构造方法不能加void,加了后,AS并不在该文件中包错,但其它文件出现问题你又找不到原因,把你爽到极点。
    public Question(int textResId, boolean answerTrue) {

        mTextResId=textResId;
        mAnswerTrue=answerTrue;
    }

    public int getTextResId() { // 蓝色表示该方法已被使用
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
