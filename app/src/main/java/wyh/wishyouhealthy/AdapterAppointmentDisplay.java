package wyh.wishyouhealthy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ccpizzadaisuki on 2015/4/9.
 */
public class AdapterAppointmentDisplay extends BaseAdapter{

    private static ArrayList<AppointmentDisplay> searchArrayList;
    private LayoutInflater mInflater;

    public AdapterAppointmentDisplay(Context context, ArrayList<AppointmentDisplay> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return searchArrayList.size();
    }

    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.ch_appoint_row,
                    null);
            holder = new ViewHolder();
            holder.nameDoctor = (TextView) convertView
                    .findViewById(R.id.doctor_name);
            holder.timestamp = (TextView) convertView.findViewById(R.id.timestamp_);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nameDoctor.setText(searchArrayList.get(position).getNameDoctor());
        holder.timestamp.setText(searchArrayList.get(position).getTimestamp());
        return convertView;
    }

    static class ViewHolder {
        TextView nameDoctor;
        TextView timestamp;
    }
}