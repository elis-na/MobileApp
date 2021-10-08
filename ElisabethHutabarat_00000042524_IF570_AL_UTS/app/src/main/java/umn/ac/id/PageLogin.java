package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PageLogin extends AppCompatActivity {
    Button btnnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_login);

        Intent intent = getIntent();
        Toast.makeText(this, intent.getStringExtra("extras"), Toast.LENGTH_LONG).show();

        btnnext = findViewById(R.id.btnnext);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageLogin.this, MainLagu.class);
                startActivity(intent);
            }
        });
    }
}