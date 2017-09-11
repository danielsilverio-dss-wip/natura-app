package br.com.fiap.natura.naturaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SucessfulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucessful);
    }

    public void finaliza(View v){
        Intent intent = new Intent(this, ProjectListActivity.class);
        startActivity(intent);
    }
}
