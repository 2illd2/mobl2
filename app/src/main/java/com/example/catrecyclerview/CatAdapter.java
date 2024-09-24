package com.example.catrecyclerview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {

    private List<Cat> catList;
    private Context context;

    public CatAdapter(List<Cat> catList, Context context) {
        this.catList = catList;
        this.context = context;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cat, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = catList.get(position);
        holder.catImageView.setImageResource(cat.getImageResId());
        holder.catTextView.setText(cat.getText());

        // Устанавливаем обработчик нажатий
        holder.itemView.setOnClickListener(v -> {
            // Показываем всплывающее сообщение с текстом котика
            Toast.makeText(context, cat.getText(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    public static class CatViewHolder extends RecyclerView.ViewHolder {
        ImageView catImageView;
        TextView catTextView;

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            catImageView = itemView.findViewById(R.id.catImageView);
            catTextView = itemView.findViewById(R.id.catTextView);
        }
    }
}