package TFPOO;
import java.util.*;

public class CrudProdutos extends Produto {
    private final HashMap<Integer, Produto> listaProdutos;

    public CrudProdutos() {
        this.listaProdutos = new HashMap<>();
    }

    //Inserir produtos no hashmap
    public void cadastrar() {
        System.out.println("--------------------" +
                           "Cadastro de produtos" +
                           "--------------------\n");

        while(true){
            Produto produto = new Produto();
            while(true) {
                try {
                    System.out.print("Codigo do produto: ");
                    produto.setCdgProduto(scanner.nextInt());
                } catch (InputMismatchException ime) {
                    scanner.nextLine();
                    System.out.println("Error: O formato do codigo não é compativel, por favor tente novamente\n");
                    continue;
                }

                if (listaProdutos.containsKey(produto.getCdgProduto())) {
                    System.out.println("Error: Codigo existente, por favor tente novamente\n");
                    continue;
                }else if(produto.getCdgProduto() < 0){
                    System.out.println("Codigo do produto não pode ser negatiivo, tente novamente\n");
                    continue;
                }
                break;
            }

            leituraProdutos(produto);

            listaProdutos.put(produto.getCdgProduto(), produto);
            while (true) {
                System.out.print("Deseja adicionar novo produto? sim|nao: ");
                var v = scanner.next();

                if (v.equals("sim")) {
                    System.out.println();//quebra de linha
                    break;
                } else if (v.equals("nao")) {
                    System.out.println();//quebra de linha
                    return;
                } else {
                    System.out.println("Error: Comando invalido, tente novamente\n");
                }
            }
        }
    }

    //Mostra os produtos cadastrados
    public void mostrarProdutos() {
        System.out.println("------------------" +
                "Lista de produtos" +
                "------------------\n");

        if(listaProdutos.isEmpty()) System.out.println("Nenhum produto cadastrado\n");
        listaProdutos.forEach((codigo, produto) -> {
            System.out.println("--------------------------");
            System.out.println("Codigo: #" + produto.getCdgProduto());
            System.out.println("Nome: " + produto.getNomeProduto());
            System.out.println("Tipo do produto: " + produto.getTipoProduto());
            System.out.println("Preço: " + produto.getValorProduto());
            System.out.println("Quantidade: " + produto.getQntProduto());
            System.out.println("--------------------------\n");
        });
    }

    //Remove os produtos do HashMap de acordo com a chave
    public void removerProduto() {
        System.out.println("-------------------" +
                           "Remoção de produtos" +
                           "-------------------\n");
        if(listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado\n");
            return;
        }
        listaProdutos.forEach((codigo, produto) -> {
            System.out.println("--------------------------");
            System.out.print("Nome: " + produto.getNomeProduto());
            System.out.println(" #" + produto.getCdgProduto());
            System.out.println("--------------------------");
        });

        while (true) {
            int codigo = 0;
            try {
                System.out.print("Informe o código do produto a ser removido: ");
                codigo = scanner.nextInt();
            }catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Error: O codigo inserido não é valido, por favor tente novamente\n");
                continue;
            }
            Produto produto = listaProdutos.remove(codigo);
            if (produto != null) {
                System.out.println("Produto removido com sucesso: " + produto.getNomeProduto());
                return;
            } else {
                System.out.println("O produto não foi encontrado, por favor tente novamente\n");
                continue;
            }
        }
    }

    // procura os atributos pelo codigo e atualiza suas informações
    public void atualizarProdutos() {
        System.out.println("-----------------------" +
                           "Atualização de produtos" +
                           "-----------------------\n");
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado\n");
            return;
        }

        while (true) {
            // Sumario para se orientar do codigo do produto
            listaProdutos.forEach((codigo, produto) -> {
                System.out.println("--------------------------");
                System.out.print("Nome: " + produto.getNomeProduto());
                System.out.println(" #" + produto.getCdgProduto());
                System.out.println("--------------------------");
            });
            int codigo = 0;

            while (true) {
                try {
                        System.out.print("Insira o codigo do produto que você quer Atualizar: ");
                        codigo = scanner.nextInt();
                    }catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("Error: o valor inserido não é valido,por favor tente novamente \n");
                    continue;
                }
                break;
            }

            Produto produto = listaProdutos.get(codigo);

            if (produto == null) {
                System.out.println("Codigo invalido, por favor tente novamente\n");
                continue;
            } else if (!listaProdutos.containsKey(codigo)) {
                System.out.println("Codigo invalido, produto não encontrado\n");
                continue;
            }

            leituraProdutos(produto);

            listaProdutos.put(codigo, produto);
            System.out.println("Produto atualizado com sucesso: " + produto.getNomeProduto() + "\n");

            int auxInt = 0;
            while (true) {
                System.out.print("Deseja Atualizar outro produto? sim|nao: ");
                String aux = scanner.next();
                if (aux.equals("sim")) {
                    auxInt = 1;
                    break;
                } else if (aux.equals("nao")) break;
                else {
                    System.out.println("Comando invalido, por favor tente novamente \n");
                    continue;
                }
            }
            if (auxInt == 1) continue;

            break;
        }
    }

    //metodo para leitura, para nao poluir tanto o codigo
    private void leituraProdutos(Produto produto) {
        System.out.print("Nome: ");
        produto.setNomeProduto(scanner.next());
        System.out.print("Tipo: ");
        produto.setTipoProduto(scanner.next());
        while (true) {
            try {
                System.out.print("Quantidade: ");
                produto.setQntProduto(scanner.nextInt());
            }catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Error: A quantidade inserida nao é valida, por favor tente novamente\n");
                continue;
            }
            if(produto.getQntProduto() < 0){
                System.out.println("A quantidade não pode ser negativa, por favor tente novamente.\n");
                continue;
            }
            break;
        }
        while (true) {
            try {
                System.out.print("Preço: ");
                produto.setValorProduto(scanner.nextDouble());
            }catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Error: O preço inserido nao é valido, por favor tente novamente\n");
                continue;
            }
            if(produto.getValorProduto() < 0){
                System.out.println("O preço do produto não pode ser negativo, por favor tente novamente.\n");
                continue;
            }
            break;
        }
    }

    public Scanner scanner = new Scanner(System.in);
}
