package Classes;

import javax.swing.JOptionPane; //São as telas do projeto - Interface Grafica
import java.util.Map;
import java.util.HashMap;

public class Principal {
  public static void main(String[] args) {
    Map<Integer, Produtos> produtos = new HashMap<>();// HASH MAP DOS PRODUTOS
    Map<Integer, Clientes> clientes = new HashMap<>(); // HASH MAP DOS CLIENTES
    Map<Integer, Vendedores> vendedores = new HashMap<>(); // HASH MAP DOS CLIENTES

    // TODO ARRUMAR PARTE DE ADICIONAR PRODUTOS
    for (int i = 0; i < 10; i++) {
      produtos.put(i, new Produtos(i, "TESTE", 55.55, 10));
    }
    // codigo - nome
    // 1 - joao
    // 2 - jeff
    // 3 - igor

    boolean exec = true;
    // Loop principal do projeto
    do {
      int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));

      switch (opcao) {
        case 1: // ACESSAR CLIENTES -- -- - -
          String messageClientes = "Clientes\n\n";
          messageClientes += "1 - Cadastrar novo cliente\n";
          messageClientes += "2 - Visualizar clientes\n";
          messageClientes += "\n\nDigite sua opção:";

          switch (Integer.parseInt(JOptionPane.showInputDialog(messageClientes))) {
            case 1: // CADASTRAR NOVO CLIENTE
              int codigoCliente = Integer.parseInt(JOptionPane.showInputDialog("Me diga o código do cliente: "));
              String nomeCliente = JOptionPane.showInputDialog("Nome do cliente:");

              clientes.put(codigoCliente, new Clientes(codigoCliente, nomeCliente));
              JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
              break;

            case 2: // VISUALIZAR CLIENTE
              String messageMostrarCliente = "COD - NOME\n";
              for (Map.Entry<Integer, Clientes> cliente : clientes.entrySet()) {
                messageMostrarCliente += cliente.getKey() + " -> " + cliente.getValue() + "\n";
              }
              JOptionPane.showInputDialog(messageMostrarCliente);
              break;

            default:
              break;
          }
          break;
        case 2:
          String messageVendedores = "Vendedores\n\n";
          messageVendedores += "1 - Cadastrar novo vendedor\n";
          messageVendedores += "2 - Visualizar vendedores\n";
          messageVendedores += "\n\nDigite sua opção:";

          switch (Integer.parseInt(JOptionPane.showInputDialog(messageVendedores))) {
            case 1: // CADASTRAR NOVO CLIENTE
              int codigoVendedor = Integer.parseInt(JOptionPane.showInputDialog("Me diga o código do vendedor: "));
              String nomeVendedor = JOptionPane.showInputDialog("Nome do vendedor:");

              vendedores.put(codigoVendedor, new Vendedores(codigoVendedor, nomeVendedor));
              JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso!");
              break;

            case 2: // VISUALIZAR VENDEDOR
              String messageMostrarCliente = "COD - NOME\n";
              for (Map.Entry<Integer, Vendedores> vendedor : vendedores.entrySet()) {
                messageMostrarCliente += vendedor.getKey() + " -> " + vendedor.getValue() + "\n";
              }
              JOptionPane.showInputDialog(messageMostrarCliente);
              break;

            default:

              break;
          }
          break;
        case 3:
          String messageProdutos = "Produtos\n\n";
          messageProdutos += "1 - Cadastrar novo produto\n";
          messageProdutos += "2 - Visualizar produtores\n";
          messageProdutos += "\n\nDigite sua opção:";
          switch (Integer.parseInt(JOptionPane.showInputDialog(messageProdutos))) {
            case 1:
              System.out.println("PARTE DE CADASTRAR NOVO PRODUTO"); // AJEITAR DEPOIS
              break;
            case 2:
              String messageMostrarProdutos = "";
              for (Map.Entry<Integer, Produtos> produto : produtos.entrySet()) {
                messageMostrarProdutos += produto.getKey() + " -> " + produto.getValue() + "\n";
              }
              JOptionPane.showInputDialog(messageMostrarProdutos);
            default:
              break;
          }

        case 4:
          exec = false;
          break;

        default:
          break;
      }

    } while (exec);
    JOptionPane.showMessageDialog(null, "PROGRAMA ENCERRADO");

  }

  public static String menu() {
    String menu = "ATACADAO DO VAREJO\n\n";
    menu += "1 - Acessar Clientes\n";
    menu += "2 - Acessar Vendedores\n";
    menu += "3 - Acessar Produtos\n";
    menu += "4 - Sair\n";
    menu += "\n\nDigite sua opção:";
    return menu;
  }
}