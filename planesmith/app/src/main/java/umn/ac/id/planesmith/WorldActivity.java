package umn.ac.id.planesmith;

import static umn.ac.id.planesmith.DatabaseHelper.KEY_ID;
import static umn.ac.id.planesmith.DatabaseHelper.KEY_WORLD_CONTENT;
import static umn.ac.id.planesmith.DatabaseHelper.KEY_WORLD_NAME;
import static umn.ac.id.planesmith.DatabaseHelper.KEY_FOLDER;
import static umn.ac.id.planesmith.DatabaseHelper.TABLE_WORLD;

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

import umn.ac.id.planesmith.data.World;

public class WorldActivity extends AppCompatActivity {

    private RecyclerView rvWorld;

    private static final String TAG = "World";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world);
        Button addNew = (Button) findViewById(R.id.addButton);
        rvWorld = findViewById(R.id.rv_world);

        addNew.setOnClickListener(v -> {
            Log.d(TAG, "onClick: AddNewWorld");
            Intent intent = new Intent(WorldActivity.this, AddWorld.class);
            startActivity(intent);
        });
        displayWorld();
    }

    private void displayWorld(){
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {KEY_ID, KEY_WORLD_NAME, KEY_WORLD_CONTENT, KEY_FOLDER};
        Cursor cursor = db.query(TABLE_WORLD, projection, null, null, null, null, null);

        int idColumnIndex = cursor.getColumnIndexOrThrow(KEY_ID);
        int nameColumnIndex = cursor.getColumnIndexOrThrow(KEY_WORLD_NAME);
        int contentColumnIndex = cursor.getColumnIndexOrThrow(KEY_WORLD_CONTENT);
        int folderColumnIndex = cursor.getColumnIndexOrThrow(KEY_FOLDER);

        ArrayList<World> listWorld = new ArrayList<>();

        while(cursor.moveToNext()){
            Log.d("World", cursor.getString(nameColumnIndex));
            int id = cursor.getInt(idColumnIndex);
            String name = cursor.getString(nameColumnIndex);
            String content = cursor.getString(contentColumnIndex);
            String folder = cursor.getString(folderColumnIndex);

            listWorld.add(new World(id, name, content, folder));
        }
        cursor.close();
        rvWorld.setAdapter(new WorldAdapter(listWorld));
        rvWorld.setLayoutManager(new LinearLayoutManager(this));

    }
}