package umn.ac.id.planesmith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Characters extends AppCompatActivity {
    int id;
    String character_name;
    String character_age;
    String character_height;
    String character_weight;
    String character_gender;
    String character_content;
    String character_group;
    String created_at;

    private static final String TAG = "Characters";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        Log.d(TAG, "onCreate: Starting.");

        Button addButton = (Button) findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onclick: AddNewCharacter");

                Intent intent = new Intent(Characters.this, AddCharacter.class);
                startActivity(intent);

            }
        });


    }

    public Characters () {
    }

    public Characters (String character_name, String character_content, String character_age, String character_gender, String character_weight, String character_height, String character_group) {
        this.character_name = character_name;
        this.character_content = character_content;
        this.character_age = character_age;
        this.character_weight = character_weight;
        this.character_height = character_height;
        this.character_gender = character_gender;
        this.character_group = character_group;
    }

    public Characters (int id, String character_name, String character_content, String character_age, String character_gender, String character_weight, String character_height, String character_group) {
        this.id = id;
        this.character_name = character_name;
        this.character_content = character_content;
        this.character_age = character_age;
        this.character_weight = character_weight;
        this.character_height = character_height;
        this.character_gender = character_gender;
        this.character_group = character_group;
    }

    // setter
    public void setId(int id) {
        this.id = id;
    }

    public void setCharacter_name(String character_name) {
        this.character_name = character_name;
    }

    public void setCharacter_height(String character_height){
        this.character_height = character_height;
    }

    public void setCharacter_weight(String character_weight) {
        this.character_weight = character_weight;
    }

    public void setCharacter_age(String character_age) {
        this.character_age = character_age;
    }

    public void setCharacter_gender(String character_gender) {
        this.character_gender = character_gender;
    }

    public void setCharacter_content (String character_content) {
        this.character_content = character_content;
    }

    public void setCharacter_group (String character_group) {
        this.character_group = character_group;
    }

    public void setCreatedAt(String created_at){
        this.created_at = created_at;
    }

    //getter
    public long getId() {
        return this.id;
    }

    public String getCharacter_name() {
        return this.character_name;
    }

    public String getCharacter_age() {
        return character_age;
    }

    public String getCharacter_height() {
        return character_height;
    }

    public String getCharacter_weight() {
        return character_weight;
    }

    public String getCharacter_gender() {
        return character_gender;
    }

    public String getCharacter_content() {
        return this.character_content;
    }

    public String getCharacter_group() {
        return this.character_group;
    }
}