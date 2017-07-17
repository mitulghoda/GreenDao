package com.vnnovate.greendao.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vnnovate.greendao.Activities.MainActivity;
import com.vnnovate.greendao.App;
import com.vnnovate.greendao.Entities.DaoSession;
import com.vnnovate.greendao.Entities.Student;
import com.vnnovate.greendao.Entities.StudentDao;
import com.vnnovate.greendao.R;

import java.util.List;

/**
 * Created by Vnnovate on 17-Jul-17.
 */

public class StudentDataAdapter extends BaseAdapter {
    private static LayoutInflater inflater;

    List<Student> students;
    StudentDao studentDao;
    Context context;
    MainActivity mainActivity;

    public StudentDataAdapter(Context context, List<Student> students, MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.context = context;
        this.students = students;
        ;

    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder {
        private TextView txt_name, txt_father, txt_id, txt_contact, txt_standard;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi;
        Holder holder = new Holder();

        if (convertView == null) {

            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_layout_student_data, null);

        }

        holder.txt_id = (TextView) convertView.findViewById(R.id.txt_id);
        holder.txt_name = (TextView) convertView.findViewById(R.id.txt_name);
        holder.txt_standard = (TextView) convertView.findViewById(R.id.txt_standard);
        holder.txt_father = (TextView) convertView.findViewById(R.id.txt_father);
        holder.txt_contact = (TextView) convertView.findViewById(R.id.txt_contact);


        if (convertView != null) {
            holder.txt_id.setText("" + students.get(position).getID());
            holder.txt_name.setText(students.get(position).getName());
            holder.txt_father.setText(students.get(position).getFathername());
            holder.txt_contact.setText(students.get(position).getContactnumber());
            holder.txt_standard.setText("" + students.get(position).getStandard());
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "ID Removed" + students.get(position).getID(), Toast.LENGTH_SHORT).show();
                mainActivity.delete(students.get(position).getID());
            }
        });

        return convertView;
    }
}
