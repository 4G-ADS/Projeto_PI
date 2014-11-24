package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.fafica.projeto_pi.modelos.Solo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TelaPrincipalReserva extends JFrame {

	private JPanel contentPane;
	private ArrayList<Solo> listaSolo = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalReserva frame = new TelaPrincipalReserva();
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
	public TelaPrincipalReserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAddPesquisador = new JButton("Add Pesquisador");
		
		 
		
		JButton btnAddSolo = new JButton("Add Solo");
		btnAddSolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CadastrarSolo().setVisible(true);
			}		
		});
		
		JButton btnAddNasciente = new JButton("Add Nascente");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddPesquisador)
						.addComponent(btnAddSolo, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddNasciente, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(285, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(btnAddPesquisador)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAddSolo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAddNasciente)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}


}
