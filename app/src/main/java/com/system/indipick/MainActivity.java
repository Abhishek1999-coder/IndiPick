package com.system.indipick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button btn;
ImageView img;
private Toolbar toolbar;
private BroadcastReceiver MyReceiver = null;
LinearLayout lt;
String[] var;
public static List<String> items,aplist;
public String Res;
public static String Rp11,Rp22,aplt;
int f=1;
Button buttonok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        //For Registering Product
        /*GoogleRWAndroid GRWF = new GoogleRWAndroid();
        StringBuilder rp1 = new StringBuilder();
        StringBuilder rp2 = new StringBuilder();
        rp1.append("https://script.googleusercontent.com/macros/echo?user_content_key=ICqXxGNoTFLfH6WwiM8ehKJyfL1uTM0DsQE8C0tQqb4p3wZxhK-aqxDUezIIgzXlbdv_Z87lK6P6LxX5-HAS8teWOw4pIQc7m5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnOuSELVdGFb2pSrUrn3qhUaaxNQBBH-gxAlL3UjeLisRuZyaBQweydKF7Tbs44QKGJrjnsONd6I7QRdUn7KVh5IAiPU_NIV2TDBpWyP3oFZoNORkMgTU_kA&lib=M2W3oELCQhr1fmO9aZyhMFGuAUODbKL4L");
        rp2.append("https://script.googleusercontent.com/macros/echo?user_content_key=4GkMvRgDlvO22JNiAVGiNwLLKdKNXo0d1yRdUnVzInaKUKzruNPEFu6cNiUHdLKx9OrsJDWy3BIT-k5vb3kLH0UzylIpOGW7OJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHazI8nTF7j8GMqbBgcjc3dMhE_FLy_GJEqUfNl0_RqR4e7MOOc2m2e2GUWsDgEF8OiaZYzUoLXh4k4_6FRNQV03Nmu7OL0qCKJzwN1Sw-ebye75QADN4QzI7OKCfAOANUWw&lib=M2W3oELCQhr1fmO9aZyhMFGuAUODbKL4L");
        Rp11 = GRWF.sendToGoogleSheet(rp1.toString());
        Rp22 = GRWF.sendToGoogleSheet(rp2.toString());*/






        /*GoogleRWAndroid GRWW = new GoogleRWAndroid();
        StringBuilder sbb = new StringBuilder();
        sbb.append("https://script.google.com/macros/s/AKfycbzIrrEAugSk9qXmSo0iztfrkGpAHKMQKhtWGCWZp_F0jeh1SVU/exec?KEY=AEC3DEA441909FE0&category=");
        sbb.append("00000");
        Res = GRWW.sendToGoogleSheet(sbb.toString());*/


        /*f=1;
        // Res = "Select Category"+"\n"+Res;
        *//*var = Res.split("\n");
        items = Arrays.asList(var);*//*
        if(items.isEmpty()){
            f=0;
        }*/
        lt = findViewById(R.id.click);
      //  toolbar = findViewById(R.id.toolbar1);
        img = findViewById(R.id.img);
      //  setSupportActionBar(toolbar);
      //  getSupportActionBar().setTitle("IndiPick");
        lt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager cm =
                        (ConnectivityManager)getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);

                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                boolean isConnected = activeNetwork != null &&
                        activeNetwork.isConnectedOrConnecting();
                if(isConnected == true) {

                        GoogleRWAndroid GRWF = new GoogleRWAndroid();
                        /*StringBuilder rp1 = new StringBuilder();
                        StringBuilder rp2 = new StringBuilder();
                        */
                        StringBuilder apsb = new StringBuilder();
                        /*rp1.append("https://script.googleusercontent.com/macros/echo?user_content_key=ICqXxGNoTFLfH6WwiM8ehKJyfL1uTM0DsQE8C0tQqb4p3wZxhK-aqxDUezIIgzXlbdv_Z87lK6P6LxX5-HAS8teWOw4pIQc7m5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnOuSELVdGFb2pSrUrn3qhUaaxNQBBH-gxAlL3UjeLisRuZyaBQweydKF7Tbs44QKGJrjnsONd6I7QRdUn7KVh5IAiPU_NIV2TDBpWyP3oFZoNORkMgTU_kA&lib=M2W3oELCQhr1fmO9aZyhMFGuAUODbKL4L");
                        rp2.append("https://script.googleusercontent.com/macros/echo?user_content_key=4GkMvRgDlvO22JNiAVGiNwLLKdKNXo0d1yRdUnVzInaKUKzruNPEFu6cNiUHdLKx9OrsJDWy3BIT-k5vb3kLH0UzylIpOGW7OJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHazI8nTF7j8GMqbBgcjc3dMhE_FLy_GJEqUfNl0_RqR4e7MOOc2m2e2GUWsDgEF8OiaZYzUoLXh4k4_6FRNQV03Nmu7OL0qCKJzwN1Sw-ebye75QADN4QzI7OKCfAOANUWw&lib=M2W3oELCQhr1fmO9aZyhMFGuAUODbKL4L");
                        */
                        apsb.append("https://script.googleusercontent.com/macros/echo?user_content_key=SABqSGW7oCZQBUGYezDMap9U_qp09SRAhbkQK5YwBBclcebwoDT9h6DItIZsmUM4l-hnethk2EuDiEYwZRc6Jjnj0r4BwidkOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHazI8nTF7j8GMqbBgcjc3dMhE_FLy_GJEqUfNl0_RqR4e7MOOc2m2e2GUWsDgEF8OiaZYzUoLXh4k4_6FRNQV03Nmu7OL0qCKJzwN1Sw-ebyeQiwV0fBsVDfwK8tKTFuAEw&lib=M2W3oELCQhr1fmO9aZyhMFGuAUODbKL4L");
                        /*Rp11 = GRWF.sendToGoogleSheet(rp1.toString());
                        Rp22 = GRWF.sendToGoogleSheet(rp2.toString());*/
                        aplt = GRWF.sendToGoogleSheet(apsb.toString());
                        //aplt = aplt+"\n"+"UDEMY";
                        aplist = Arrays.asList(aplt.split("\n"));

                       /* GoogleRWAndroid GRWW = new GoogleRWAndroid();
                        StringBuilder sbb = new StringBuilder();
                        sbb.append("https://script.google.com/macros/s/AKfycbzIrrEAugSk9qXmSo0iztfrkGpAHKMQKhtWGCWZp_F0jeh1SVU/exec?KEY=AEC3DEA441909FE0&category=");
                        sbb.append("00000");
                        Res = GRWW.sendToGoogleSheet(sbb.toString());
                        var = Res.split("\n");
                        items = Arrays.asList(var);*/

                    Toast.makeText(getApplicationContext(), "Welcome to IndiPick", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), Second_Page.class);
                    startActivity(i);
                }
                else
                {
                    ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC,100);
                    toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP,500);
                    ViewGroup viewGroup = findViewById(android.R.id.content);
                    View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_footer,viewGroup,false);
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setView(dialogView);
                    final AlertDialog alertDialog = alert.create();
                    buttonok = (Button) dialogView.findViewById(R.id.btn);
                    buttonok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.dismiss();
                        }
                    });
                    alertDialog.show();

                }
            }
        });
    }
}