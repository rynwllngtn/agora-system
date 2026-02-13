package dev.rynwllngtn.agorasystem.model;

import dev.rynwllngtn.agorasystem.model.Enums.Enums;

public class Conta {
    private int contaID;
    private Usuario usuario;
    private Enums.ContaTipo contaTipo;
    private float saldo;

    private static int nextID = 1;
    public Conta(Usuario usuario, Enums.ContaTipo contaTipo) {
        this.contaID = nextID++;
        this.usuario = usuario;
        this.contaTipo = contaTipo;
        this.saldo = 0.0f;
    }

    public void getStatus() {
        System.out.println("----Bank Status----");
        System.out.println("ID: " + getContaID());
        System.out.println("Nome: " + getUsuario());
        System.out.println("Tipo: " + getContaTipo());
        System.out.printf("Saldo: R$%.02f%n", getSaldo());
        System.out.println("-------------------");
    }

    public int getContaID() {
        return contaID;
    }

    public String getUsuario() {
        return usuario.getNome();
    }

    public Enums.ContaTipo getContaTipo() {
        return contaTipo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
