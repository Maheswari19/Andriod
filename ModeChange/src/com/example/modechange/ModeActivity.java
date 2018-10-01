package com.example.modechange;

import android.media.AudioManager;
import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.SmsMessage;
import android.util.Log;

public class ModeActivity extends BroadcastReceiver{

	String msg=null;
	AudioManager am; 
	SharedPreferences sp;

	@Override
	public void onReceive(Context con, Intent it) {
		// TODO Auto-generated method stub
		am=(AudioManager)con.getSystemService(Context.AUDIO_SERVICE);
		 final String TAG = "Message recieved";

				     Bundle bundle = it.getExtras();
				     sp=con.getSharedPreferences("MyPreference", Context.MODE_PRIVATE);
				     String sil=sp.getString("silent", null);
				     String rin=sp.getString("ring", null);
				     String vib=sp.getString("vibrate", null);
				     Object[] pdus = (Object[]) bundle.get("pdus");
				     SmsMessage messages =SmsMessage.createFromPdu((byte[]) pdus[0]);    
				     Log.i(TAG,  messages.getMessageBody());
				     msg=messages.getMessageBody();
				     if(msg.equalsIgnoreCase(sil))
				     {
				    	 am.setRingerMode(0);
				     }
				     if(msg.equalsIgnoreCase(rin))
				     {
				    	 am.setRingerMode(2);
				     }
				     if(msg.equalsIgnoreCase(vib))
				     {
				    	 am.setRingerMode(1);
				     }
				
				   	     
			}
	}


