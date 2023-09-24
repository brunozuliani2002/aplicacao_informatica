package br.com.infox.telas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela2Principal {
    private JButton btnCardapio;
    private JButton btnSeusPedidos;
    private JButton btnCadastrarFormaDePagamento;
    public JPanel JPTelaPrincipal;

    public Tela2Principal() {
        btnSeusPedidos.setEnabled(false);
        btnCadastrarFormaDePagamento.setEnabled(false);



        btnCardapio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frameTelaLogin = (JFrame) SwingUtilities.getWindowAncestor(JPTelaPrincipal);
                frameTelaLogin.setVisible(false);

                JFrame frameTelaCardapio = new JFrame("TelaCardapio");
                frameTelaCardapio.setContentPane(new Tela4Cardapio().JPTelaCardapio);
                frameTelaCardapio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameTelaCardapio.pack();
                frameTelaCardapio.setVisible(true);
                frameTelaCardapio.setLocationRelativeTo(null);
            }
        });
    }
}
