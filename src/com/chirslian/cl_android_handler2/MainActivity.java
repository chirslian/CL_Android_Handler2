package com.chirslian.cl_android_handler2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	private TextView textView;
	private Button button;
	private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textView = (TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MyThread t = new MyThread();
				t.start();
			}
		});
        handler = new MyHandler();
    }
    class MyHandler extends Handler{

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			String s = (String)msg.obj;
			textView.setText(s);
			System.out.println("handleMessage----:"+Thread.currentThread().getName());
		}
    	
    }
    
    class MyThread extends Thread{

		@Override
		public void run() {
			try {
				sleep(3*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String s = "Chirs Lian";
			Message msg = handler.obtainMessage();
			msg.obj = s;
			handler.sendMessage(msg);
		}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
