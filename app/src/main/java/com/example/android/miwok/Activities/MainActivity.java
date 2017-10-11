package com.example.android.miwok.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.android.miwok.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void changeActivity(View view) {
        int id = view.getId();
        Intent intent;

        if (id == R.id.colors) {
            intent = new Intent(this, ColorsActivity.class);
        } else if (id == R.id.family) {
            intent = new Intent(this, FamilyActivity.class);
        } else if (id == R.id.numbers) {
            intent = new Intent(this, NumbersActivity.class);
        } else {
            intent = new Intent(this, PhrasesActivity.class);
        }

        startActivity(intent);
    }
}
