package TFPOO;
import java.util.*;

public class CrudAdm {
    int auxEst = 0;
    int auxVen = 0;
    Beneficios salarioEst = Beneficios.SALARIOEST;
    Beneficios salarioVen = Beneficios.SALARIOVEN;
    Beneficios valeRef = Beneficios.VALEREFE;
    Beneficios valeTransp = Beneficios.VALETRANSP;
    private HashMap<Integer, Estoquista> listaEstoquistas;
    private HashMap<Integer, Vendedor> listaVendedores;

    public CrudAdm(){
        listaEstoquistas = new HashMap<>();
        listaVendedores = new HashMap<>();
    }

    public void contratar(){
        System.out.println("--------------------" +
                "Tela de Contrato" +
                "--------------------\n");
        System.out.println("""
                Quem você deseja contratar?\s
                1- Estoquista
                2- Vendedor
                0- voltar""");
        System.out.print("Escolha uma opção: ");
            String v = scanner.next();

        try {
            switch (v) {
                case "1":
                    Estoquista est =  new Estoquista();
                    est.setId(auxEst);
                    System.out.print("Nome: ");
                    est.setNome(scanner.next());
                    while(true) { // Exeção para caso a for inserida uma string na idade
                        try {
                            System.out.print("Idade: ");
                            est.setIdade(scanner.nextInt());
                        }catch (InputMismatchException e){
                            scanner.nextLine();
                            System.out.println("A idade nao é valida por favor tente novamente");
                            continue;
                        }
                        if(est.getIdade() < 18){
                            System.out.println("A idade do funcionario não é valida, tente novamente");
                            continue;
                        }
                        break;
                    }

                    while (true) { // Exeção para caso for inserida uma string no cpf
                        try {
                            System.out.print("CPF: ");
                            est.setCpf(scanner.nextInt());
                        }catch (InputMismatchException e){
                            scanner.nextLine();
                            System.out.println("Cpf informado não é valido, tente novamente");
                            continue;
                        }
                        if(est.getCpf() < 0){
                            System.out.println("O cpf inserido não é valido, tente novamente.");
                            continue;
                        }
                        break;
                    }
                    System.out.println("Contrato realizado com sucesso, estoquista " + est.getNome() + "\n") ;
                    System.out.println("Salario mensal de " + est.getNome() + ": " + salarioEst.getVale());
                    System.out.println("Vale Alimentação de " + est.getNome() + ": "+ valeRef.getVale() + "\n");
                    listaEstoquistas.put(est.getId(), est);
                    auxEst++;
                    break;
                case "2":
                    Vendedor vend = new Vendedor();
                    vend.setId(auxVen);
                    System.out.print("Nome: ");
                    vend.setNome(scanner.next());
                    while(true) { // Exeção para caso a for inserida uma string na idade
                        try {
                            System.out.print("Idade: ");
                            vend.setIdade(scanner.nextInt());
                        }catch (InputMismatchException e){
                            scanner.nextLine();
                            System.out.println("A idade nao é valida por favor tente novamente");
                            continue;
                        }
                        if(vend.getIdade() < 18){
                            System.out.println("A idade do funcionario não é valida, tente novamente");
                            continue;
                        }
                        break;
                    }
                    while (true) { // Exeção para caso for inserida uma string no cpf
                        try {
                            System.out.print("CPF: ");
                            vend.setCpf(scanner.nextInt());
                        }catch (InputMismatchException e){
                            scanner.nextLine();
                            System.out.println("O cpf inserido não é valido, tente novamente.");
                            continue;
                        }
                        if(vend.getCpf() < 0){
                            System.out.println("O cpf não é valido, tente novamente");
                            continue;
                        }
                        break;
                    }
                    System.out.println("Contrato realizado com sucesso, vendedor " + vend.getNome() + "\n");
                    System.out.println("Salario mensal: " + salarioVen.getVale());
                    System.out.println("Vale transporte: " + valeTransp.getVale() + "\n");
                    listaVendedores.put(vend.getId(), vend);

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

    public void demitir(){
            System.out.println("""
                    Quem você deseja demitir?\s
                    1- Estoquista
                    2- Vendedor
                    0- voltar""");
            System.out.print("Escolha uma opção: ");
            String v = scanner.next();

            try {
                switch (v) {
                    case "1":
                        if(listaEstoquistas.isEmpty()) {
                            System.out.println("Nenhum estoquista foi contratado\n");
                            return;
                        }
                        listaEstoquistas.forEach((id, estoquista) -> {
                            System.out.println("--------------------------");
                            System.out.print("Nome: " + estoquista.getNome());
                            System.out.println(" #" + estoquista.getId());
                            System.out.println("--------------------------\n");
                        });
                        while (true) {
                            int id = 0;
                            try {
                                System.out.print("Digite o id do estoquista que voce deseja demitir:");
                                id = scanner.nextInt();
                            }catch (InputMismatchException e){
                                scanner.nextLine();
                                System.out.println("Error: O id inserido não é valido, por favor tente novamente\n");
                                continue;
                            }
                            Estoquista estoquista= listaEstoquistas.remove(id);
                            if (estoquista != null) {
                                System.out.println("O funcionario " + estoquista.getNome() + " foi demitido!\n");
                                return;
                            } else {
                                System.out.println("Id de funcionario inexistente, por favor tente novamente\n");
                                continue;
                            }
                        }
                    case "2":
                        if(listaVendedores.isEmpty()) {
                            System.out.println("Nenhum vendedor foi contratado\n");
                            return;
                        }
                        listaVendedores.forEach((id, vendedor) -> {
                            System.out.println("--------------------------");
                            System.out.print("Nome: " + vendedor.getNome());
                            System.out.println(" #" + vendedor.getId());
                            System.out.println("--------------------------\n");
                        });
                        while (true) {
                            int id = 0;
                            try {
                                System.out.println("Digite o id do vendedor que voce deseja demitir:");
                                id = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                scanner.nextLine();
                                System.out.println("Error: O id inserido não é valido, por favor tente novamente\n");
                                continue;
                            }
                            Vendedor vendedor = listaVendedores.remove(id);
                            if (vendedor != null) {
                                System.out.println("O funcionario " + vendedor.getNome() + " foi demitido!\n");
                                return;
                            } else {
                                System.out.println("Id de funcionario inexistente, por favor tente novamente\n");
                                continue;
                            }
                        }
                    case "0": //    System.exit(0)
                        System.out.println();
                        return;
                    default:
                        System.out.println("Erro: comando invalido \n");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    public void mostrar(){
            while (true) {
                try {
                    System.out.println("""
                            De qual funcionario você gostaria de ver a lista?\s
                            1- Estoquista
                            2- Vendedor
                            0- voltar""");
                    System.out.print("Escolha uma opção: ");
                    String v = scanner.next();

                    switch (v) {
                        case "1":
                            System.out.println("------------------" +
                                    "Lista de estoquistas" +
                                    "------------------\n");

                            if (listaEstoquistas.isEmpty()) System.out.println("Nenhum Estoquista contratado\n");
                            listaEstoquistas.forEach((id, estoquista) -> {
                                System.out.println("--------------------------");
                                System.out.println("id: #" + estoquista.getId());
                                System.out.println("Nome: " + estoquista.getNome());
                                System.out.println("Idade: " + estoquista.getIdade());
                                System.out.println("Salario: " + salarioEst.getVale());
                                System.out.println("Vale refeição: " + valeRef.getVale());
                                System.out.println("--------------------------\n");
                            });
                            break;
                        case "2":
                            System.out.println("------------------" +
                                    "Lista de vendedores" +
                                    "------------------\n");

                            if (listaVendedores.isEmpty()) System.out.println("Nenhum Vendedor contratado\n");
                            listaVendedores.forEach((id, vendedor) -> {
                                System.out.println("--------------------------");
                                System.out.println("id: #" + vendedor.getId());
                                System.out.println("Nome: " + vendedor.getNome());
                                System.out.println("Idade: " + vendedor.getIdade());
                                System.out.println("Salario: " + salarioVen.getVale());
                                System.out.println("Vale transporte: " + valeTransp.getVale());
                                System.out.println("--------------------------\n");
                            });
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


        Scanner scanner = new Scanner(System.in);
}

