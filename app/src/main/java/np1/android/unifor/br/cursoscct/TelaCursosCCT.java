package np1.android.unifor.br.cursoscct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class TelaCursosCCT extends AppCompatActivity {

    private int escolha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cursos_cct);

        ListView lista = (ListView) findViewById(R.id.lvCursos);
        registerForContextMenu(lista);
        ArrayList<String> cursos = preencherDados();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, cursos);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                escolha = position;
            }
        });

    }

    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<>();
        dados.add("ADS");
        dados.add("Curso 2");
        dados.add("Curso 3");
        dados.add("Curso 4");
        dados.add("Curso 5");
        return dados;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contexto, menu);
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intencao = new Intent(TelaCursosCCT.this, TelaDetalhes.class);
        Bundle parametros = new Bundle();
        switch (item.getItemId()) {
            case R.id.itemDetalhes:
                switch (escolha) {
                    case 0:
                        parametros.putInt("curso", 1);
                        intencao.putExtras(parametros);
                        startActivity(intencao);
                        break;
                    case 1:
                        parametros.putInt("curso", 2);
                        intencao.putExtras(parametros);
                        startActivity(intencao);
                        break;
                    case 2:
                        parametros.putInt("curso", 3);
                        intencao.putExtras(parametros);
                        startActivity(intencao);
                        break;
                    case 3:
                        parametros.putInt("curso", 4);
                        intencao.putExtras(parametros);
                        startActivity(intencao);
                        break;
                    case 4:
                        parametros.putInt("curso", 5);
                        intencao.putExtras(parametros);
                        startActivity(intencao);
                        break;
                    default:
                        startActivity(intencao);
                        break;
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
