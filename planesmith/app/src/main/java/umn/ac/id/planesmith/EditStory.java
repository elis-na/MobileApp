package umn.ac.id.planesmith;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditStory extends AppCompatActivity {
    //Class is for Updating and Deleting
    EditText chapter_name, chapter_details;
    Button update_button, delete_button;

    String chapter_title, chapter_content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_story);

        chapter_name = findViewById(R.id.chapter_name2);
        chapter_details = findViewById(R.id.chapter_detail2);

        getAndSetIntentData();

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DatabaseHelper myDB = new DatabaseHelper(updateStory.this);
//                chapter_title = chapter_name.getText().toString().trim();
//                chapter_content = chapter_details.getText().toString().trim();
//                myDB.updateStory(chapter_title, chapter_content);
            }
        });

    }

    void getAndSetIntentData() {
    }
}