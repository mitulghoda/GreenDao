package com.vnnovate.greendao.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.vnnovate.greendao.Adapters.StudentDataAdapter;
import com.vnnovate.greendao.App;
import com.vnnovate.greendao.Entities.DaoSession;
import com.vnnovate.greendao.Entities.Student;
import com.vnnovate.greendao.Entities.StudentDao;
import com.vnnovate.greendao.R;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.query.Query;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StudentDao studentDao;
    private Query<Student> studentQuery;
    private List<Student> students;

    private TextView txt_name, txt_father, txt_contact, txt_standard;
    private Button btn_add, btn_show;
    private EditText edit_name, edit_father, edit_contact, edit_standard;
    private ListView lv_data;
    private StudentDataAdapter studentDataAdapter;

    private LinearLayout ll_add;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        studentDao = daoSession.getStudentDao();

        studentQuery = studentDao.queryBuilder().orderAsc(StudentDao.Properties.ID).build();
        students = studentQuery.list();

        Log.e("DATA", "" + studentQuery.list().size());


        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_father = (EditText) findViewById(R.id.edit_father);
        edit_contact = (EditText) findViewById(R.id.edit_contact);
        edit_standard = (EditText) findViewById(R.id.edit_standard);

        ll_add = (LinearLayout) findViewById(R.id.ll_add);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_show = (Button) findViewById(R.id.btn_show);

        lv_data = (ListView) findViewById(R.id.lv_data);

        txt_name = (TextView) findViewById(R.id.txt_name);
        txt_father = (TextView) findViewById(R.id.txt_father);
        txt_contact = (TextView) findViewById(R.id.txt_contact);
        txt_standard = (TextView) findViewById(R.id.txt_standard);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_add.setVisibility(View.VISIBLE);
                lv_data.setVisibility(View.GONE);

                if (edit_name.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "enter first name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edit_father.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "enter father name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edit_contact.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "enter contact", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edit_standard.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "enter standard", Toast.LENGTH_SHORT).show();
                    return;
                }
                Student student = new Student();
                student.setName(edit_name.getText().toString());
                student.setFathername(edit_father.getText().toString());
                student.setContactnumber(edit_contact.getText().toString());
                student.setStandard(Integer.parseInt(edit_standard.getText().toString()));

                studentDao.insert(student);
                students = studentQuery.list();
                edit_name.setText("");
                edit_father.setText("");
                edit_contact.setText("");
                edit_standard.setText("");
                studentDataAdapter = new StudentDataAdapter(MainActivity.this, students, MainActivity.this);
                lv_data.setAdapter(studentDataAdapter);

                Log.e("", "----------------INSERTED-------------------------");
                Log.e("RECORD IS", String.valueOf(student));


            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                lv_data.setVisibility(View.VISIBLE);
                for (int i = 0; i < students.size(); i++) {
                    Log.e("Name:--", students.get(i).getName());
                    Log.e("ID:--", "" + i);
                }
                studentDataAdapter = new StudentDataAdapter(MainActivity.this, students, MainActivity.this);
                lv_data.setAdapter(studentDataAdapter);

            }
        });


    }

    public void delete(Long id) {
        studentDao.deleteByKey(id);
        students = studentQuery.list();
        studentDataAdapter = new StudentDataAdapter(MainActivity.this, students, MainActivity.this);
        lv_data.setAdapter(studentDataAdapter);

    }
}
