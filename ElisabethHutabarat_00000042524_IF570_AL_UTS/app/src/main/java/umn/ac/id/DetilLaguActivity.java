package umn.ac.id;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetilLaguActivity extends AppCompatActivity {
    private EditText etJudul;
    private EditText etPenyanyi;
    private Button btnPlay;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_lagu);
        etJudul = (EditText) findViewById(R.id.etJudul);
        etPenyanyi = (EditText) findViewById(R.id.etPenyanyi);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SumberLagu sv = (SumberLagu) bundle.getSerializable(
                "DetilLagu");
        etJudul.setText(sv.getJudul());
        etPenyanyi.setText(sv.getPenyanyi());

        //BtnBack
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Detil Lagu Activity");

        btnPlay = (Button) findViewById(R.id.btnPlay);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp = MediaPlayer.create(getApplicationContext(),R.raw.thefeels);
                mp.start();
            }
        });

    }
}
