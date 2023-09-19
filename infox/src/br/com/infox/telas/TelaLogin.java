package br.com.infox.telas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import javax.swing.*;
import br.com.infox.telas.TelaPrincipal;

public class TelaLogin {

    private JButton btnButton;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JLabel LUsuario;
    private JPanel JPTelaLogin;
    private JLabel LStatus;

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;




    public static void main(String[] args) {
        Connection conexao = null;
        conexao = ModuloConexao.conector();


        JFrame frame = new JFrame("TelaLogin");
        frame.setContentPane(new TelaLogin().JPTelaLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        frame.setLocationRelativeTo(null);
        instance = new TelaPrincipal();

    }
    public void logar(){
        String sql = "select * from tbusuarios where login = ? and senha = ?";
    try {
        // consulta ao banco o q foi digitado nos txt
        pst = conexao.prepareStatement(sql);
        pst.setString(1,txtUsuario.getText());
        pst.setString(2,txtSenha.getText());
        //executa a query
        rs=pst.executeQuery();
        //se existir usuario e senha correspondente
        if (rs.next()) {
            JFrame frame = new JFrame("TelaPrincipal");
            frame.setVisible(true);

        }else {
            JOptionPane.showMessageDialog(null,"usuario ou senha incorreto");
        }
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }

    }


    public TelaLogin(){
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;


        conexao = ModuloConexao.conector();
        System.out.println(conexao);
        if (conexao != null) {
            LStatus.setText("conectado");
        }else {
            LStatus.setText("nao conectado");
        }


        btnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logar();
            }
        });
    }



    private static TelaPrincipal instance;

    public static TelaPrincipal getInstance() {
        return instance;
    }


    }




