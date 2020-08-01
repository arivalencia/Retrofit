package com.example.dvoladaaliado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dvoladaaliado.activities.ImprovePackageActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnRecharge;
    Button btnImprove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonRecharge :
                //Abrir Intent RECARGAR
                break;
            case R.id.buttonImprove :
                startActivity(new Intent(this, ImprovePackageActivity.class));
                break;
            default:

        }
    }

    public void initializeVariables(){
        btnRecharge = findViewById(R.id.buttonRecharge);
        btnImprove = findViewById(R.id.buttonImprove);
        btnRecharge.setOnClickListener(this);
        btnImprove.setOnClickListener(this);
    }
}
