package com.ghost.aes;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import javax.crypto.spec.*;

import android.util.Log;

public class Aes {
	private final String a = "PBKDF2WithHmacSHA1";
	private final int b = 10000;
	private final int c = 256;
	private char d[] = { 'l', 't', 'j', '-', 'g', 'r', 'o', 'u', 'p' };
	private byte e[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
	private PBEKeySpec f;
	private final String g = "AES/CBC/PKCS7Padding";
	private SecretKeyFactory h;
	private SecretKey i;
	private SecretKeySpec j;
	private byte k[] = { 10, 1, 11, 5, 4, 15, 7, 9, 23, 3, 1, 6, 8, 12, 13, 91 };
	private IvParameterSpec l;

	public Aes() {
		f = new PBEKeySpec(d, e, 10000, 256);
		h = null;
		i = null;
		j = null;
		try {
			h = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			i = h.generateSecret(f);
		} catch (NoSuchAlgorithmException nosuchalgorithmexception) {
			Log.v("exception", nosuchalgorithmexception.getMessage());
		} catch (InvalidKeySpecException invalidkeyspecexception) {
			Log.v("exception", invalidkeyspecexception.getMessage());
		}
		j = new SecretKeySpec(i.getEncoded(), "AES");
		l = new IvParameterSpec(k);
	}

	private byte[] a(String s, SecretKey secretkey, IvParameterSpec ivparameterspec, byte abyte0[]) {
		
		Log.v("CryptType",s);
		Log.v("Key",new String(secretkey.getEncoded()));
		Log.v("Source:", "");
		
		for(int i = 0; i < abyte0.length; i++)
		{
			Log.v("abyte0:" + i,"" + abyte0[i]);
		}
		
		try {
			Cipher cipher = Cipher.getInstance(s);
			cipher.init(1, secretkey, ivparameterspec);
			return cipher.doFinal(abyte0);
		} catch (NoSuchAlgorithmException paramSecretKey) {
			return null;
		} catch (NoSuchPaddingException paramSecretKey) {
			return null;
		} catch (InvalidKeyException paramString) {
			return null;
		} catch (InvalidAlgorithmParameterException paramString) {
			return null;
		} catch (IllegalBlockSizeException paramString) {
			return null;
		} catch (BadPaddingException paramString) {
			return null;
		}
	}

	 public String a(byte abyte0[])
	    {
	        return Filter.a(a("AES/CBC/PKCS5Padding", ((SecretKey) (j)), l, abyte0));
	    }
	 
	 public String encrypt(String source)
	 {
		 try{
			 return a(source.getBytes("UTF-8"));
		 }catch(UnsupportedEncodingException e)
		 {
			 Log.v("exception", e.getMessage());
			 return null;
		 }
		 
	 }
}
