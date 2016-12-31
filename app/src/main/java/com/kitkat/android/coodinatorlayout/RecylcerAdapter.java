package com.kitkat.android.coodinatorlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecylcerAdapter extends RecyclerView.Adapter<RecylcerAdapter.Holder>{
    private Context context;
    private LayoutInflater inflater;

    private String[] arr = {"Baby Soul", "Yoo JiAe", "Seo JiSoo", "Lee MiJoo", "Kei", "JIN", "Ryu SuJeong", "Jeong YeIn"};

    public RecylcerAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public RecylcerAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recycler_item, parent, false);
        Holder holder = new Holder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecylcerAdapter.Holder holder, int position) {
        holder.text.setText(arr[position]);
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView text;

        public Holder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
