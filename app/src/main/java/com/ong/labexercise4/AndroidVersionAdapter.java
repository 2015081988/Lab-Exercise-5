package com.ong.labexercise4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import com.ong.labexercise4.models.AndroidVersion;

import java.util.List;

public class AndroidVersionAdapter extends ArrayAdapter<AndroidVersion> implements View.OnClickListener {

    private Context mContext;
    private List<AndroidVersion> androidVersions;

    public AndroidVersionAdapter(Context context, List<AndroidVersion> objects) {
        super(context, 0, objects);
        this.mContext = context;
        this.androidVersions = objects;
    }

    private static class ViewHolder{
        TextView androidNameText;
        TextView androidApiLevelText;
        TextView androidReleaseDateText;
        TextView androidVersion;
        ImageView androidImage;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AndroidVersion androidVersion = getItem(position);
        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.android_cell, parent, false);
            viewHolder.androidNameText = convertView.findViewById(R.id.android_name);
            viewHolder.androidApiLevelText = convertView.findViewById(R.id.android_api_level);
            viewHolder.androidReleaseDateText = convertView.findViewById(R.id.android_release_date);
            viewHolder.androidImage = convertView.findViewById(R.id.android_imageview);
            viewHolder.androidVersion = convertView.findViewById(R.id.android_version);
            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.androidNameText.setText(androidVersion.getName());
        viewHolder.androidApiLevelText.setText(String.format("API Level %s",androidVersion.getApiLevel()));
        viewHolder.androidReleaseDateText.setText(String.format("Released %s", androidVersion.getReleaseDate()));
        viewHolder.androidVersion.setText(String.format("Ver. %s", androidVersion.getVersion()));
        viewHolder.androidImage.setImageResource(androidVersion.getImageResource());
        return result;
    }

    @Override
    public void onClick(View view) {

    }
}
