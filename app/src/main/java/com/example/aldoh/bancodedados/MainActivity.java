package com.example.aldoh.bancodedados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText placa = (EditText)findViewById(R.id.editText);
                EditText carro = (EditText)findViewById((R.id.editText2));
                EditText ano = (EditText)findViewById(R.id.editText3);
                String placaString = placa.getText().toString();
                String carroString = carro.getText().toString();
                String anoString = ano.getText().toString();
                String resultado;

                resultado = crud.insereDado(placaString,carroString,anoString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });

        Button Listar = (Button)findViewById(R.id.listarTodos);

        Listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
