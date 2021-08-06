package justinwallace.greetings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{
 private TextView greetingTextView;
 private boolean isHello;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetingTextView = (TextView) findViewById(R.id.textView);
        greetingTextView.setText(" ");
        initializeGreeting();
        Button greetBtn = (Button) findViewById(R.id.button);
        greetBtn.setOnClickListener(toggleGreeting);

    }

 private final View.OnClickListener toggleGreeting = new View.OnClickListener()
 {
     @Override
     public void onClick(View btn)
     {
      if(isHello)
      {
       isHello = false;
       greetingTextView.setText(R.string.hello);
      }
      else
          {
           isHello = true;
           greetingTextView.setText(R.string.goodbye);
          }
     }

 };

 private void initializeGreeting()
 {
  isHello = true;
 }


}
