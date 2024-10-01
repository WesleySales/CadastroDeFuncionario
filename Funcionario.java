
package entities;

import java.util.ArrayList;
import java.util.List;


public class Funcionario {
    private static Long GERADOR_ID=1L;
    private Long id;
    private String nome;
    private double salario;
    private static List<Funcionario> listaDeFuncionarios = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(String nome, double salario) {
        this.id = GERADOR_ID++;
        this.nome = nome;
        this.salario = salario;
    }
    
    public static void cadastrarFuncionario (String nome, double salario){
        Funcionario novoFuncionario = new Funcionario(nome, salario);
        listaDeFuncionarios.add(novoFuncionario);
    }
    
    public static Funcionario buscarFuncionarioPorId(Long id){
        Funcionario funcionarioPorId = null;
        if(!listaDeFuncionarios.isEmpty()){
            for(Funcionario func:listaDeFuncionarios){
                if(func.id==id){
                    funcionarioPorId=func;
                }
            }
        }
        return funcionarioPorId;
    }
    
    public static void editarFuncionario(Long id, String novoNome, double novoSalario){
        Funcionario f = buscarFuncionarioPorId(id);
        f.setNome(novoNome);
        f.setSalario(novoSalario);
    }
    
    public static void deletarFuncionario(Long id){
        Funcionario f = buscarFuncionarioPorId(id);
        listaDeFuncionarios.remove(f);
    }
    
    public static String exibirFuncionarios(){
        if(!listaDeFuncionarios.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for(Funcionario func: listaDeFuncionarios){
                sb.append(func).append("\n");
            }
            return sb.toString();
        }
        return "A lista está vazia";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome.length()>=3){
           this.nome = nome; 
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if(salario>=0){
            this.salario = salario;
        }
    }

    public static List<Funcionario> getListaDeFuncionarios() {
        return listaDeFuncionarios;
    }
    

    @Override
    public String toString() {
        return String.format("ID: %d - Nome: %s - Salário: R$%.2f", id,nome,salario);
    }
    
    
    
}
