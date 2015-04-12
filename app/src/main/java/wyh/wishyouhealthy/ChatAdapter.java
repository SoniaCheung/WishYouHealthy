package wyh.wishyouhealthy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by An on 8/4/2015.
 */
public class ChatAdapter extends ArrayAdapter<Bubble> {
    private ArrayList<Bubble> bubbles;
    private Context context;

    public ChatAdapter(ArrayList<Bubble> bubbles, Context context) {
        super(context, R.layout.chat_row);
        this.bubbles = bubbles;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // First let's verify the convertView is not null
        if (convertView == null) {
            // This a new view we inflate the new layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.chat_row, parent, false);
        }
        // Now we can fill the layout with the right values
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView content = (TextView) convertView.findViewById(R.id.content);
        Bubble bubble = bubbles.get(position);

        name.setText(bubble.getName());
        content.setText("" + bubble.getContent());

        return convertView;
    }

    @Override
    public int getCount() {
        return bubbles.size();
    }

    @Override
    public Bubble getItem(int position) {
        return bubbles.get(position);
    }

    public void setBubbles(ArrayList<Bubble> bubbles2) {
        bubbles.clear();
        for (int i = 0; i < bubbles2.size(); i++) {
            bubbles.add(bubbles2.get(i));
        }
    }
}
