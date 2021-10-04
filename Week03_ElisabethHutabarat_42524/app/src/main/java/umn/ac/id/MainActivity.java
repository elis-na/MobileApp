package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.LinkedList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private DaftarKataAdapter mAdapter;
    private final LinkedList<String> mDaftarKata = new
            LinkedList<>();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int jumlahKata = mDaftarKata.size() ;
                mDaftarKata.addLast("Kata " + (jumlahKata + 1) +
                        " telah ditambahkan");
                Objects.requireNonNull
                        (mRecyclerView.getAdapter()).notifyItemInserted(jumlahKata);
                mRecyclerView.smoothScrollToPosition(jumlahKata);
            }
        });

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            for (int i = 1; i < 21; i++) {
                mDaftarKata.add("Kata " + i);
            }

            mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
            mAdapter = new DaftarKataAdapter(this, mDaftarKata);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }