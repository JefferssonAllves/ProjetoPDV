package Classes;

public class Vendedores {
  int codigo = 0;
  static int quantidadeVendedores = 1;
  String nome = "";
  Double comissao = 0.;

  public Vendedores(String nome) {
    quantidadeVendedores += 1;
    this.codigo = quantidadeVendedores;
    this.nome = nome;
  }

  @Override
  public String toString() {
    return this.nome;
  }
}