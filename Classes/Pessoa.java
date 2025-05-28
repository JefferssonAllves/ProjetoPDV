package Classes;

import java.util.Map;

public class Pessoa {
  // ATRIBUTOS
  int codigo = 0; // Codigo do objeto filho - Cliente ou Vendedor
  String nome = ""; // Nome do objeto filho - Cliente ou Vendedor

  // METODOS
  public Pessoa(int quantidadeCriada, String nome) {
    this.codigo = quantidadeCriada; // Atualiza o codigo de acordo com a quantidade de objetos criados de cada classe

    if (nome.equals("")) { // Verifica se a String 'nome' não esta vazia
      throw new NullPointerException(); // Se estiver vazia, é lançada uma exceção do tipo 'NullPointerException'
    }
    this.nome = nome;
  }

  public static String mostrar(Map<Integer, Pessoa> cadastrados) {
    if (cadastrados == null || cadastrados.isEmpty()) { // Verifica se o HashMap possui dados
      throw new NullPointerException(); // Se nao tiver dados, lança uma exceção 'NullPointerException'
    }

    String message = ""; // String utilizada para mostrar os objetos cadastrados
    message += "COD -    NOME\n";
    for (Map.Entry<Integer, Pessoa> pessoa : cadastrados.entrySet()) { // Percorre o HashMap dos objetos cadastrados - // 'objetos'
      // String formatada para mostrar o codigo e o nome dos objetos
      // cliente.getKey() -> retorna a chave do HashMap(codigo do cliente)
      // cliente.getValue() -> retorna o objeto 'cliente ou vendedor', nesse caso mostrará o nome por causa do metodo 'toString()'
      message += "   " + pessoa.getKey() + "    -    " + pessoa.getValue() + "\n"; // Cria uma String formada para mostrar os objetos cadastrados
    }
    return message; // Retorna a mensagem completa com todos os objetos
  }

  // Reescreve o toString para retornar o nome do cliente ou do vendedor cadastrado
  @Override
  public String toString() {
    return this.nome;
  }
}