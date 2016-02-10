package halalfoods.model;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.halalfoods.R;

import java.util.ArrayList;

import halalfoods.model.FoodItem;

public class FoodItemList extends ArrayAdapter<String> {

    private final Activity context;
    private final Integer[] foodImages;
    private final String[] foodNames;
    private final String[] foodPrices;
    private final Integer[] halalImages;
    public FoodItemList(Activity context, Integer[] foodImages, String[] foodNames, String[] foodPrices, Integer[] halalImages){
        super(context, R.layout.list_single, foodNames);
        this.context = context;
        this.foodImages = foodImages;
        this.foodNames = foodNames;
        this.foodPrices = foodPrices;
        this.halalImages = halalImages;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView foodName = (TextView) rowView.findViewById(R.id.foodName);
        foodName.setText(foodNames[position]);
        TextView foodPrice = (TextView) rowView.findViewById(R.id.foodPrice);
        foodPrice.setText(foodPrices[position]);
        ImageView foodImage = (ImageView) rowView.findViewById(R.id.foodImage);
        foodImage.setImageResource(foodImages[position]);
        ImageView halalImage = (ImageView) rowView.findViewById(R.id.halalImage);
        halalImage.setImageResource(halalImages[position]);
        return rowView;
    }
}