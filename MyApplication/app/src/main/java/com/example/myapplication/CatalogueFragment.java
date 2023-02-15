package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import books_catalogue.Book;

public class CatalogueFragment extends LibraryFragment {
    /*public CatalogueFragment()
    {
        super(R.layout.catalogue_fragment_layout);
    }*/
    Button delete_button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.catalogue_fragment_layout, container, false);
        booksListView = view.findViewById(R.id.list_view_catalogue);


        UpdateAdapter();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    @Override
    public String get_fragmentName() {
        return "Catalogue fragment";
    }

    @Override
    public void onAttaching() {
        UpdateAdapter();
    }
}
