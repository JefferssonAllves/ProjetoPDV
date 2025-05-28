package Classes;

public class Vendedor extends Pessoa{
  static int quantidadeVendedores = 1; // Variavel para atualizar o codigo do vendedor com base na quantidade de vendedores cadastrados
  double comissao = 0.;
  public Vendedor(String nome) {
    super(quantidadeVendedores, nome); // Inicializa a classe pai 'Pessoa' com os atributos quantidadeVendedores e nome
    quantidadeVendedores += 1; // Atualiza a quantidade de vendedores cadastrados
  }
}