package Classes;

import javax.swing.JOptionPane; //São as telas do projeto - Interface Grafica
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class Principal {
  public static void main(String[] args) {
    Map<Integer, Produtos> produtos = new HashMap<>();// HASH MAP DOS PRODUTOS
    Map<Integer, Clientes> clientes = new HashMap<>(); // HASH MAP DOS CLIENTES
    Map<Integer, Vendedores> vendedores = new HashMap<>(); // HASH MAP DOS CLIENTES


    // TODO ARRUMAR PARTE DE ADICIONAR PRODUTOS
    for (int i = 0; i < 10; i++) {
      produtos.put(i, new Produtos(i, "TESTE", 55.55, 10));
    }

    boolean exec = true;
    // Loop principal do projeto
    do {
      int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));

      switch (opcao) {
        case 1: // ACESSAR CLIENTES
          String messageClientes = "Clientes\n\n";
          messageClientes += "1 - Cadastrar novo cliente\n";
          messageClientes += "2 - Visualizar clientes\n";
          messageClientes += "\n\nDigite sua opção:";

          switch (Integer.parseInt(JOptionPane.showInputDialog(messageClientes))) {
            case 1: // CADASTRAR NOVO CLIENTE
              String nomeCliente = JOptionPane.showInputDialog("Nome do cliente:");

              clientes.put(Clientes.quantidadeClientes, new Clientes(nomeCliente));
              JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
              break;

            case 2: // VISUALIZAR CLIENTE
              String messageMostrarCliente = "COD - NOME\n";
              for (Map.Entry<Integer, Clientes> cliente : clientes.entrySet()) {
                messageMostrarCliente += "   " + cliente.getKey() + "    -    " + cliente.getValue() + "\n";
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
              String nomeVendedor = JOptionPane.showInputDialog("Nome do vendedor:");
              vendedores.put(Vendedores.quantidadeVendedores, new Vendedores(nomeVendedor));
              JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso!");
              break;

            case 2: // VISUALIZAR VENDEDOR
              String messageMostrarCliente = "COD - NOME\n";
              for (Map.Entry<Integer, Vendedores> vendedor : vendedores.entrySet()) {
                messageMostrarCliente += "   " + vendedor.getKey() + "    -    " + vendedor.getValue() + "\n";
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
          break;
        case 4://REALIZAR VENDA

          HashMap<Integer, ArrayList<Venda>> vendas = new HashMap<>();

          ArrayList<Clientes> clientesArray = new ArrayList<>();
          for (Map.Entry<Integer, Clientes> cliente : clientes.entrySet()) {
            clientesArray.add(cliente.getValue());
          }

          ArrayList<Vendedores> vendedoresArray = new ArrayList<>();
          for (Map.Entry<Integer, Vendedores> vendedor : vendedores.entrySet()) {
            vendedoresArray.add(vendedor.getValue());
          }
          ArrayList<Produtos> produtosArray = new ArrayList<>();
          for (Map.Entry<Integer, Produtos> produto : produtos.entrySet()) {
            produtosArray.add(produto.getValue());
          }

          Clientes clienteSelecionado = null;
          Vendedores vendedorSelecionado = null;
          Produtos produtoSelecionado = null;



          if (!clientesArray.isEmpty() && !vendedoresArray.isEmpty()) {
            clienteSelecionado = (Clientes) JOptionPane.showInputDialog(null, "Seleciona o cliente", "Opçao",JOptionPane.INFORMATION_MESSAGE, null, clientesArray.toArray(), clientesArray.get(0));
            vendedorSelecionado = (Vendedores) JOptionPane.showInputDialog(null, "Seleciona o vendedor", "Opçao",JOptionPane.INFORMATION_MESSAGE, null, vendedoresArray.toArray(), vendedoresArray.get(0));

            int resposta = 0;
            ArrayList<Venda> vendasConcluidas = new ArrayList<>();
            do {
              if (!produtosArray.isEmpty()) {
                produtoSelecionado = (Produtos) JOptionPane.showInputDialog(null, "Seleciona o produto", "Opçao",JOptionPane.INFORMATION_MESSAGE, null, produtosArray.toArray(), produtosArray.get(0));
              }
              int quantidadeComprada = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade que deseja comprar:", "1"));
              if (quantidadeComprada < produtoSelecionado.estoque && quantidadeComprada > 0) {
                produtoSelecionado.estoque -= quantidadeComprada;
                vendasConcluidas.add(new Venda(clienteSelecionado, vendedorSelecionado, produtoSelecionado, quantidadeComprada));
              } else {
                if(quantidadeComprada == 0){
                  JOptionPane.showMessageDialog(null, "Estoque zerado");
                } else {
                  JOptionPane.showMessageDialog(null, "Quantidade Invalida");
                }
              }
              Object[] options = { "Sim", "Finalizar a compra" };
              resposta = JOptionPane.showOptionDialog(null, "Deseja continuar comprando?", "Aviso",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            } while (resposta == 0);
            String messageFinalizarVenda = "";
            if(!vendasConcluidas.isEmpty()){
              vendas.put(clienteSelecionado.codigo, vendasConcluidas);
              for(Map.Entry<Integer, ArrayList<Venda>> venda : vendas.entrySet()){
                for(Venda vendaEfetuada : venda.getValue()){
                  messageFinalizarVenda += vendaEfetuada.cliente + "    " + vendaEfetuada.vendedor + "    " + vendaEfetuada.produto + "    " + vendaEfetuada.totalVenda + "\n";
                }
              }
            } else {
              messageFinalizarVenda = "NENHUMA COMPRA FOI REALIZADA";
            }
            JOptionPane.showMessageDialog(null, messageFinalizarVenda);

            //TODO FINALIZAR COMPRA
          } else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente ou vendedor cadastrado");
          }
          break;
        case 5:
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
    menu += "4 - Realizar Compra\n";
    menu += "5 - Sair\n";
    menu += "\n\nDigite sua opção:";
    return menu;
  }
}