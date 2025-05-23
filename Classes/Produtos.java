package Classes;

public  class Produtos {
  //ATRIBUTOS
  int codigo = 0;
  String nome = null;
  Double valor = null;
  int estoque = 0;
  //METODOS
  public Produtos(int codigo, String nome, Double valor, int estoque){
    this.codigo = codigo;
    this.nome = nome;
    this.valor = valor;
    this.estoque = estoque;
  }
  @Override
  public String toString() {
    return this.nome;
  }
} 