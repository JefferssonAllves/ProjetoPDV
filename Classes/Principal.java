package Classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane; // Biblioteca utilizada para criação de telas

public class Principal {
  public static void main(String[] args) {
    Map<Integer, Produto> produtos = new HashMap<>();// HasMap para todos os protudos registrados
    Map<Integer, Pessoa> clientes = new HashMap<>(); // HasMap para todos os clientes registrados
    Map<Integer, Pessoa> vendedores = new HashMap<>(); // HasMap para todos os vendedores registrados

    ArrayList<Venda> vendasDiarias = new ArrayList<>(); // ArrayList para armazenar todas as vendas efetuadas no dia

    // Loop para adicionar produtos pré registrados ao programa principal
    for (Produto produto : gerarProdutos()) {
      produtos.put(produto.codigo, produto); // Adiciona os produtos a lista de produtos do programa principal
    }

    boolean exec = true; // Define a execução do programa inicial

    do { // Loop principal do projeto
      try { // Tratamento de erros do programa
        String respostaString = JOptionPane.showInputDialog(menu()); // Obtem a opção escolhida pelo usuario no primeiro menu
        if (respostaString == null) { // Se a resposta for igual a 'null', significa que o usuario clicou em 'cancelar' no menu principal
          exec = false; // Encerra a execução do programa principal
          break;
        }

        switch (Integer.parseInt(respostaString)) { // SWITCH CASE PRINCIPAL: Escolha referente ao primeiro menu mostrado ao usuario
          case 1: // SWITCH CASE PRINCIPAL - CASE 1 - Aba referente aos clientes
            // Menu da aba clientes
            String messageClientes = "Clientes\n\n";
            messageClientes += "1 - Cadastrar novo cliente\n";
            messageClientes += "2 - Visualizar clientes\n";
            messageClientes += "3 - Remover cliente\n";
            messageClientes += "\n\nDigite sua opção:";

            switch (Integer.parseInt(JOptionPane.showInputDialog(messageClientes))) { // SWITCH CASE DA ABA CLIENTES: Escolha referente as opções para clientes
              case 1: // SWITCH CASE DA ABA CLIENTES - CASE 1 - Aba referente ao cadastramento de clientes
                String nomeCliente = JOptionPane.showInputDialog("Nome do cliente:"); // Pede o nome do cliente que será cadastrado
                clientes.put(Cliente.quantidadeClientes, new Cliente(nomeCliente)); // Cria um novo objeto do tipo 'Clientes', e armazena-o no HashMap 'clientes'
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                break;

              case 2: // SWITCH CASE DA ABA CLIENTES - CASE 2 - Aba referente a visualização de clientes cadastrados
                try {
                  String messageMostrarClientes = Pessoa.mostrar(clientes);
                  JOptionPane.showMessageDialog(null, messageMostrarClientes); // Mostra todos os clientes cadastrados
                } catch (NullPointerException npe) {
                  JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado");
                }
                break;

              case 3: // SWITCH CASE DA ABA CLIENTES - CASE 3 - Aba referente a remoção de clientes cadastrados
                try {
                  String messageRemoverCliente = Pessoa.mostrar(clientes); //Mostrar clientes
                  // Remove o cliente cadastrado com base no codigo dele
                  int codigoCliente = Integer.parseInt(JOptionPane.showInputDialog(messageRemoverCliente + "\n\nDigite o codigo do cliente que deseja remover:"));

                  if(clientes.containsKey(codigoCliente)){
                    clientes.remove(codigoCliente);
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
                  } else {
                    JOptionPane.showMessageDialog(null, "Nenhum cliente com esse codigo");
                  }
                } catch (NullPointerException npe) {
                  JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado");
                }
                break;
              default:
                JOptionPane.showMessageDialog(null, "Opção inválida", "ERRO", JOptionPane.ERROR_MESSAGE);
                break;
            }
            break;

          case 2: // SWITCH CASE PRINCIPAL - CASE 2 - Aba referente aos vendedores
            // Menu da aba vendedores
            String messageVendedores = "Vendedores\n\n";
            messageVendedores += "1 - Cadastrar novo vendedor\n";
            messageVendedores += "2 - Visualizar vendedores\n";
            messageVendedores += "3 - Remover vendedor\n";
            messageVendedores += "\n\nDigite sua opção:";

            switch (Integer.parseInt(JOptionPane.showInputDialog(messageVendedores))) { // SWITCH CASE DA ABA VENDEDORES: Escolha referente as opções para vendedores
              case 1: // SWITCH CASE DA ABA VENDEDORES - CASE 1 - Aba referente ao cadastramento de vendedores
                String nomeVendedor = JOptionPane.showInputDialog("Nome do vendedor:"); // Pede o nome do vendedor que será cadastrado
                vendedores.put(Vendedor.quantidadeVendedores, new Vendedor(nomeVendedor)); // Cria um novo objeto do tipo 'Vendedor', e armazena-o no HashMap 'vendedores'
                JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso!");
                break;

              case 2: // SWITCH CASE DA ABA VENDEDORES - CASE 2 - Aba referente a visualização de vendedores cadastrados
                try {
                  String messageMostrarVendedores = Pessoa.mostrar(vendedores); // Mostra os vendedores cadastrados
                  JOptionPane.showMessageDialog(null, messageMostrarVendedores);
                } catch (NullPointerException npe) {
                  JOptionPane.showMessageDialog(null, "Nenhum vendedor cadastrado");
                }
                break;

              case 3: // SWITCH CASE DA ABA VENDEDORES - CASE 3 - Aba referente a remoção de vendedores cadastrados
                try {
                  String messageRemoverVendedor = Pessoa.mostrar(vendedores); // Mostra os vendedores cadastrados
                  // Remove o vendedor cadastrado com base no codigo dele
                  int codigoVendedor = Integer.parseInt(JOptionPane.showInputDialog(messageRemoverVendedor + "\n\nDigite o codigo do cliente que deseja remover:"));
                  if(vendedores.containsKey(codigoVendedor)){
                    vendedores.remove(codigoVendedor);
                    JOptionPane.showMessageDialog(null, "Vendedor removido com sucesso");
                  } else {
                    JOptionPane.showMessageDialog(null, "Nenhum vendedor com esse codigo");
                  }
                } catch (NullPointerException npe) {
                  JOptionPane.showMessageDialog(null, "Nenhum vendedor cadastrado");
                }
                break;
              default:
                break;
            }
            break;

          case 3: // SWITCH CASE PRINCIPAL - CASE 3 - Aba referente aos produtos
            // Menu da aba produtos
            String messageProdutos = "Produtos\n\n";
            messageProdutos += "1 - Cadastrar novo produto\n";
            messageProdutos += "2 - Visualizar produtos\n";
            messageProdutos += "3 - Atualizar estoque\n";
            messageProdutos += "4 - Remover produto\n";
            messageProdutos += "\n\nDigite sua opção:";

            switch (Integer.parseInt(JOptionPane.showInputDialog(messageProdutos))) { // SWITCH CASE DA ABA PRODUTOS: Escolha referente as opções para produtos
              case 1: // SWITCH CASE DA ABA PRODUTOS - CASE 1 - Aba referente ao cadastramento de produtos
                String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto:"); // Recebe o nome do produto para o cadastramento
                if (nomeProduto.equals("")) { // Verifica se o nome do produto esta vazio
                  throw new NullPointerException(); // Se vazio, retorna uma exeção do tipo 'NullPointerException'
                }
                Double valorProduto = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto:")); // Recebe o valor do produto
                if (valorProduto == null || valorProduto < 0) { // Faz uma validação do valor do produto
                  JOptionPane.showMessageDialog(null, "Valor inválido");
                  break;
                }
                int quantidadeEstoque = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade desse produto:")); // Recebe a quantidade em estoque do produto
                if (quantidadeEstoque < 0) { // Faz uma vlidação da quantidade do produto
                  JOptionPane.showMessageDialog(null, "Quantidade inválida");
                  break;
                }
                // Adiciona um novo objeto do tipo 'Produto' na lista de produtos
                produtos.put(Produto.quantidadeProdutos, new Produto(nomeProduto, valorProduto, quantidadeEstoque));
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
                break;
              case 2: // SWITCH CASE DA ABA PRODUTOS - CASE 2 - Aba referente a visualização de produtos
                // Usa o metodo 'mostrar' da classe Produto para retornar a String com todos os produtos cadastrados
                JOptionPane.showMessageDialog(null, Produto.mostrar(produtos));
                break;
              case 3: // SWITCH CASE DA ABA PRODUTOS - CASE 3 - Aba referente ao aumento na quantidade de produtos
                // Mostra todos os produtos e recebe o codigo do produto que sera adicionada a quantidade de estoque
                int codigoProduto = Integer.parseInt(JOptionPane.showInputDialog(Produto.mostrar(produtos) + "\n\nDigite o codigo do produto:"));

                // Recebe a quantidade que sera adicionada ao produto
                int quantidadeAdicionada = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade que deseja adicionar:"));

                produtos.get(codigoProduto).estoque += quantidadeAdicionada; // Adiciona a quantidade ao atributo 'estoque' do produto
                JOptionPane.showMessageDialog(null, "Estoque atualizado");
                break;
              case 4: // SWITCH CASE DA ABA PRODUTOS - CASE 4 - Aba referente a remoção de produtos
                // Mostra todos os produtos e recebe o codigo do produto que sera removido
                int codigoRemoverProduto = Integer.parseInt(JOptionPane.showInputDialog(Produto.mostrar(produtos) + "\n\nDigite o codigo do produto que deseja remover:"));

                if(produtos.containsKey(codigoRemoverProduto)){
                  produtos.remove(codigoRemoverProduto); // Remove o produto selecionado da lista de produtos
                  JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
                } else {
                  JOptionPane.showMessageDialog(null, "Nenhum produto com esse codigo");
                }
                break;
              default:
                break;
            }
            break;
          case 4: // SWITCH CASE PRINCIPAL - CASE 4 - Aba referente a efetuar uma venda

            // Transforma todos os HashMaps de objetos criados em ArrayLists para serem usados no Input listado do JOptionPane
            ArrayList<Pessoa> clientesArray = new ArrayList<>(clientes.values());
            ArrayList<Pessoa> vendedoresArray = new ArrayList<>(vendedores.values());
            ArrayList<Produto> produtosArray = new ArrayList<>(produtos.values());

            // Cria objetos para serem usados no restante do codigo
            Cliente clienteSelecionado = null;
            Vendedor vendedorSelecionado = null;
            Produto produtoSelecionado = null;
            String dataHora = null;
            if (!clientesArray.isEmpty() && !vendedoresArray.isEmpty()) { // Testa para saber se existe algum cliente e vendedor cadastrado
              // Recebe o cliente selecionado na hora da compra
              clienteSelecionado = (Cliente) JOptionPane.showInputDialog(null, "Selecione o cliente", "Opção",JOptionPane.INFORMATION_MESSAGE, null, clientesArray.toArray(), clientesArray.get(0));

              // Recebe o vendedor selecionado na hora da compra
              vendedorSelecionado = (Vendedor) JOptionPane.showInputDialog(null, "Selecione o vendedor", "Opção",JOptionPane.INFORMATION_MESSAGE, null, vendedoresArray.toArray(), vendedoresArray.get(0));

              String[] options = { "Sim", "Finalizar a compra" }; // Opções para finalizar a compra - Serão mostradas no JOptionPane do While
              ArrayList<Venda> carrinhoCompras = new ArrayList<>(); // Carrinho de compras do cliente selecionado
              do {
                if (!produtos.isEmpty()) { // Verifica se existe produtos cadastrados
                  produtoSelecionado = (Produto) JOptionPane.showInputDialog(null, "Selecione o produto", "Opção",JOptionPane.INFORMATION_MESSAGE, null, produtosArray.toArray(), produtosArray.get(0));
                } else {
                  JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado");
                }

                //Recebe a quantidade do produto selecionado que sera comprada
                int quantidadeComprada = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade que deseja comprar:", "1"));

                // Verifica se a quantidade comprada é menor que a do estoque, e verifica se a quantidade comprada é maior que 0
                if (produtoSelecionado.estoque >= quantidadeComprada && quantidadeComprada > 0) {
                  produtoSelecionado.estoque -= quantidadeComprada; // Retira a quantidade comprada do estoque do produto
                  LocalDateTime now = LocalDateTime.now();
                  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                  dataHora = now.format(formatter);
                  // Cria um objeto do tipo venda, onde será armazedas as informações da venda realizada
                  Venda vendaCliente = new Venda(clienteSelecionado, vendedorSelecionado, produtoSelecionado,quantidadeComprada, dataHora); // TODO

                  carrinhoCompras.add(vendaCliente); // Adiciona a venda efetuada ao carrinho de compras do cliente
                  vendasDiarias.add(vendaCliente); // Adiciona a venda efetuada as vendas realizadas no dia
                } else {
                  JOptionPane.showMessageDialog(null, "Quantidade Invalida");
                }

                // While para manter o cliente no menu de compras
              } while (JOptionPane.showOptionDialog(null, "Deseja continuar comprando?", "Aviso",JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0);

              String messageFinalizarVenda = "";
              if (!carrinhoCompras.isEmpty()) { // Verifica se o carrinho de compras do cliente esta vazio
                Double valorTotalCompra = 0.; // Valor total das compras realizadas pelo cliente

                //Como obrigatoriamente todos os valores de cliente, vendedor, data e hora serão iguais, pode-se usar o valor do primeiro elemento do ArrayList - get(0)

                messageFinalizarVenda += "Cliente: " + clienteSelecionado; // Recupera o nome do cliente que efetuou a compra
                messageFinalizarVenda += "\nVendedor: " + vendedorSelecionado; // Recupera o nome do vendedor que efetuou a venda
                messageFinalizarVenda += "\nData e Hora: " + dataHora + "\n\n"; // Recupera a data e hora da compra
                for (Venda produtosCarrinho : carrinhoCompras) { // Recupera todos os produtos comprados pelo cliente
                  valorTotalCompra += produtosCarrinho.totalVenda; // Adiciona o valor do produto multiplicado pela quantidade comprada ao valor total da compra

                  //Formata a string dos produtos comprados pelo cliente
                  messageFinalizarVenda += produtosCarrinho.produto.nome + "  -  "
                      + produtosCarrinho.quantidadeComprada
                      + "  X  R$" + produtosCarrinho.produto.valor + "   -    R$"
                      + Math.round(produtosCarrinho.totalVenda)
                      + "\n";
                }

                messageFinalizarVenda += "\n\nVALOR TOTAL:   R$" + valorTotalCompra; // Mostra o valor final da compra
                messageFinalizarVenda += "\n\nFinalizar compra?";
              } else {
                messageFinalizarVenda = "Nenhuma compra foi realizada";
              }

              // Mostra a string formatada da compra realizada pelo cliente, e exibe a opção de finalizar a venda
              int respostaFinalizarCompra = JOptionPane.showConfirmDialog(null, messageFinalizarVenda,"Finalizar Venda", JOptionPane.YES_NO_OPTION);
              if (respostaFinalizarCompra == 1) { // Verifica se a resposta do cliente foi igual a 'Não'. Se caso isso ocorra, o programa deverá cancelar a venda
               // Percorre o HashMap do carrinho de compras do cliente
                for (Venda vendaEfetuada : carrinhoCompras) { // Percorre apenas os objetos do tipo 'venda' do carrinho de compras do cliente, para acessar os produtos que ele comprou
                  vendaEfetuada.produto.estoque += vendaEfetuada.quantidadeComprada; // Coloca a quantidade que foi comprada de volta ao estoque do produto
                  // Serve para remover a ultimo objeto do tipo 'venda' adicionado a 'vendasDiarias'.
                  vendasDiarias.remove(vendasDiarias.size() - 1); // Como esta dentro do 'for', removera todos os objetos do tipo 'venda' que foram criadas pelo cliente que cancelou a compra
                }
              }
            } else {
              JOptionPane.showMessageDialog(null, "Nenhum cliente ou vendedor cadastrado");
            }
            break;
          case 5: // SWITCH CASE PRINCIPAL - CASE 5 - Aba referente a geração de relatorio
            Double valorBruto = 0.; // Valor total de todas as vendas realizadas no dia
            for (Venda venda : vendasDiarias) {
              valorBruto += venda.totalVenda; // Soma o valor de todas as vendas individualmente para formar o valor final
            }
            Double impostoDiario = valorBruto * 0.25; // Aplica um imposto de 25% as vendas realizadas no dia
            String relatorioDiario = "RELATORIO\n\n"; // Cria uma String para mostrar o relatorio final

            //Mostra as informações principais de todas as vendas realizadas no dia
            for (Venda venda : vendasDiarias) {
              relatorioDiario += venda.produto.nome + "  -  " + venda.quantidadeComprada
                  + "  X  R$" + venda.produto.valor + "   -    R$" + Math.round(venda.totalVenda)
                  + "\nVendedor:  " + venda.vendedor.nome + "  -  Comissão:   R$" + venda.comissaoVenda + "\n\n";
            }
            relatorioDiario += "RELATORIO DE COMISSÕES\n";
            for (Map.Entry<Integer, Pessoa> pessoa : vendedores.entrySet()) { // Mostra o valor total que cada vendedor recebeu de comissão durante o dia
              Vendedor vendedor = (Vendedor) pessoa.getValue();
              relatorioDiario += vendedor + ":     R$" + vendedor.comissao + "\n";
            }

            relatorioDiario += "\n\nNúmero de vendas:   " + vendasDiarias.size(); // Mostra o total de vendas realizadas no dia
            relatorioDiario += "\nValor bruto:   R$" + valorBruto; // Mostra o valor bruto adquirido no dia
            relatorioDiario += "\nImposto aplicado:   R$" + impostoDiario; // Mostra o valor com o imposto aplicado
            relatorioDiario += "\nValor final:   R$" + (valorBruto - impostoDiario); // Mostra o valor real ganho no dia
            JOptionPane.showMessageDialog(null, relatorioDiario);
            break;
          case 6: // SWITCH CASE PRINCIPAL - CASE 6 - Finaliza o programa
            exec = false; // Encerra a execução do programa principal
            break;
          default:
            JOptionPane.showMessageDialog(null, "Opção Inválida", "Erro", JOptionPane.ERROR_MESSAGE);
            break;
        }
      // Tratamento de exceções
      } catch (NumberFormatException nfe) { // Caso o usuario digite alguma String na hora de escolher alguma opção do programa
        JOptionPane.showMessageDialog(null, "Opção Inválida", "Erro", JOptionPane.ERROR_MESSAGE);
      } catch (NullPointerException npe) { // Caso o usuario deixe algum espaço em branco durante a execução do programa
        JOptionPane.showMessageDialog(null, "ERRO! Campo Vazio", "Erro", JOptionPane.ERROR_MESSAGE);
      }
    } while (exec); // Execução do loop principal do projeto
    JOptionPane.showMessageDialog(null, "Programa Encerrado");
  }
  // Cria o menu principal do programa
  public static String menu() {
    String menu = "                 ZAIA\n\n";
    menu += "1 - Acessar Clientes\n";
    menu += "2 - Acessar Vendedores\n";
    menu += "3 - Acessar Produtos\n";
    menu += "4 - Realizar Compra\n";
    menu += "5 - Gerar Relatório\n";
    menu += "6 - Sair do programa\n";
    menu += "\n\nDigite sua opção:";
    return menu;
  }
  // Cadastra alguns produtos antes da execução do programa
  public static ArrayList<Produto> gerarProdutos() {
    ArrayList<Produto> produtos = new ArrayList<>();
    produtos.add(new Produto("Placa de video", 4750.0, 5));
    produtos.add(new Produto("Processador", 2200.0, 8));
    produtos.add(new Produto("RAM", 450.0, 18));
    produtos.add(new Produto("SSD", 500.0, 20));
    produtos.add(new Produto("Mouse", 130.0, 30));
    produtos.add(new Produto("Teclado", 220.0, 28));
    produtos.add(new Produto("HeadSet", 120.0, 32));
    produtos.add(new Produto("WebCam", 100.0, 40));
    produtos.add(new Produto("Placa mãe", 1300.0, 16));
    produtos.add(new Produto("Fonte", 400.0, 25));
    return produtos;
  }
}