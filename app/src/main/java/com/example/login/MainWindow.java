package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainWindow extends AppCompatActivity {


    String fruitlist[] = {"Apple", "Banana", "Apricot", "Orange"};
    int fruitImages[] = {R.drawable.apple, R.drawable.bananas, R.drawable.lychee, R.drawable.orange};

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);

        listView = (ListView) findViewById(R.id.customList);
        CustomBaseAdapter customBaseAdaptr = new CustomBaseAdapter(getApplicationContext(),fruitlist,fruitImages);
        listView.setAdapter(customBaseAdaptr);
    }
}