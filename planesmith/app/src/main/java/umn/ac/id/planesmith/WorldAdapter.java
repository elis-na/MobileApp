package umn.ac.id.planesmith;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import umn.ac.id.planesmith.data.World;

public class WorldAdapter extends RecyclerView.Adapter<WorldAdapter.MyViewHolder> {

    private ArrayList<World> list;

    WorldAdapter(ArrayList<World> list){
        this.list = list;
    }

    @NonNull
    @Override
    public WorldAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_world, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull WorldAdapter.MyViewHolder holder, int position) {
        holder.name.setText(list.get(position).getWorld_name());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.item_world_name);
        }
    }
}
