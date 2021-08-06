package justinwallace.flagsofstates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity
{
 private ImageView flag;
 private TextView output;
 private Button button1;
 private Button button2;
 private Button button3;
 private Button button4;
 private Button button5;
 private int currentFlag;
 private int currentStateB1;
 private int currentStateB2;
 private int currentStateB3;
 private int currentStateB4;
 private int currentStateB5;
 private Integer[] array = {1,2,3,4,5};
 private int newArraysize = 5;


 @Override
 protected void onCreate(Bundle savedInstanceState)
 {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  flag = (ImageView) findViewById(R.id.imageView);
  output = (TextView) findViewById(R.id.textView);
  button1 = (Button) findViewById(R.id.button1);
  button2 = (Button) findViewById(R.id.button2);
  button3 = (Button) findViewById(R.id.button3);
  button4 = (Button) findViewById(R.id.button4);
  button5 = (Button) findViewById(R.id.button5);

  button1.setOnClickListener(buttonCheck);
  button2.setOnClickListener(buttonCheck);
  button3.setOnClickListener(buttonCheck);
  button4.setOnClickListener(buttonCheck);
  button5.setOnClickListener(buttonCheck);

  randomGenerator();
 }

 private final View.OnClickListener buttonCheck = new View.OnClickListener()
 {
  @Override
  public void onClick(View v)
  {
   switch (v.getId())
   {
    case R.id.button1:
     if(currentFlag == currentStateB1)
     {
      output.setText("Correct!");
      randomGenerator();
     }else
      {
       output.setText("Incorrect!");
      }
     break;

    case R.id.button2:
     if(currentFlag == currentStateB2)
     {
      output.setText("Correct!");
      randomGenerator();
     }else
      {
       output.setText("Incorrect!");
      }
     break;

    case R.id.button3:
     if(currentFlag == currentStateB3)
     {
      output.setText("Correct!");
      randomGenerator();
     }else
      {
       output.setText("Incorrect!");
      }
     break;

    case R.id.button4:
     if(currentFlag == currentStateB4)
     {
      output.setText("Correct!");
      randomGenerator();
     }else
      {
       output.setText("Incorrect!");
      }
     break;

    case R.id.button5:
     if(currentFlag == currentStateB5)
     {
      output.setText("Correct!");
      randomGenerator();
     }else
      {
       output.setText("Incorrect!");
      }
     break;
   }
  }
 };


 private void randomGenerator()
 {
  currentFlag = getRandom();
  setFlag(currentFlag);

  currentStateB1 = getRandomFromArray();
  setButton(currentStateB1, 1);
  array = removeIntFromArray(currentStateB1);
  shuffleArray(array);

  currentStateB2 = getRandomFromArray();
  setButton(currentStateB2, 2);
  array = removeIntFromArray(currentStateB2);


  currentStateB3 = getRandomFromArray();
  setButton(currentStateB3, 3);
  array = removeIntFromArray(currentStateB3);


  currentStateB4 = getRandomFromArray();
  setButton(currentStateB4, 4);
  array = removeIntFromArray(currentStateB4);


  currentStateB5 = getRandomFromArray();
  setButton(currentStateB5, 5);

  array = resetArray();


 }


 private void setFlag(int stateFlag)
 {
  switch (stateFlag)
  {
   case 1:
    flag.setBackgroundResource(R.drawable.flag_of_new_york);
    break;
   case 2:
    flag.setBackgroundResource(R.drawable.flag_of_california);
    break;
   case 3:
    flag.setBackgroundResource(R.drawable.flag_of_hawaii);
    break;
   case 4:
    flag.setBackgroundResource(R.drawable.flag_of_arizona);
    break;
   case 5:
    flag.setBackgroundResource(R.drawable.flag_of_alaska);
    break;
  }
 }


 private void setButton (int state,int button)
 {
  switch (button)
  {
   case 1:
    if(state == 1)
     button1.setText("New York");
    if(state == 2)
     button1.setText("California");
    if(state == 3)
     button1.setText("Hawaii");
    if(state == 4)
     button1.setText("Arizona");
    if(state == 5)
     button1.setText("Alaska");
    break;

   case 2:
    if(state == 1)
     button2.setText("New York");
    if(state == 2)
     button2.setText("California");
    if(state == 3)
     button2.setText("Hawaii");
    if(state == 4)
     button2.setText("Arizona");
    if(state == 5)
     button2.setText("Alaska");
    break;

   case 3:
    if(state == 1)
     button3.setText("New York");
    if(state == 2)
     button3.setText("California");
    if(state == 3)
     button3.setText("Hawaii");
    if(state == 4)
     button3.setText("Arizona");
    if(state == 5)
     button3.setText("Alaska");
    break;

   case 4:
    if(state == 1)
     button4.setText("New York");
    if(state == 2)
     button4.setText("California");
    if(state == 3)
     button4.setText("Hawaii");
    if(state == 4)
     button4.setText("Arizona");
    if(state == 5)
     button4.setText("Alaska");
    break;

   case 5:
    if(state == 1)
     button5.setText("New York");
    if(state == 2)
     button5.setText("California");
    if(state == 3)
     button5.setText("Hawaii");
    if(state == 4)
     button5.setText("Arizona");
    if(state == 5)
     button5.setText("Alaska");
    break;
  }
 }


 private int getRandomFromArray()
 {
  Random num = new Random();
  int number;
  number = array[num.nextInt(array.length)];


  return number;
 }


 private int getRandom()
 {
  int min = 1;
  int max = 5;
  int number;

  Random num = new Random();
  number = num.nextInt((max - min) + 1) + min;

  return number;
 }


 private Integer[] removeIntFromArray(int num)
 {
  newArraysize = newArraysize - 1;
  int j = 0;
  Integer[]newArray = new Integer[newArraysize];

  for (int i=0;i<array.length;i++)
  {
   if(array[i] != num)
   {
    newArray[j++] = array[i];
   }
  }

  return newArray;
 }

 private void shuffleArray(Integer[] a)
 {
  Collections.shuffle(Arrays.asList(a));
 }


 private Integer[] resetArray()
 {
  Integer[]newArray = {1,2,3,4,5};

  newArraysize = 5;

  shuffleArray(newArray);

  return newArray;
 }


}
