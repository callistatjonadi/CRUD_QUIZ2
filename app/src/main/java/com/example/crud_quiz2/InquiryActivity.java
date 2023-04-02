package com.example.crud_quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.crud_quiz2.adapter.BukuAdapter;
import com.example.crud_quiz2.model.Buku;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class InquiryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);

        //tarik data pengguna

        Realm realm = Realm.getDefaultInstance();
        //penarikan data
        RealmResults<Buku> buku = realm.where(Buku.class).findAll();

        //menampilkan data
//            for (User user : users){
//                Log.d("TAG", "Nama :" + user.getNama() + ", Nomor Telp" + user.getNama());
//            }

        ArrayList<Buku> arrayofbuku = new ArrayList<Buku>();
        arrayofbuku.addAll(realm.copyFromRealm(buku));

        realm.close();
        BukuAdapter bukuAdapter = new BukuAdapter(this, arrayofbuku);
        ListView listView = (ListView) findViewById(R.id.listViewBuku);
        listView.setAdapter(bukuAdapter);

    }
}