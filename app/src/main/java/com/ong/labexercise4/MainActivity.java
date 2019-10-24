package com.ong.labexercise4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ong.labexercise4.models.AndroidVersion;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewVersionHistory;
    private List<Integer> versionImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeWidget();
        String[] versions = getResources().getStringArray(R.array.android_versions);
        final List<AndroidVersion> androidVersions = _seedData(versions);

        AndroidVersionAdapter adapter = new AndroidVersionAdapter(this,androidVersions);
        listViewVersionHistory.setAdapter(adapter);
        listViewVersionHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showAlertDialog(androidVersions.get(i));
            }
        });
    }

    private List<AndroidVersion> _seedData(String[] loadData){
        List<AndroidVersion> androidVersions = new ArrayList<>();
        for (int i = 0; i < loadData.length; i++){
            androidVersions.add(generateAndroidVersion(loadData[i], i));
        }
        return androidVersions;
    }

    private AndroidVersion generateAndroidVersion(String versionString, int index){
        String[] androidVersion = versionString.split("~");
        AndroidVersion newVersion = new AndroidVersion();
        newVersion.setName(androidVersion[0]);
        newVersion.setVersion(androidVersion[1]);
        newVersion.setReleaseDate(androidVersion[2]);
        newVersion.setApiLevel(androidVersion[3]);
        newVersion.setDescription(androidVersion[4]);
        newVersion.setImageResource(versionImages.get(index));
        return newVersion;
    }

    private void initializeWidget(){
        listViewVersionHistory = findViewById(R.id.listview_version_history);
        versionImages = new ArrayList<>();
        versionImages.add(R.drawable.cupcake);
        versionImages.add(R.drawable.donut);
        versionImages.add(R.drawable.eclair);
        versionImages.add(R.drawable.froyo);
        versionImages.add(R.drawable.gingerbread);
        versionImages.add(R.drawable.honeycomb);
        versionImages.add(R.drawable.icecream);
        versionImages.add(R.drawable.jellybean);
        versionImages.add(R.drawable.kitkat);
        versionImages.add(R.drawable.lollipop);
        versionImages.add(R.drawable.marshmallow);
        versionImages.add(R.drawable.nougat);
        versionImages.add(R.drawable.oreo);
        versionImages.add(R.drawable.pie);
        versionImages.add(R.drawable.android_10);
    }

    public void showAlertDialog(AndroidVersion androidVersion){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(androidVersion.getName());
        dialog.setIcon(androidVersion.getImageResource());
        dialog.setMessage(androidVersion.getDescription());
        dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.create().show();
    }
}
