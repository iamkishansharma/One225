package com.ks.one225.unitOne;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ks.one225.R;


public class ToolBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("Kishan Kr Sharma");
//        toolbar.setBackground(getDrawable(R.drawable.bg));
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.it1:
                Toast.makeText(ToolBarActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.it2:
                Toast.makeText(ToolBarActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.it3:
                Toast.makeText(ToolBarActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iit1:
                Toast.makeText(ToolBarActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iit2:
                Toast.makeText(ToolBarActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.iit3:
                Toast.makeText(ToolBarActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}