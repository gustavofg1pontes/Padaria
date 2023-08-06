package org.example;

import org.example.models.Cliente;
import org.example.models.VendasCliente;
import org.example.services.VendasClienteService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MainFrame extends JFrame {
    private JTextField txtCnpj;
    private JButton btnConsultar;
    private JTextField txtCliente;
    private JList<LocalDate> listData;
    private JList<Float> listToneladas;
    private JList<Float> listValor;
    private JTextField txtTonTotal;
    private JTextField txtValorTotal;
    private JPanel JMainPanel;
    private JLabel lblCnpj;
    private JLabel lblCliente;
    private JLabel lblData;
    private JLabel lblToneladas;
    private JLabel lblValor;
    private VendasClienteService vendasClienteService;

    public MainFrame(VendasClienteService vendasClienteService) {
        this.vendasClienteService = vendasClienteService;
        setContentPane(JMainPanel);
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Cliente cliente = vendasClienteService.getCliente(Integer.valueOf(txtCnpj.getText()));
                    txtCliente.setText(cliente.getNome());
                    List<VendasCliente> vendasClientes = vendasClienteService.getVendasCliente(cliente);
                    DefaultListModel<LocalDate> listModelData = new DefaultListModel<>();
                    DefaultListModel<Float> listModelTon = new DefaultListModel<>();
                    DefaultListModel<Float> listModelValor = new DefaultListModel<>();
                    Float tonTotal = 0f, valorTotal = 0f;
                    for (VendasCliente v : vendasClientes) {
                        listModelData.addElement(v.getDataVenda());
                        listModelTon.addElement(v.getToneladas());
                        listModelValor.addElement(v.getValor());
                        tonTotal += v.getToneladas();
                        valorTotal += v.getValor();
                    }
                    listData.setModel(listModelData);
                    listToneladas.setModel(listModelTon);
                    listValor.setModel(listModelValor);
                    txtTonTotal.setText(tonTotal.toString());
                    txtValorTotal.setText(valorTotal.toString());
                } catch (Exception er) {
                    JOptionPane.showMessageDialog(JMainPanel, "Erro ao buscar cliente!");
                }
            }
        });
    }
}
