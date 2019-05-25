package com.danny.attendancemanager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //firebaseAuth.signOut();
        finish();
        startActivity(new Intent(MainActivity.this,AboutActivity.class));
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Really Exit ??");
        builder.setTitle("Exit");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok",new MyListener());
        builder.setNegativeButton("Cancel",null);
        builder.show();
    }
    public class MyListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        }
    }

    public void fn(View view){
        try{
            if(view.getId()==R.id.teacherButton){
                // Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,TeacherLogin.class);
                startActivity(intent);
            }
            else{
                Intent intent2=new Intent(MainActivity.this,StudentLogin.class);
                startActivity(intent2);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
