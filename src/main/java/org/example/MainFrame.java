package org.example;

import javax.swing.*;

public class MainFrame extends JFrame{
    private JTextField txtCnpj;
    private JButton btnConsultar;
    private JTextField txtCliente;
    private JList listData;
    private JList listToneladas;
    private JList listValor;
    private JTextField txtTonTotal;
    private JTextField txtValorTotal;
    private JPanel JMainPanel;
    private JLabel lblCnpj;
    private JLabel lblCliente;
    private JLabel lblData;
    private JLabel lblToneladas;
    private JLabel lblValor;

    public MainFrame(){
        setContentPane(JMainPanel);
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
