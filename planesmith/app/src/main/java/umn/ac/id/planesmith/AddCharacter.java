package umn.ac.id.planesmith;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCharacter extends AppCompatActivity {

    EditText character_name, character_age, character_height, character_weight, character_gender, character_group, character_content;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_character);

        character_name = findViewById(R.id.character_name);
        character_age = findViewById(R.id.character_age);
        character_height = findViewById(R.id.character_height);
        character_weight = findViewById(R.id.character_weight);
        character_gender = findViewById(R.id.character_gender);
        character_group = findViewById(R.id.character_group);
        character_content = findViewById(R.id.character_detail);
        add_button = findViewById(R.id.save_character);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper myDB = new DatabaseHelper(AddCharacter.this);
                myDB.addCharacter(character_name.getText().toString().trim(),
                        character_age.getText().toString().trim(),
                        character_height.getText().toString().trim(),
                        character_weight.getText().toString().trim(),
                        character_gender.getText().toString().trim(),
                        character_group.getText().toString().trim(),
                        character_content.getText().toString().trim());
            }
        });
    }
}