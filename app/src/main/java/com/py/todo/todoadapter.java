package com.py.todo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class todoadapter extends RecyclerView.Adapter<todoadapter.MyViewHolder> {

    Context context;
    ArrayList<todo> myDoes;

    public todoadapter(Context c, ArrayList<todo> p) {
        context = c;
        myDoes = p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.todo, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.titledoes.setText(myDoes.get(i).getTitledoes());
        myViewHolder.descdoes.setText(myDoes.get(i).getDescdoes());
        myViewHolder.datedoes.setText(myDoes.get(i).getDatedoes());

        final String getTitleDoes = myDoes.get(i).getTitledoes();
        final String getDescDoes = myDoes.get(i).getDescdoes();
        final String getDateDoes = myDoes.get(i).getDatedoes();
        final String id = myDoes.get(i).getid();

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("KLJ", String.valueOf(myDoes.get(i).getid()));
                Intent aa = new Intent(context, Edittask.class);
                aa.putExtra("titledoes", getTitleDoes);
                aa.putExtra("id",id);
                aa.putExtra("descdoes", getDescDoes);
                aa.putExtra("datedoes", getDateDoes);

                context.startActivity(aa);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myDoes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titledoes, descdoes, datedoes, keydoes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titledoes = (TextView) itemView.findViewById(R.id.titledoes);
            descdoes = (TextView) itemView.findViewById(R.id.descdoes);
            datedoes = (TextView) itemView.findViewById(R.id.datedoes);
        }
    }
}
