package by.gov.house.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import by.gov.house.Models.Human;

public class SovietHumanAdapter extends ArrayAdapter<Human> {

    ArrayList<Human> arrayList;

    public SovietHumanAdapter(Context context, ArrayList<Human> arrayList) {
        super(context, android.R.layout.simple_list_item_1, arrayList);
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Human getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Human human = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(android.R.layout.simple_list_item_1, null);
        }
        ((TextView) convertView.findViewById(android.R.id.text1)).setText(human.name1 + " " + human.name2 + " " + human.name3);
        return convertView;
    }
}
