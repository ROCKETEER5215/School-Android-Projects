package justinwallace.rentalcar;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * Created by Justin Wallace on 4/15/2017.
 */

public class InputFragment extends Fragment implements AdapterView.OnItemSelectedListener
{

 private Spinner days;
 private Spinner vehicle;
 private CheckBox insuredDriver;
 private CheckBox prepay;
 private TextView label;
 private TextView labelD;
 private EditText numD;
 private Activity activity ;
 private Button cost;
    boolean ID = false;
    boolean PG = false;

 public void onAttach(Activity activity)
 {
  super.onAttach(activity);
  this.activity = activity;
 }


 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
 {
  View v = inflater.inflate(R.layout.fragment_input,container,false);

  days = (Spinner) v.findViewById(R.id.DaysSpinner);
  days.setOnItemSelectedListener(this);
  ArrayAdapter<CharSequence> daysAdapter = ArrayAdapter.createFromResource(this.getActivity(),
          R.array.numOfDays,android.R.layout.simple_spinner_item);
     daysAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
     days.setAdapter(daysAdapter);


  vehicle = (Spinner) v.findViewById(R.id.VehicleSpinner);
  vehicle.setOnItemSelectedListener(this);
     ArrayAdapter<CharSequence> vehicleAdapter = ArrayAdapter.createFromResource(this.getActivity(),
             R.array.Vehicle,android.R.layout.simple_spinner_item);
     vehicleAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
     vehicle.setAdapter(vehicleAdapter);



  insuredDriver = (CheckBox) v.findViewById(R.id.InsuredCheckBox);
  prepay = (CheckBox) v.findViewById(R.id.PrepayCheckBox);


  insuredDriver.setOnCheckedChangeListener(Inputchecked);
  prepay.setOnCheckedChangeListener(Inputchecked);

  cost = (Button) v.findViewById(R.id.CostButton);
  cost.setOnClickListener(buttonChecked);

  label = (TextView) v.findViewById(R.id.textView);
  labelD = (TextView) v.findViewById(R.id.textView2);

  numD = (EditText) v.findViewById(R.id.editText);


  return v;
 }

 public void onItemSelected(AdapterView<?> parent,View view, int pos, long id)
 {
  Spinner spinner = (Spinner) parent;

  if(spinner.getId() == R.id.DaysSpinner)
  {

   if(parent.getSelectedItem()==null)
   {
    return;
   }
   else
   {
       try {
           int item1 = Integer.parseInt( parent.getSelectedItem().toString());
           ((onInputSelectedListener1) activity).onInputSelected1(item1);
       }catch (ClassCastException cce){}
   }
  }
  if(spinner.getId() == R.id.VehicleSpinner)
  {
   if(parent.getSelectedItem()==null)
   {
    return;
   }
   else
   {
    String item2 = parent.getSelectedItem().toString();
     try {
         ((onInputSelectedListener2) activity).onInputSelected2(item2);
     }catch (ClassCastException cce){}
   }
  }

 }
 public void onNothingSelected(AdapterView<?> parent)
 {

 }

 public  CompoundButton.OnCheckedChangeListener Inputchecked = new CompoundButton.OnCheckedChangeListener()
 {

  public void onCheckedChanged(CompoundButton v,boolean isChecked)
  {

   switch (v.getId())
   {
    case R.id.InsuredCheckBox:
     if(isChecked)
      ID = true;
     else
      ID = false;
     break;

    case R.id.PrepayCheckBox:
    if (isChecked)
     PG = true;
    else
     PG = false;
     break;
   }
   try {
       ((onInputClickedListener) activity).onInputClicked( ID, PG);
   }catch (ClassCastException cce){}
  }
 };


 private View.OnClickListener buttonChecked = new View.OnClickListener()
 {

  public void onClick(View v)
  {
   boolean isClicked = true;

   try {
    int ND = Integer.parseInt( numD.getText().toString());
    ((onEditTextListener) activity).onEditText(ND);
   }catch (ClassCastException cce){}


      try {
          ((onButtonClickedListener) activity).ButtonClicked(isClicked);
      }catch (ClassCastException cce){}

  }
 };

 public interface onEditTextListener
 {
  public void onEditText(int num);
 }

 public interface onButtonClickedListener
 {
  public void ButtonClicked(boolean isCost);
 }

 public  interface onInputSelectedListener1
 {
  public  void onInputSelected1(int days);
 }

 public interface onInputSelectedListener2
 {
  public void onInputSelected2(String vehicle);
 }

 public interface onInputClickedListener
 {
  public void onInputClicked(boolean InsuredCB,boolean PrepayCB);
 }

}
