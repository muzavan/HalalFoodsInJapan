package com.halalfoods;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import halalfoods.model.FoodItemList;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] foodNames = {
            "Google Plus",
            "Twitter",
            "Windows",
            "Bing",
            "Itunes",
            "Wordpress",
            "Drupal"
    } ;

    String[] foodPrices = {
            "Rp 10.000,00",
            "Rp 9.000,00",
            "Rp 8.000,00",
            "Rp 7.000,00",
            "Rp 6.000,00",
            "Rp 5.000,00",
            "Rp 4.000,00",
    } ;

    Integer[] foodImages = {
            R.drawable.ayam_bakar,
            R.drawable.ayam_bakar,
            R.drawable.ayam_bakar,
            R.drawable.ayam_bakar,
            R.drawable.ayam_bakar,
            R.drawable.ayam_bakar,
            R.drawable.ayam_bakar,
    };

    Integer[] halalImages = {
            R.drawable.logo_haram,
            R.drawable.logo_halal,
            R.drawable.logo_edible,
            R.drawable.logo_halal,
            R.drawable.logo_halal,
            R.drawable.logo_edible,
            R.drawable.logo_haram,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Components
        FoodItemList adapter = new
                FoodItemList(MainActivity.this, foodImages, foodNames, foodPrices,halalImages);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "You Clicked at " + foodNames[position], Toast.LENGTH_SHORT).show();
            }
        });

        //For searching
        final SearchView searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d("Search","Invoked");
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.d("Search","Invoked");
        }
    }
}
