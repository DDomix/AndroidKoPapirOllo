package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView emberkep;
    private ImageView gepkep;
    private TextView eredmeny;
    private Button kogomb;
    private Button papirgomb;
    private Button ollogomb;
    private Random rnd;
    private int gyozelmek;
    private int gepgyozelmek;
    private AlertDialog.Builder builderVege;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        kogomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emberkep.setImageResource(R.drawable.rock);
                int geptipp=rnd.nextInt(2);
                if (geptipp==0){
                    gepkep.setImageResource(R.drawable.rock);
                    Toast.makeText(MainActivity.this, "Döntetlen lett", Toast.LENGTH_SHORT).show();
                } else if(geptipp==1){
                    gepkep.setImageResource(R.drawable.paper);
                    Toast.makeText(MainActivity.this, "A gép nyert", Toast.LENGTH_SHORT).show();
                    gepgyozelmek++;
                    eredmeny.setText(String.format("Eredmény: Ember : %d, Computer : %d",gyozelmek,gepgyozelmek));
                }
                else{
                    gepkep.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "Te nyertél", Toast.LENGTH_SHORT).show();
                    gyozelmek++;
                    eredmeny.setText(String.format("Eredmény: Ember : %d, Computer : %d",gyozelmek,gepgyozelmek));
                }
                if (gyozelmek==3){
                    builderVege.setTitle("Győzelem");
                    AlertDialog dialog = builderVege.create();
                    dialog.show();
                }else if(gepgyozelmek==3){
                    builderVege.setTitle("Vereség");
                    AlertDialog dialog = builderVege.create();
                    dialog.show();
                }
            }
        });

        papirgomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emberkep.setImageResource(R.drawable.paper);
                int geptipp=rnd.nextInt(2);
                if (geptipp==0){
                    gepkep.setImageResource(R.drawable.rock);
                    Toast.makeText(MainActivity.this, "Te nyertél", Toast.LENGTH_SHORT).show();
                    gyozelmek++;
                    eredmeny.setText(String.format("Eredmény: Ember : %d, Computer : %d",gyozelmek,gepgyozelmek));

                } else if(geptipp==1){
                    gepkep.setImageResource(R.drawable.paper);
                    Toast.makeText(MainActivity.this, "Döntetlen lett", Toast.LENGTH_SHORT).show();
                }
                else{
                    gepkep.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "A gép nyert", Toast.LENGTH_SHORT).show();
                    gepgyozelmek++;
                    eredmeny.setText(String.format("Eredmény: Ember : %d, Computer : %d",gyozelmek,gepgyozelmek));
                }
                if (gyozelmek==3){
                    builderVege.setTitle("Győzelem");
                    AlertDialog dialog = builderVege.create();
                    dialog.show();
                }else if(gepgyozelmek==3){
                    builderVege.setTitle("Vereség");
                    AlertDialog dialog = builderVege.create();
                    dialog.show();
                }
            }
        });

        ollogomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emberkep.setImageResource(R.drawable.scissors);
                int geptipp=rnd.nextInt(2);
                if (geptipp==0){
                    gepkep.setImageResource(R.drawable.rock);
                    Toast.makeText(MainActivity.this, "A gép nyert", Toast.LENGTH_SHORT).show();
                    gepgyozelmek++;
                    eredmeny.setText(String.format("Eredmény: Ember : %d, Computer : %d",gyozelmek,gepgyozelmek));
                } else if(geptipp==1){
                    gepkep.setImageResource(R.drawable.paper);
                    Toast.makeText(MainActivity.this, "Te nyertél", Toast.LENGTH_SHORT).show();
                    gyozelmek++;
                    eredmeny.setText(String.format("Eredmény: Ember : %d, Computer : %d",gyozelmek,gepgyozelmek));
                }
                else{
                    gepkep.setImageResource(R.drawable.scissors);
                    Toast.makeText(MainActivity.this, "Döntetlen lett", Toast.LENGTH_SHORT).show();
                }
                if (gyozelmek==3){
                    builderVege.setTitle("Győzelem");
                    AlertDialog dialog = builderVege.create();
                    dialog.show();
                }else if(gepgyozelmek==3){
                    builderVege.setTitle("Vereség");
                    AlertDialog dialog = builderVege.create();
                    dialog.show();
                }
            }
        });

    }
    public void init(){
        this.emberkep=findViewById(R.id.emberkep);
        this.gepkep=findViewById(R.id.gepkep);
        this.eredmeny=findViewById(R.id.eredmeny);
        this.kogomb=findViewById(R.id.kogomb);
        this.papirgomb=findViewById(R.id.papirgomb);
        this.ollogomb=findViewById(R.id.ollogomb);
        rnd=new Random();
        gyozelmek=0;
        gepgyozelmek=0;
        builderVege = new AlertDialog.Builder(MainActivity.this);
        builderVege.setCancelable(false).setMessage("Szeretne új játékot játszani?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ujJatek();
                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
    }

    private void ujJatek() {
        gyozelmek=0;
        gepgyozelmek=0;
        emberkep.setImageResource(R.drawable.rock);
        gepkep.setImageResource(R.drawable.rock);
    }
}