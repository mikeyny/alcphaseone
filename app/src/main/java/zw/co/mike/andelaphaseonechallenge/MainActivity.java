package zw.co.mike.andelaphaseonechallenge;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnProfile = findViewById(R.id.btnProfile);
        Button btnAbout= findViewById(R.id.btnWebview);
        btnProfile.setOnClickListener(v-> navigateToActivity(ProfileActivity.class));
        btnAbout.setOnClickListener(v->navigateToActivity(WebviewActivity.class));
        ActionBar toolbar = getSupportActionBar();
        toolbar.setTitle("ALC Phase 1");
    }

    private void navigateToActivity(Class<?> cls) {
        Intent myIntent = new Intent(MainActivity.this, cls);
        startActivity(myIntent);
    }
}
