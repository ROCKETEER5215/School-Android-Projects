package justinwallace.taxcalculator;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Created by Justin Wallace on 4/20/2017.
 */

public class InputFragment extends Fragment
{
 private Activity activity;
 private EditText income;
 private RadioGroup filing;
 private Button Tax;
 private boolean MFJ = false;
 private boolean MFS = false;
 private boolean S = false;
 private boolean HOH = false;


 public void onAttach(Activity activity)
 {
  super.onAttach(activity);
  this.activity = activity;
 }

 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
 {
  View v = inflater.inflate(R.layout.fragment_input,container,false);

  income = (EditText) v.findViewById(R.id.TaxIncomeEditText);
  filing = (RadioGroup) v.findViewById(R.id.radioGroup);
  Tax = (Button) v.findViewById(R.id.button);

  filing.setOnCheckedChangeListener(radioChecked);
  Tax.setOnClickListener(buttonCheck);

  return v;
 }

 private RadioGroup.OnCheckedChangeListener radioChecked = new RadioGroup.OnCheckedChangeListener()
 {
  @Override
  public void onCheckedChanged(RadioGroup v, int id)
  {

   switch (id)
   {
    case R.id.SingleRadioButton:
     if(S)
      S = false;
     else
      S = true;
      HOH = false;
      MFS = false;
      MFJ = false;
     break;
    case R.id.HeadOfHouseholdRadioButton:
     if(HOH)
      HOH = false;
     else
      HOH = true;
      S = false;
      MFS = false;
      MFJ = false;
     break;
    case R.id.MFSeparatelyRadioButton:
     if(MFS)
      MFS = false;
     else
      MFS = true;
      S = false;
      MFJ = false;
      HOH = false;
     break;
    case R.id.MFJonintlyRadioButton:
     if(MFJ)
      MFJ = false;
     else
      MFJ = true;
      S = false;
      MFS = false;
      HOH = false;
     break;
   }

   try
   {
    ((onSelectedListener)activity).onSelected(MFJ,MFS,HOH,S);
   }catch (ClassCastException cce){}

  }
 };

 private View.OnClickListener buttonCheck = new View.OnClickListener()
 {
  @Override
  public void onClick(View v)
  {
   boolean isClicked = true;

   try
   {
    double IC = Double.parseDouble(income.getText().toString());
    ((onEditTextListener)activity).onEditText(IC);
   }catch (ClassCastException cce){}

   try
   {
    ((onButtonClickedListener)activity).onButtonClicked(isClicked);
   }catch (ClassCastException cce){}
  }

 };




 public interface onEditTextListener
 {
  void onEditText(double income);
 }

 public interface onSelectedListener
 {
  void onSelected(boolean MFJ,boolean MFS, boolean HOH, boolean S);
 }

 public interface onButtonClickedListener
 {
  void onButtonClicked(boolean isComputeTax);
 }

}
