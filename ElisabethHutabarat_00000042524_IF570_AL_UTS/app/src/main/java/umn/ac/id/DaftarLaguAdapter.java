package umn.ac.id;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class DaftarLaguAdapter extends
        RecyclerView.Adapter<DaftarLaguAdapter.ItemLaguViewHolder> {
    private LinkedList<SumberLagu> mDaftarLagu;
    private LayoutInflater mInflater;
    private Context mContext;


    public DaftarLaguAdapter (Context context, LinkedList<SumberLagu> daftarLagu) {
        this.mContext = context;
        this.mDaftarLagu = daftarLagu;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemLaguViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.lagu_item_layout ,
                parent , false);
        return new ItemLaguViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLaguViewHolder holder,
                                 int position) {
        SumberLagu mSumberLagu = mDaftarLagu.get(position);
        holder.tvJudul.setText(mSumberLagu.getJudul());
        holder.tvPenyanyi.setText(mSumberLagu.getPenyanyi());
        //holder.kotakLagu.setVideoURI(
                //Uri.parse(mSumberVideo.getLaguURI()));
        //holder.kotakLagu.setImageDrawable(mSumberLagu.getKotakLagu());
    }
    @Override
    public int getItemCount() {
        return mDaftarLagu.size();
    }

    class ItemLaguViewHolder extends RecyclerView.ViewHolder
                            implements View.OnClickListener {
        //private ImageView kotakLagu;
        private TextView tvJudul;
        private TextView tvPenyanyi;
        private DaftarLaguAdapter mAdapter;
        private int mPosisi;
        private SumberLagu mSumberLagu;

        public ItemLaguViewHolder(@NonNull View itemView,
                                   DaftarLaguAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            //kotakLagu = (ImageView) itemView.findViewById(R.id.kotakLagu);
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvPenyanyi = (TextView) itemView.findViewById(R.id.tvPenyanyi);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mPosisi = getLayoutPosition();
            mSumberLagu = mDaftarLagu.get(mPosisi);
            Intent intent = new Intent(mContext,
                    DetilLaguActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("DetilLagu", mSumberLagu);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        }
    }
}
