package com.rikzah.assignment_2.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rikzah.assignment_2.Activities.Detailed_Activity;
import com.rikzah.assignment_2.Activities.ViewAll_Activity;
import com.rikzah.assignment_2.R;
import com.rikzah.assignment_2.models.PopularModel;

import java.io.Serializable;
import java.util.List;
public class PopularAdapters  extends RecyclerView.Adapter<PopularAdapters.ViewHolder> {
    private Context context;
    private List<PopularModel> popularModelList;

    public PopularAdapters(Context context, List<PopularModel> popularModelList) {
        this.context=context;
        this.popularModelList=popularModelList;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item,parent,false));}
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(popularModelList.get(position).getImg_url()).into(holder.popImg);
        holder.name.setText(popularModelList.get(position).getName());
        holder.rating.setText(popularModelList.get(position).getRating());
        holder.description.setText(popularModelList.get(position).getDescription());
        holder.discount.setText(popularModelList.get(position).getDiscount());
        holder.price.setText(popularModelList.get(position).getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, Detailed_Activity.class);
                intent.putExtra("detail",popularModelList.get(position));
                context.startActivity(intent);}});}
    @Override
    public int getItemCount() {
        return popularModelList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView popImg;
        TextView name, description, rating, discount,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            popImg=itemView.findViewById(R.id.pop_img);
            name =itemView.findViewById(R.id.pop_name);
            description = itemView.findViewById(R.id.pop_des);
            discount = itemView.findViewById(R.id.pop_discount);
            rating =itemView.findViewById(R.id.pop_rating);
            price=itemView.findViewById(R.id.popularitem_price);}}}
