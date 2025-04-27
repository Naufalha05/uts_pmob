package com.example.maps.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maps.GaleriActivity;
import com.example.maps.R;
import com.example.maps.model.FileItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.FileViewHolder> {

    private List<FileItem> fileList;
    private ArrayList<FileItem> originalList;
    private Context context;

    public FileAdapter(Context context, List<FileItem> fileList) {
        this.context = context;
        this.fileList = fileList;
        this.originalList = new ArrayList<>();
        this.originalList.addAll(fileList);
    }

    public static class FileViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;
        TextView details;
        TextView description;
        View divider;

        public FileViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon_file);
            name = itemView.findViewById(R.id.tv_file_name);
            details = itemView.findViewById(R.id.tv_file_details);
            description = itemView.findViewById(R.id.tv_file_description);
            divider = itemView.findViewById(R.id.divider);
        }
    }

    @NonNull
    @Override
    public FileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_file, parent, false);
        return new FileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FileViewHolder holder, int position) {
        FileItem currentItem = fileList.get(position);

        holder.icon.setImageResource(currentItem.getIconResId());
        holder.name.setText(currentItem.getName());

        if (!currentItem.getSize().isEmpty() && !currentItem.getDate().isEmpty()) {
            holder.details.setVisibility(View.VISIBLE);
            holder.details.setText(currentItem.getSize() + " • " + currentItem.getDate());
        } else {
            holder.details.setVisibility(View.GONE);
        }

        // Show description
        if (currentItem.getDescription() != null && !currentItem.getDescription().isEmpty()) {
            holder.description.setVisibility(View.VISIBLE);
            holder.description.setText(currentItem.getDescription());
        } else {
            holder.description.setVisibility(View.GONE);
        }

        // Set divider for all items except the last one
        if (position < fileList.size() - 1) {
            holder.divider.setVisibility(View.VISIBLE);
        } else {
            holder.divider.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If card ID is set, we can navigate back to GaleriActivity
                // and highlight the specific card
                if (currentItem.getCardId() != -1) {
                    Intent intent = new Intent(context, GaleriActivity.class);
                    intent.putExtra("HIGHLIGHT_CARD_ID", currentItem.getCardId());
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }

    // Method to filter the list based on search query
    public void filter(String query) {
        fileList = new ArrayList<>();
        if (query.isEmpty()) {
            fileList.addAll(originalList);
        } else {
            String lowerCaseQuery = query.toLowerCase(Locale.getDefault());
            for (FileItem item : originalList) {
                // Search in name and description
                if (item.getName().toLowerCase(Locale.getDefault()).contains(lowerCaseQuery) ||
                        item.getDescription().toLowerCase(Locale.getDefault()).contains(lowerCaseQuery)) {
                    fileList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    // Method to set new data
    public void setData(List<FileItem> newData) {
        fileList = newData;
        originalList.clear();
        originalList.addAll(newData);
        notifyDataSetChanged();
    }
}