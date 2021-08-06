package justinwallace.coinscollection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
 private EditText nameET;
 private EditText quartersET;
 private EditText dimesET;
 private EditText nickelsET;
 private EditText penniesET;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referenceUIcomponents();


    }

    public void computeCoinValues (View view)
    {
     final int divisor = 100;

     final int quarterValue = 25;
     final int dimeValue = 10;
     final int nickelValue = 5;
     final int pennieValue = 1;
     String name = nameET.getText().toString();
     int numQuarters = Integer.valueOf(quartersET.getText().toString());
     int numDimes = Integer.valueOf(dimesET.getText().toString());
     int numNickels = Integer.valueOf(nickelsET.getText().toString());
     int numPennies = Integer.valueOf(penniesET.getText().toString());
     int totalValueQ;
     int totalValueD;
     int totalValueN;
     int totalValueP;
     int totalValue;
     int remander;
     int dollars;
     int cents;

     totalValueQ = quarterValue * numQuarters;
     totalValueD = dimeValue * numDimes;
     totalValueN = nickelValue * numNickels;
     totalValueP = pennieValue * numPennies;
     totalValue = totalValueQ + totalValueD + totalValueN + totalValueP;
     remander = totalValue % divisor;
     totalValue = totalValue - remander;
     dollars = totalValue / divisor;
     cents = remander;

     String output = "Hello "+name+"\nYour coins are worth "+dollars+" dollars and "+cents+" cents. Bye!";
        Intent outputIntent = new Intent(MainActivity.this,OutputActivity.class);
        outputIntent.putExtra("outputTV",output);
        startActivity(outputIntent);

    }



    private void referenceUIcomponents()
    {
     nameET = (EditText) findViewById(R.id.CustomerNameEditText);
     quartersET = (EditText) findViewById(R.id.QuartersEditText);
     dimesET = (EditText) findViewById(R.id.DimesEditText);
     nickelsET = (EditText) findViewById(R.id.NickelsEditText);
     penniesET = (EditText) findViewById(R.id.PenniesEditText);
    }



}
