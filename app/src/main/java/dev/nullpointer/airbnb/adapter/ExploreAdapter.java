package dev.nullpointer.airbnb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import dev.nullpointer.airbnb.R;

/**
 * Created by umarfadil on 1/19/18.
 * website : www.umarfadil.com
 * github : https://github.com/umarfadil
 */

public class ExploreAdapter extends BaseAdapter {

    Context context;
    private final String [] country;
    private final String [] city;
    private final int [] thumbnail;

    public ExploreAdapter(Context context, String [] country, String [] city, int [] thumbnail){
        //super(context, R.layout.single_list_app_item, utilsArrayList);
        this.context = context;
        this.country = country;
        this.city = city;
        this.thumbnail = thumbnail;
    }

    @Override
    public int getCount() {
        return city.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.custom_explore_list, parent, false);
            viewHolder.textCity = convertView.findViewById(R.id.city);
            viewHolder.textCountry = convertView.findViewById(R.id.country_name);
            viewHolder.thumb = convertView.findViewById(R.id.thumbnail);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.textCity.setText(city[position]);
        viewHolder.textCountry.setText(country[position]);
        viewHolder.thumb.setImageResource(thumbnail[position]);

        return convertView;
    }

    private static class ViewHolder {

        TextView textCity;
        TextView textCountry;
        ImageView thumb;

    }
}
