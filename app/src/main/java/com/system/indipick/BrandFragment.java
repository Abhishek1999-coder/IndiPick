package com.system.indipick;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
//import android.lifecycle.ViewModelProviders;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.system.indipick.BuildConfig;
//import com.system.indipick.C0636R;
import com.system.indipick.GoogleRWAndroid;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrandFragment extends Fragment {

    Button ButSearchProdut;
    EditText ETSearchProduct;
    TextView TVProductSearch;
    ProgressDialog dialog;
    Spinner spnr;
    ArrayAdapter adapter;
    List<String> var,empty;
    String tempo;
    private ProdsearchViewModel prodsearchViewModel;

    private class AsyncTaskRun extends AsyncTask<String, String, String> {
        String ResResponse;
        ProgressDialog progressDialog;
        private String resp;

        private AsyncTaskRun() {
            this.ResResponse = BuildConfig.FLAVOR;
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... params) {
            try {
                //BrandFragment.this.hideKeyboard(BrandFragment.this.getView());
                params[0]=params[0].replace(" ","");
                this.ResResponse = BrandFragment.this.SearchResult(tempo+" "+params[0].substring(2,params[0].length()));
            } catch (Exception e) {
            }
            return this.resp;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String result) {
            this.progressDialog.dismiss();

            //BrandFragment.this.ETSearchProduct.setText("");
            //BrandFragment.this.ETSearchProduct2.setText("");
            BrandFragment.this.ButSearchProdut.setEnabled(true);
            // BrandFragment.this.TVProductSearch.setText(this.ResResponse);
            BrandFragment.this.TVProductSearch.setText(this.ResResponse);

        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.progressDialog = ProgressDialog.show(BrandFragment.this.getActivity(), BuildConfig.FLAVOR, "Searching for...");
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(String... text) {
        }
    }




    /* renamed from: com.example.indipick.ui.prodsearch.BrandFragment$AsyncTaskRunner */
    private class AsyncTaskRunner extends AsyncTask<String, String, String> {
        String ResResponse;
        ProgressDialog progressDialog;
        private String resp;


        private AsyncTaskRunner() {
            this.ResResponse = BuildConfig.FLAVOR;
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... params) {
            try {
                tempo = params[0];
                BrandFragment.this.hideKeyboard(BrandFragment.this.getView());
                this.ResResponse = BrandFragment.this.SearchResult(params[0]);
            } catch (Exception e) {
            }
            return this.resp;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String result) {
            this.progressDialog.dismiss();

            //BrandFragment.this.ETSearchProduct.setText("");
            //BrandFragment.this.ETSearchProduct2.setText("");
            BrandFragment.this.ButSearchProdut.setEnabled(true);

            if((this.ResResponse.contains("Alternate"))||(this.ResResponse.contains("review"))){
                spnr.setEnabled(false);
                BrandFragment.this.ButSearchProdut.setEnabled(true);
                BrandFragment.this.TVProductSearch.setText(this.ResResponse);
                empty = new ArrayList<>();
                adapter = new ArrayAdapter<>(getActivity().getApplicationContext(), R.layout.spinnertxt, empty);
                spnr.setAdapter(adapter);

            }

            else {
                // BrandFragment.this.TVProductSearch.setText(this.ResResponse);
                String[] str = this.ResResponse.split("\n");
                List<String> it = Arrays.asList(str);
                var = new ArrayList<>(it);
                var.remove(0);
                var.remove(var.size() - 1);
                var.add(0, "Select Category");
                adapter = new ArrayAdapter<>(getActivity().getApplicationContext(), R.layout.spinnertxt, var);
                spnr.setAdapter(adapter);
                spnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (position != 0) {
                            String stringtosearch = BrandFragment.this.var.get(position);
                            new BrandFragment.AsyncTaskRun().execute(new String[]{stringtosearch});
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
           /* spnr.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String stringtosearch = BrandFragment.this.var.get(position);
                    new BrandFragment.AsyncTaskRun().execute(new String[]{stringtosearch});
                    //ProductsFragment.this.SearchResult(ProductsFragment.this.variabletemp.get(position));
                }

            });*/


        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.progressDialog = ProgressDialog.show(BrandFragment.this.getActivity(), BuildConfig.FLAVOR, "Searching for...");
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(String... text) {
        }
    }






    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      //  this.prodsearchViewModel = (ProdsearchViewModel) ViewModelProviders.m8of((Fragment) this).get(ProdsearchViewModel.class);
        View root = inflater.inflate(R.layout.activity_brand__fragment, container, false);
        this.TVProductSearch = (TextView) root.findViewById(R.id.txtview);
        this.ETSearchProduct = (EditText) root.findViewById(R.id.txt1);
        this.ButSearchProdut = (Button) root.findViewById(R.id.btn_1);
       // this.ButSearchProdut = (Button) root.findViewById(R.id.btn_1);
        this.spnr = (Spinner) root.findViewById(R.id.spnr);

        try {
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            this.dialog = progressDialog;
            progressDialog.setProgressStyle(0);
            this.dialog.setTitle("Searching");
            this.dialog.setMessage("Searching. Please wait...");
            this.dialog.setIndeterminate(true);
            this.dialog.setCanceledOnTouchOutside(false);
        } catch (Exception e) {
        }
        this.ButSearchProdut.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                String stringtosearch = BrandFragment.this.ETSearchProduct.getText().toString();
               // stringtosearch = stringtosearch+" "+BrandFragment.this.ETSearchProduct2.getText().toString();
                new AsyncTaskRunner().execute(new String[]{stringtosearch});
                BrandFragment.this.TVProductSearch.setText("Waiting for info..");
                //BrandFragment.this.ButSearchProdut.setText("Wait...");
                BrandFragment.this.ButSearchProdut.setEnabled(false);
                spnr.setEnabled(true);
            }
        });
        return root;
    }

    /* access modifiers changed from: 0000 */
    public String SearchResult(String ProductName) {
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        GoogleRWAndroid GRW = new GoogleRWAndroid();
        StringBuilder sb = new StringBuilder();
        sb.append("https://script.google.com/macros/s/AKfycbzIrrEAugSk9qXmSo0iztfrkGpAHKMQKhtWGCWZp_F0jeh1SVU/exec?KEY=AEC3DEA441909FE0&product=");
        sb.append(ProductName);
        return GRW.sendToGoogleSheet(sb.toString());
    }

    @SuppressLint("WrongConstant")
    public void hideKeyboard(View view) {
        ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.ETSearchProduct.getWindowToken(), 0);
        }
        }
