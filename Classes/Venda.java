package Classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venda {
  Clientes cliente = null;
  Vendedores vendedor = null;
  Produtos produto = null;
  int quantidadeComprada = 0;
  Double totalVenda = 0.;
  String dataHora = "";
  Double comissaoVenda = 0.;

  public Venda(Clientes cliente, Vendedores vendedor, Produtos produto, int quantidadeComprada) {
    this.cliente = cliente;
    this.vendedor = vendedor;
    this.produto = produto;
    this.quantidadeComprada = quantidadeComprada;
    this.totalVenda = produto.valor * this.quantidadeComprada;
    this.comissaoVenda = this.totalVenda * 0.05;
    this.vendedor.comissao += comissaoVenda;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    this.dataHora = now.format(formatter);
  }
}
