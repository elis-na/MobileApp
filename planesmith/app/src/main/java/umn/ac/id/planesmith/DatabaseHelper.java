package umn.ac.id.planesmith;

import androidx.annotation.Nullable;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    //SQLiteDatabase db;
    Context context;

    //LogCat
    static final String LOG = "DatabaseHelper";

    //Version
    static final int DATABASE_VERSION = 1;

    //DB Name
    static final String DATABASE_NAME = "planesmith.db";

    //Table names
    static final String TABLE_CHARACTERS = "character";
    static final String TABLE_WORLD = "world";
    static final String TABLE_STORY = "story";

    //common column names
    static final String KEY_ID = "id";
    static final String KEY_CREATED_AT = "created_at";

    //Character Columns
    static final String KEY_CHARACTER_NAME = "character_name";
    static final String KEY_CHARACTER_AGE = "character_age";
    static final String KEY_CHARACTER_HEIGHT = "character_height";
    static final String KEY_CHARACTER_WEIGHT = "character_weight";
    static final String KEY_CHARACTER_GENDER = "character_gender";
    static final String KEY_CHARACTER_CONTENT = "character_content";
    static final String KEY_CHARACTER_GROUP = "character_group";

    //Story Columns
    static final String KEY_CHAPTER_NAME = "chapter_name";
    static final String KEY_CHAPTER_CONTENT = "chapter_content";
    static final String KEY_ARC = "arc";

    //World Columns
    static final String KEY_WORLD_NAME = "world_name";
    static final String KEY_WORLD_CONTENT = "world_content";
    static final String KEY_FOLDER = "Folder";

    //Table create
    private static final String CREATE_TABLE_CHARACTERS = "CREATE TABLE "
            + TABLE_CHARACTERS + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_CHARACTER_NAME + " TEXT, "
            + KEY_CHARACTER_AGE + " TEXT, "
            + KEY_CHARACTER_HEIGHT + " TEXT, "
            + KEY_CHARACTER_WEIGHT + " TEXT, "
            + KEY_CHARACTER_GENDER + " TEXT, "
            + KEY_CHARACTER_CONTENT + " TEXT, "
            + KEY_CHARACTER_GROUP + " TEXT, "
            + KEY_CREATED_AT + " DATETIME" + ")";

    private static final String CREATE_TABLE_STORY = "CREATE TABLE "
            + TABLE_STORY + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_CHAPTER_NAME + " TEXT,"
            + KEY_CHAPTER_CONTENT + " TEXT,"
            + KEY_ARC + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    private static final String CREATE_TABLE_WORLD = "CREATE TABLE "
            + TABLE_WORLD + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_WORLD_NAME + " TEXT,"
            + KEY_WORLD_CONTENT + " TEXT,"
            + KEY_FOLDER + " TEXT,"
            + KEY_CREATED_AT + " DATETIME" + ")";

    DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    //@Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_WORLD);
        sqLiteDatabase.execSQL(CREATE_TABLE_CHARACTERS);
        sqLiteDatabase.execSQL(CREATE_TABLE_STORY);
    }

    //@Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_WORLD);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CHARACTERS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_STORY);

        onCreate(sqLiteDatabase);
    }

    //ADD FUNCTIONS
    void addWorld(String world_name, String world_content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(KEY_WORLD_NAME, world_name);
        cv.put(KEY_WORLD_CONTENT, world_content);
        long result = db.insert(TABLE_WORLD, null, cv);
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    void addStory(String chapter_name, String chapter_content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(KEY_CHAPTER_NAME, chapter_name);
        cv.put(KEY_CHAPTER_CONTENT, chapter_content);
        long result = db.insert(TABLE_STORY, null, cv);
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    void addCharacter(String character_name, String character_height, String character_weight, String character_age, String character_gender, String character_group, String character_content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_CHARACTER_NAME, character_name);
        cv.put(KEY_CHARACTER_HEIGHT, character_height);
        cv.put(KEY_CHARACTER_WEIGHT, character_weight);
        cv.put(KEY_CHARACTER_AGE, character_age);
        cv.put(KEY_CHARACTER_GENDER, character_gender);
        cv.put(KEY_CHARACTER_GROUP, character_group);
        cv.put(KEY_CHARACTER_CONTENT, character_content);
        long result = db.insert(TABLE_CHARACTERS, null, cv);
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    //UPDATE FUNCTIONS
    void updateStory(String id, String chapter_title, String chapter_content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_CHAPTER_NAME, chapter_title);
        cv.put(KEY_CHAPTER_CONTENT, chapter_content);

        long result = db.update(TABLE_STORY, cv, "_id=?", new String[]{id});
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void updateWorld(String id, String world_title, String world_content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_WORLD_NAME, world_title);
        cv.put(KEY_WORLD_CONTENT, world_content);

        long result = db.update(TABLE_WORLD, cv, "_id=?", new String[]{id});
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void updateCharacter(String id, String character_name, String character_height, String character_weight, String character_age, String character_gender, String character_group, String character_content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_CHARACTER_NAME, character_name);
        cv.put(KEY_CHARACTER_HEIGHT, character_height);
        cv.put(KEY_CHARACTER_WEIGHT, character_weight);
        cv.put(KEY_CHARACTER_AGE, character_age);
        cv.put(KEY_CHARACTER_GENDER, character_gender);
        cv.put(KEY_CHARACTER_GROUP, character_group);
        cv.put(KEY_CHARACTER_CONTENT, character_content);

        long result = db.update(TABLE_CHARACTERS, cv, "_id=?", new String[]{id});
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    //DELETE FUNCTIONS
    void deleteStory(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_STORY, "id=?", new String[]{id});
        if (result == -1) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteWorld(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_WORLD, "id=?", new String[]{id});
        if (result == -1) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteCharacter(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_CHARACTERS, "id=?", new String[]{id});
        if (result == -1) {
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }
}