package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";
    private static final String CYCLE_TAG = "LifeCycle";
    private static final String SAVED_TEXT = "SavedText";
    public static final  String ARRAY_TAG = "ArrayTag";
    private ArrayList<ListItemH> listThing = new ArrayList<ListItemH>();
    boolean isItNums = false;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(CYCLE_TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*if(savedInstanceState!=null){
            TextView textVie = (TextView) findViewById(R.id.textView3);
            textVie.setText(savedInstanceState.getString(SAVED_TEXT,""));
        }*/

        if(findViewById(R.id.frameLayout)!=null){
            fragmentReplacement(LemsFragment.newInstance());
        }
    }
    public void switchFragment(View view){
        if(isItNums){
            fragmentReplacement(LemsFragment.newInstance());

        }else{
            fragmentReplacement(NumsFragment.newInstance());
            //Log.d(TAG,"its working!!!!!");
        }
        isItNums = !isItNums;
    }
    private void fragmentReplacement(Fragment fragment){
        //Log.d(TAG,"its working!");
        FragmentManager mngr = getSupportFragmentManager();
        FragmentTransaction trs = mngr.beginTransaction();
        trs.replace(R.id.frameLayout,fragment);
        trs.commit();
    }
    public void nextWindow(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }
    /*public void sendMessage(View view) {
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText editText1 = (EditText) findViewById(R.id.editTextTextPersonName2);
        String message = getString(R.string.result_ssum) + editText.getText().toString() + " " + editText1.getText().toString();
        TextView textVie = (TextView) findViewById(R.id.textView3);
        textVie.setText(message);
        Toast toast = Toast.makeText(this,editText.getText().toString() + " " + editText1.getText().toString(),Toast.LENGTH_SHORT);
        toast.show();
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    public void addToList(ListItemH newItem){
        listThing.add(newItem);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(this, ListActivity.class);
                intent.putParcelableArrayListExtra(ARRAY_TAG,listThing);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outstate){
       /* TextView textVie = (TextView) findViewById(R.id.textView3);
        outstate.putString(SAVED_TEXT,textVie.getText().toString());*/
        Log.d(CYCLE_TAG,"onSaveInstanceState");
        super.onSaveInstanceState(outstate);
    }
    @Override
    protected void onStart(){
        Log.d(CYCLE_TAG,"onStart");
        super.onStart();
    }
    @Override
    protected void onResume(){
        Log.d(CYCLE_TAG,"onResume");
        super.onResume();
    }
    @Override
    protected void onPause(){
        Log.d(CYCLE_TAG,"onPause");
        super.onPause();
    }
    @Override
    protected void onStop(){
        Log.d(CYCLE_TAG,"onStop");
        super.onStop();
    }
    @Override
    protected void onDestroy(){
        Log.d(CYCLE_TAG,"onDestroy");
        super.onDestroy();
    }

}