package Classes;

public class Clientes {
  //ATRIBUTOS
  int codigo = 0;
  String nome = "";
  //METODOS
  public Clientes(int codigo, String nome){
      this.codigo = codigo;
      this.nome = nome;
  }

  @Override
  public String toString(){
      return this.nome;
  }
}