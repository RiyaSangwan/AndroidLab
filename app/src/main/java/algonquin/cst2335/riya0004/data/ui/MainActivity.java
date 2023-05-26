package algonquin.cst2335.riya0004.data.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
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

        TextView mytext = variableBinding.textview;
        Button btn = variableBinding.mybutton;
        EditText myedit = variableBinding.editText;
        CheckBox checkBox = variableBinding.checkBox;
        Switch switch1 = variableBinding.switch1;
        RadioButton radioButton = variableBinding.radioButton;
        ImageView imageView = variableBinding.imageview;
        ImageButton imageButton = variableBinding.imagebutton;

//        variableBinding.textview.setText(model.editString);

        model.editString.observe(this, s -> {
           variableBinding.textview.setText("Your edit text has: "+s);
        });
        variableBinding.mybutton.setOnClickListener(click ->
        {
            model.editString.postValue(variableBinding.editText.getText().toString());
        });

        model.isSelected.observe(this, selected ->{
            variableBinding.checkBox.setChecked(selected);
            variableBinding.radioButton.setChecked(selected);
            variableBinding.switch1.setChecked(selected);
        });

     checkBox.setOnCheckedChangeListener((mycheckBox,isChecked)->{
         model.isSelected.postValue(isChecked);
     });
     switch1.setOnCheckedChangeListener((myswitch,isChecked)->{
            model.isSelected.postValue(isChecked);
     });
     radioButton.setOnCheckedChangeListener((myradiobutton,isChecked)->{
            model.isSelected.postValue(isChecked);
     });
    }

}