package by.gov.house.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import by.gov.house.R;

import java.util.ArrayList;

import by.gov.house.Models.Human;


public class HumanAdapter extends BaseAdapter implements Filterable {

    ArrayList<Human> humanList;
    ArrayList<Human> mOriginalValues;
    Context context;

    public HumanAdapter(Context context, ArrayList<Human> humans){
        this.humanList = humans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return humanList.size();
    }

    @Override
    public Human getItem(int position) {
        return humanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"SetTextI18n", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = convertView;
        final Human human = getItem(position);
        final ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            customView = inflater.inflate(R.layout.human_item, null);

            holder.imageView = customView.findViewById(R.id.image_human);
            holder.textView1 = customView.findViewById(R.id.text_human_name);
            holder.textView2 = customView.findViewById(R.id.text_human_io);
            customView.setTag(holder);
        }
        else {
            holder = (ViewHolder) customView.getTag();
        }

        holder.imageView.setImageResource(context.getResources().getIdentifier("drawable/"+human.image, null, context.getPackageName()));
        holder.textView1.setText(human.name1);
        holder.textView2.setText(human.name2 + " " + human.name3);

        return customView;
    }

    public static class ViewHolder{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,FilterResults results) {

                humanList = (ArrayList<Human>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                ArrayList<Human> FilteredArrList = new ArrayList<>();

                if (mOriginalValues == null) {
                    mOriginalValues = new ArrayList<Human>(humanList); // saves the original data in mOriginalValues
                }

                if (constraint == null || constraint.length() == 0) {

                    // set the Original result to return
                    results.count = mOriginalValues.size();
                    results.values = mOriginalValues;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < mOriginalValues.size(); i++) {
                        Human data = mOriginalValues.get(i);
                        if (data.name1.toLowerCase().contains(constraint.toString())) {
                            FilteredArrList.add(data);
                        }
                    }
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }
        };
    }

}
