package Classes;

public class Venda {
  Clientes cliente = null;
  Vendedores vendedor = null;
  Produtos produto = null;
  int quantidadeComprada = 0;
  Double totalVenda = 0.;

  public Venda(Clientes cliente, Vendedores vendedor, Produtos produto, int quantidadeComprada) {
    this.cliente = cliente;
    this.vendedor = vendedor;
    this.produto = produto;
    this.quantidadeComprada = quantidadeComprada;
    this.totalVenda = produto.valor * this.quantidadeComprada;
  }
}
