package net.androidbootcamp.rebuildmyr6;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Integer[] Parts = {R.drawable.clutch, R.drawable.frontwheel,
            R.drawable.headlights,R.drawable.rearwheel,R.drawable.sidecover,
            R.drawable.steering};
    String [] partNames = {"Clutch", "Front Wheel", "Headlights", "Rear Wheel", "Side Cover", "Steering"};
    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid =(GridView) findViewById(R.id.gridView);
        final ImageView pic = (ImageView) findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Selected Part: " + partNames[position], Toast.LENGTH_SHORT).show();
                pic.setImageResource(Parts[position]);

            }
        });
    }


    private class ImageAdapter extends BaseAdapter {

        private Context context;


        public ImageAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return Parts.length;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(Parts[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,300));
            return pic;
        }


        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
}
