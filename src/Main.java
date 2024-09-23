import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaquinaDeVendas maquina = new MaquinaDeVendas();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        // Cadastrar alguns produtos iniciais
        maquina.cadastrarProduto("Coca-Cola", 5.00, 10);
        maquina.cadastrarProduto("Chocolate", 3.50, 5);
        maquina.cadastrarProduto("Chips", 2.50, 8);

        while (opcao != 5) {
            System.out.println("\n===== Máquina de Vendas =====");
            System.out.println("1. Ver produtos disponíveis");
            System.out.println("2. Inserir dinheiro");
            System.out.println("3. Selecionar produto");
            System.out.println("4. Retornar troco");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    maquina.exibirProdutos();
                    break;

                case 2:
                    System.out.print("Digite o valor a ser inserido: ");
                    double valor = scanner.nextDouble();
                    maquina.inserirDinheiro(valor);
                    break;

                case 3:
                    System.out.print("Selecione o número do produto: ");
                    int indiceProduto = scanner.nextInt();
                    maquina.selecionarProduto(indiceProduto);
                    break;

                case 4:
                    maquina.retornarTroco();
                    break;

                case 5:
                    System.out.println("Encerrando o sistema. Obrigado!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
