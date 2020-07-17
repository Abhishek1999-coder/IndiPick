package com.system.indipick;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.system.indipick.MainActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductsFragment extends Fragment {
    ProgressDialog dialog;
    String Resp;


    /* renamed from: com.example.indipick.ui.prodsearch.ProductsFragment$AsyncTaskRunner */
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
              //  ProductsFragment.this.hideKeyboard(ProductsFragment.this.getView());
                this.ResResponse = ProductsFragment.this.SearchResult(params[0]);
            } catch (Exception e) {
            }
            return this.resp;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String result) {
            this.progressDialog.dismiss();
            AlertDialog.Builder builder;
            builder = new AlertDialog.Builder(getContext());
            builder.setMessage(Resp);
            builder.setPositiveButton("Ok",null);
            builder.show();
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            this.progressDialog = ProgressDialog.show(ProductsFragment.this.getActivity(), BuildConfig.FLAVOR, "Searching for...");
        }

        /* access modifiers changed from: protected */
        public void onProgressUpdate(String... text) {
        }
    }


    
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_products_fragment, container, false);
        setHasOptionsMenu(true);
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
        CardView television = root.findViewById(R.id.Television);
        television.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "television";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView refrigetrator = root.findViewById(R.id.Refrigerator);
        refrigetrator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "refrigerator";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView washing_machine = root.findViewById(R.id.Washing_Machine);
        washing_machine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "washing machine";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView microwave_oven = root.findViewById(R.id.microwave_oven);
        microwave_oven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "microwave oven";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView otg_oven = root.findViewById(R.id.otg_oven);
        otg_oven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "otg oven";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView induction_cooktop = root.findViewById(R.id.induction_cooktop);
        induction_cooktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "induction cooktop";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView led_bulb = root.findViewById(R.id.led_bulb);
        led_bulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "led bulb";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView led_tube = root.findViewById(R.id.led_tube);
        led_tube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "led tube";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView wallclock = root.findViewById(R.id.wallclock);
        wallclock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "wallclock";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView pencil_battery = root.findViewById(R.id.pencil_battery);
        pencil_battery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "pencil battery";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView clothing = root.findViewById(R.id.clothing);
        clothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "clothing";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView footwear = root.findViewById(R.id.footwear);
        footwear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "footwear";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView wrist_watch = root.findViewById(R.id.wrist_watch);
        wrist_watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "wrist watch";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView detergent_cloth = root.findViewById(R.id.detergent_cloth);
        detergent_cloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "detergent(cloth)";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView detergent_dishwash = root.findViewById(R.id.detergent_dishwash);
        detergent_dishwash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "detergent(dish wash)";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView floor_cleaner = root.findViewById(R.id.floor_cleaner);
        floor_cleaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "floor cleaner";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView toilet_cleaner = root.findViewById(R.id.toilet_cleaner);
        toilet_cleaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "toilet cleaner";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView air_freshner = root.findViewById(R.id.air_freshner);
        air_freshner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "air freshners";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView insecticide = root.findViewById(R.id.insecticide);
        insecticide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "insecticide";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView mosquito_repellant = root.findViewById(R.id.mosquito_repellant);
        mosquito_repellant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "mosquito repellant";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView metal_polish = root.findViewById(R.id.metal_polish);
        metal_polish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "metal polish";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView furniture_polish = root.findViewById(R.id.furniture_polish);
        furniture_polish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "furniture polish";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView softdrink = root.findViewById(R.id.soft_drink);
        softdrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "soft drink";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView staples_cereals = root.findViewById(R.id.staples_cereals);
        staples_cereals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "staples/cereals";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView edible_oil = root.findViewById(R.id.edible_oil);
        edible_oil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "edible oil";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView packet_tea = root.findViewById(R.id.packet_tea);
        packet_tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "packet tea";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView toothpaste = root.findViewById(R.id.toothpaste);
        toothpaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "toothpaste";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView ketchup = root.findViewById(R.id.ketchup);
        ketchup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "ketchup";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView jam = root.findViewById(R.id.jam);
        jam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "jams";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView chocolate = root.findViewById(R.id.chocolate);
        chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "chocolates";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView milk = root.findViewById(R.id.milk);
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "milk";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView dairy_products = root.findViewById(R.id.dairy_products);
        dairy_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "dairy products";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView mineral_water = root.findViewById(R.id.mineral_water);
        mineral_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "mineral water";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView coffee = root.findViewById(R.id.coffee);
        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "coffee";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView health_drink = root.findViewById(R.id.health_drink);
        health_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "health drink";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView health_supplements = root.findViewById(R.id.health_supplements);
        health_supplements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "health supplements";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView soap = root.findViewById(R.id.soap);
        soap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "soap";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView shampoo = root.findViewById(R.id.shampoo);
        shampoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "shampoo";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView deodorant = root.findViewById(R.id.deodorant);
        deodorant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "deodorant";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView talcum_powder = root.findViewById(R.id.talcum_powder);
        talcum_powder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "talcum powder";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView feminine_hygiene = root.findViewById(R.id.feminine_hygiene);
        feminine_hygiene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "feminine hygiene";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView lipstick = root.findViewById(R.id.lipstick);
        lipstick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "lipstick";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView eyeliner = root.findViewById(R.id.eyeliner);
        eyeliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "eyeliner";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView eyeshadow = root.findViewById(R.id.eyeshadow);
        eyeshadow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "eyeshadow";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });
        CardView moisturising_cream = root.findViewById(R.id.moisturising_cream);
        moisturising_cream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringtosearch = "moisturising cream";
                new AsyncTaskRunner().execute(new String[]{stringtosearch});

            }
        });



        return root;
    }

    /* access modifiers changed from: 0000 */
    public String SearchResult(String ProductName) {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        GoogleRWAndroid GRW = new GoogleRWAndroid();
        StringBuilder sb = new StringBuilder();
        sb.append("https://script.google.com/macros/s/AKfycbzIrrEAugSk9qXmSo0iztfrkGpAHKMQKhtWGCWZp_F0jeh1SVU/exec?KEY=AEC3DEA441909FE0&category=");
        sb.append(ProductName);
        Resp = GRW.sendToGoogleSheet(sb.toString());
        return BuildConfig.FLAVOR;
    }


}