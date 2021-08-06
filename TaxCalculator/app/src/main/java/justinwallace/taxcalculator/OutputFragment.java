package justinwallace.taxcalculator;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Justin Wallace on 4/20/2017.
 */

public class OutputFragment extends Fragment
{

 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
 {
  View v = inflater.inflate(R.layout.fragment_output,container,false);

  String outputString = getArguments().getString("totalTax");
  TextView output;
  output = (TextView) v.findViewById(R.id.OutputTextView);
  output.setText(outputString);

  return v;
 }
}
