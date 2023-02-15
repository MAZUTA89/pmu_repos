package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.time.Year;

import books_catalogue.Book;
import books_catalogue.Catalogue;

public class MainActivity extends AppCompatActivity {

    public static final int f_INFO_KEY = 10;
    public static final int f_ADD_KEY = 11;
    public static final int f_REDACT_KEY = 12;
    public static final int f_DELETE_KEY = 13;
    public static final int f_FIRST_KEY = 14;
    public static final int f_SECOND_KEY = 15;
    public static final int f_THIRD_KEY = 16;

    public final String MAIN_LIFECYCLE_TAG = "Main lifecycle";

    private final String f_MENU_TAG = "Tap Menu";

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    Bundle bundle;

    public static Catalogue catalogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            bundle = savedInstanceState;
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        catalogue = new Catalogue();
        InitData();
        LogMainLifcycle("Main is onCreate!!!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(Menu.NONE, f_INFO_KEY, Menu.NONE, "Catalogue");
        menu.add(Menu.NONE, f_ADD_KEY, Menu.NONE, "Add book");
        menu.add(Menu.NONE, f_REDACT_KEY, Menu.NONE, "Redact book");
        menu.add(Menu.NONE, f_FIRST_KEY, Menu.NONE, "A) Function");
        menu.add(Menu.NONE, f_SECOND_KEY, Menu.NONE, "B) Function");
        menu.add(Menu.NONE, f_THIRD_KEY, Menu.NONE, "C) Function");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment = null;
        Class fragmentClass = null;
        int id = item.getItemId();
        switch (id)
        {
            case f_INFO_KEY:
            {
                fragmentClass = CatalogueFragment.class;
                /*if (bundle == null) {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.container, CatalogueFragment.class, null)
                            .commit();
                    Log.d(f_MENU_TAG, "Catalogue tap");*/
                //}
                break;
            }
            case f_ADD_KEY:
            {
                fragmentClass = AddFragment.class;

                Log.d(f_MENU_TAG, "Add tap");
                break;
            }
            case f_DELETE_KEY:
            {
                Log.d(f_MENU_TAG, "Delete tap");
                break;
            }
            case f_REDACT_KEY:
            {
                Log.d(f_MENU_TAG, "Redact tap");
                break;
            }
            case f_FIRST_KEY:
            {
                fragmentClass = AuthorsFragment.class;
                Log.d(f_MENU_TAG, "A) tap");
                break;
            }
            case f_SECOND_KEY:
            {
                fragmentClass = PublishersFragment.class;
                Log.d(f_MENU_TAG, "B) tap");
                break;
            }
            case f_THIRD_KEY:
            {
                fragmentClass = YearFragment.class;
                Log.d(f_MENU_TAG, "C) tap");
                break;
            }
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

        return super.onOptionsItemSelected(item);
    }

    public static void LogFragment(String TAG, String text)
    {
        Log.d(TAG, text);
    }
    void LogMainLifcycle(String text)
    {
        Log.d(MAIN_LIFECYCLE_TAG, "------------" + text + "--------------");
    }

    void InitData()
    {
        Book b1 = new Book("Title1", "Author1", "Publisher1", 1999, 201, 100.1, "Bind1");
        Book b2 = new Book("Title2", "Author2", "Publisher2", 2000, 202, 100.2, "Bind2");
        Book b3 = new Book("Title3", "Author3", "Publisher3", 2001, 203, 100.3, "Bind3");
        Book b4 = new Book("Title4", "Author4", "Publisher4", 2002, 204, 100.4, "Bind4");
        Book b5 = new Book("Title5", "Author5", "Publisher5", 2003, 205, 100.5, "Bind5");
        Book b6 = new Book("Title6", "Author6", "Publisher6", 2004, 206, 100.6, "Bind6");
        Book b7 = new Book("Title7", "Author7", "Publisher7", 2005, 207, 100.7, "Bind7");
        Book b8 = new Book("Title8", "Author8", "Publisher8", 2006, 208, 100.8, "Bind8");
        Book b9 = new Book("Title9", "Author9", "Publisher9", 2007, 209, 100.9, "Bind9");
        Book b10 = new Book("Title10", "Author10", "Publisher10", 2008, 210, 101.0, "Bind10");
        Book b11 = new Book("Title11", "Author11", "Publisher11", 2009, 211, 101.1, "Bind11");
        Book b12 = new Book("Title12", "Author12", "Publisher12", 2010, 212, 101.2, "Bind12");
        Book b13 = new Book("Title13", "Author13", "Publisher13", 2011, 213, 101.3, "Bind13");
        Book b14 = new Book("Title14", "Author14", "Publisher14", 2012, 214, 101.4, "Bind14");
        Book b15 = new Book("Title15", "Author15", "Publisher15", 2013, 215, 101.5, "Bind15");
        Book b16 = new Book("Title16", "Author16", "Publisher16", 2014, 216, 101.6, "Bind16");
        Book b17 = new Book("Title17", "Author17", "Publisher17", 2015, 217, 101.7, "Bind17");
        Book b18 = new Book("Title18", "Author18", "Publisher18", 2016, 218, 101.8, "Bind18");
        Book b19 = new Book("Title19", "Author19", "Publisher19", 2017, 219, 101.9, "Bind19");
        Book b20 = new Book("Title20", "Author20", "Publisher20", 2018, 220, 102.0, "Bind20");

        catalogue.Add(b1);
        catalogue.Add(b2);
        catalogue.Add(b3);
        catalogue.Add(b4);
        catalogue.Add(b5);
        catalogue.Add(b6);
        catalogue.Add(b7);
        catalogue.Add(b8);
        catalogue.Add(b9);
        catalogue.Add(b10);
        catalogue.Add(b11);
        catalogue.Add(b12);
        catalogue.Add(b13);
        catalogue.Add(b14);
        catalogue.Add(b15);
        catalogue.Add(b16);
        catalogue.Add(b17);
        catalogue.Add(b18);
        catalogue.Add(b19);
        catalogue.Add(b20);

    }

    @Override
    protected void onStart() {
        super.onStart();
        LogMainLifcycle("Main is onStart !!!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogMainLifcycle("Main is onRestart !!!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogMainLifcycle("Main is onResume !!!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogMainLifcycle("Main is onPause !!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogMainLifcycle("Main is onStop !!!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogMainLifcycle("Main is onDestroy !!!");
    }
}