package com.example.materialdesignapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SelectorItemsAdapter extends RecyclerView.Adapter<SelectorItemsAdapter.SelectorViewHolder> {
    private static final String TAG = "SelectorItemsAdapter";
    final private ListItemClickListner mOnclickListner;

    public SelectorItemsAdapter(ListItemClickListner mOnclickListner) {
        this.mOnclickListner = mOnclickListner;
    }

    public interface ListItemClickListner{
        void onListItemClick(int clickedItemList);
    }

    @NonNull
    @Override
    public SelectorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selector_list_item,parent,false);
         SelectorViewHolder viewHolder = new SelectorViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SelectorViewHolder holder, int position) {
        Log.e(TAG,"onBindViewHolder:#"+position);

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class SelectorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView firstName,lastName;
        ImageView icon;
        public SelectorViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.person_icon);
            firstName = itemView.findViewById(R.id.first_name);
            lastName = itemView.findViewById(R.id.last_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnclickListner.onListItemClick(clickedPosition);
        }
    }
}
