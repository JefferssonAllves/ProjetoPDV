package Classes;


public class Venda {
  static int codigo = 0;
  Cliente cliente = null;
  Vendedor vendedor = null;
  Produto produto = null;
  int quantidadeComprada = 0;
  Double totalVenda = 0.;
  String dataHora = "";
  Double comissaoVenda = 0.;

  public Venda(Cliente cliente, Vendedor vendedor, Produto produto, int quantidadeComprada, String dataHora) {
    codigo += 1;
    this.cliente = cliente;
    this.vendedor = vendedor;
    this.produto = produto;
    this.quantidadeComprada = quantidadeComprada;
    this.totalVenda = produto.valor * this.quantidadeComprada;
    this.comissaoVenda = this.totalVenda * 0.05;
    this.vendedor.comissao += comissaoVenda;
    this.dataHora = dataHora;
  }
}
