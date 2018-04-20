package com.example.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Item_Data> myDataSet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 1; i < 101; i++) {
            Item_Data item = new Item_Data();
            item.setText(i + "");
            myDataSet.add(item);
        }
        MyAdapter myAdapter = new MyAdapter(myDataSet);
        RecyclerView mList = (RecyclerView) findViewById(R.id.list_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mList.setLayoutManager(layoutManager);
        mList.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.select_item, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int itemWasClicked = item.getItemId();
        if (itemWasClicked == R.id.select) {
            String str1 = "";
            for (int i = 0; i < 100; i++) {
                if (myDataSet.get(i).isCheck()) {
                    str1 += myDataSet.get(i).getText()+" ";
                }
            }
            Toast.makeText(this, "You select: " + str1, Toast.LENGTH_SHORT).show();
            return true;
        }
            return super.onOptionsItemSelected(item);
    }

}
