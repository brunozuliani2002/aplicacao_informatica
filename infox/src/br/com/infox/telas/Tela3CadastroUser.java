package br.com.infox.telas;

import br.com.infox.dal.ModuloConexao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tela3CadastroUser {
    private JTextField txtNome;
    private JLabel JLNome;
    private JLabel JLSenha;
    private JTextField txtSenha;
    private JButton cadastrarButton;
    private JButton voltarButton;
    private JLabel JLTituloTchefood;
    public JPanel JPTelaCadastroUser;
    private JTextField txtFone;
    private JTextField txtLogin;
    private JButton btnVoltar;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame("TelaCadastroUser");
        frame.setContentPane(new Tela3CadastroUser().JPTelaCadastroUser);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    public Tela3CadastroUser() {

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String senha = txtSenha.getText();
                String fone = txtFone.getText();
                String login = txtLogin.getText();


                if (cadastrarUsuario(nome,fone,login ,senha)) {

                    JOptionPane.showMessageDialog(JPTelaCadastroUser, "Cadastro realizado com sucesso!");

                    JFrame frameTelaCadastro = (JFrame) SwingUtilities.getWindowAncestor(JPTelaCadastroUser);
                    frameTelaCadastro.setVisible(false);

                    JFrame frameTelaLogin = new JFrame("TelaLogin");
                    try {
                        frameTelaLogin.setContentPane(new Tela3Login().JPTelaLogin);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    frameTelaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frameTelaLogin.pack();
                    frameTelaLogin.setVisible(true);
                    frameTelaLogin.setLocationRelativeTo(null);
                } else {

                    JOptionPane.showMessageDialog(JPTelaCadastroUser, "Erro ao cadastrar usuário", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameTelaCadastroUser = (JFrame) SwingUtilities.getWindowAncestor(JPTelaCadastroUser);
                frameTelaCadastroUser.setVisible(false);

                JFrame frameTelaInicio = new JFrame("TelaInicio");
                frameTelaInicio.setContentPane(new Tela1Inicio().JPTelaInicio);
                frameTelaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameTelaInicio.pack();
                frameTelaInicio.setVisible(true);
                frameTelaInicio.setLocationRelativeTo(null);
            }
        });

    }


    private boolean cadastrarUsuario( String nome, String fone, String login, String senha) {
        // Lógica para cadastrar o usuário no banco de dados
        // Substitua pelo código de inserção no banco de dados

        try {
            Connection conexao = ModuloConexao.obterConexao();
            String insercaoSQL = "INSERT INTO tbusuarios (nome,fone,login, senha) VALUES (?, ?,?,?)";
            PreparedStatement statement = conexao.prepareStatement(insercaoSQL);

            statement.setString(1, nome);
            statement.setString(2, fone);
            statement.setString(3, login);
            statement.setString(4, senha);
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
