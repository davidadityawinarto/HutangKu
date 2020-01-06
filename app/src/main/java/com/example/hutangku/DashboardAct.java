package com.example.hutangku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DashboardAct extends AppCompatActivity {

    TextView day, nameuser, date, hutang, piutang, pengaturan, teamapps, mainmenus,
            pagetitle, pagesubtitle, imageViewHutang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Time now in Dashboard
        day = findViewById(R.id.day);
        nameuser = findViewById(R.id.nameuser);
        date = findViewById(R.id.date);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EE, d MMMM yyyy");
        String dateTime = simpleDateFormat.format(calendar.getTime());

        String[] splitDate = dateTime.split(",");

        day.setText(splitDate[0]);
        date.setText(splitDate[1]);
        // Time now in Dashboard

        hutang = findViewById(R.id.hutang);
        piutang = findViewById(R.id.piutang);
        pengaturan = findViewById(R.id.pengaturan);
        teamapps = findViewById(R.id.teamapps);
        mainmenus = findViewById(R.id.mainmenus);

        pagetitle = findViewById(R.id.pagetitile);
        pagesubtitle = findViewById(R.id.pagesubtitle);

//        imageViewHutang = findViewById(R.id.imageViewHutang);

        // Import font
//        Typeface MLight = Typeface.createFromAsset(getAssets(), "font/ml.ttf");
//        Typeface MMedium = Typeface.createFromAsset(getAssets(), "font/mm.ttf");
//        Typeface MRegular = Typeface.createFromAsset(getAssets(), "font/mr.ttf");

        // Customize font
//        nameuser.setTypeface(MMedium);
//        walletuser.setTypeface(MLight);
//
//        mainmenus.setTypeface(MRegular);
//
//        hutang.setTypeface(MMedium);
//        piutang.setTypeface(MMedium);
//        pengaturan.setTypeface(MMedium);
//        teamapps.setTypeface(MMedium);
//
//        pagetitle.setTypeface(MRegular);
//        pagesubtitle.setTypeface(MLight);

        // Klik imagenya ke Hutang
//        imageViewHutang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("TAG", "Diklik"); untuk debug
//                Intent a = new Intent(DashboardAct.this, MainActivity.class);
//                startActivity(a);
//            }
//        });
        // Klik textviewnya ke Hutang
        hutang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DashboardAct.this, MainActivity.class);
                startActivity(a);
            }
        });

        // Klik textviewnya ke Piutang
        piutang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DashboardAct.this, MainActivity2.class);
                startActivity(a);
            }
        });

    }
}
