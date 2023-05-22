package algonquin.cst2335.riya0004.data.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import algonquin.cst2335.riya0004.R;
import algonquin.cst2335.riya0004.data.MainViewModel;
import algonquin.cst2335.riya0004.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainViewModel model;
    private ActivityMainBinding variableBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());

        Button btn = findViewById(R.id.mybutton);
        TextView mytext = variableBinding.textview;
        EditText myedit = findViewById(R.id.editText);
        String editString = myedit.getText().toString();
        mytext.setText("Your edit has: "+editString);

        btn.setOnClickListener( (View v) -> {mytext.setText("Your edit text has: " + editString);});

//        variableBinding.textview.setText(model.editString);
        variableBinding.mybutton.setOnClickListener(click ->
        {
            model.editString.postValue(variableBinding.editText.getText().toString());
            variableBinding.textview.setText("Your edit text has: "+ model.editString);
        });

        model.editString.observe(this, s -> {
           variableBinding.textview.setText("Your edit text has: "+s);
        });
    }

}