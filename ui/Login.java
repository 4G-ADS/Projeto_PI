package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.LayoutStyle.ComponentPlacement;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField senha;
	private JTextField login;
	private JButton btnCadastrese;
	private Administrador adm = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Entrar");
			
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				System.out.println(verificarUsuario());
				if(verificarUsuario() == true){
					
					dispose();
					new MenuPrincipal(adm).setVisible(true);
					
				}else{
					JOptionPane.showMessageDialog(null, "Usuario ou senha inválidos");
				}
				
			}
		});
		
		senha = new JTextField();
		senha.setColumns(10);
		
		login = new JTextField();
		login.setColumns(10);
		
		JLabel lblL = new JLabel("Login");
		
		JLabel lblSenha = new JLabel("Senha");
		
		btnCadastrese = new JButton("Cadastre-se");
		btnCadastrese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new CadastrarAdministrador().setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(198, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(senha, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblL)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(login, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCadastrese)
					.addContainerGap(325, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(login, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblL))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha))
					.addGap(18)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
					.addComponent(btnCadastrese)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public boolean verificarUsuario() {
		ArrayList<Administrador> listaAdm;
		
		boolean verifica = false;
		
		try {
			listaAdm = Fachada.getInstace().listarAdministrador();
			for (Administrador administrador : listaAdm) {
				System.out.println("Senha: " + administrador.getSenha());
				
				if(login.getText().equals(administrador.getLogin()) && 
						senha.getText().equals(String.valueOf(administrador.getSenha()))){
					verifica = true;
					System.out.println("aqui" + verifica);
					adm = administrador;
					break;
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return verifica;
		
		
		
	}
}
