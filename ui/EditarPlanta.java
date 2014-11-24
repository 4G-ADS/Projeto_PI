package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarPlanta extends JFrame {

	private JPanel contentPane;
	private JTextField campoEspecie;
	private JTextField campoNome;
	private JTextField campoTamanho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarPlanta frame = new EditarPlanta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditarPlanta() {
		setTitle("Editar Planta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nome:");
		label.setBounds(42, 74, 41, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Espécie:");
		label_1.setBounds(32, 120, 51, 16);
		contentPane.add(label_1);
		
		campoEspecie = new JTextField();
		campoEspecie.setColumns(10);
		campoEspecie.setBounds(89, 114, 134, 28);
		contentPane.add(campoEspecie);
		
		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setBounds(89, 68, 134, 28);
		contentPane.add(campoNome);
		
		JLabel label_2 = new JLabel("Tamanho:");
		label_2.setBounds(241, 120, 62, 16);
		contentPane.add(label_2);
		
		campoTamanho = new JTextField();
		campoTamanho.setColumns(10);
		campoTamanho.setBounds(309, 114, 113, 28);
		contentPane.add(campoTamanho);
		
		JButton button = new JButton("Alterar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(89, 154, 104, 29);
		contentPane.add(button);
	}

}
