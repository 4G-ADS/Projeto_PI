package com.fafica.projeto_pi.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Login {

	private JFrame frmTelaDeLogin;
	private JTextField login;
	private JTextField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmTelaDeLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaDeLogin = new JFrame();
		frmTelaDeLogin.setTitle("Tela de login");
		frmTelaDeLogin.setBounds(100, 100, 450, 300);
		frmTelaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Login");
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		
		login = new JTextField();
		login.setColumns(10);
		
		senha = new JTextField();
		senha.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				System.out.println(verificarUsuario());
				if(verificarUsuario() == true){
					
					frmTelaDeLogin.dispose();
					new MenuPrincipal().setVisible(true);
					
				}else{
					JOptionPane.showMessageDialog(null, "Usuario ou senha inválidos");
				}
				
			}

			
		});
		
		JButton btnCadastrese = new JButton("Cadastre-se");
		btnCadastrese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmTelaDeLogin.dispose();
				new CadastrarAdministrador().setVisible(true);
			}
		});
		
	
		
		GroupLayout groupLayout = new GroupLayout(frmTelaDeLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(220)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(senha, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addComponent(login, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
					.addGap(25))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(306, Short.MAX_VALUE)
					.addComponent(btnEntrar)
					.addGap(65))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(btnCadastrese)
					.addContainerGap(297, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(login, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addComponent(btnEntrar)
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addComponent(btnCadastrese)
					.addGap(31))
		);
		frmTelaDeLogin.getContentPane().setLayout(groupLayout);
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
