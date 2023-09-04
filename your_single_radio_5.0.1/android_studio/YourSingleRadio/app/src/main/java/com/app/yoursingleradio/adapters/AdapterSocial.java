package com.app.yoursingleradio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.yoursingleradio.R;
import com.app.yoursingleradio.models.Social;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class AdapterSocial extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Social> items;
    private Context context;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Social obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterSocial(Context context, ArrayList<Social> items) {
        this.items = items;
        this.context = context;
    }

    public static class OriginalViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_name;
        private ImageView img_icon;
        private LinearLayout lyt_parent;

        public OriginalViewHolder(View view) {
            super(view);
            lyt_parent = view.findViewById(R.id.lyt_parent);
            txt_name = view.findViewById(R.id.txt_name);
            img_icon = view.findViewById(R.id.img_icon);
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_social, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            final Social social = items.get(position);
            final OriginalViewHolder vItem = (OriginalViewHolder) holder;

            vItem.txt_name.setText(social.social_name);

            Glide.with(context)
                    .load(social.social_icon.replace(" ", "%20"))
                    .placeholder(R.drawable.ic_thumbnail)
                    .thumbnail(0.3f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(vItem.img_icon);

            vItem.lyt_parent.setOnClickListener(view -> {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, social, position);
                }
            });

        }
    }

    public void setItems(ArrayList<Social> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void resetListData() {
        this.items.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}