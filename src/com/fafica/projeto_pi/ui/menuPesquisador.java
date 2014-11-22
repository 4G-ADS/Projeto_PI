package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class menuPesquisador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPesquisador frame = new menuPesquisador();
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
	public menuPesquisador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton criarPesquisador = new JButton("Criar");
		
		JLabel lblPesquisador = new JLabel("Pesquisador");
		lblPesquisador.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		
		JButton editarPesquisador = new JButton("Editar");
		
		JButton listarPesquisador = new JButton("Listar");
		
		JButton btnExcluir = new JButton("Excluir");
		
		JButton btnProcurar = new JButton("Procurar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(criarPesquisador)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editarPesquisador)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(listarPesquisador)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnProcurar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPesquisador)
							.addGap(150))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(lblPesquisador)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(criarPesquisador)
						.addComponent(editarPesquisador)
						.addComponent(listarPesquisador)
						.addComponent(btnExcluir)
						.addComponent(btnProcurar))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
