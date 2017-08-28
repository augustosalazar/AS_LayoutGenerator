package co.edu.uninorte.layoutgenerator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout main;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        main = (LinearLayout) findViewById(R.id.mainLayout);
        count = 1;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateLayout3();
            }
        });
    }

    private void generateLayout() {
        LinearLayout newLayout = new LinearLayout(this);
        newLayout.setOrientation(LinearLayout.VERTICAL);
        TextView tv = new TextView(this);
        EditText et = new EditText(this);
        Button bt = new Button(this);
        bt.setText("Button "+count);
        bt.setTag(count);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("LayoutGeneratorLog","El boton "+view.getTag());
            }
        });
        tv.setText("el tv");

        newLayout.addView(tv);
        newLayout.addView(et);
        newLayout.addView(bt);
        main.addView(newLayout);
        count++;
    }


    private void generateLayout2() {
        LinearLayout newLayout = new LinearLayout(this);
        newLayout.setOrientation(LinearLayout.VERTICAL);
        TextView tv = new TextView(this);
        EditText et = new EditText(this);
        et.setId(count);
        Button bt = new Button(this);
        bt.setText("Button "+count);
        bt.setTag(count);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = (int) view.getTag();
                EditText e = (EditText) findViewById(id);
                Log.d("LayoutGeneratorLog","El boton "+e.getText());
            }
        });
        tv.setText("el tv");

        newLayout.addView(tv);
        newLayout.addView(et);
        newLayout.addView(bt);
        main.addView(newLayout);

        count++;
    }

    private void generateLayout3() {
        LinearLayout newLayout = new LinearLayout(this);
        newLayout.setOrientation(LinearLayout.VERTICAL);
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.inside, newLayout, false);

        Button button = (Button) v.findViewById(R.id.elBoton);
        final EditText et = (EditText) v.findViewById(R.id.elEditText);
        button.setText("Button "+count);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("LayoutGeneratorLog","El boton "+et.getText());
            }
        });


        newLayout.addView(v);

        main.addView(newLayout);
        count++;
    }
}
