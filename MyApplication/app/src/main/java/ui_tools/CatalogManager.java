package ui_tools;


import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;

import books_catalogue.Book;

public class CatalogManager {

        EditValidator editValidator;

        public CatalogManager()
        {
                editValidator = new EditValidator();
        }
    public Book ReadAddView(View view) throws ValidateExcepsion {
            EditText title_edit = view.findViewById(R.id.edit_add_title);
            String title = title_edit.getText().toString();

            title = editValidator.Validate(title, EditValidator.TITLE_PATTERN);

            EditText author_edit = view.findViewById(R.id.edit_add_author);
            String author = String.valueOf(author_edit.getText());

            author = editValidator.Validate(author, EditValidator.TITLE_PATTERN);

            EditText publisher_edit = view.findViewById(R.id.edit_add_publisher);
            String publisher = String.valueOf(publisher_edit.getText());

            publisher = editValidator.Validate(publisher, EditValidator.TITLE_PATTERN);

            EditText year_edit = view.findViewById(R.id.edit_add_year);
            String year = String.valueOf(year_edit.getText());

            int iyear = Integer.parseInt(editValidator.Validate(year, EditValidator.D_PATTERN));

            EditText pages_edit = view.findViewById(R.id.edit_add_pages);
            String pages = String.valueOf(pages_edit.getText());

            int ipages =  Integer.parseInt(editValidator.Validate(pages, EditValidator.D_PATTERN));


            EditText price_edit = view.findViewById(R.id.edit_add_price);
            String price =  String.valueOf(price_edit.getText());

            double dprice = Double.parseDouble(editValidator.Validate(price, EditValidator.MONEY_PATTERN));

            EditText binding_edit = view.findViewById(R.id.edit_add_binding);
            String binding = String.valueOf(binding_edit.getText());

            binding = editValidator.Validate(binding, EditValidator.TITLE_PATTERN);

            Book book = new Book(title, author, publisher, iyear, ipages, dprice, binding);

            return book;

    }
}
