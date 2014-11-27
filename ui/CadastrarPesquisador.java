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
		lblNome.setBounds(10, 30, 41, 16);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 81, 27, 16);
		contentPane.add(lblCpf);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(221, 81, 41, 16);
		contentPane.add(lblIdade);
		
		JLabel lblProfisso = new JLabel("Profiss�o:");
		lblProfisso.setBounds(10, 125, 67, 16);
		contentPane.add(lblProfisso);
		
		campoNome = new JTextField();
		campoNome.setBounds(67, 24, 358, 28);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		campoCpf = new JTextField();
		campoCpf.setBounds(67, 75, 134, 28);
		contentPane.add(campoCpf);
		campoCpf.setColumns(10);
		
		campoIdade = new JTextField();
		campoIdade.setBounds(276, 75, 75, 28);
		contentPane.add(campoIdade);
		campoIdade.setColumns(10);
		
		campoProfissao = new JTextField();
		campoProfissao.setBounds(67, 119, 284, 28);
		contentPane.add(campoProfissao);
		campoProfissao.setColumns(10);
		
		btnCadastrar = new JButton("Finalizar cadastro");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(listaPesquisador.size() == 0){

					String nome = campoNome.getText();
					String cpf = campoCpf.getText();
					int idade = Integer.parseInt(campoIdade.getText());
					String profissao = campoProfissao.getText();
					
					Pesquisador p  = new Pesquisador(nome, cpf, idade, profissao);
					listaPesquisador.add(p);
				}
				
				dispose();
				reservaProvisoria.setPesquisadores(listaPesquisador);
				new CadastrarSolo(reservaProvisoria).setVisible(true);
			}
		});
		btnCadastrar.setBounds(305, 221, 120, 29);
		contentPane.add(btnCadastrar);
		
		JButton btnNovo = new JButton("Cadastrar");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = campoNome.getText();
				String cpf = campoCpf.getText();
				int idade = Integer.parseInt(campoIdade.getText());
				String profissao = campoProfissao.getText();
				
				Pesquisador p  = new Pesquisador(nome, cpf, idade, profissao);
				listaPesquisador.add(p);
				
				campoNome.setText("");
				campoCpf.setText("");
				campoIdade.setText("");
				campoProfissao.setText("");
				
			}
		});
		btnNovo.setBounds(198, 221, 97, 29);
		contentPane.add(btnNovo);
	}
}
