package Classes;

import javax.swing.JOptionPane; //São as telas do projeto - Interface Grafica
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Principal {
  public static void main(String[] args) {
    Map<Integer, Produtos> produtos = new HashMap<>();// HASH MAP DOS PRODUTOS
    Map<Integer, Clientes> clientes = new HashMap<>(); // HASH MAP DOS CLIENTES
    Map<Integer, Vendedores> vendedores = new HashMap<>(); // HASH MAP DOS CLIENTES

    ArrayList<Venda> vendasDiarias = new ArrayList<>();

    for (Produtos produto : gerarProdutos()) {
      produtos.put(produto.codigo, produto);
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
              String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto:");
              Double valorProduto = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto:"));
              int quantidadeEstoque = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade desse produto:"));

              Produtos produto = new Produtos(nomeProduto, valorProduto, quantidadeEstoque);
              produtos.put(produto.codigo, produto);
              break;
            case 2:
              String messageMostrarProdutos = "";
              for (Map.Entry<Integer, Produtos> produtoMap : produtos.entrySet()) {
                messageMostrarProdutos += produtoMap.getKey() + ":   " + produtoMap.getValue() + "\n";
              }
              JOptionPane.showInputDialog(messageMostrarProdutos);
            default:
              break;
          }
          break;
        case 4:// REALIZAR VENDA
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
            clienteSelecionado = (Clientes) JOptionPane.showInputDialog(null, "Seleciona o cliente", "Opçao",
                JOptionPane.INFORMATION_MESSAGE, null, clientesArray.toArray(), clientesArray.get(0));
            vendedorSelecionado = (Vendedores) JOptionPane.showInputDialog(null, "Seleciona o vendedor", "Opçao",
                JOptionPane.INFORMATION_MESSAGE, null, vendedoresArray.toArray(), vendedoresArray.get(0));

            int resposta = 0;
            ArrayList<Venda> vendasConcluidas = new ArrayList<>();
            do {
              if (!produtosArray.isEmpty()) {
                produtoSelecionado = (Produtos) JOptionPane.showInputDialog(null, "Seleciona o produto", "Opçao",
                    JOptionPane.INFORMATION_MESSAGE, null, produtosArray.toArray(), produtosArray.get(0));
              }
              int quantidadeComprada = Integer
                  .parseInt(JOptionPane.showInputDialog("Digite a quantidade que deseja comprar:", "1"));
              if (produtoSelecionado.estoque >= quantidadeComprada && quantidadeComprada > 0) {
                produtoSelecionado.estoque -= quantidadeComprada;
                Venda vendaCliente = new Venda(clienteSelecionado, vendedorSelecionado, produtoSelecionado,
                    quantidadeComprada);
                vendasConcluidas.add(vendaCliente);
                vendasDiarias.add(vendaCliente);
              } else {
                if (quantidadeComprada == 0) {
                  JOptionPane.showMessageDialog(null, "Estoque zerado");
                } else {
                  JOptionPane.showMessageDialog(null, "Quantidade Invalida");
                }
              }
              Object[] options = { "Sim", "Finalizar a compra" };
              resposta = JOptionPane.showOptionDialog(null, "Deseja continuar comprando?", "Aviso",
                  JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            } while (resposta == 0);
            String messageFinalizarVenda = "";
            if (!vendasConcluidas.isEmpty()) {
              Double valorTotalCompra = 0.;
              vendas.put(clienteSelecionado.codigo, vendasConcluidas);
              for (Map.Entry<Integer, ArrayList<Venda>> venda : vendas.entrySet()) {
                messageFinalizarVenda += "Cliente: " + venda.getValue().get(0).cliente;
                messageFinalizarVenda += "\nVendedor: " + venda.getValue().get(0).vendedor;
                messageFinalizarVenda += "\nData e Hora: " + venda.getValue().get(0).dataHora + "\n\n";
                for (Venda vendaEfetuada : venda.getValue()) {
                  valorTotalCompra += vendaEfetuada.totalVenda;
                  messageFinalizarVenda += vendaEfetuada.produto.nome + "    " + vendaEfetuada.quantidadeComprada
                      + "  X  R$" + vendaEfetuada.produto.valor + "    R$" + Math.round(vendaEfetuada.totalVenda)
                      + "\n";
                }
              }
              messageFinalizarVenda += "\n\nVALOR TOTAL:   R$" + valorTotalCompra;
            } else {
              messageFinalizarVenda = "NENHUMA COMPRA FOI REALIZADA";
            }
            JOptionPane.showMessageDialog(null, messageFinalizarVenda);
          } else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente ou vendedor cadastrado");
          }
          break;
        case 5:
          Double valorBruto = 0.;
          for (Venda venda : vendasDiarias) {
            valorBruto += venda.totalVenda;
          }
          Double impostoDiario = valorBruto * 0.25;
          String messageFechamentoCaixa = "Valor bruto:   R$" + valorBruto;
          messageFechamentoCaixa += "\nImposto aplicado:   R$" + impostoDiario;
          messageFechamentoCaixa += "\nValor final:   R$" + (valorBruto - impostoDiario);
          JOptionPane.showMessageDialog(null, messageFechamentoCaixa);
          break;
        case 7:
          exec = false;
          break;
        default:
          break;
      }
    } while (exec);
    JOptionPane.showMessageDialog(null, "PROGRAMA ENCERRADO");
  }

  public static String menu() {
    String menu = "                 ZAIA\n\n";
    menu += "1 - Acessar Clientes\n";
    menu += "2 - Acessar Vendedores\n";
    menu += "3 - Acessar Produtos\n";
    menu += "4 - Realizar Compra\n";
    menu += "5 - Fechamento de caixa\n";
    menu += "6 - Gerar Relatório\n";
    menu += "7 - Sair do programa\n";
    menu += "\n\nDigite sua opção:";
    return menu;
  }

  public static ArrayList<Produtos> gerarProdutos() {
    ArrayList<Produtos> produtos = new ArrayList<>();
    produtos.add(new Produtos("Placa de video", 4750.0, 5));
    produtos.add(new Produtos("Processador", 2200.0, 8));
    produtos.add(new Produtos("RAM", 450.0, 18));
    produtos.add(new Produtos("SSD", 500.0, 20));
    produtos.add(new Produtos("Mouse", 130.0, 30));
    produtos.add(new Produtos("Teclado", 220.0, 28));
    produtos.add(new Produtos("HeadSet", 120.0, 32));
    produtos.add(new Produtos("WebCam", 100.0, 40));
    produtos.add(new Produtos("Placa mãe", 1300.0, 16));
    produtos.add(new Produtos("Fonte", 400.0, 25));
    return produtos;
  }
}