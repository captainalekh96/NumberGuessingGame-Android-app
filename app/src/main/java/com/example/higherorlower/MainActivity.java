package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randNo;
    int count;
    int level=1;


    public void reset(View view){
    this.level=1;
    Random ran=new Random();
    this.count=0;
    this.randNo= ran.nextInt(100);
        TextView textView = (TextView) findViewById(R.id.levelView);
        textView.setText("Level:- "+level);

}
public void generateRandom(){
            Random ran =new Random();
            this.randNo=ran.nextInt(randNo+100);
}
    public void numberRandom(View view){
        count++;
        EditText number = (EditText)findViewById(R.id.userNumber);
        int userno=Integer.parseInt(number.getText().toString());
        if(userno!=randNo){

            if(userno>randNo){
                Toast.makeText(this,"Lower",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Higher",Toast.LENGTH_SHORT).show();

            }
        }else{
            level++;

            Toast.makeText(this,"You got it correct in "+count+" Attempts",Toast.LENGTH_LONG).show();
            this.count=0;
            Toast.makeText(this,"Congratulations!!! You can't beat me this time.",Toast.LENGTH_LONG).show();
            number.getText().clear();
            Toast.makeText(this,"Level up to: "+level+" Can you Guess Now",Toast.LENGTH_LONG).show();
           generateRandom();
            Log.i("Randomnumber","number is"+randNo);
            TextView textView = (TextView) findViewById(R.id.levelView);

            textView.setText("Level:- "+level);

            // setContentView(R.layout.activity_main);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences prefs = this.getSharedPreferences("Mylevel", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("level", level);
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
        this.count=0;
        generateRandom();
        Log.i("Randomnumber","number is"+randNo);
        SharedPreferences prefs = this.getSharedPreferences("Mylevel", MODE_PRIVATE);
        level=prefs.getInt("level", 1);
        TextView textView1 = (TextView) findViewById(R.id.levelView);
       textView1.setText("Level:- "+level);
    }
}
