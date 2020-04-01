package me.mehedee.accounts;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_accounts, R.id.navigation_payables, R.id.navigation_receivables)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        Uri uri = new Uri.Builder().authority("me.mehedee.ingredientsexpress").scheme("content").appendPath("flight").build();

        Log.d("TAAAAAG", uri.toString());

        String[] mProjection = {"id", "source", "destination", "price"};

        Cursor c = getContentResolver().query(
                uri,
                null,
                null,
                null, null);

        while (c.moveToNext()){
            Log.d("TAAGAA", "ID: " + c.getInt(0));
            Log.d("TAAGAA", "source: " + c.getString(1));
            Log.d("TAAGAA", "destination: " + c.getString(2));
            Log.d("TAAGAA", "price: " + c.getString(3));
        }

    }

}
