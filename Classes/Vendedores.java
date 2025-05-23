package Classes;

public class Vendedores {
  int codigo = 0;
  String nome = "";

  public Vendedores(int codigo, String nome) {
    this.codigo = codigo;
    this.nome = nome;
  }

  @Override
  public String toString() {
    return this.nome;
  }
}