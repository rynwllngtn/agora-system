package dev.rynwllngtn.agorasystem;

import dev.rynwllngtn.agorasystem.model.Conta;
import dev.rynwllngtn.agorasystem.model.Enums.Enums;
import dev.rynwllngtn.agorasystem.model.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario User = new Usuario(
                "1112223334",
                "Usuário 1",
                "20000101",
                "user@domain.com",
                "1234567890");

        User.getStatus();

        Conta userCorrente = new Conta(User, Enums.ContaTipo.CORRENTE);
        Conta userPoupanca = new Conta(User, Enums.ContaTipo.POUPANÇA);
        userCorrente.getStatus();
        userPoupanca.getStatus();
    }
}
