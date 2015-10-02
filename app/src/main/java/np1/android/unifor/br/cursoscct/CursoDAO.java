package np1.android.unifor.br.cursoscct;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Samuel Santiago on 01/10/2015.
 */
public class CursoDAO extends SQLiteOpenHelper{


    public static final int VERSAO = 3;
    public static final String TABELA = "curso";
    public static final String DATABASE = "CURSO.DB";

    public CursoDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public CursoDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public CursoDAO(Context context){
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Consulta SQL de criação da tabela.
        String sql = "CREATE TABLE curso" + TABELA
                + "(id INTEGER PRIMARY KEY, "
                + "nome TEXT, "
                + "descrisao TEXT, "
                + "titulacao TEXT,"
                + "tempo TEXT,  "
                + "coordenador TEXT);";

        // Execução do comando para criação de tabelas no SQLite
        db.execSQL(sql);
        inserirRegistro(new CursoBean(1,"ADS","tecnologico","superior","2 anos e meio", "lia"));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+ TABELA;
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserirRegistro(CursoBean curso){
        ContentValues valores = new ContentValues();

        valores.put("nome", curso.getNome());
        valores.put("descricao", curso.getDescricao());
        valores.put("titulacao", curso.getTitulacao());
        valores.put("tempo", curso.getTempoDeDuracao());
        valores.put("coordenador", curso.getCoordenador());
        getWritableDatabase().insert(TABELA, null, valores);
    }
}
