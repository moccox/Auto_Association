package com.example.administrator.auto_association;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class Main extends AppCompatActivity {
    /**
     * 成员变量
     */
    private String mInput; //用于存放输入框输入内容
    private Button mStarSearching; //搜索按钮
    private AutoCompleteTextView mAutoView;
    MultiAutoCompleteTextView mMulAutoView;
    /**
     * 默认的自动联想内容存放
     **/
  private static String[] autoStr
        = new String[]{"Android Studio","珠海 美食","码云","Andy","Android Diordna"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 成员变量初始化
         **/
        mStarSearching= (Button) this.findViewById(R.id.StartSearching);
        //mAutoView = (AutoCompleteTextView) findViewById(R.id.AutoView);
        /*
        * AutoCompatActivity的联想内容是固定的，即只有autoStr中的内容
        * 若要使用AutoCompatActivity需要将布局中的<MultiAutoCompatActivity/>换成
        * <AutoCompleteTextView
                android:id="@+id/AutoView"
                android:layout_width="180sp"
                android:layout_height="wrap_content"
                android:background="@android:drawable/edit_text"
                android:maxLines="1" />
        * */
        mMulAutoView = (MultiAutoCompleteTextView) findViewById(R.id.MulAutoView);

        /**
         * new一个排列（数组）适配器（ArrayAdapter），并将autoStr内容传入
         **/
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,autoStr);

        /**
         * 将ArrayAdapter内容放入AutoCompatActivity中
         **/

        //mAutoView.setAdapter(adapter);


        /**
         * 使用MultiAutoCompatActivity，用setTokenizer（分词切分）实现
         * 功能更强大：
         * 可以不断扩展联想选项，如果输入的内容和联想不一样，会询问你是否将其加入联想选择列表中
         **/

        mMulAutoView.setAdapter(adapter);
        mMulAutoView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
