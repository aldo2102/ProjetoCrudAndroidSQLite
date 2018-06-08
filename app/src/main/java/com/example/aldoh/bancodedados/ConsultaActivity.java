package com.example.aldoh.bancodedados;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ConsultaActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Cursor cursor;
        setContentView(R.layout.activity_consulta);

            BancoController crud = new BancoController(getBaseContext());
            cursor = crud.carregaDados();

            final String[] nomeCampos = new String[] {CriaBanco.ID, CriaBanco.NOME};
            int[] idViews = new int[] {R.id.idCarro, R.id.nomeCarro};

            SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                    R.layout.activity_consulta,cursor,nomeCampos,idViews, 0);
            lista = (ListView)findViewById(R.id.listView);
            lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.ID));
                Intent intent = new Intent(ConsultaActivity.this, AlterarActivity.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });

    }
}
