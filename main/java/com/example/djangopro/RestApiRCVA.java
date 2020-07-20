package com.example.djangopro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;

import org.json.JSONObject;

import java.util.ArrayList;

public class RestApiRCVA extends RecyclerView.Adapter<RestApiRCVA.ViewHolder> {
    Context context;
    ArrayList<ForRest> forRests;
    OnItemClickListener mylistener;

    public RestApiRCVA(Context context, ArrayList<ForRest> forRests) {
        this.context =  context;
        this.forRests = forRests;
    }

    interface  OnItemClickListener{
        void OnClick(int position);
    }

    public void setOnRCVItemClickListener(OnItemClickListener mylistener){
        this.mylistener=mylistener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.forestapi,parent,false);
        ViewHolder holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestApiRCVA.ViewHolder holder, int position) {
        ForRest forRest = forRests.get(position);
        holder.post.setText(forRest.getPost());
        holder.title.setText(forRest.getTitle());
        holder.author.setText(forRest.getAuthor());
        holder.created.setText(forRest.getCreationdate());
    }



    @Override
    public int getItemCount() {
        return forRests.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView author,title,post,created;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            post=itemView.findViewById(R.id.post);
            title=itemView.findViewById(R.id.title);
            author=itemView.findViewById(R.id.author);
            created = itemView.findViewById(R.id.cdate);

//use the usual setOnClickListener and then use the interface & its methods
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mylistener!=null){
                        int position =getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            mylistener.OnClick(position);
                        }
                    }
                }
            });
        }
    }
}
