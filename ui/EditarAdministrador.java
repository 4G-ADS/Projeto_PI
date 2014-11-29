package com.fafica.projeto_pi.ui;

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

import com.fafica.projeto_pi.excecoes.AdministradorNaoEncontradoException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Administrador;
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class EditarAdministrador extends JFrame {

	private JPanel contentPane;
	private Administrador admProvisorio;
	private JLabel carregarID;
	private JLabel carregarNome;
	private JLabel carregarLogin;
	private JLabel carregarSenha;
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
		admProvisorio = adm;
		setTitle("Editar Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.getInstace().editarAdministrador(admProvisorio);
					dispose();
					new MenuPrincipal(admProvisorio).setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AdministradorNaoEncontradoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		JLabel labelNome = new JLabel("Nome");
		
		JLabel labelLogin = new JLabel("Login");
		
		JLabel labelSenha = new JLabel("Senha");
		
		JLabel labelCPF = new JLabel("CPF");
		
		JLabel lblIdID = new JLabel("ID");
		
		carregarCaracteristicas();
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nome = JOptionPane.showInputDialog("novo nome");
				admProvisorio.setNome(nome);
				carregarNome.setText(nome);
				
			}
		});
		
		JButton buttonEditarLogin = new JButton("Editar");
		buttonEditarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String login = JOptionPane.showInputDialog("novo login");
				admProvisorio.setLogin(login);
				carregarLogin.setText(login);
			}
		});
		
		JButton buttonEditarSenha = new JButton("Editar");
		buttonEditarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int senha = Integer.parseInt(JOptionPane.showInputDialog("nova senha"));
				admProvisorio.setSenha(senha);
				carregarSenha.setText(String.valueOf(senha));
			}
		});
		
		JLabel carregarCPF = new JLabel(adm.getCpf());
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblIdID)
					.addGap(32)
					.addComponent(carregarID))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(carregarNome, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(102)
					.addComponent(buttonEditarNome))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(labelLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(carregarLogin, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(91)
					.addComponent(buttonEditarLogin))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(labelSenha, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(carregarSenha, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(91)
					.addComponent(buttonEditarSenha))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(labelCPF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(carregarCPF, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(317)
					.addComponent(buttonVoltar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdID)
						.addComponent(carregarID))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(labelNome))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(carregarNome))
						.addComponent(buttonEditarNome))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(labelLogin)
						.addComponent(carregarLogin)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(buttonEditarLogin)))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(labelSenha))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(carregarSenha))
						.addComponent(buttonEditarSenha))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(labelCPF)
						.addComponent(carregarCPF))
					.addGap(38)
					.addComponent(buttonVoltar))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void carregarCaracteristicas(){
		
		carregarID = new JLabel(""+admProvisorio.getId());
		
		carregarNome = new JLabel(admProvisorio.getNome());
		
		carregarLogin = new JLabel(admProvisorio.getLogin());
		
		carregarSenha = new JLabel(String.valueOf(admProvisorio.getSenha()));
	}
}
