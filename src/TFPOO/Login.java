package TFPOO;
import java.util.Scanner;

public class Login {
    Conta login;
    String username;
    String password;

    public Login(String user, String pass){
        this.username = user;
        this.password = pass;
    }

    public void entrar() {
        while (true) {
            MenuEst est = new MenuEst();
            MenuAdm adm = new MenuAdm();
            System.out.println("---------------------------------");
            System.out.print("""
                Login gerente  | Login estoquista
                ---------------------------------
                User - admin   | User - estq
                Password - 123 | Password - 123
                """);
            System.out.println("----------------------------------\n");

            System.out.println("------------Login------------");
            System.out.print("Usuario: ");
            setUsername(scanner.next());
            System.out.print("Senha: ");
            setPassword(scanner.next());

            for (Conta conta : Conta.values()) {
                if (conta.username.equals(username) && conta.password.equals(password)) {
                    this.login = conta;
                }
            }
            if (login == Conta.EST) {
                System.out.println("Login valido para estoquista.\n");
                est.menuEst();
                this.login = null;
            } else if (login == Conta.ADM) {
                System.out.println("Menu valido para gerente\n");
                adm.menuAdm();
                this.login = null;
            }else {
                System.out.println("usuario ou senha invalidos, tente novamente.\n");
                continue;
            }
        }
    }

    //Geetters and Setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    Scanner scanner = new Scanner(System.in);
}
