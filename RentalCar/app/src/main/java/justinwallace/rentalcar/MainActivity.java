package justinwallace.rentalcar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements InputFragment.onButtonClickedListener,InputFragment.onInputClickedListener,
        InputFragment.onInputSelectedListener1,InputFragment.onInputSelectedListener2,InputFragment.onEditTextListener
{
 private Fragment inputFragment;

 private int rentaldays=0;
 private int vehicleCost=0;
 private int gas=0;
 private final int multicost = 22;
 private int numOfDriver =1;
 private int insuranceCost=24;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFragment = new InputFragment();

        setFragment(inputFragment);
    }

    public void setFragment(Fragment f)
    {
        FragmentManager fm = getFragmentManager();
        if(fm.findFragmentById(R.id.fragment_container)==null)
        {
         fm.beginTransaction().add(R.id.fragment_container,f).addToBackStack(null).commit();
        }
        else
            {
             fm.beginTransaction().replace(R.id.fragment_container,f).addToBackStack(null).commit();
            }

    }

    public void onInputClicked(boolean InsuredCB,boolean PrepayCB)
    {

     if(InsuredCB)
     {
         insuranceCost = 0;
     }else
         {
             insuranceCost = 24;
         }

     if (PrepayCB)
     {
           gas = 52;
     }else
         {
             gas = 0;
         }
    }

    public void onInputSelected1(int days)
    {
     rentaldays = days;
    }

    public void onInputSelected2(String vehicle)
    {
     if(vehicle.equals("Jeep Wrangler"))
     {
      vehicleCost = 55;
     }
     if(vehicle.equals("Jeep Grand Cherokee"))
     {
      vehicleCost = 85;
     }
     if(vehicle.equals("Land Rover"))
     {
      vehicleCost = 125;
     }
    }

    public void onEditText(int num)
    {
     numOfDriver = num;
    }

    public void ButtonClicked(boolean isCost)
    {
     if(isCost)
     {
      computeCost();
     }
    }

   public void computeCost()
   {
       int costperday;
       int costperDriver;
       int totalCost;
       String output = " ";

    if(numOfDriver>1) {
        costperDriver = numOfDriver * multicost;
    }else
        {
         costperDriver = 0;
        }

    costperday = vehicleCost + costperDriver + insuranceCost;
    totalCost = costperday * rentaldays ;
    totalCost = totalCost + gas;
    output = "The total cost of your Rental is: $"+ totalCost;


       OutputFragment fragString = new OutputFragment();
    Bundle bundle = new Bundle();
    bundle.putString("total",output);

    fragString.setArguments(bundle);
    setFragment(fragString);
   }
}
