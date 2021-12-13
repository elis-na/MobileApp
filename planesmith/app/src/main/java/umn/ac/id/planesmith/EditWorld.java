package umn.ac.id.planesmith;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditWorld extends AppCompatActivity {
    //Class is for Updating and Deleting

    EditText world_name, world_detail;
    Button update_button, delete_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_world);

        world_name = findViewById(R.id.world_name2);
        world_detail = findViewById(R.id.world_detail2);
    }



}