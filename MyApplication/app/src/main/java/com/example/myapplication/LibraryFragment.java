package com.example.myapplication;

import android.content.Context;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.myapplication.*;

import java.util.ArrayList;
import java.util.List;

import books_catalogue.Book;


public abstract class LibraryFragment extends Fragment {
    public String LIBRARY_FRAGMENT_TAG = "Library fragment lifecycle";
    ListView booksListView;
    public abstract String  get_fragmentName();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MainActivity.LogFragment(LIBRARY_FRAGMENT_TAG, get_fragmentName() + " ATTEMPT!");
        onAttaching();
    }
    public void UpdateAdapter()
    {
        BooksAdapter adapter = new BooksAdapter(getContext(), MainActivity.catalogue.getBooks());
        if(booksListView != null)
        {
            booksListView.setAdapter(adapter);
        }
    }
    public void UpdateAdapter(ArrayList<Book> books)
    {
        BooksAdapter adapter = new BooksAdapter(getContext(), books);
        if(booksListView != null)
        {
            booksListView.setAdapter(adapter);
        }
    }
    public abstract void onAttaching();
}
