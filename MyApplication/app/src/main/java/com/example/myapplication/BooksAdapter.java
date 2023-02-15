package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import books_catalogue.Book;
import ui_tools.CatalogManager;
import ui_tools.ValidateExcepsion;

public class BooksAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Book> objects;

    View currentView;

    LibraryFragment fragment;

    public BooksAdapter(Context context, ArrayList<Book> books)
    {
        ctx = context;
        objects = books;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int i) {
        return objects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = lInflater.inflate(R.layout.custom_catalogue_layout, viewGroup, false);
            currentView = view;
        }

        Book book = (Book) getItem(i);

        TextView binding = view.findViewById(R.id.textView_binding_value);
        TextView author = view.findViewById(R.id.textView_author_value);
        TextView pages = view.findViewById(R.id.textView_pages_value);
        TextView publisher = view.findViewById(R.id.textView_publisher_value);
        TextView price = view.findViewById(R.id.textView_price_value);
        TextView title = view.findViewById(R.id.textView_title_value);
        TextView year = view.findViewById(R.id.textView_year_value);

        binding.setText(book.getBinding());
        author.setText(book.getAuthor());
        pages.setText(book.getStrPages());
        publisher.setText(book.getPublisher());
        price.setText(book.getStrPrice());
        title.setText(book.getTitle());
        year.setText(book.getStrYear());

        Button button_delete = view.findViewById(R.id.button_delete);
        button_delete.setOnClickListener(clickListener);
        button_delete.setTag(i);
        return view;
    }

    Book getBook(int position)
    {
        return (Book)getItem(position);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int i = (Integer) view.getTag();
            Book b = getBook(i);
            objects.remove(b);
            if(fragment != null)
            {
                fragment.onAttaching();
            }
        }
    };

    public void set_Fragment(CatalogueFragment fr)
    {
         fragment = fr;
    }
}
