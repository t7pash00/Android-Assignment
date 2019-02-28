package number.random.randomnumber;
import android.graphics.Color;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.sql.ResultSet;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edit_min, edit_max;
    Button b_generate;
    TextView number_output;
    TextView number_output1;
    RelativeLayout relativeLayout;
    Button background;
    Button reset;


    Random r;
    int min, max, output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        r = new Random();

        edit_min = (EditText) findViewById(R.id.edit_min);
        edit_max = (EditText) findViewById(R.id.edit_max);
        b_generate= (Button) findViewById(R.id.b_generate);
        background = (Button) findViewById(R.id.background);
        number_output = (TextView) findViewById(R.id.number_output);
        number_output1 = (TextView) findViewById(R.id.number_output1);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        reset = (Button) findViewById(R.id.reset);



        b_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = Color.argb(255, r.nextInt(256), r.nextInt(256),
                        r.nextInt(256));

                number_output.setTextColor(color);
                number_output1.setTextColor(color);


                String tempMin, tempMax;
                tempMin = edit_min.getText().toString();
                tempMax = edit_max.getText().toString();

                if(!tempMin.equals("") && !tempMax.equals("")) {
                    min = Integer.parseInt(tempMin);
                    max = Integer.parseInt(tempMax);
                    if(max > min) {
                        output = r.nextInt((max - min) + 1) + min;
                        number_output1.setText("");
                        number_output.setText("" + output);
                    } else {
                        number_output1.setText("Please put maximum value greater than minimum value");
                        number_output.setText("");
                    }
                }
            }
        });
            background.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int color = Color.argb(255, r.nextInt(256), r.nextInt(256),
                            r.nextInt(256));
                    relativeLayout.setBackgroundColor(color);


                }


        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_min.setText("");
                edit_max.setText("");
                number_output.setText("");
                number_output1.setText("");
            }
        });
    }
}
