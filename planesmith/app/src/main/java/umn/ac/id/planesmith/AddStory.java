package umn.ac.id.planesmith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddStory extends AppCompatActivity {

    EditText chapter_name, chapter_details;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_story);

        chapter_name = findViewById(R.id.chapter_name);
        chapter_details = findViewById(R.id.chapter_detail);
        add_button = findViewById(R.id.save_story);
        add_button.setOnClickListener(v -> {
            DatabaseHelper myDB = new DatabaseHelper(getApplicationContext());
            myDB.addStory(chapter_name.getText().toString().trim(),
                    chapter_details.getText().toString().trim());
            Intent goBack = new Intent(this, StoryActivity.class);
            goBack.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.startActivity(goBack);
        });
    }
}