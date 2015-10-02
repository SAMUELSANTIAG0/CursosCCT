package np1.android.unifor.br.cursoscct;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Samuel Santiago on 01/10/2015.
 */
public class CursoDAO extends SQLiteOpenHelper{


    public static final int VERSAO = 1;
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

        CursoBean curso1 = new CursoBean(1, "ADS", "tecnologico", "superior", "2 anos e meio", "lia");
        CursoBean curso2 = new CursoBean(2,"Curso 2", "Descrição do curso 2", "nivel do curso 2", "tempo do curso 2", "coordenador do curso 2");
        CursoBean curso3 = new CursoBean(3,"Curso 3", "Descrição do curso 3", "nivel do curso 3", "tempo do curso 3", "coordenador do curso 3");
        CursoBean curso4 = new CursoBean(4,"Curso 4", "Descrição do curso 4", "nivel do curso 4", "tempo do curso 4", "coordenador do curso 4");
        CursoBean curso5 = new CursoBean(5,"Curso 5", "Descrição do curso 5", "nivel do curso 5", "tempo do curso 5", "coordenador do curso 5");

        inserirRegistro(curso1);
        inserirRegistro(curso2);
        inserirRegistro(curso3);
        inserirRegistro(curso4);
        inserirRegistro(curso5);
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

    public ArrayList<CursoBean> consultarRegistros(){

        // Criação da lista de academias que será retornada para a aplicação.
        // Os objetos serão construidos com base nos registros existentes na
        // base de dados SQLite
        ArrayList<CursoBean> listaCursos = new ArrayList<CursoBean>();

        // Definição do comando SQL para recuperar instancias de academia
        // que já estão persistidas na base de dados.

        String sql = "Select * from curso order by nome" ;

        // Criação do objeto pra receber os registros do banco de dados
        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        // Os blocos try, catch e finally são utilizados para o tratamento de exceções
        try{
            while(cursor.moveToNext()){
                // Criação da instancia de curso utilizando informações
                // provenientes da base de dados
                CursoBean curso = new CursoBean();

                // Construindo o objeto a partir dos registros da base de dados
                curso.setId(cursor.getInt(0));
                curso.setNome(cursor.getString(1));
                curso.setDescricao(cursor.getString(2));
                curso.setTitulacao(cursor.getString(3));
                curso.setTempoDeDuracao(cursor.getString(4));
                curso.setCoordenador(cursor.getString(5));

                // Adicionando a instancia de curso a lista de academias
                listaCursos.add(curso);
            }
        }catch(SQLException sqle){
            //Log.e(TAG_L, sqle.getMessage());
        }finally{
            cursor.close();
        }

        // Ao final deve ser retornada a lista com todo os academias
        // existentes na base de dados
        return listaCursos;
    }


}
