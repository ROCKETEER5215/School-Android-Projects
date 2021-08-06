package justinwallace.horseauction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
 private ImageView AbbyImageView;
 private ImageView RascalImageView;
 private boolean isAbby;
 private boolean isRascal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AbbyImageView = (ImageView) findViewById(R.id.imageViewAbby);
        RascalImageView = (ImageView) findViewById(R.id.imageViewRascal);

        initializeImageViews();

        Button AbbyBtn = (Button) findViewById(R.id.buttonAbby);
        Button BothBtn = (Button) findViewById(R.id.buttonBoth);
        Button RascalBtn = (Button) findViewById(R.id.buttonRascal);

        AbbyBtn.setOnClickListener(toggleAbby);
        BothBtn.setOnClickListener(toggleBoth);
        RascalBtn.setOnClickListener(toggleRascal);
    }

    private final View.OnClickListener toggleAbby = new View.OnClickListener()
    {
     public void onClick(View btn)
     {
      if(isAbby)
      {
       isAbby = false;
       AbbyImageView.setVisibility(View.INVISIBLE);
      }
      else
      {
       isAbby = true;
       AbbyImageView.setVisibility(View.VISIBLE);
      }
     }
    };

    private final View.OnClickListener toggleBoth = new View.OnClickListener()
    {
        public void onClick(View btn)
        {
            if(isAbby && isRascal)
            {
                isAbby = false;
                isRascal = false;
                AbbyImageView.setVisibility(View.INVISIBLE);
                RascalImageView.setVisibility(View.INVISIBLE);
            }
            else
            {
                isAbby = true;
                isRascal = true;
                AbbyImageView.setVisibility(View.VISIBLE);
                RascalImageView.setVisibility(View.VISIBLE);
            }
        }
    };

    private final View.OnClickListener toggleRascal = new View.OnClickListener()
    {
        public void onClick(View btn)
        {
            if(isRascal)
            {
                isRascal = false;
                RascalImageView.setVisibility(View.INVISIBLE);
            }
            else
            {
                isRascal = true;
                RascalImageView.setVisibility(View.VISIBLE);
            }
        }
    };

    private void initializeImageViews()
    {
     isAbby = false;
     isRascal = false;
    }
}
