package TFPOO;

public abstract class CLT {
    private String nome;
    private int id, idade, cpf;
    protected double salario;

    public CLT(String nome, int id, int idade, int cpf, double salario){
        setNome(nome);
        setId(id);
        setIdade(idade);
        setCpf(cpf);
        setSalario(salario);
    }
    public CLT() {
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
