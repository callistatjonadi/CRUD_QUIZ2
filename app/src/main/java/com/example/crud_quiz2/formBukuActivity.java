package com.example.crud_quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.crud_quiz2.model.Buku;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class formBukuActivity extends AppCompatActivity {

    EditText edtIdBuku, edtJudulBuku, edtPengarang, edtPenerbit, edtTahunTerbit;
    Button btnSimpanBuku;
    Integer idbuku;
    String judul="";
    String pengarang="";
    String penerbit="";
    Integer tahunTerbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_buku);

        edtIdBuku = (EditText) findViewById(R.id.edtIdBuku);
        edtJudulBuku = (EditText) findViewById(R.id.edtJudulBuku);
        edtPengarang = (EditText) findViewById(R.id.edtPengarang);
        edtPenerbit = (EditText) findViewById(R.id.edtPenerbit);
        edtTahunTerbit = (EditText) findViewById(R.id.edtTahunTerbit);
        btnSimpanBuku = (Button) findViewById(R.id.btnSimpanBuku);

        btnSimpanBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idbuku = Integer.parseInt(edtIdBuku.getText().toString());
                judul = edtJudulBuku.getText().toString();
                pengarang = edtPengarang.getText().toString();
                penerbit = edtPenerbit.getText().toString();
                tahunTerbit = Integer.parseInt(edtTahunTerbit.getText().toString());
                Log.d("TAG", "ID Buku" + idbuku + "Judul" + judul + "Pengarang" + pengarang + "Penerbit" + penerbit + "Tahun Terbit" + tahunTerbit);
                tambahDataBuku(idbuku, judul, pengarang, penerbit, tahunTerbit);
            }
        });

    }
    public void tambahDataBuku(Integer idbuku, String judul, String pengarang, String penerbit, Integer tahunTerbit){
        Realm realm = Realm.getDefaultInstance();

        //penyimpanan data
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    Log.d("TAG", "ID Buku" + idbuku + "Judul" + judul + "Pengarang" + pengarang + "Penerbit" + penerbit + "Tahun Terbit" + tahunTerbit);
                    Buku buku1 = realm.createObject(Buku.class, idbuku);
                    buku1.setJudul(judul);
                    buku1.setPengarang(pengarang);
                    buku1.setPenerbit(penerbit);
                    buku1.setTahunTerbit(tahunTerbit);
                    finish();
                }catch(RealmPrimaryKeyConstraintException e){
                    Log.d("TAG", "PrimaryKey Sudah ada : " + e.getMessage().toString());
                }

            }
        });
        realm.close();
    }
}