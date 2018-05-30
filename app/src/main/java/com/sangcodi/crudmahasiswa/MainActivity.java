package com.sangcodi.crudmahasiswa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.sangcodi.crudmahasiswa.adapter.MahasiswaAdapter;
import com.sangcodi.crudmahasiswa.model.Mahasiswa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // coba gambar dinamis
        /*ImageView ivCobaGambar=(ImageView)findViewById(R.id.iv_gambar);

        int SDK_INT= Build.VERSION.SDK_INT;
        if (SDK_INT>8){
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

        try {
            URL url=new URL("https://picsum.photos/200/300?image=1");
            Bitmap bmp= BitmapFactory.decodeStream(url.openConnection().getInputStream());
            ivCobaGambar.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        Picasso.with(this).load("http://picsum.photos/200/300/?image=1").into(ivCobaGambar);*/

        // 1. data
        final String[] nama=new String[]{"sep","septy","septyan"};

        Mahasiswa mahasiswa1=new Mahasiswa();
        mahasiswa1.setNama("sep");
        mahasiswa1.setNim("3.34.15.1.20");
        mahasiswa1.setEmail("sep@sep.cc");
        mahasiswa1.setFoto("sep");

        Mahasiswa mahasiswa2=new Mahasiswa(
                "septy",
                "3.34.15.1.25",
                "septy@sep.cc",
                "sep"
        );

        ArrayList<Mahasiswa> mahasiswas=new ArrayList<>();
        mahasiswas.add(mahasiswa1);
        mahasiswas.add(mahasiswa2);

        // 2. adapter
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                nama);

        MahasiswaAdapter mahasiswaAdapter=new MahasiswaAdapter(this,
                R.layout.item_mahasiswa,mahasiswas);

        // 3. activity
        ListView lvDaftarNama=(ListView)findViewById(R.id.lv_daftar_nama);
        lvDaftarNama.setAdapter(mahasiswaAdapter);

        lvDaftarNama.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, ""+nama[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
