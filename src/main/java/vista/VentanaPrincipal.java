package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlador.ControladorRequerimientos;
import modelo.tableModel.Requerimiento_1TableModel;
import modelo.tableModel.Requerimiento_2TableModel;
import modelo.tableModel.Requerimiento_3TableModel;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private JLabel labelTitulo;
    private ControladorRequerimientos controlador;
    private JButton button1, button2, button3;
    private JTable table1, table2, table3;

    public VentanaPrincipal() {

        controlador = new ControladorRequerimientos();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setTitle("Proyecto Final Ciclo 2 - MisionTIC 2022");
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panelPrincipal = new JPanel();
        labelTitulo = new JLabel("OLB Constructores");
        panelPrincipal.add(labelTitulo, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel Requerimiento 1
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        JTextArea textArea1 = new JTextArea();
        textArea1.setLineWrap(true);
        textArea1.setBounds(0, 0, 445, 20);
        textArea1.setText(
                "Listado del promedio de los salarios de los líderes de proyecto, agrupados por Ciudad de Residencia, y teniendo salario promedio inferior a 600.000");
        textArea1.setEditable(false);
        
        button1 = new JButton("Refrescar tabla");
        button1.addActionListener(this);
        button1.setBounds(0, 0, 95, 20);
        JFrame descriptionContainer1 = new JFrame();
        descriptionContainer1.add(textArea1, BorderLayout.WEST);
        descriptionContainer1.add(button1, BorderLayout.EAST);
        panel1.add(descriptionContainer1.getContentPane(), BorderLayout.NORTH);

        // Tabla 1
        table1 = new JTable();
        SetModelTable1();
        JScrollPane tableContainer1 = new JScrollPane(table1);
        panel1.add(tableContainer1, BorderLayout.CENTER);
        

        // Panel Requerimiento 2
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        JTextArea textArea2 = new JTextArea();
        textArea2.setLineWrap(true);
        textArea2.setBounds(0, 0, 445, 20);
        textArea2.setText(
                "Listado de los nombres de los proveedores de las diferentes compras realizadas para los proyectos de la ciudad de Quibdó");
        textArea2.setEditable(false);
        
        button2 = new JButton("Refrescar tabla");
        button2.addActionListener(this);
        button2.setBounds(0, 0, 95, 20);
        JFrame descriptionContainer2 = new JFrame();
        descriptionContainer2.add(textArea2, BorderLayout.WEST);
        descriptionContainer2.add(button2, BorderLayout.EAST);
        panel2.add(descriptionContainer2.getContentPane(), BorderLayout.NORTH);

        // Tabla 2
        table2 = new JTable();
        SetModelTable2();
        JScrollPane tableContainer2 = new JScrollPane(table2);
        panel2.add(tableContainer2, BorderLayout.CENTER);
        

        // Panel Requerimiento 3
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        JTextArea textArea3 = new JTextArea();
        textArea3.setLineWrap(true);
        textArea3.setBounds(0, 0, 445, 20);
        textArea3.setText(
                "Listado de materiales utilizados para los proyectos con ID entre 5 y 15 ordenados de forma ascendente por el ID del proyecto");
        textArea3.setEditable(false);
        
        button3 = new JButton("Refrescar tabla");
        button3.addActionListener(this);
        button3.setBounds(0, 0, 95, 20);
        JFrame descriptionContainer3 = new JFrame();
        descriptionContainer3.add(textArea3, BorderLayout.WEST);
        descriptionContainer3.add(button3, BorderLayout.EAST);
        panel3.add(descriptionContainer3.getContentPane(), BorderLayout.NORTH);

        // Tabla 3
        table3 = new JTable();
        SetModelTable3();
        JScrollPane tableContainer3 = new JScrollPane(table3);
        panel3.add(tableContainer3, BorderLayout.CENTER);
        

        // Agregar Paneles
        tabbedPane.addTab("Requerimiento 1", panel1);
        tabbedPane.addTab("Requerimiento 2", panel2);
        tabbedPane.addTab("Requerimiento 3", panel3);
        add(panelPrincipal, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);

    }

    private void SetModelTable1() {
        try {
            var result = controlador.consultarRequerimiento1();
            Requerimiento_1TableModel tableModel = new Requerimiento_1TableModel(result);
            table1.setModel(tableModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la Base de Datos", "Error en la Consulta 1",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void SetModelTable2() {
        try {
            var result = controlador.consultarRequerimiento2();
            Requerimiento_2TableModel tableModel = new Requerimiento_2TableModel(result);
            table2.setModel(tableModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la Base de Datos", "Error en la Consulta 1",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void SetModelTable3() {
        try {
            var result = controlador.consultarRequerimiento3();
            Requerimiento_3TableModel tableModel = new Requerimiento_3TableModel(result);
            table3.setModel(tableModel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la Base de Datos", "Error en la Consulta 1",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            SetModelTable1();
        } else if (e.getSource() == button2) {
            SetModelTable2();
        } else if (e.getSource() == button3) {
            SetModelTable3();
        }
    }

}
