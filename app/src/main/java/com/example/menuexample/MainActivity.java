package com.example.menuexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, View.OnClickListener {
Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button1);
        registerForContextMenu(button1);
        button1.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mInflater=getMenuInflater();
        mInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_add:
                Intent mIntent=new Intent(MainActivity.this, Pickeractivity.class);
                startActivity(mIntent);
                Toast.makeText(MainActivity.this, "add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_edit:
                Toast.makeText(MainActivity.this,"edit",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                Toast.makeText(MainActivity.this,"delete",Toast.LENGTH_SHORT).show();
                break;
                default:
                    System.out.println("hello");
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater mInflater1=getMenuInflater();
        mInflater1.inflate(R.menu.menu_main,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_add:

                Toast.makeText(MainActivity.this,"add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_edit:
                Toast.makeText(MainActivity.this,"add",Toast.LENGTH_SHORT).show();
                break;
            default:
                System.out.println("hello");
        }
        return super.onOptionsItemSelected(item);

    }

    public void showMenu(View v){
        PopupMenu popup=new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_main);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.action_add:
                Log.d("Menu","add");
                return true;
            case R.id.action_edit:
                Log.d("Menu","edit");
                return true;
            case R.id.action_delete:
                Log.d("Menu","delete");
                return true;

default:return false;
        }
    }

    @Override
    public void onClick(View v) {
        showMenu(button1);

    }
}
