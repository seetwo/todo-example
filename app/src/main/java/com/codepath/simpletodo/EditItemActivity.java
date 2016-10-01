package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class EditItemActivity extends AppCompatActivity {

    EditText etEditItem;

    public final static String INPUT_POSITION = "inputPosition";
    public final static String EDITED_TEXT = "editedText";
    public final static String INPUT_TEXT = "inputText";
    public final static String EDITED_POSITION = "editedPosition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String itemText = getIntent().getStringExtra(INPUT_TEXT);
        etEditItem = (EditText) findViewById(R.id.etEditItem);
        etEditItem.setText(itemText);
        etEditItem.setSelection(etEditItem.getText().length());
        etEditItem.setSelection(etEditItem.getText().length());
    }

    public void saveTodoItem(View c) {
        EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
        int position = getIntent().getIntExtra(INPUT_POSITION, 0);
        Intent data = new Intent();
        data.putExtra(EDITED_TEXT, etEditItem.getText().toString());
        data.putExtra(EDITED_POSITION, position);
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }

}