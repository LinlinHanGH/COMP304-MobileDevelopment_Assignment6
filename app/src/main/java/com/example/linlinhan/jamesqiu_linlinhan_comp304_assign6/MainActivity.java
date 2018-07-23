package com.example.linlinhan.jamesqiu_linlinhan_comp304_assign6;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] contacts;
    ListView lstView;
    //
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().setTitle("My Messaging App");
        //ListView lstView = getListView();
        lstView = (ListView)findViewById(R.id.android_list);
        TextView textView = new TextView(getApplicationContext());
        textView.setText("My Contacts");
        lstView.addHeaderView(textView);
        lstView.setChoiceMode(ListView.CHOICE_MODE_NONE);
        lstView.setTextFilterEnabled(true);
        contacts = getResources().getStringArray(R.array.contacts);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                contacts);
        // Assign adapter to ListView
        lstView.setAdapter(adapter);
        intent = new Intent(this, MessageActivity.class);

        // ListView Item Click Listener
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                int itemPosition = position;
                // ListView Clicked item value
                String item = (String) lstView.getItemAtPosition(position);
                // Show Alert intent.putExtra("contactName",item); startActivity(intent);
            }
        });

    }
}
