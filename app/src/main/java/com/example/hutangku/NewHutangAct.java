package com.example.hutangku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class NewHutangAct extends AppCompatActivity {

    TextView titlepage, addname, addamount, adddesc, adddate;
    EditText namahutang, jumlahhutang, deskripsihutang, tanggalhutang;
    Button btnSaveDebt, btnCancelDebt;
    DatabaseReference reference;
    Integer hutangNum = new Random().nextInt(); // Id hutang
    String keyhutang = Integer.toString(hutangNum);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hutang);

        titlepage = findViewById(R.id.titlepage);

        addname = findViewById(R.id.addname);
        addamount = findViewById(R.id.addamount);
        adddesc = findViewById(R.id.adddesc);
        adddate = findViewById(R.id.adddate);

        namahutang = findViewById(R.id.namahutang);
        jumlahhutang = findViewById(R.id.jumlahhutang);
        deskripsihutang = findViewById(R.id.deskripsihutang);
        tanggalhutang = findViewById(R.id.tanggalhutang);

        btnSaveDebt = findViewById(R.id.btnSaveDebt);
        btnCancelDebt = findViewById(R.id.btnCancelDebt);

        btnSaveDebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Insert data to firebase
                reference = FirebaseDatabase.getInstance().getReference().child("HutangApp").
                        child("hutang" + hutangNum);
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // Set and put the data in MainActivity
                        dataSnapshot.getRef().child("nama").setValue(namahutang.getText().toString());
                        dataSnapshot.getRef().child("jumlah").setValue(jumlahhutang.getText().toString());
                        dataSnapshot.getRef().child("deskripsi").setValue(deskripsihutang.getText().toString());
                        dataSnapshot.getRef().child("tanggal").setValue(tanggalhutang.getText().toString());
                        dataSnapshot.getRef().child("keyhutang").setValue(keyhutang);

                        // Show the data in MainActivity
                        Toast.makeText(getApplicationContext(), "Data successfully added", Toast.LENGTH_SHORT).show();

                        Intent a = new Intent(NewHutangAct.this, MainActivity.class);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        btnCancelDebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Back to MainActivity
                Intent a = new Intent(NewHutangAct.this, MainActivity.class);
                startActivity(a);
            }
        });

        // Import font
//        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Light.ttf");
//        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Medium.ttf");

        // Customize font
//        titlepage.setTypeface(MMedium);

//        addname.setTypeface(MLight);
//        namahutang.setTypeface(MMedium);
//
//        addamount.setTypeface(MLight);
//        jumlahhutang.setTypeface(MMedium);
//
//        adddesc.setTypeface(MLight);
//        deskripsihutang.setTypeface(MMedium);
//
//        adddate.setTypeface(MLight);
//        tanggalhutang.setTypeface(MMedium);

//        btnSaveDebt.setTypeface(MMedium);
//        btnCancelDebt.setTypeface(MLight);

    }
}
