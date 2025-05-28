package Classes;

public class Cliente extends Pessoa {
  static int quantidadeClientes = 1; // Variavel para atualizar o codigo do cliente com base na quantidade de clientes cadastrados

  public Cliente(String nome) {
    super(quantidadeClientes, nome); // Inicializa a classe pai 'Pessoa' com os atributos quantidadeClientes e nome
    quantidadeClientes += 1; // Atualiza a quantidade de clientes cadastrados
  }
}