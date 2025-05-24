package Classes;
import javax.swing.JOptionPane;

public class teste {
  public static void main(String[] args) {
    Object[] itens = {"cliente 2", "BANANA" };
    Object selectedValue = JOptionPane.showInputDialog(null, "Seleciona o cliente", "Opçao",JOptionPane.INFORMATION_MESSAGE, null, itens, itens[0]);

  }
}
