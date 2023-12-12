package TFPOO;
import java.util.Scanner;

public class MenuAdm {
    public void menuAdm(){
        CrudAdm adm = new CrudAdm();
        while(true){
            System.out.println("------------Menu Gerente------------");
            System.out.println("""
                    1- Contratar funcionarios\s
                    2- Demitir Funcionarios
                    3- Mostrar Lista de funcionarios contratados\s
                    0- Sair""");
            System.out.print("Escolha uma opção: ");
            String v = scanner.nextLine();
            System.out.println();
            try {
                switch (v) {
                    case "1":
                        adm.contratar();
                        break;
                    case "2":
                        adm.demitir();
                        break;
                    case "3":
                        adm.mostrar();
                        break;
                    case "0":
                        System.out.println();
                        return;
                    default:
                        System.out.println("Erro: comando invalido \n");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Scanner scanner = new Scanner(System.in);
}