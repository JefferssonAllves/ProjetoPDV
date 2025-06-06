package Classes;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
public class Vendedor extends Pessoa{
  static int quantidadeVendedores = 1; // Variavel para atualizar o codigo do vendedor com base na quantidade de vendedores cadastrados
  Map<String, ArrayList<Double>> comissoesDiarias = new HashMap<>();

  public Vendedor(String nome) {
    super(quantidadeVendedores, nome); // Inicializa a classe pai 'Pessoa' com os atributos quantidadeVendedores e nome
    quantidadeVendedores += 1; // Atualiza a quantidade de vendedores cadastrados
  }

  public Double comissaoTotal(String data) {
    Double total = 0.;
    for (Double comissao : comissoesDiarias.get(data)) {
      total += comissao;
    }
    return total;
  }
}