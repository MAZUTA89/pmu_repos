package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import books_catalogue.Book;
import ui_tools.EditValidator;

public class AuthorsFragment extends LibraryFragment {
    @Override
    public String get_fragmentName() {
        return "Authors fragment";
    }
    EditValidator  editValidator;
    EditText authorText;
    Button button;
    TextView v;


    @Override
    public View CreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_authors_layout,container, false);
        editValidator = new EditValidator();
        booksListView = view.findViewById(R.id.list_view_year);
        authorText = view.findViewById(R.id.edit_text_year);
        button = view.findViewById(R.id.button_find_year);

        button.setOnClickListener(onClickListener);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttaching() {

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String author = authorText.getText().toString();
            ArrayList<Book> list = new ArrayList<>();
            list = MainActivity.catalogue.findAuthor(author);


            BooksAdapter adapter = new BooksAdapter(getContext(), list);
            booksListView.setAdapter(adapter);

            /*if(editValidator.IsValid(author, EditValidator.TITLE_PATTERN))
            {
                list = MainActivity.catalogue.findAuthor(author);
                UpdateAdapter(list);

            }else{
                Toast.makeText(getContext(), "Fail input", Toast.LENGTH_SHORT);
            }*/
        }
    };


}
