package com.suganth.mvvmexampleapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.suganth.mvvmexampleapp.R;
import com.suganth.mvvmexampleapp.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<NicePlace> mNicePlace = new ArrayList<>();
    private Context mContext;

    public RecyclerAdapter(List<NicePlace> mNicePlace, Context mContext) {
        this.mNicePlace = mNicePlace;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //Set the name of the place
        ((ViewHolder)holder).mName.setText(mNicePlace.get(position).getTitle());
        //Set the image
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(mNicePlace.get(position).getImageUrl())
                .into(((ViewHolder)holder).mImage);
    }

    @Override
    public int getItemCount() {
        return mNicePlace.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView mImage;
        private TextView mName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mName = itemView.findViewById(R.id.image_name);
        }
    }
}
