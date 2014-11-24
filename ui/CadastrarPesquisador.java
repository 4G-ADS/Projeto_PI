package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class CadastrarPesquisador extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoCpf;
	private JTextField campoIdade;
	private JTextField campoProfissao;
	private JButton btnCadastrar;
	private Reserva reservaProvisoria = null;
	private ArrayList <Pesquisador> listaPesquisador = new ArrayList<Pesquisador>(); 

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(22, 48, 41, 16);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(36, 79, 27, 16);
		contentPane.add(lblCpf);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(203, 79, 41, 16);
		contentPane.add(lblIdade);
		
		JLabel lblProfisso = new JLabel("Profissão:");
		lblProfisso.setBounds(6, 124, 67, 16);
		contentPane.add(lblProfisso);
		
		campoNome = new JTextField();
		campoNome.setBounds(67, 42, 358, 28);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		campoCpf = new JTextField();
		campoCpf.setBounds(67, 73, 134, 28);
		contentPane.add(campoCpf);
		campoCpf.setColumns(10);
		
		campoIdade = new JTextField();
		campoIdade.setBounds(251, 73, 60, 28);
		contentPane.add(campoIdade);
		campoIdade.setColumns(10);
		
		campoProfissao = new JTextField();
		campoProfissao.setBounds(69, 118, 222, 28);
		contentPane.add(campoProfissao);
		campoProfissao.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservaProvisoria.setPesquisadores(listaPesquisador);
				new CadastrarSolo(reservaProvisoria).setVisible(true);
			}
		});
		btnCadastrar.setBounds(316, 221, 97, 29);
		contentPane.add(btnCadastrar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = campoNome.getText();
				String cpf = campoCpf.getText();
				int idade = Integer.parseInt(campoIdade.getText());
				String profissao = campoProfissao.getText();
				
				Pesquisador p  = new Pesquisador(nome, cpf, idade, profissao);
				listaPesquisador.add(p);
			}
		});
		btnNovo.setBounds(214, 221, 97, 29);
		contentPane.add(btnNovo);
	}
}
