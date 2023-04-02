package com.example.crud_quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.crud_quiz2.crud.bukuCRUD;

public class bukuEditFormActivity extends AppCompatActivity {

    TextView edtIdBukue;
    EditText edtJudulBukue, edtPengarange, edtPenerbite, edtTahunTerbite;
    Button btnSimpanBukue;
    Integer idbuku;
    String judul="";
    String pengarang="";
    String penerbit="";
    Integer tahunTerbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_edit_form);

        edtIdBukue = (TextView) findViewById(R.id.edtIdBukue);
        edtJudulBukue = (EditText) findViewById(R.id.edtJudulBukue);
        edtPengarange = (EditText) findViewById(R.id.edtPengarange);
        edtPenerbite = (EditText) findViewById(R.id.edtPenerbite);
        edtTahunTerbite = (EditText) findViewById(R.id.edtTahunTerbite);
        btnSimpanBukue = (Button) findViewById(R.id.btnSimpanBukue);
        edtIdBukue.setText(getIntent().getStringExtra("idbuku"));
        edtJudulBukue.setText(getIntent().getStringExtra("judul"));
        edtPengarange.setText(getIntent().getStringExtra("pengarang"));
        edtPenerbite.setText(getIntent().getStringExtra("penerbit"));
        edtTahunTerbite.setText(getIntent().getStringExtra("tahunterbit"));


        btnSimpanBukue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idbuku = Integer.parseInt(edtIdBukue.getText().toString());
                judul = edtJudulBukue.getText().toString();
                pengarang = edtPengarange.getText().toString();
                penerbit = edtPenerbite.getText().toString();
                tahunTerbit = Integer.parseInt(edtTahunTerbite.getText().toString());
                Log.d("TAG", "ID Buku" + idbuku + "Judul" + judul + "Pengarang" + pengarang + "Penerbit" + penerbit + "Tahun Terbit" + tahunTerbit);
                bukuCRUD usercrud = new bukuCRUD();
                usercrud.updateBuku(idbuku, judul, pengarang, penerbit, tahunTerbit);
                finish();
            }
        });
    }
}