package com.ghost.aes;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import cn.j.guang.utils.*;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.v("start", "start");
        
		byte[] buffer;
		
		try{
			buffer="123456".getBytes("UTF-8");
		}catch(UnsupportedEncodingException e){
			Log.v("exception", e.getMessage());
			buffer = null;
		}
		
		String crypt = new a().a(buffer);
		Log.v("crypt",crypt);
	}
	
	 private static String a(String s, String s1)
	    {
	        try
	        {
	            s1 = new PKCS8EncodedKeySpec(com.caiqiu.tools.e.b.a(s1));
	            s1 = KeyFactory.getInstance("RSA", "BC").generatePrivate(s1);
	            Signature signature = Signature.getInstance("SHA1WithRSA");
	            signature.initSign(s1);
	            signature.update(s.getBytes("utf-8"));
	            s = com.caiqiu.tools.e.b.a(signature.sign());
	        }
	        // Misplaced declaration of an exception variable
	        catch(String s)
	        {
	            s.printStackTrace();
	            return null;
	        }
	        return s;
	    }
}
