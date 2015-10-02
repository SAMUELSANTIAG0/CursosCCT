package np1.android.unifor.br.cursoscct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TelaDetalhes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_detalhes);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contexto, menu);

        ListView lista = (ListView) findViewById(R.id.lvCursos);
        ArrayList<String> cursos = preencherDados();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, cursos);
        lista.setAdapter(arrayAdapter);

        return true;
    }

    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<>();
        Intent intent = getIntent();
        Bundle args = intent.getExtras();
        int tipoCurso = args.getInt("curso");

        switch (tipoCurso){
            case 1:
                dados.add(CursoBean.curso1.getNome());
                dados.add(CursoBean.curso1.getDescricao());
                dados.add(CursoBean.curso1.getTitulacao());
                dados.add(CursoBean.curso1.getTempoDeDuracao());
                dados.add(CursoBean.curso1.getCoordenador());
                break;
            case 2:
                dados.add(CursoBean.curso2.getNome());
                dados.add(CursoBean.curso2.getDescricao());
                dados.add(CursoBean.curso2.getTitulacao());
                dados.add(CursoBean.curso2.getTempoDeDuracao());
                dados.add(CursoBean.curso2.getCoordenador());
                break;
            case 3:
                dados.add(CursoBean.curso3.getNome());
                dados.add(CursoBean.curso3.getDescricao());
                dados.add(CursoBean.curso3.getTitulacao());
                dados.add(CursoBean.curso3.getTempoDeDuracao());
                dados.add(CursoBean.curso3.getCoordenador());
                break;
            case 4:
                dados.add(CursoBean.curso4.getNome());
                dados.add(CursoBean.curso4.getDescricao());
                dados.add(CursoBean.curso4.getTitulacao());
                dados.add(CursoBean.curso4.getTempoDeDuracao());
                dados.add(CursoBean.curso4.getCoordenador());
                break;
            case 5:
                dados.add(CursoBean.curso5.getNome());
                dados.add(CursoBean.curso5.getDescricao());
                dados.add(CursoBean.curso5.getTitulacao());
                dados.add(CursoBean.curso5.getTempoDeDuracao());
                dados.add(CursoBean.curso5.getCoordenador());
                break;
        }

        return dados;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
