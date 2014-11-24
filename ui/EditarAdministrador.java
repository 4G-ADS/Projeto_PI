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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.fafica.projeto_pi.modelos.Administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarAdministrador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarAdministrador frame = new EditarAdministrador(null);
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
	public EditarAdministrador(Administrador adm) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("Avan\u00E7ar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel labelNome = new JLabel("Nome");
		
		JLabel labelLogin = new JLabel("Login");
		
		JLabel labelSenha = new JLabel("Senha");
		
		JLabel labelCPF = new JLabel("CPF");
		
		JLabel lblIdID = new JLabel("ID");
		
		JLabel carregarID = new JLabel("");
		
		JButton btnNewButton = new JButton("Editar");
		
		JButton btnEditar = new JButton("Editar");
		
		JButton btnEditar_1 = new JButton("Editar");
		
		JButton btnEditar_2 = new JButton("Editar");
		
		JLabel carregarNome = new JLabel(adm.getNome());
		
		JLabel carregarLogin = new JLabel(adm.getLogin());
		
		JLabel carregarSenha = new JLabel(String.valueOf(adm.getSenha()));
		
		JLabel carregarCPF = new JLabel(adm.getCpf());
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(labelSenha, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(labelLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(labelNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(28)
												.addComponent(carregarID))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(carregarNome, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(carregarSenha, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(labelCPF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(carregarCPF, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(45)
										.addComponent(carregarLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(btnNewButton)
									.addComponent(btnEditar)
									.addComponent(btnEditar_1)
									.addComponent(btnEditar_2))
								.addContainerGap(138, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblIdID)
								.addContainerGap(403, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdID)
						.addComponent(carregarID))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelNome)
						.addComponent(btnNewButton)
						.addComponent(carregarNome))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEditar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(carregarLogin)
								.addComponent(labelLogin))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar_1)
						.addComponent(labelSenha)
						.addComponent(carregarSenha))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar_2)
						.addComponent(labelCPF)
						.addComponent(carregarCPF))
					.addGap(38)
					.addComponent(button)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
