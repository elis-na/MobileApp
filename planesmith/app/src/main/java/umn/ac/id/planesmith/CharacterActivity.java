package umn.ac.id.planesmith;

import static umn.ac.id.planesmith.DatabaseHelper.KEY_CHARACTER_AGE;
import static umn.ac.id.planesmith.DatabaseHelper.KEY_CHARACTER_CONTENT;
import static umn.ac.id.planesmith.DatabaseHelper.KEY_CHARACTER_GENDER;
import static umn.ac.id.planesmith.DatabaseHelper.KEY_CHARACTER_GROUP;
import static umn.ac.id.planesmith.DatabaseHelper.KEY_CHARACTER_HEIGHT;
import static umn.ac.id.planesmith.DatabaseHelper.KEY_CHARACTER_NAME;
import static umn.ac.id.planesmith.DatabaseHelper.KEY_CHARACTER_WEIGHT;
import static umn.ac.id.planesmith.DatabaseHelper.KEY_ID;
import static umn.ac.id.planesmith.DatabaseHelper.TABLE_CHARACTERS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

import umn.ac.id.planesmith.data.Character;

public class CharacterActivity extends AppCompatActivity {

    private RecyclerView rvCharacter;

    private static final String TAG = "Characters";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        Button addNew = findViewById(R.id.addButton);
        rvCharacter = findViewById(R.id.rv_character);

        addNew.setOnClickListener(v -> {
            Log.d(TAG, "onClick: AddNewCharacter");
            Intent intent = new Intent(CharacterActivity.this, AddCharacter.class);
            startActivity(intent);
        });
        displayCharacter();
    }

    private void displayCharacter(){
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {KEY_ID, KEY_CHARACTER_NAME, KEY_CHARACTER_AGE, KEY_CHARACTER_HEIGHT, KEY_CHARACTER_WEIGHT, KEY_CHARACTER_GENDER, KEY_CHARACTER_GROUP, KEY_CHARACTER_CONTENT};
        Cursor cursor = db.query(TABLE_CHARACTERS, projection, null, null, null, null, null);

        int idColumnIndex = cursor.getColumnIndexOrThrow(KEY_ID);
        int nameColumnIndex = cursor.getColumnIndexOrThrow(KEY_CHARACTER_NAME);
        int ageColumnIndex = cursor.getColumnIndexOrThrow(KEY_CHARACTER_AGE);
        int heightColumnIndex = cursor.getColumnIndexOrThrow(KEY_CHARACTER_HEIGHT);
        int weightColumnIndex = cursor.getColumnIndexOrThrow(KEY_CHARACTER_WEIGHT);
        int genderColumnIndex = cursor.getColumnIndexOrThrow(KEY_CHARACTER_GENDER);
        int groupColumnIndex = cursor.getColumnIndexOrThrow(KEY_CHARACTER_GROUP);
        int contentColumnIndex = cursor.getColumnIndexOrThrow(KEY_CHARACTER_CONTENT);

        ArrayList<Character> listCharacter = new ArrayList<>();

        while(cursor.moveToNext()){
            Log.d("Characters", cursor.getString(nameColumnIndex));
            int id = cursor.getInt(idColumnIndex);
            String name = cursor.getString(nameColumnIndex);
            String age = cursor.getString(ageColumnIndex);
            String height = cursor.getString(heightColumnIndex);
            String weight = cursor.getString(weightColumnIndex);
            String gender = cursor.getString(genderColumnIndex);
            String group = cursor.getString(groupColumnIndex);
            String content = cursor.getString(contentColumnIndex);
            listCharacter.add(new Character(id, name, age, height, weight, gender, group, content));
        }
        cursor.close();
        rvCharacter.setAdapter(new CharacterAdapter(listCharacter));
        rvCharacter.setLayoutManager(new LinearLayoutManager(this));
    }
}