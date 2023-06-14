package com.example.practical_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumber;
    String newNumber;
    String operator;
    Boolean isNew=true;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit=findViewById(R.id.editTextPers);
    }
public void clickNumber(View view){
        if(isNew)
            edit.setText("");
        isNew=false;
        String number=edit.getText().toString();
        switch (view.getId()){
            case R.id.buttonSew: number=number+"7";break;
            case R.id.buttonEight: number=number+"8";break;
            case R.id.buttonNine: number=number+"9";break;
            case R.id.buttonSix: number=number+"6";break;
            case R.id.buttonFive: number=number+"5";break;
            case R.id.buttonFore: number=number+"4";break;
            case R.id.buttonThree: number=number+"3";break;
            case R.id.buttonTwo: number=number+"2";break;
            case R.id.buttonOne: number=number+"1";break;
            case R.id.buttonZero: number=number+"0";break;
            case R.id.buttonSumRasn:
               if( minusIsPresent(number)){
                   number=number.substring(1);
               }else{
                   number="-"+number;
               }
                break;
            case R.id.buttonzap:
               if( dotIsPresent(number)) {

               }else{
                   number=number+".";
               }
               break;
        }
        edit.setText(number);
}

    public boolean minusIsPresent(String number) {
        if(number.charAt(0)=='-') {
            return true;
        } else{
            return false;
        }
    }

    public void Opperation(View view){
        isNew=true;
        oldNumber=edit.getText().toString();
        switch (view.getId()){
            case R.id.buttonDiv: operator=":";break;
            case R.id.buttonMult: operator="*";break;
            case R.id.buttonMinus: operator="-";break;
            case R.id.buttonPlas: operator="+";break;
        }
}
public void ClickRawno(View view){
        newNumber=edit.getText().toString();
        Double result=0.0;
    switch (operator){
        case "-": result=Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);break;
        case "+": result=Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);break;
        case "*": result=Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);break;
        case "/": result=Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);break;
    }
    edit.setText(result.toString());
}
public void ACClick(View view){
        edit.setText("0");
        isNew=true;
}
public boolean dotIsPresent(String number){
       if (number.indexOf(".")==-1) {
           return false;
       }else{
           return true;
       }
}

}