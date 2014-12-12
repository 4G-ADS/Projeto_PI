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
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JButton btnCadastrese;
	private Administrador adm = null;
	private JLabel lblImagem;
	private JPasswordField campoSenha;


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
		System.out.println("Pego");
		setForeground(new Color(0, 255, 153));
		setBackground(new Color(0, 255, 153));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 51));
		contentPane.setForeground(new Color(51, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBounds(902, 143, 152, 29);
			
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
		
		login = new JTextField();
		login.setBounds(902, 38, 152, 28);
		login.setColumns(10);
		
		JLabel lblL = new JLabel("Login");
		lblL.setBounds(902, 11, 35, 16);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(902, 77, 46, 16);
		
		btnCadastrese = new JButton("Cadastre-se");
		btnCadastrese.setBounds(10, 641, 121, 29);
		btnCadastrese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new CadastrarAdministrador().setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		contentPane.add(lblSenha);
		contentPane.add(lblL);
		contentPane.add(login);
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(902, 104, 152, 28);
		contentPane.add(campoSenha);
		contentPane.add(btnCadastrese);
		
		lblImagem = new JLabel("imagem");
		lblImagem.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\imagesLogin.jpg"));
		lblImagem.setBounds(0, 0, 1074, 691);
		contentPane.add(lblImagem);
	}
	
	public boolean verificarUsuario() {
		ArrayList<Administrador> listaAdm;
		
		boolean verifica = false;
		
		try {
			listaAdm = Fachada.getInstace().listarAdministrador();
			for (Administrador administrador : listaAdm) {
				System.out.println("Senha: " + administrador.getSenha());
				
				if(login.getText().equals(administrador.getLogin()) && 
						String.valueOf(campoSenha.getPassword()).equals(String.valueOf(administrador.getSenha()))){
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
