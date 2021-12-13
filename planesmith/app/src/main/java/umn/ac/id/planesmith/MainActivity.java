package umn.ac.id.planesmith;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageView;

    //initial var Switch Theme
    SwitchCompat switchCompat;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Switch Theme
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_Dark);
        }else {
            setTheme(R.style.Theme_Light);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting.");

        Button characters = (Button) findViewById(R.id.characters);

        Button world = (Button) findViewById(R.id.world);

        Button story = (Button) findViewById(R.id.story);

        //Switch Theme
        switchCompat = findViewById(R.id.bt_switch);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        characters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Characters.");

                Intent intent = new Intent(MainActivity.this, CharacterActivity.class);
                startActivity(intent);

            }
        });

        world.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: World.");

                Intent intent = new Intent(MainActivity.this, WorldActivity.class);
                startActivity(intent);
            }
        });

        story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onclick: Story.");

                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                startActivity(intent);
            }
        });

    }


}