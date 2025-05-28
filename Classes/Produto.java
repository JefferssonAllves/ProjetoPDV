package Classes;

import java.util.Map;

public class Produto {
  // ATRIBUTOS
  static int quantidadeProdutos = 1;
  int codigo = 0;
  String nome = null;
  Double valor = null;
  int estoque = 0;
  
  // METODOS
  public Produto(String nome, Double valor, int estoque) {
    this.codigo = quantidadeProdutos;
    quantidadeProdutos += 1;
    this.nome = nome;
    this.valor = valor;
    this.estoque = estoque;
  }

  public static String mostrar(Map<Integer, Produto> produtos) {
    String message = "";
    for (Map.Entry<Integer, Produto> produtoMap : produtos.entrySet()) {
      message += produtoMap.getKey() + ":   " + produtoMap.getValue() + "\n";
    }
    return message;
  }

  @Override
  public String toString() {
    return this.nome + "       R$" + this.valor + "         Quantidade: " + this.estoque;
  }
}