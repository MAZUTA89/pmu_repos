package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import books_catalogue.Book;
import ui_tools.CatalogManager;
import ui_tools.ValidateExcepsion;

public class AddFragment extends LibraryFragment {
    CatalogManager catalogManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewContent = inflater.inflate(R.layout.custom_add_delete_layout, container, false);

        catalogManager = new CatalogManager();

        Button add_button = viewContent.findViewById(R.id.button_add);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Book book = catalogManager.ReadAddView(viewContent);
                    Toast.makeText(getContext(), "Added", Toast.LENGTH_SHORT).show();
                    MainActivity.catalogue.Add(book);

                }catch (ValidateExcepsion excepsion)
                {
                    Toast.makeText(getContext(), excepsion.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return viewContent;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public String get_fragmentName() {
        return "Add_Delete Fragment";
    }

    @Override
    public void onAttaching() {

    }
}
