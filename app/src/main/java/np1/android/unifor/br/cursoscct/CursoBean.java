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
}
