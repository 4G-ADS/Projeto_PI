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
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(20, 60, 31, 16);
		contentPane.add(labelNome);
		
		JLabel labelEspecie = new JLabel("Espécie:");
		labelEspecie.setBounds(20, 87, 40, 16);
		contentPane.add(labelEspecie);
		
		JLabel labelTamanho = new JLabel("Tamanho:");
		labelTamanho.setBounds(20, 116, 48, 16);
		contentPane.add(labelTamanho);
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonVoltar.setBounds(320, 221, 104, 29);
		contentPane.add(buttonVoltar);
		
		JLabel lableID = new JLabel("ID:");
		lableID.setBounds(20, 33, 31, 16);
		contentPane.add(lableID);
		
		JLabel labelCarregarId = new JLabel("");
		labelCarregarId.setBounds(86, 34, 31, 16);
		contentPane.add(labelCarregarId);
		
		JLabel labelCarregarNome = new JLabel("");
		labelCarregarNome.setBounds(86, 61, 31, 16);
		contentPane.add(labelCarregarNome);
		
		JLabel labelCarregarEspecie = new JLabel("");
		labelCarregarEspecie.setBounds(86, 88, 31, 16);
		contentPane.add(labelCarregarEspecie);
		
		JLabel labelCarregarTamanho = new JLabel("");
		labelCarregarTamanho.setBounds(86, 117, 31, 16);
		contentPane.add(labelCarregarTamanho);
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.setBounds(144, 57, 89, 23);
		contentPane.add(buttonEditarNome);
		
		JButton buttonEditarEspecie = new JButton("Editar");
		buttonEditarEspecie.setBounds(144, 84, 89, 23);
		contentPane.add(buttonEditarEspecie);
		
		JButton buttonEditarTamanho = new JButton("Editar");
		buttonEditarTamanho.setBounds(144, 113, 89, 23);
		contentPane.add(buttonEditarTamanho);
	}

}
