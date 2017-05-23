package sg.edu.rp.c346.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by 15056158 on 16/5/2017.
 */

public class customAdapter  extends ArrayAdapter<Task> {

    private Context context;
    private ArrayList<Task> task;
    private TextView tvID, tvDescription,tvDate;





    public customAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);

        task = objects;

        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvID = (TextView) rowView.findViewById(R.id.tvID);

        tvDescription = (TextView) rowView.findViewById(R.id.tvDescription);

        tvDate = (TextView) rowView.findViewById(R.id.tvDate);



        Task currentTask = task.get(position);

        tvID.setText(currentTask.getId());

        tvDescription.setText(currentTask.getDescription());

        tvDate.setText(currentTask.getDate());



        return rowView;
    }
}



