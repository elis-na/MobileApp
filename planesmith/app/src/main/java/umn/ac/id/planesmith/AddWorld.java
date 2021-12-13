package umn.ac.id.planesmith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

public class AddWorld extends AppCompatActivity {

    EditText world_name, world_detail;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_world);

        world_name = findViewById(R.id.world_name);
        world_detail = findViewById(R.id.world_detail);
        add_button = findViewById(R.id.save_world);
        add_button.setOnClickListener(v -> {
            DatabaseHelper myDB = new DatabaseHelper(getApplicationContext());
            myDB.addWorld(world_name.getText().toString().trim(),
                    world_detail.getText().toString().trim());
            Intent goBack = new Intent(this, WorldActivity.class);
            goBack.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(goBack);
        });
    }
}