package br.com.infox.telas;

import javax.swing.*;

public class TelaPrincipal {

    private JButton button1;
    private JPanel JPTelaPrincipal;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TelaPrincipal");
        frame.setContentPane(new TelaPrincipal().JPTelaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}