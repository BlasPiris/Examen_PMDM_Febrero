package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String [] prefijos =new String[]{"Allo","Stego","Brachio","Tyranno",
            "Diplo","Tricera","Archaeo","Ankylo","Para",
            "Spino","Megalo","Hadro","Megalo"};
    String [] sufijos = new String[]{"saurus","tops","raptor","teryx","docus","odon"};
    String [] apellido = new String[]{"Rex", "Antartica", "Mayorum", ""};

    ArrayList<String> allDino;
    ArrayList<String> tenDino;

    int numDino=10;

    RecyclerView recyclerView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.list);
        allDino=generarNombre();
        tenDino=getTenDino(allDino,numDino);



        MyItemRecyclerViewAdapter adapter=new MyItemRecyclerViewAdapter(tenDino);
        recyclerView.setAdapter(adapter);


    }

    public ArrayList<String> generarNombre(){
        ArrayList<String> arrayNombres=new ArrayList<>();
        for (int i = 0; i < prefijos.length; i++) {
            for (int j = 0; j < sufijos.length ; j++) {
                for (int k = 0; k < apellido.length; k++) {
                    String name=prefijos[i]+sufijos[j]+" "+apellido[k];
                    arrayNombres.add(name);
                    Log.d("NOMBRE",name);
                }
            }

        }
        Log.d("ARRAYLIST",String.valueOf(arrayNombres));
        return arrayNombres;
    }

    public ArrayList<String> getTenDino(ArrayList<String> allDino,int numDino){

        ArrayList<String> tenDino=new ArrayList<>();
        for (int i = 0; i < numDino; i++) {
            Random rn=new Random();
            int rand= rn.nextInt(allDino.size());
            if(!tenDino.contains(allDino.get(rand))){
                tenDino.add(allDino.get(rand));

            }else{
                i--;
            }

        }

        return tenDino;
    }
}