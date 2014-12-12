package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CadastrarInstituicao extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoTipo;
	private JTextField campoCNPJ;
	private Reserva reservaProvisoria;
	private JLabel planoDeFundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarInstituicao frame = new CadastrarInstituicao(null);
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
	public CadastrarInstituicao(Reserva reserva) {
		reservaProvisoria = reserva;
		setTitle("Cadastrar Instituição");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(17, 19, 68, 28);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipo.setBounds(17, 114, 46, 24);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCnpj.setBounds(17, 68, 56, 23);
		
		campoNome = new JTextField();
		campoNome.setBounds(83, 20, 567, 34);
		campoNome.setColumns(10);
		
		campoTipo = new JTextField();
		campoTipo.setBounds(83, 113, 567, 34);
		campoTipo.setColumns(10);
		
		campoCNPJ = new JTextField();
		campoCNPJ.setBounds(83, 66, 567, 34);
		campoCNPJ.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(983, 657, 81, 23);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				try {
					
					
					String nome = campoNome.getText();
					String tipo = campoTipo.getText();
					String cnpj = campoCNPJ.getText();
					if(!nome.equals("") && !tipo.equals("") && !cnpj.equals("")){
					Instituicao instituicao = new Instituicao(nome, tipo, cnpj);
					instituicao.setReserva(reservaProvisoria);
					Fachada.getInstace().cadastrarInstituicao(instituicao);
					dispose();
					new MenuInstituicao(reservaProvisoria).setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "Preencher todos os campos");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CampoObritarorioInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (CPFInvalidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AdministradorJaCadastradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnCadastrar);
		contentPane.add(lblNome);
		contentPane.add(lblTipo);
		contentPane.add(campoTipo);
		contentPane.add(lblCnpj);
		contentPane.add(campoCNPJ);
		contentPane.add(campoNome);
		
		planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}

}
