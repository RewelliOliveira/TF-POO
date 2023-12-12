package TFPOO;
import java.util.Scanner;

public class MenuEst {

    public void menuEst(){
        CrudProdutos produto = new CrudProdutos();
        while (true) {
            System.out.println("------------Menu Estoque------------");
            System.out.println("""
                    1- Cadastrar produto\s
                    2- Mostrar produtos cadastrados\s
                    3- Deletar produto\s
                    4- Atualizar produto\s
                    0- Sair""");
            System.out.print("Escolha uma opção: ");
            String v = scanner.nextLine();
            System.out.println();
            try {
                switch (v) {
                    case "1":
                        produto.cadastrar();
                        break;
                    case "2":
                        produto.mostrarProdutos();
                        break;
                    case "3":
                        produto.removerProduto();
                        break;
                    case "4":
                        produto.atualizarProdutos();
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
