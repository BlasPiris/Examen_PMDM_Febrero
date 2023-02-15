package com.example.myapplication;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.myapplication.databinding.FragmentItemBinding;

import java.util.ArrayList;
import java.util.Random;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<String> mValues;

    public MyItemRecyclerViewAdapter(ArrayList<String> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem =mValues.get(position);
        holder.mIdView.setText(String.valueOf(position));
        holder.mContentView.setText(mValues.get(position));

       holder.imageView.setImageResource(setRandomDinoImage());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               Intent i=new Intent();
//               i.setAction(Intent.EXTRA_EMAIL);
//               i.putExtra("to","misdinosaurios@gmail.com");
//               i.putExtra("subject","He creado el nombre de un dinosaurio");
//               i.putExtra("text","Hola!!. El nuevo dinosaurio se llama "+mValues.get(position));
//               v.getContext().startActivity(i);

                Toast.makeText(v.getContext(),"Hola!!. El nuevo dinosaurio se llama "+mValues.get(position),Toast.LENGTH_SHORT ).show();

            }
        });


    }

    private int setRandomDinoImage() {
        Random rd=new Random();
        int rand=rd.nextInt(4);
        if(rand==0){
            return R.mipmap.dino1;
        }else {
            if(rand==2){
                return R.mipmap.dino2;
            }else{
                if(rand==3){
                    return R.mipmap.dino3;
                }else{
                    return R.mipmap.dino4;
                }
            }
        }

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public String mItem;

        public ImageView imageView;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
            imageView=binding.image;

        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}