package justinwallace.taxcalculator;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements InputFragment.onEditTextListener ,
        InputFragment.onSelectedListener, InputFragment.onButtonClickedListener
{
 private double Income;
 private double amountOver;
 private double taxablePercetage;
 private double tax;
 private boolean MFJointly;
 private boolean MFSeparately;
 private boolean HOfHouse;
 private boolean Single;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

     InputFragment input = new InputFragment();
     setFragment(input);
    }



 public void onEditText(double income)
 {
  Income = income;
 }

 public void onSelected(boolean MFJ,boolean MFS, boolean HOH, boolean S)
 {
  if(MFJ)
  {
   MFJointly = true;
  }else
   {
    MFJointly = false;
   }

  if(MFS)
  {
   MFSeparately = true;
  }else
   {
    MFSeparately = false;
   }

  if(HOH)
  {
   HOfHouse = true;
  }else
   {
    HOfHouse = false;
   }

  if(S)
  {
   Single = true;
  }else
   {
    Single = false;
   }

 }

 public void onButtonClicked(boolean isComputeTax)
 {
  if(isComputeTax)
  {
   if(Single)
   {
    amountOver = 49300.00;
    taxablePercetage = 0.31;
    tax = 11158.50;
   }

   if(MFJointly)
   {
    if(Income > 34000 && Income <= 82150)
    {
     amountOver = 34000;
     taxablePercetage = 0.28;
     tax = 5100.00;
    }else
     {
      amountOver = 82150;
      taxablePercetage = 0.31;
      tax = 18582.00;
     }
   }

   if(MFSeparately)
   {
    amountOver = 41075;
    taxablePercetage = 0.31;
    tax = 9291.00;
   }

   if(HOfHouse)
   {
    if(Income > 27300 && Income <= 70450)
    {
     amountOver = 27300;
     taxablePercetage = 0.28;
     tax = 4095.00;
    }else
     {
      amountOver = 70450;
      taxablePercetage = 0.31;
      tax = 16177.00;
     }
   }

   computeTax();
  }
 }

 public void computeTax()
 {
  double taxDue;
  String output;

  taxDue = tax + (taxablePercetage * (Income - amountOver));

  output = "You owe $"+ taxDue +" in taxes.";

  OutputFragment fragString = new OutputFragment();
  Bundle bundle = new Bundle();
  bundle.putString("totalTax",output);
  fragString.setArguments(bundle);
  setFragment(fragString);

 }

 public void setFragment(Fragment f)
 {
  FragmentManager fm = getFragmentManager();
  if(fm.findFragmentById(R.id.fragment_container)==null)
  {
   fm.beginTransaction().add(R.id.fragment_container,f).addToBackStack(null).commit();
  }else
   {
    fm.beginTransaction().replace(R.id.fragment_container,f).addToBackStack(null).commit();
   }
 }

}
