package com.example.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv=(TextView) findViewById(R.id.textView1);
	}
	public void onPost(View v){
		new Thread(){
			public void run() {
				
			};
		}.start();
	}
	public void onClick(View v){
		new Thread(){
			public void run() {
				try {
					URL url=new URL("https://www.baidu.com/baidu?tn=monline_3_dg&ie=utf-8&wd=bmob");
					HttpsURLConnection sconn=(HttpsURLConnection) url.openConnection();
					sconn.setRequestMethod("GET");
					InputStream in=sconn.getInputStream();
					BufferedReader br=new BufferedReader(new InputStreamReader(in));
					String s=null;
					final StringBuffer sb=new StringBuffer();
					while((s=br.readLine())!=null){
						sb.append(s+"\n");
					}
					runOnUiThread(new Runnable() {
						
						@Override
						public void run() {
							tv.setText(sb);
						}
					});
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();
	}
}
