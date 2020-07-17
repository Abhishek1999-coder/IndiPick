package com.system.indipick;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.system.indipick.MainActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment {
    Button btn;
    TextView txt1,txt2;
    public RegisterFragment(){
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.activity_register_fragment,container,false);
        this.btn = (Button)view.findViewById(R.id.btn);/*
        this.txt1 = (TextView) view.findViewById(R.id.txt_r1);
        this.txt2 = (TextView) view.findViewById(R.id.txt_r2);*/
        /*txt1.setText(MainActivity.Rp11);
        txt2.setText(MainActivity.Rp22);*/
        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW ,Uri.parse("mailto:"+"hello@indipick.in"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"I want to register my product");
                intent.putExtra(Intent.EXTRA_TEXT,"Hii");
                startActivity(intent);
            }
        });
        return view;
    }
}
