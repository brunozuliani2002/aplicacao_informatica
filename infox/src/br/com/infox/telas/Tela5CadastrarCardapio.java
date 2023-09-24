package br.com.infox.telas;

import br.com.infox.dal.ModuloConexao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class Tela5CadastrarCardapio {

    private JTextField txtProduto;
    private JTextField txtPreco;
    public JPanel JPTelaCadastrarCardapio;
    public Tela4Cardapio tela4Cardapio;
    private JButton btnCadastrar;
    private JButton btnVoltar;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TelaCadastrarCardapio");
        frame.setContentPane(new Tela5CadastrarCardapio().JPTelaCadastrarCardapio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    public Tela5CadastrarCardapio() {

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String produto = txtProduto.getText();
                int preco = Integer.parseInt(txtPreco.getText());

                if (cadastrarPedidos(produto,preco)) {

                    JOptionPane.showMessageDialog(JPTelaCadastrarCardapio, "Cadastro do produto realizado com sucesso!");



                    JFrame frameTelaCadastro = (JFrame) SwingUtilities.getWindowAncestor(JPTelaCadastrarCardapio);
                    frameTelaCadastro.setVisible(false);

                    JFrame frameTelaCardapio4 = new JFrame("TelaCardapio4");
                    frameTelaCardapio4.setContentPane(new Tela4Cardapio().JPTelaCardapio);
                    frameTelaCardapio4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frameTelaCardapio4.pack();
                    frameTelaCardapio4.setVisible(true);
                    frameTelaCardapio4.setLocationRelativeTo(null);
                } else {

                    JOptionPane.showMessageDialog(JPTelaCadastrarCardapio, "Erro ao cadastrar produto", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameTelaCadastrarCardapio = (JFrame) SwingUtilities.getWindowAncestor(JPTelaCadastrarCardapio);
                frameTelaCadastrarCardapio.setVisible(false);

                JFrame frameTelaCardapio = new JFrame("TelaJPTelaCardapio");
                frameTelaCardapio.setContentPane(new Tela4Cardapio().JPTelaCardapio);
                frameTelaCardapio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameTelaCardapio.pack();
                frameTelaCardapio.setVisible(true);
                frameTelaCardapio.setLocationRelativeTo(null);
            }
        });

    }


    private boolean cadastrarPedidos( String produto, int preco) {
        // Lógica para cadastrar o usuário no banco de dados
        // Substitua pelo código de inserção no banco de dados

        try {
            Connection conexao = ModuloConexao.obterConexao();
            String insercaoSQL = "INSERT INTO tbpedidos (produto,preco) VALUES (?, ?)";
            PreparedStatement statement = conexao.prepareStatement(insercaoSQL);

            statement.setString(1, produto);
            statement.setInt(2, preco);

            int linhasAfetadas = statement.executeUpdate();

            conexao.close();
            return linhasAfetadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
  }

