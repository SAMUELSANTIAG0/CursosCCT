package np1.android.unifor.br.cursoscct;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Samuel Santiago on 01/10/2015.
 */
public class CursoBean implements Parcelable{

    private int id;
    private String nome;
    private String descricao;
    private String titulacao;
    private String tempoDeDuracao;
    private String coordenador;

    public static CursoBean curso1 = new CursoBean(1, "ADS", "tecnologico", "superior", "2 anos e meio", "lia");
    public static CursoBean curso2 = new CursoBean(2,"Curso 2", "Descrição do curso 2", "nivel do curso 2", "tempo do curso 2", "coordenador do curso 2");
    public static CursoBean curso3 = new CursoBean(3,"Curso 3", "Descrição do curso 3", "nivel do curso 3", "tempo do curso 3", "coordenador do curso 3");
    public static CursoBean curso4 = new CursoBean(4,"Curso 4", "Descrição do curso 4", "nivel do curso 4", "tempo do curso 4", "coordenador do curso 4");
    public static CursoBean curso5 = new CursoBean(5,"Curso 5", "Descrição do curso 5", "nivel do curso 5", "tempo do curso 5", "coordenador do curso 5");

    public static final Creator<CursoBean> CREATOR = new Creator<CursoBean>() {
        @Override
        public CursoBean createFromParcel(Parcel in) {
            return new CursoBean(in);
        }

        @Override
        public CursoBean[] newArray(int size) {
            return new CursoBean[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public String getTempoDeDuracao() {
        return tempoDeDuracao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public String setNome(String nome) {
        this.nome = nome;
        return nome;
    }

    public String setDescricao(String descricao) {
        this.descricao = descricao;
        return descricao;
    }

    public String setTitulacao(String titulacao) {
        this.titulacao = titulacao;
        return titulacao;
    }

    public String setTempoDeDuracao(String tempoDeDuracao) {
        this.tempoDeDuracao = tempoDeDuracao;
        return tempoDeDuracao;
    }

    public String setCoordenador(String coordenador) {
        this.coordenador = coordenador;
        return coordenador;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nome);
        dest.writeString(descricao);
        dest.writeString(titulacao);
        dest.writeString(tempoDeDuracao);
        dest.writeString(coordenador);
    }

    private void readFromParcelable(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        descricao = in.readString();
        titulacao = in.readString();
        tempoDeDuracao = in.readString();
        coordenador = in.readString();
    }

    public CursoBean(Parcel in) {
        readFromParcelable(in);
    }

    public CursoBean(int id, String nome, String descricao, String titulacao, String tempoDeDuracao, String coordenador) {
        this.id = setId(id);
        this.nome = setNome(nome);
        this.descricao = setDescricao(descricao);
        this.titulacao = setTitulacao(titulacao);
        this.tempoDeDuracao = setTempoDeDuracao(tempoDeDuracao);
        this.coordenador = setCoordenador(coordenador);
    }
    public CursoBean(){

    }
}
