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
import java.awt.Font;
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(956, 632, 97, 29);
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
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNome.setBounds(355, 127, 66, 29);
		
		JLabel labelLogin = new JLabel("Login:");
		labelLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelLogin.setBounds(355, 167, 55, 29);
		
		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelSenha.setBounds(355, 218, 66, 30);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCPF.setBounds(355, 259, 46, 29);
		
		JLabel lblIdID = new JLabel("ID:");
		lblIdID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdID.setBounds(355, 86, 37, 29);
		
		carregarCaracteristicas();
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.setBounds(973, 131, 80, 29);
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nome = JOptionPane.showInputDialog("novo nome");
				admProvisorio.setNome(nome);
				carregarNome.setText(nome);
				
			}
		});
		
		JButton buttonEditarLogin = new JButton("Editar");
		buttonEditarLogin.setBounds(973, 174, 80, 29);
		buttonEditarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String login = JOptionPane.showInputDialog("novo login");
				admProvisorio.setLogin(login);
				carregarLogin.setText(login);
			}
		});
		
		JButton buttonEditarSenha = new JButton("Editar");
		buttonEditarSenha.setBounds(973, 223, 80, 29);
		buttonEditarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int senha = Integer.parseInt(JOptionPane.showInputDialog("nova senha"));
				admProvisorio.setSenha(senha);
				carregarSenha.setText(String.valueOf(senha));
			}
		});
		
		JLabel carregarCPF = new JLabel(adm.getCpf());
		carregarCPF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		carregarCPF.setBounds(432, 264, 522, 19);
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
		
		JLabel lblImagemadm = new JLabel("");
		lblImagemadm.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\user1.png"));
		lblImagemadm.setBounds(48, 36, 266, 318);
		contentPane.add(lblImagemadm);
		
		JLabel planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}

	public void carregarCaracteristicas(){
		
		carregarID = new JLabel(""+admProvisorio.getId());
		carregarID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		carregarID.setBounds(431, 91, 522, 19);
		
		carregarNome = new JLabel(admProvisorio.getNome());
		carregarNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		carregarNome.setBounds(431, 127, 522, 29);
		
		carregarLogin = new JLabel(admProvisorio.getLogin());
		carregarLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		carregarLogin.setBounds(431, 173, 522, 23);
		
		carregarSenha = new JLabel(String.valueOf(admProvisorio.getSenha()));
		carregarSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		carregarSenha.setBounds(431, 225, 522, 16);
	}
}
