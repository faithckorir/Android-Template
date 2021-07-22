package com.ekenya.rnd.paybills.ui.notifications.adapters;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ekenya.rnd.paybills.databinding.NotificationListContentBinding;
import com.ekenya.rnd.paybills.ui.notifications.placeholder.PlaceholderContent;

import java.util.List;

public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderContent.PlaceholderItem> mValues;
    private final View.OnClickListener mOnClickListener;
    private final View.OnContextClickListener mOnContextClickListener;

    public SimpleItemRecyclerViewAdapter(List<PlaceholderContent.PlaceholderItem> items,
                                         View.OnClickListener onClickListener,
                                         View.OnContextClickListener onContextClickListener) {
        mValues = items;
        mOnClickListener = onClickListener;
        mOnContextClickListener = onContextClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        NotificationListContentBinding binding =
                NotificationListContentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.itemView.setTag(mValues.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            holder.itemView.setOnContextClickListener(mOnContextClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mIdView;
        final TextView mContentView;

        ViewHolder(NotificationListContentBinding binding) {
            super(binding.getRoot());
            mIdView = binding.idText;
            mContentView = binding.content;
        }

    }
}