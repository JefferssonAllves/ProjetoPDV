package Classes;

public  class Produtos {
  //ATRIBUTOS
  static int quantidadeProdutos = 0;
  int codigo = 0;
  String nome = null;
  Double valor = null;
  int estoque = 0;
  //METODOS
  public Produtos(String nome, Double valor, int estoque) {
    quantidadeProdutos += 1;
    this.codigo = quantidadeProdutos;
    this.nome = nome;
    this.valor = valor;
    this.estoque = estoque;
  }
  @Override
  public String toString() {
    return this.nome + "       R$" + this.valor + "         Quantidade: " + this.estoque;
  }
}