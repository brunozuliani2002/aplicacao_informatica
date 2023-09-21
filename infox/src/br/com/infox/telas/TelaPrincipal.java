package br.com.infox.telas;

import javax.swing.*;

public class TelaPrincipal {

    private JButton button1;
    public JPanel JPTelaPrincipal;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TelaPrincipal");
        frame.setContentPane(new TelaPrincipal().JPTelaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}