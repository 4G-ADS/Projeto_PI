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
		setBounds(100, 100, 276, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBounds(159, 119, 81, 29);
			
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				System.out.println(verificarUsuario());
				if(verificarUsuario() == true){
					
					dispose();
					new MenuPrincipal(adm).setVisible(true);
					
				}else{
					JOptionPane.showMessageDialog(null, "Usuario ou senha inv�lidos");
				}
				
			}
		});
		
		senha = new JTextField();
		senha.setBounds(88, 73, 152, 28);
		senha.setColumns(10);
		
		login = new JTextField();
		login.setBounds(88, 27, 152, 28);
		login.setColumns(10);
		
		JLabel lblL = new JLabel("Login");
		lblL.setBounds(24, 33, 35, 16);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(24, 79, 46, 16);
		
		btnCadastrese = new JButton("Cadastre-se");
		btnCadastrese.setBounds(39, 119, 121, 29);
		btnCadastrese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new CadastrarAdministrador().setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		contentPane.add(lblSenha);
		contentPane.add(senha);
		contentPane.add(lblL);
		contentPane.add(login);
		contentPane.add(btnCadastrese);
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
					System.out.println(administrador.toString());
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
