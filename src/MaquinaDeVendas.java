import java.util.ArrayList;
import java.util.List;

public class MaquinaDeVendas {
    private List<Produto> produtos;
    private double saldoAtual;

    public MaquinaDeVendas() {
        this.produtos = new ArrayList<>();
        this.saldoAtual = 0.0;
    }

    // Método para cadastrar novos produtos
    public void cadastrarProduto(String nome, double preco, int quantidade) {
        produtos.add(new Produto(nome, preco, quantidade));
    }

    // Método para exibir os produtos disponíveis na máquina
    public void exibirProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println((i + 1) + ". " + produtos.get(i));
            }
        }
    }

    // Método para inserir dinheiro
    public void inserirDinheiro(double valor) {
        saldoAtual += valor;
        System.out.println("Você inseriu R$ " + valor + ". Saldo atual: R$ " + saldoAtual);
    }

    // Método para selecionar um produto
    public void selecionarProduto(int indiceProduto) {
        if (indiceProduto < 1 || indiceProduto > produtos.size()) {
            System.out.println("Produto inválido.");
            return;
        }

        Produto produtoSelecionado = produtos.get(indiceProduto - 1);

        if (produtoSelecionado.getQuantidade() <= 0) {
            System.out.println("Produto indisponível.");
            return;
        }

        if (saldoAtual >= produtoSelecionado.getPreco()) {
            saldoAtual -= produtoSelecionado.getPreco();
            produtoSelecionado.diminuirQuantidade(1);
            System.out.println("Você comprou: " + produtoSelecionado.getNome());
        } else {
            System.out.println("Saldo insuficiente. Por favor, insira mais dinheiro.");
        }
    }

    // Método para retornar troco
    public double retornarTroco() {
        double troco = saldoAtual;
        saldoAtual = 0.0;
        System.out.println("Seu troco é: R$ " + troco);
        return troco;
    }
}
