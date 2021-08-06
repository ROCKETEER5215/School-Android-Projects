package justinwallace.coinscollection;

/**
 * Created by Justin Wallace on 4/8/2017.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        TextView outputTV = (TextView) findViewById(R.id.outputTextView);
        Intent intent = getIntent();
        String output;
        output = intent.getStringExtra("outputTV");
        outputTV.setText(output);
    }
}
