package com.example.bai3c8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MySmsReceiver extends BroadcastReceiver {
    SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        Object []arrMessage= (Object[]) bundle.get("pdus");
        for(int i=0;i<arrMessage.length;i++)
        {
            byte []bytes= (byte[]) arrMessage[i];
            SmsMessage message=SmsMessage.createFromPdu(bytes);
            String phone=message.getDisplayOriginatingAddress();
            for(int j=0;j<MainActivity.listBand.size();j++)
            {
                if(phone == MainActivity.listBand.get(j))
                {
                    Toast.makeText(context, "Day la tin nhan rac", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }
}
