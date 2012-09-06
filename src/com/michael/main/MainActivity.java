package com.michael.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.michael.widget.BottomBar;
import com.michael.widget.BottomBar.OnItemChangedListener;

/**
 * 
 * 这种方式和前面两种的封装方式又有所不同，前面两张是在代码中生成Button，
 * 而这种事通过布局文件来生成Button，效果都一样，但是布局文件更灵活，
 * 可以实现一些代码中难以实现的效果，比如在按钮的右上角加上一个小图标指示器等较为复杂的布局效果
 * 
 * @author MichaelYe
 * @since 2012-9-5
 * 
 * */
public class MainActivity extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvShow = (TextView)findViewById(R.id.tv_show);
        final BottomBar bottomBar = (BottomBar)findViewById(R.id.ll_bottom_bar);
        bottomBar.setOnItemChangedListener(new OnItemChangedListener() 
        {
			
			@Override
			public void onItemChanged(int index) 
			{

				tvShow.setText(index+"");
			}
		});
        bottomBar.setSelectedState(0);
        
        final Button btnShowOrHideIndicate = (Button)findViewById(R.id.btn_show_or_hide_indicate);
        btnShowOrHideIndicate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				if(btnShowOrHideIndicate.getText().equals("显示图标"))
				{
					btnShowOrHideIndicate.setText("隐藏图标");
					bottomBar.showIndicate(12);
				}
				else
				{
					btnShowOrHideIndicate.setText("显示图标");
					bottomBar.hideIndicate();
				}
			}
		});
    }

}
