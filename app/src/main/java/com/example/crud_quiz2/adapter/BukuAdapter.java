package com.example.crud_quiz2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.crud_quiz2.R;
import com.example.crud_quiz2.bukuEditFormActivity;
import com.example.crud_quiz2.model.Buku;
import com.example.crud_quiz2.crud.bukuCRUD;

import java.util.List;

public class BukuAdapter extends ArrayAdapter<Buku> {
    public BukuAdapter(Context context, List<Buku> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Buku buku = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_listviewbuku, parent, false);
        }
        TextView txvIdBuku = (TextView) convertView.findViewById(R.id.txvIdBuku);
        TextView txvJudul = (TextView) convertView.findViewById(R.id.txvJudul);
        TextView txvPengarang = (TextView) convertView.findViewById(R.id.txvPengarang);
        TextView txvPenerbit = (TextView) convertView.findViewById(R.id.txvPenerbit);
        TextView txvTahunTerbit = (TextView) convertView.findViewById(R.id.txvTahunTerbit);

        txvIdBuku.setText(buku.getId_buku().toString());
        txvJudul.setText(buku.getJudul());
        txvPengarang.setText(buku.getPengarang());
        txvPenerbit.setText(buku.getPenerbit());
        txvTahunTerbit.setText(buku.getTahunTerbit().toString());

        ImageButton btnEdit = (ImageButton) convertView.findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), bukuEditFormActivity.class);
                intent.putExtra("idbuku", String.valueOf(buku.getId_buku()));
                intent.putExtra("judul", buku.getJudul());
                intent.putExtra("pengarang", buku.getPengarang());
                intent.putExtra("penerbit", buku.getPenerbit());
                intent.putExtra("tahunterbit", String.valueOf(buku.getTahunTerbit()));
                getContext().startActivity(intent);
            }
        });

        ImageButton btnDelete = (ImageButton) convertView.findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bukuCRUD bukucrud = new bukuCRUD();
                bukucrud.deleteBuku(buku.getId_buku());
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
}

