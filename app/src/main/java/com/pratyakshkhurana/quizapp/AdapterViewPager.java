package com.pratyakshkhurana.quizapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterViewPager extends PagerAdapter {
    private Context context;
    private ArrayList<OnBoardIngItems> item;

    public AdapterViewPager(Context context, ArrayList<OnBoardIngItems> item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.onboarding_screen_layout, null);
        ImageView image = view.findViewById(R.id.imageView);
        TextView text = view.findViewById(R.id.textView);

        image.setImageResource(item.get(position).getImage());
        text.setText(item.get(position).getText());
        container.addView(view);
        return view;
    }
}

