package app.SummerPalace;
import java.util.ArrayList;
import app.SummerPalace.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
/*Author:Tsing Miao*/
public class home extends Activity {
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        AutoPlayGallery g = (AutoPlayGallery) findViewById(R.id.autoGallery);
        ArrayList<Drawable> drawables = new ArrayList<Drawable>();
        drawables.add(getResources().getDrawable(R.drawable.tuijian_001));
        drawables.add(getResources().getDrawable(R.drawable.tuijian_002));
        drawables.add(getResources().getDrawable(R.drawable.tuijian_003));
        ImageAdapter adapter = new ImageAdapter(this, drawables);
        g.setAdapter(adapter);
    }
}