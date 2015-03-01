package util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.copticstream.copticstreamdroid.R;

import java.util.ArrayList;

import custom.DrawerItem;

/**
 * Created by Mina on 2/28/2015.
 */
public class DrawerListBaseAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<DrawerItem> drawerItems;

    public DrawerListBaseAdapter(Context context, ArrayList<DrawerItem> drawerItems) {

        this.context = context;
        this.drawerItems = drawerItems;
        inflater = inflater.from(context);
    }

    @Override
    public int getCount() {
        return drawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return drawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.drawer_item, null);
        }
        else {
            view = convertView;
        }


        TextView titleView = (TextView) view.findViewById(R.id.title);
        titleView.setText( drawerItems.get(position).title );

        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        imageView.setImageResource(drawerItems.get(position).icon);

        return view;
    }
}
