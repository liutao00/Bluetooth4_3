package com.example.bluetooth.le;

import com.example.bluetooth.le.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * 把字符串去空格后转换成byte数组。如"37   5a"转成[0x37][0x5A]
	 * @param s
	 * @return
	 */
	public static byte[] string2bytes(String s){
		String ss = s.replace(" ", "");
		int string_len = ss.length();
		int len = string_len/2;
		if(string_len%2 ==1){
			ss = "0"+ss;
			string_len++;
			len++;
		}
		byte[] a = new byte[len];
		for(int i=0;i<len;i++){
			a[i] = (byte)Integer.parseInt(ss.substring(2*i,2*i+2), 16);
		}
		return a;
	}

}
