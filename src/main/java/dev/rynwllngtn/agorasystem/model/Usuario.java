package dev.rynwllngtn.agorasystem.model;

public class Usuario {

    //Indentificação
    private String cpf;
    private String nome;
    private String dataNascimento;
    private boolean isActive;

    //Login e Contato
    private String email;
    private String senha;

    public Usuario(String cpf, String nome, String dataNascimento, String email, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
        this.isActive = true;
    }

    public void getStatus() {
        System.out.println("----User Status----");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Data de nascimento: " + getDataNascimento());
        System.out.println("Email: " + getEmail());
        System.out.println("É ativo?: " + isActive());
        System.out.println("-------------------");
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
