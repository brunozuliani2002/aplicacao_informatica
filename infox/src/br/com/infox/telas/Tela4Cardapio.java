package br.com.infox.telas;

import br.com.infox.dal.ModuloConexao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tela4Cardapio {
    public JPanel JPTelaCardapio;
    private JButton btnAdicionar1;
    private JButton btnAdicionar2;
    private JButton btnAdicionar3;
    private JButton btnAdicionar4;
    private JButton btnAdicionar5;
    private JTextField txtItem2;
    private JTextField txtItem1;
    private JTextField txtItem3;
    private JTextField txtItem4;
    private JTextField txtItem5;


    private JButton btnCadastrarCardapioButton;
    private JLabel LCardapio;
    private JButton btnRemover;
    private JTable tbPedido;
    private JButton btnFinalizarPedido;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TelaPrincipal");
        frame.setContentPane(new Tela4Cardapio().JPTelaCardapio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


    }
    public Tela4Cardapio() {
        btnAdicionar1.setEnabled(false);
        btnAdicionar2.setEnabled(false);
        btnAdicionar3.setEnabled(false);
        btnAdicionar4.setEnabled(false);
        btnAdicionar5.setEnabled(false);
        btnRemover.setEnabled(false);
        btnFinalizarPedido.setEnabled(false);




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
        txtItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Connection conexao = ModuloConexao.obterConexao();
                    String insercaoSQL = "SELECT * FROM tbpedidos WHERE id = ?";
                    int idDesejado = 1;
                    PreparedStatement statement = conexao.prepareStatement(insercaoSQL);
                    statement.setInt(1, idDesejado);
                    ResultSet rs = statement.executeQuery();

                    while (rs.next()) {
                        // Acesse os dados do resultado, por exemplo:
                        String produto = rs.getString("produto");
                        txtItem1.setText(produto);
                    }





                } catch (SQLException ex) {
                    ex.printStackTrace();


                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

        });

    }

}

