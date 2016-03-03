package co.edu.udea.compumovil.gr8.lab1ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import java.util.ArrayDeque;


public class MainActivity extends AppCompatActivity {
    TextView dataContact;
    EditText nameText;
    EditText lastNameText;
    EditText addressText;
    EditText countryText;
    EditText emailText;
    EditText phoneText;
    RadioGroup radioGroup;
    DatePicker datePicker;
    String favorito;
    Spinner spinner;
    int year;
    int month;
    int day;
    String[] countries;
    String Gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner de hobbies
        Spinner hobbiesSpinner = (Spinner) findViewById(R.id.hobbiesSpinner);
        ArrayAdapter<CharSequence> hobbiesArray = ArrayAdapter.createFromResource(this,
                R.array.hobbies, android.R.layout.simple_spinner_item);
        hobbiesArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hobbiesSpinner.setAdapter(hobbiesArray);

        //autocompletar
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.countryNameField);
        countries = getResources().getStringArray(R.array.countries);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, countries);
        textView.setAdapter(adapter);


    }

    public void showContactData(View view) {


        nameText = (EditText) findViewById(R.id.nameField);
        lastNameText = (EditText) findViewById(R.id.lastNameField);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupGender);
        datePicker = (DatePicker) findViewById(R.id.datePicker1);
        countryText = (EditText) findViewById(R.id.countryNameField);
        phoneText = (EditText) findViewById(R.id.phoneNumberField);
        addressText = (EditText) findViewById(R.id.personAddressField);
        emailText = (EditText) findViewById(R.id.personEmailField);
        final CheckBox favourite = (CheckBox) findViewById(R.id.favouriteCheckbox);
        spinner = (Spinner) findViewById(R.id.hobbiesSpinner);


        String name = nameText.getText().toString();

        String lastName = lastNameText.getText().toString();

        // Radio group
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButt = (RadioButton) findViewById(radioButtonID);
        //radioButt =(RadioButton) findViewById(radioButtonID);
        Gender = radioButt.getText().toString();

        year = datePicker.getYear();
        month = datePicker.getMonth();
        day = datePicker.getDayOfMonth();


        String country = countryText.getText().toString();

        String phoneAux = phoneText.getText().toString();

        String address = addressText.getText().toString();

        String email = emailText.getText().toString();

        favorito = getString(R.string.isNotFavourite);
        if (favourite.isChecked()) {
            favorito = getString(R.string.isFavourite);
            favourite.setChecked(false);

        }
        //Toast.makeText(MainActivity.this, favorito, Toast.LENGTH_SHORT).show();

        String hobbiesString = spinner.getSelectedItem().toString();

        String[] header = getResources().getStringArray(R.array.header);

        if (name.equals("") || lastName.equals("") || country.equals("") || email.equals("") || address.equals("") || phoneAux.equals("")) {
            String messageAdvice = getResources().getString(R.string.noFilledMessage);
            Toast.makeText(MainActivity.this, messageAdvice, Toast.LENGTH_SHORT).show();
        } else {

            int phone = Integer.parseInt(phoneText.getText().toString());

            dataContact = (TextView) findViewById(R.id.dataText);
            dataContact.setText("");

            dataContact.append(header[0] + ": " + name + "\n");
            dataContact.append(header[1] + ": " + lastName + "\n");
            dataContact.append(header[2] + ": " + Gender + "\n");
            dataContact.append(header[3] + ": " + country + "\n");
            dataContact.append(header[4] + ": " + phone + "\n");
            dataContact.append(header[5] + ": " + address + "\n");
            dataContact.append(header[6] + ": " + email + "\n");
            dataContact.append(header[7] + ": " + day + " " + "/" + " " + selectMonth(month) + " " + "/" + " " + year + "\n");
            dataContact.append(header[8] + ": " + hobbiesString + "\n");
            dataContact.append(favorito);

        }
    }
    private String selectMonth(int monthParam){

        String month;
        String[] months = getResources().getStringArray(R.array.months);
        month=months[monthParam];

        return month;
    }

    public void confirmContactData (View view){
        String message = getResources().getString(R.string.confirmMessage);
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }


}
