package umn.ac.id.planesmith;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditCharacter extends AppCompatActivity {
    //Class is for Updating and Deleting
    EditText character_name, character_age, character_height, character_weight, character_gender, character_group;
    Button update_button, delete_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_character);

        character_name = findViewById(R.id.character_name2);
        character_age = findViewById(R.id.character_age2);
        character_height = findViewById(R.id.character_height2);
        character_weight = findViewById(R.id.character_weight2);
        character_gender = findViewById(R.id.character_gender2);
        character_group = findViewById(R.id.character_group2);
    }
}