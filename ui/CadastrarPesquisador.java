package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastrarPesquisador extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoCpf;
	private JTextField campoIdade;
	private JTextField campoProfissao;
	private JButton btnCadastrar;
	private Reserva reservaProvisoria = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarPesquisador frame = new CadastrarPesquisador(null);
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
	public CadastrarPesquisador(Reserva reserva) {
		reservaProvisoria = reserva;
		setTitle("Cadastrar Pesquisador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(33, 30, 41, 16);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(46, 58, 27, 16);
		contentPane.add(lblCpf);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(304, 64, 41, 16);
		contentPane.add(lblIdade);
		
		JLabel lblProfisso = new JLabel("Profissão:");
		lblProfisso.setBounds(9, 102, 64, 16);
		contentPane.add(lblProfisso);
		
		campoNome = new JTextField();
		campoNome.setBounds(86, 24, 337, 28);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		campoCpf = new JTextField();
		campoCpf.setBounds(85, 58, 134, 28);
		contentPane.add(campoCpf);
		campoCpf.setColumns(10);
		
		campoIdade = new JTextField();
		campoIdade.setBounds(345, 58, 75, 28);
		contentPane.add(campoIdade);
		campoIdade.setColumns(10);
		
		campoProfissao = new JTextField();
		campoProfissao.setBounds(85, 102, 337, 28);
		contentPane.add(campoProfissao);
		campoProfissao.setColumns(10);
		
		btnCadastrar = new JButton("Proximo");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					try {
						String nome = campoNome.getText();
						String cpf = campoCpf.getText();
						int idade = Integer.parseInt(campoIdade.getText());
						String profissao = campoProfissao.getText();

						Pesquisador pesquisador  = new Pesquisador(nome, cpf, idade, profissao);
						pesquisador.setReserva(reservaProvisoria);
						System.out.println(pesquisador.toString());
						System.out.println(reservaProvisoria.toString());
						Fachada.getInstace().cadastrarPesquisador(pesquisador);
						dispose();
						
						new CadastrarSolo(reservaProvisoria).setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch(Exception e2){
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}


			}
		});
		btnCadastrar.setBounds(275, 132, 148, 29);
		contentPane.add(btnCadastrar);
	}
}
