package com.example.listcustomtvn;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random = new Random();
    private ItemDataAdapter adapter;
    private List<ItemData> samples = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        FloatingActionButton fab = findViewById(R.id.fab);
        fillSamples();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomItemData();
            }
        });
        adapter = new ItemDataAdapter(this, null);
        listView.setAdapter(adapter);
    }


    private void generateRandomItemData() {
        adapter.addItem(samples.get(random.nextInt(samples.size())));
    }

    private void fillSamples() {
        samples.add(new ItemData(getDrawable(R.drawable.calendar),
                getString(R.string.title3),
                getString(R.string.subtitle2),
                random.nextBoolean()));
        samples.add(new ItemData(getDrawable(R.drawable.spinner),
                getString(R.string.title2),
                getString(R.string.subtitle2),
                random.nextBoolean()));
        samples.add(new ItemData(getDrawable(R.drawable.notes),
                getString(R.string.title1),
                getString(R.string.subtitle1),
                random.nextBoolean()));
    }
}
