package com.example.crud_quiz2.crud;

import android.util.Log;

import com.example.crud_quiz2.model.Buku;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class bukuCRUD {
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
                }catch(RealmPrimaryKeyConstraintException e){
                    Log.d("TAG", "PrimaryKey Sudah ada + " + e.getMessage().toString());
                }

            }
        });
        realm.close();
    }

    public void updateBuku(Integer idbuku, String judul, String pengarang, String penerbit, Integer tahunTerbit){
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    Log.d("TAG", "ID Buku" + idbuku + "Judul" + judul + "Pengarang" + pengarang + "Penerbit" + penerbit + "Tahun Terbit" + tahunTerbit);
                    Buku buku1 = realm.where(Buku.class).equalTo("idbuku", idbuku).findFirst();
                    buku1.setJudul(judul);
                    buku1.setPengarang(pengarang);
                    buku1.setPenerbit(penerbit);
                    buku1.setTahunTerbit(tahunTerbit);
                }catch(RealmPrimaryKeyConstraintException e){
                    Log.d("TAG", "PrimaryKey Sudah ada: " + e.getMessage().toString());
                }

            }
        });
        realm.close();
    }

    public void deleteBuku(Integer id_buku){
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    Log.d("TAG","ID Buku" + id_buku);
                    Buku buku1 = realm.where(Buku.class).equalTo("idbuku", id_buku).findFirst();
                    buku1.deleteFromRealm();
                }catch(RealmPrimaryKeyConstraintException e){
                    Log.d("TAG", "PrimaryKey Sudah ada: " + e.getMessage().toString());
                }

            }
        });
        realm.close();
    }
}

