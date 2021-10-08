package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class MainLagu extends AppCompatActivity {
    RecyclerView rvDaftarLagu;
    DaftarLaguAdapter mAdapter;
    LinkedList<SumberLagu> daftarLagu = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lagu);

        isiDaftarVideo();
        rvDaftarLagu = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DaftarLaguAdapter(this, daftarLagu);
        rvDaftarLagu.setAdapter(mAdapter);
        rvDaftarLagu.setLayoutManager(new LinearLayoutManager(this));
    }

    public void isiDaftarVideo(){
        daftarLagu.add(new SumberLagu("The Feels",
                "TWICE" + R.raw.thefeels));
        daftarLagu.add(new SumberLagu("FANCY",
                "TWICE" + R.raw.fancy));
        daftarLagu.add(new SumberLagu("Feel Special", "TWICE" + R.raw.feelspecial));
    }
}