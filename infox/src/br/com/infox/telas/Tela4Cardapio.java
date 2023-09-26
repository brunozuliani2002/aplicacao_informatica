package br.com.infox.telas;

import br.com.infox.dal.ModuloConexao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Tela4Cardapio {
    public JPanel JPTelaCardapio;
    private JButton btnAdicionar1;
    private JButton btnAdicionar2;
    private JButton btnAdicionar3;
    private JButton btnAdicionar4;
    private JButton btnAdicionar5;
    public JTextField txtItem1;


    private JButton btnCadastrarCardapioButton;
    private JLabel LCardapio;
    private JButton btnRemover;
    private JTable tbPedido;
    private JButton btnFinalizarPedido;
    private JTextField txtItem2;
    private JTextField txtItem3;
    private JTextField txtItem4;
    private JTextField txtItem5;
    private JButton btnView;
    private JTable tbCardapio;
    JTextField[] textFields = {txtItem1, txtItem2, txtItem3,txtItem4, txtItem5};
    JButton[] buttons = {btnAdicionar1, btnAdicionar2, btnAdicionar3,btnAdicionar4, btnAdicionar5};


    public static void main(String[] args) {
        JFrame frame = new JFrame("TelaCardapio");
        frame.setContentPane(new Tela4Cardapio().JPTelaCardapio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);




    }
    public Tela4Cardapio() {


        for (JTextField textField : textFields) {
            textField.setEnabled(false);

            btnRemover.setEnabled(false);
            btnFinalizarPedido.setEnabled(false);






            for (JButton button : buttons) {
                if (button.isSelected()) {
                    try {
                        Connection conexao = ModuloConexao.obterConexao();
                        String insercaoSQL = "SELECT * FROM tbpedidos";


                        PreparedStatement statement = conexao.prepareStatement(insercaoSQL);

                        ResultSet rs = statement.executeQuery();




                        while (rs.next()) {
                            DefaultTableModel tableModel;
                            tableModel = new DefaultTableModel(new String[]{"preco"}, 1);

                            String preco = rs.getString("preco");
                            tableModel.addRow(new Object[]{preco});
                            tbPedido.setModel(tableModel);
                        }

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }




                    btnCadastrarCardapioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frameTelaCardapio = (JFrame) SwingUtilities.getWindowAncestor(JPTelaCardapio);
                    frameTelaCardapio.setVisible(false);

                    JFrame frameTelaCadastrarCardapio = new JFrame("TelaCadastrarCardapio");
                    frameTelaCadastrarCardapio.setContentPane(new Tela5CadastrarCardapio().JPTelaCadastrarCardapio);
                    frameTelaCadastrarCardapio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frameTelaCadastrarCardapio.pack();
                    frameTelaCadastrarCardapio.setVisible(true);
                    frameTelaCadastrarCardapio.setLocationRelativeTo(null);
                }
            });






            btnView.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Connection conexao = ModuloConexao.obterConexao();
                        String insercaoSQL = "SELECT * FROM tbpedidos";


                        PreparedStatement statement = conexao.prepareStatement(insercaoSQL);

                        ResultSet rs = statement.executeQuery();


                        int textFieldIndex = 0;

                        while (rs.next() && textFieldIndex < textFields.length) {
                            String produto = rs.getString("produto");
                            textFields[textFieldIndex].setText(produto);
                            textFieldIndex++;

                            for (int i = 0; i < buttons.length; i++) {

                                if (textFields[i].getText() == null || textFields[i].getText().trim().isEmpty()) {
                                    buttons[i].setEnabled(false);
                                    textFields[i].setEnabled(false);
                                } else {
                                    buttons[i].setEnabled(true);
                                    textFields[i].setEnabled(false);
                                }
                            }
                        }


                        rs.close();
                        conexao.close();

                    } catch (SQLException ex) {
                        ex.printStackTrace();


                    } catch (ClassNotFoundException exception) {
                        throw new RuntimeException(exception);
                    }
                }
            });

        }
    }




    public void exibirTextfield(){

        try {
            Connection conexao = ModuloConexao.obterConexao();
            String insercaoSQL = "SELECT * FROM tbpedidos WHERE id = ?";
            int idDesejado = 1;
            PreparedStatement statement = conexao.prepareStatement(insercaoSQL);
            statement.setInt(1, idDesejado);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                // Acesse os dados do resultado, por exemplo:
                txtItem1.setText(rs.getString("produto"));

            }


        } catch (SQLException ex) {
            ex.printStackTrace();


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

