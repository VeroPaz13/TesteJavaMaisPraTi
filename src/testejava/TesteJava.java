
package testejava;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Verônica Oliveira
 */
public class TesteJava {

    public static void main(String[] args) {
        Scanner ler = new Scanner (System.in);
        ArrayList <Pessoa> cadastro = new ArrayList(); 
        String opcao;
        int menu;
       
        do{
            //Menu de funções
            System.out.println("------ MENU ------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar ");
            System.out.println("4 - Deletar");
            System.out.println("5 - Sair");
            menu = ler.nextInt();
            
            switch(menu){
                case 1:
                    ler.nextLine();
                    //Essa opção coleta dados para criar objeto fazendo distinção de usuário comum e aluno
                        System.out.println("Nome:");
                        String nome = ler.nextLine();
                        System.out.println("Telefone: ");
                        String telefone = ler.nextLine();
                        System.out.println("Data de Nascimento no formato dd/mm/aaaa: ");
                        String dataN = ler.nextLine();
                        
                        System.out.println("Deseja informar nota final? S - Sim / N - Não");
                        opcao = ler.nextLine();
                        if("S".equalsIgnoreCase(opcao)){
                            System.out.println("Informe nota final");
                            float nota = ler.nextFloat();
                            Aluno aluno = new Aluno(nome, telefone, dataN, nota);
                            cadastro.add(aluno);
                        }else{
                            Pessoa pessoa = new Pessoa(nome,telefone,dataN) {};
                            cadastro.add(pessoa);
                        }
                        break;
                        
                    case 2:
                    //Esta opção lista item cadastrados
                    if(!cadastro.isEmpty()){
                        System.out.println("===== Usuários =====");
                        for(Pessoa dados:cadastro){
                            System.out.println("Nome: " + dados.getNome());
                            System.out.println("Telefone: " + dados.getTelefone());
                            System.out.println("Data de nascimento: " + dados.getDataNascimento());
                            System.out.println("Data Cadastro: " + dados.getDataCadastro());
                            System.out.println("Data Atualização: " + dados.getDataAlteracao());

                            if (dados instanceof Aluno){
                                Aluno aluno = (Aluno)dados;
                                System.out.println("Nota Final: " + aluno.getNotaFinal());
                            }

                            System.out.println("--------------------------------");
                        }
                    }else{
                        System.out.println("==> Lista vazia");
                    }
                    break;
                case 3:
                    //Esta opção permite alterar dados de usuário
                                        
                    ler.nextLine();
                    System.out.println("==> Informe o nome do usuário que deseja atualizar");
                    String nomeAtualizar = ler.nextLine();
                    for(Pessoa dados:cadastro){
                        if(nomeAtualizar.equals(dados.getNome())){
                            int indice = cadastro.indexOf(dados);

                            System.out.println("Nome:");
                            nome = ler.nextLine(); 
                            dados.setNome(nome);
                            System.out.println("Telefone: ");
                            telefone = ler.nextLine();
                            dados.setTelefone(telefone);
                            System.out.println("Data de Nascimento no formato dd/mm/aaaa: ");
                            dataN = ler.nextLine();
                            dados.setDataNascimento(dataN);

                            if (dados instanceof Aluno){
                                System.out.println("Informe nota final");
                                float nota = ler.nextFloat();

                                ((Aluno) dados).setNotaFinal(nota);
                            }
                            dados.setDataAlteracao();
                            cadastro.set(indice, dados);                        

                            System.out.println("Atualizado com sucesso!");
                            System.out.println("\n---------------------------\n");
                            break;
                        }if(nomeAtualizar !=(dados.getNome())){
                            System.out.println("==> Usuário  não encontrado!!!");
                            break;
                        }
                    }
                    
                    break;    
                case 4:
                    //Esta opção permite excluir itens do cadastro
                    ler.nextLine();
                    
                    System.out.println("==> Informe o nome do usuário que deseja excluir");
                    String nomeExcluir = ler.nextLine();
                    for(Pessoa dados:cadastro){
                        if(nomeExcluir.equals(dados.getNome())){

                            cadastro.remove(dados);
                            System.out.println("Excluido com sucesso!");
                            System.out.println("\n---------------------------\n");
                            break;
                        }else{
                            System.out.println("==> Usuário  não encontrado!!!");
                            break;
                        }
                    }    
                    break;
                case 5:
                    //Esta opção sai do programa
                    System.out.println("Saindo...");
                    break;
                default:
                    //gera alerta caso o usuário digite opção que não conste na lista de menu
                    System.out.println("Opção inválida!");
            }
               
        }while(menu != 5);
    }    
}
