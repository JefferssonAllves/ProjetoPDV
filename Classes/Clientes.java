package Classes;

public class Clientes {
  //ATRIBUTOS
  int codigo = 0;
  static int quantidadeClientes = 1;
  String nome = "";
  //METODOS
  public Clientes(String nome) {
    quantidadeClientes += 1;
    this.codigo = quantidadeClientes;
    this.nome = nome;
  }

  @Override
  public String toString(){
    return this.nome;
  }
}