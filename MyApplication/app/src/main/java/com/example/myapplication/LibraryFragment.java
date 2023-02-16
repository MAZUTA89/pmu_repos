package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
        MainActivity.LogFragment(LIBRARY_FRAGMENT_TAG, get_fragmentName() + " onATTEMPT!");
        onAttaching();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.LogFragment(LIBRARY_FRAGMENT_TAG, get_fragmentName() + " onCREATE!");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity.LogFragment(LIBRARY_FRAGMENT_TAG, get_fragmentName() + " onCreateView!");
        return CreateView(inflater, container, savedInstanceState);
    }
    public abstract View CreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
