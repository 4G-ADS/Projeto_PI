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
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Administrador;

import java.awt.color.CMMException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CadastrarAdministrador extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoLogin;
	private JTextField campoSenha;
	private JTextField campoCPF;
	private Administrador adm;
	private JLabel planoDeFundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarAdministrador frame = new CadastrarAdministrador();
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
	public CadastrarAdministrador() {
		setTitle("Cadastrar Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JButton btnAvanar = new JButton("Proximo");
		btnAvanar.setBounds(993, 657, 71, 23);
		btnAvanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					String nome = campoNome.getText();
					String login = campoLogin.getText();
					String cpf = campoCPF.getText();
					if(!nome.equals("") && !login.equals("") && !cpf.equals("")){
					int senha = Integer.parseInt(campoSenha.getText());
					adm = new Administrador(nome, login, cpf, senha);
					Fachada.getInstace().cadastrarAdministrardor(adm);
					
					adm = verificarUsuario();
					System.out.println(adm);
					System.out.println("ak");
					dispose();
					new MenuPrincipal(adm).setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "preencha todos os campos");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AdministradorJaCadastradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CampoObritarorioInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CPFInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(25, 12, 71, 27);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(25, 50, 71, 32);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSenha.setBounds(25, 141, 71, 23);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpf.setBounds(25, 97, 53, 23);
		
		campoNome = new JTextField();
		campoNome.setBounds(99, 16, 304, 27);
		campoNome.setColumns(10);
		
		campoLogin = new JTextField();
		campoLogin.setBounds(99, 54, 304, 32);
		campoLogin.setColumns(10);
		
		campoSenha = new JTextField();
		campoSenha.setBounds(99, 139, 304, 35);
		campoSenha.setColumns(10);
		
		campoCPF = new JTextField();
		campoCPF.setBounds(99, 97, 304, 31);
		campoCPF.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(btnAvanar);
		contentPane.add(lblSenha);
		contentPane.add(lblLogin);
		contentPane.add(lblNome);
		contentPane.add(campoNome);
		contentPane.add(campoLogin);
		contentPane.add(campoSenha);
		contentPane.add(lblCpf);
		contentPane.add(campoCPF);
		
		planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}
	
	public Administrador verificarUsuario() {
		ArrayList<Administrador> listaAdm;
		
		Administrador administradorProvisorio = null;
		
		try {
			listaAdm = Fachada.getInstace().listarAdministrador();
			for (Administrador administrador : listaAdm) {
				System.out.println("Senha: " + administrador.getSenha());
				
				if(campoLogin.getText().equals(administrador.getLogin()) && 
						campoSenha.getText().equals(String.valueOf(administrador.getSenha()))){
					System.out.println(administrador.toString());
					System.out.println("aqui" + administradorProvisorio);
					adm = administrador;
					administradorProvisorio = adm;
					break;
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return administradorProvisorio;
		
		
		
	}
}
