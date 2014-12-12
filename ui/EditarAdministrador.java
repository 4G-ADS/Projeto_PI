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
		setBounds(100, 100, 363, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(215, 213, 97, 29);
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
		labelNome.setBounds(85, 60, 37, 16);
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setBounds(85, 95, 37, 16);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setBounds(85, 140, 37, 16);
		
		JLabel labelCPF = new JLabel("CPF");
		labelCPF.setBounds(88, 176, 34, 16);
		
		JLabel lblIdID = new JLabel("ID");
		lblIdID.setBounds(108, 22, 14, 16);
		
		carregarCaracteristicas();
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.setBounds(232, 58, 80, 29);
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nome = JOptionPane.showInputDialog("novo nome");
				admProvisorio.setNome(nome);
				carregarNome.setText(nome);
				
			}
		});
		
		JButton buttonEditarLogin = new JButton("Editar");
		buttonEditarLogin.setBounds(232, 98, 80, 29);
		buttonEditarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String login = JOptionPane.showInputDialog("novo login");
				admProvisorio.setLogin(login);
				carregarLogin.setText(login);
			}
		});
		
		JButton buttonEditarSenha = new JButton("Editar");
		buttonEditarSenha.setBounds(232, 138, 80, 29);
		buttonEditarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int senha = Integer.parseInt(JOptionPane.showInputDialog("nova senha"));
				admProvisorio.setSenha(senha);
				carregarSenha.setText(String.valueOf(senha));
			}
		});
		
		JLabel carregarCPF = new JLabel(adm.getCpf());
		carregarCPF.setBounds(129, 176, 75, 16);
		contentPane.setLayout(null);
		contentPane.add(lblIdID);
		contentPane.add(carregarID);
		contentPane.add(labelNome);
		contentPane.add(carregarNome);
		contentPane.add(buttonEditarNome);
		contentPane.add(labelLogin);
		contentPane.add(carregarLogin);
		contentPane.add(buttonEditarLogin);
		contentPane.add(labelSenha);
		contentPane.add(carregarSenha);
		contentPane.add(buttonEditarSenha);
		contentPane.add(labelCPF);
		contentPane.add(carregarCPF);
		contentPane.add(buttonVoltar);
	}

	public void carregarCaracteristicas(){
		
		carregarID = new JLabel(""+admProvisorio.getId());
		carregarID.setBounds(131, 22, 8, 16);
		
		carregarNome = new JLabel(admProvisorio.getNome());
		carregarNome.setBounds(128, 60, 92, 16);
		
		carregarLogin = new JLabel(admProvisorio.getLogin());
		carregarLogin.setBounds(130, 95, 97, 16);
		
		carregarSenha = new JLabel(String.valueOf(admProvisorio.getSenha()));
		carregarSenha.setBounds(128, 140, 76, 16);
	}
}
