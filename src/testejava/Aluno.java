package testejava;

/**
 *
 * @author Verônica Oliveira
 */
public class Aluno extends Pessoa {
    
    private float notaFinal;
    
    public Aluno(String nome, String telefone, String dataNascimento, float notaFinal){
        super (nome, telefone, dataNascimento);
        this.notaFinal = notaFinal;
    
    }

    
    public float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }
    
    
    
    
    
}
