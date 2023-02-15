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

public class PublishersFragment extends LibraryFragment {
    @Override
    public String get_fragmentName() {
        return "Publishers fragment";
    }
    EditValidator editValidator;
    EditText authorText;
    Button button;
    TextView v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_publisher_layout,container, false);
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
            //Book b3 = new Book("Title3", "Author3", "Publisher3", 2001, 203, 100.3, "Bind3");
            list = MainActivity.catalogue.findPublisher(author);


            BooksAdapter adapter = new BooksAdapter(getContext(), list);
            booksListView.setAdapter(adapter);
        }
    };
}
