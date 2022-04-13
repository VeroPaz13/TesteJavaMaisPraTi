package testejava;


import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 *
 * @author Verônica Oliveira
 */
public abstract class Pessoa {
    Scanner ler = new Scanner (System.in);
    
    //Atributos  
    private String nome;
    private String telefone;
    private String dataNascimento;
    private String dataCadastro;
    private String dataAlteracao;
    
    //Construtor
    public Pessoa(String nome, String telefone, String dataNascimento){
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.setDataAlteracao();
        this.setDataCadastro();
    }

    //Métodos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataCadastro() {
        return this.dataCadastro;
    }

    private void setDataCadastro() {
        this.dataCadastro = this.DataAgora();
    }

    public String getDataAlteracao() {
        return this.dataAlteracao;
    }

    public void setDataAlteracao() {
        this.dataAlteracao = this.DataAgora();
    }
    
    private String DataAgora(){
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
    
    
}
