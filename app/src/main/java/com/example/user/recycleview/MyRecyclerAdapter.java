package com.example.user.recycleview;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> implements View.OnClickListener
{

    private List<ViewModel> items;
    private int itemLayout;

    public MyRecyclerAdapter(List<ViewModel> items, int itemLayout)
    {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        final ViewModel item = items.get(position);
        holder.itemView.setTag(item);
        holder.text.setText(item.getDescription());
    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }

    @Override
    public void onClick(View view)
    {
        ViewModel model = (ViewModel) view.getTag();
        remove(model);
    }

    public void add(ViewModel item)
    {
        items.add(item);
        notifyItemInserted(items.size());
    }

    public void add(ViewModel item, int position)
    {
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(ViewModel item)
    {
        int position = items.indexOf(item);
        items.remove(position);
        notifyItemRemoved(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView text;

        public ViewHolder(View itemView)
        {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
