package umn.ac.id.planesmith;

import static umn.ac.id.planesmith.DatabaseHelper.KEY_ID;
import static umn.ac.id.planesmith.DatabaseHelper.KEY_CHAPTER_NAME;
import static umn.ac.id.planesmith.DatabaseHelper.KEY_CHAPTER_CONTENT;
import static umn.ac.id.planesmith.DatabaseHelper.KEY_ARC;
import static umn.ac.id.planesmith.DatabaseHelper.TABLE_STORY;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import umn.ac.id.planesmith.data.Story;

public class StoryActivity extends AppCompatActivity {

    private RecyclerView rvStory;

    private static final String TAG = "Story";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Button addNew = (Button) findViewById(R.id.addButton);
        rvStory = findViewById(R.id.rv_story);

        addNew.setOnClickListener(v -> {
            Log.d(TAG, "onClick: AddNewStory");
            Intent intent = new Intent(StoryActivity.this, AddStory.class);
            startActivity(intent);
        });
        displayStory();
    }

    private void displayStory(){
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {KEY_ID, KEY_CHAPTER_NAME, KEY_CHAPTER_CONTENT, KEY_ARC};
        Cursor cursor = db.query(TABLE_STORY, projection, null, null, null, null, null);

        int idColumnIndex = cursor.getColumnIndexOrThrow(KEY_ID);
        int nameColumnIndex = cursor.getColumnIndexOrThrow(KEY_CHAPTER_NAME);
        int contentColumnIndex = cursor.getColumnIndexOrThrow(KEY_CHAPTER_CONTENT);
        int folderColumnIndex = cursor.getColumnIndexOrThrow(KEY_ARC);

        ArrayList<Story> listStory = new ArrayList<>();

        while(cursor.moveToNext()){
            Log.d("Story", cursor.getString(nameColumnIndex));
            int id = cursor.getInt(idColumnIndex);
            String name = cursor.getString(nameColumnIndex);
            String content = cursor.getString(contentColumnIndex);
            String arc = cursor.getString(folderColumnIndex);

            listStory.add(new Story(id, name, content, arc));
        }
        cursor.close();
        rvStory.setAdapter(new StoryAdapter(listStory));
        rvStory.setLayoutManager(new LinearLayoutManager(this));

    }
}