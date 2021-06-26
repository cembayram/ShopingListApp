package com.example.shopinglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlisverisAdapter extends RecyclerView.Adapter<AlisverisAdapter.ViewHolder> {

    Context context;
    List<Alisveris> alisverisList;
    RecyclerView rvAlisveris;

    final View.OnClickListener onClickListener = new MyOnClickListener();

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView alisverisAdi;
        TextView urunAdi;
        TextView urunMiktari;
        TextView urunAdedi;
        TextView urunFiyati;
        TextView urunNot;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.item_id);
            alisverisAdi = itemView.findViewById(R.id.itemAlisverisAdi);
            urunAdi = itemView.findViewById(R.id.itemUrunAdi);
            urunMiktari = itemView.findViewById(R.id.itemUrunMiktari);
            urunAdedi = itemView.findViewById(R.id.itemUrunAdedi);
            urunFiyati = itemView.findViewById(R.id.itemUrunFiyati);
            urunNot = itemView.findViewById(R.id.itemUrunNot);


        }
    }
    public AlisverisAdapter(Context context, List<Alisveris> alisverisList,RecyclerView rvAlisveris){
        this.context=context;
        this.alisverisList=alisverisList;
        this.rvAlisveris=rvAlisveris;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public AlisverisAdapter.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup viewGroup = null;
        View view = inflater.inflate(R.layout.single_item,viewGroup,false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull AlisverisAdapter.ViewHolder viewHolder, int position) {
        Alisveris alisveris = alisverisList.get(position);
        viewHolder.id.setText(""+alisveris.getId());
        viewHolder.alisverisAdi.setText(alisveris.getAlisverisAdi());
        viewHolder.urunAdi.setText(alisveris.getUrunAdi());
        viewHolder.urunMiktari.setText(alisveris.getUrunMiktari());
        viewHolder.urunAdedi.setText(alisveris.getUrunAdedi());
        viewHolder.urunFiyati.setText(alisveris.getUrunFiyati());
        viewHolder.urunNot.setText(alisveris.getUrunNot());

    }
    @Override
    public int getItemCount() {
        return alisverisList.size();
    }
    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int itemPosition = rvAlisveris.getChildLayoutPosition(v);
            String item = alisverisList.get(itemPosition).getAlisverisAdi();
            Toast.makeText(context, item, Toast.LENGTH_SHORT).show();

        }
    }
}
