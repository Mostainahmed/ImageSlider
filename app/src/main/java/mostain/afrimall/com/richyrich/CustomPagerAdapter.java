package mostain.afrimall.com.richyrich;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by shifa on 19/7/2018.
 */

public class CustomPagerAdapter extends PagerAdapter {

    private int[] image_resources = {R.drawable.rich_1,R.drawable.quote_1,R.drawable.rich_2,R.drawable.quote_2,
            R.drawable.rich_3,
            R.drawable.quote_3,R.drawable.rich_4
            ,R.drawable.quote_4,R.drawable.rich_5};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomPagerAdapter(Context ctx){

        this.ctx = ctx;

    }

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_pager,container,false);
        ImageView imageView = item_view.findViewById(R.id.imageview);
        TextView textView = (TextView)item_view.findViewById(R.id.textview);
        imageView.setImageResource(image_resources[position]);
        textView.setText("You are so much Rich. Show this app to people") ;
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
