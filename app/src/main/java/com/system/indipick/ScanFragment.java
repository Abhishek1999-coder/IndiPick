package com.system.indipick;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class ScanFragment extends Fragment {
    View view;
    Button btn;
    TextView deep,head;
    private String installedApps;
    String s="";
    int count=0;
public ScanFragment(){

}
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_scan_fragment,container,false);
        btn = (Button)view.findViewById(R.id.btn_2);

        //deep = (TextView)view.findViewById(R.id.deep);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent i = new Intent(getContext(),AppClassify.class);
                startActivity(i);*/
                deep = view.findViewById(R.id.deep);
                head = view.findViewById(R.id.head);

                installedApps = getInstalledApps();

                if(count==0){
                    String tem="Congratulations! You don't have Any Banned App";
                    head.setText(tem);
                }
                else {
                    head.setTextColor(Color.parseColor("#FF0000"));
                    if(count==1) {
                        String tem = "Beware! You have one Banned App";
                        head.setText(tem);
                    }
                    else{
                        String tem = "Beware! You have "+count+" Banned Apps";
                        head.setText(tem);
                    }
                    deep.setText(installedApps);
                }


            }
        });
        //deep.setText(MainActivity.aplist.toString());

        return view;
    }
    private String getInstalledApps() {
        count=0;
        s="";
        List<PackageInfo> packs = getActivity().getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < packs.size(); i++) {
            PackageInfo p = packs.get(i);
            if ((!isSystemPackage(p))) {
                String appName = p.applicationInfo.loadLabel(getActivity().getPackageManager()).toString();
                if(MainActivity.aplist.contains(appName.replace(" ","").toUpperCase())){
                    s = s + appName + "  \n  ";
                    count++;
                }

            }
        }
        return s;
    }

    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return (pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }
}