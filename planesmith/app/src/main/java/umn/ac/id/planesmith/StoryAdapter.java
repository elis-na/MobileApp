package umn.ac.id.planesmith;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import umn.ac.id.planesmith.data.Story;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyViewHolder> {

    private ArrayList<Story> list;

    StoryAdapter(ArrayList<Story> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public StoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.MyViewHolder holder, int position) {
        holder.name.setText(list.get(position).getChapter_name());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.item_story_name);
        }
    }
}
