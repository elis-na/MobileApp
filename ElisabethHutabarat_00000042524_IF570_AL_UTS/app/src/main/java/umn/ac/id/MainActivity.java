package umn.ac.id;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnprofile;
    Button btnlibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Btn Back
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Main Activity");

        //Intent
        btnprofile = findViewById(R.id.btnprofile);
        btnlibrary = findViewById(R.id.btnlibrary);

        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });

        //toast
        btnlibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PageLogin.class);
                intent.putExtra("extras", "Hi!");
                startActivity(intent);
            }
        });

    }
}