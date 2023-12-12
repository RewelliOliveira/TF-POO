package TFPOO;

public enum Conta {
    ADM("admin", "123"),
    EST("estq", "123");

    String username, password;

    private Conta(String user, String pass){
        this.username = user;
        this.password = pass;
    }
}
