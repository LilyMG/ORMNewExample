package com.example.lilit.ormnewexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    DBHelper dbHelper;
    RuntimeExceptionDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        dao = dbHelper.getRuntimeExceptionDao(User.class);
        User firstUser =new User("some", "password");
      //  dao.create(firstUser);
      //  dao.create(new User("lilit", "password"));
      //  dao.create(new User("lilit1", "password1"));
        List allUsers = dao.queryForAll();
        for (int i = 0; i <allUsers.size() ; i++) {
            Log.d(DBConstants.LOG, allUsers.get(i).toString());
        }
        for(Object user: allUsers){
            if(((User) user).getUsername().equals("lilit")){
                dao.update(new User ("taza some", "taza password"));
            }
        }
        Log.d(DBConstants.LOG, "after update");
        allUsers = dao.queryForAll();
        for (int i = 0; i <allUsers.size() ; i++) {
            Log.d(DBConstants.LOG, allUsers.get(i).toString());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
