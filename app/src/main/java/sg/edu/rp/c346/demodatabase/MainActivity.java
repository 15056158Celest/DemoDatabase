package sg.edu.rp.c346.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnGetTasks;
    TextView tvResults;
    ListView lv;
    ArrayList<Task> al;
    ArrayAdapter aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnGetTasks = (Button) findViewById(R.id.btnGetTask);
        tvResults = (TextView)  findViewById(R.id.tvGetTask);
        lv = (ListView) findViewById(R.id.lv);


        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.insertTask("Do Homework", "30 Apr 2016");
                db.close();
            }
        });


        btnGetTasks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db2 = new DBHelper(MainActivity.this);
                al = db2.getTasks();
                db2.close();

                aa = new customAdapter(MainActivity.this, R.layout.row, al);
                lv.setAdapter(aa);
            }
        });
    }
}

