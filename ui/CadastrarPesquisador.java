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
import java.awt.Font;
import javax.swing.ImageIcon;

public class CadastrarPesquisador extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoCpf;
	private JTextField campoIdade;
	private JTextField campoProfissao;
	private JButton btnCadastrar;
	private Reserva reservaProvisoria = null;
	private JLabel planoDeFundo;

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
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(22, 25, 75, 26);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpf.setBounds(22, 66, 53, 27);
		contentPane.add(lblCpf);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdade.setBounds(22, 104, 75, 26);
		contentPane.add(lblIdade);
		
		JLabel lblProfisso = new JLabel("Profiss\u00E3o:");
		lblProfisso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProfisso.setBounds(22, 145, 97, 22);
		contentPane.add(lblProfisso);
		
		campoNome = new JTextField();
		campoNome.setBounds(149, 28, 337, 28);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		campoCpf = new JTextField();
		campoCpf.setBounds(149, 69, 134, 28);
		contentPane.add(campoCpf);
		campoCpf.setColumns(10);
		
		campoIdade = new JTextField();
		campoIdade.setBounds(149, 107, 75, 28);
		contentPane.add(campoIdade);
		campoIdade.setColumns(10);
		
		campoProfissao = new JTextField();
		campoProfissao.setBounds(149, 146, 337, 28);
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
		btnCadastrar.setBounds(916, 634, 148, 29);
		contentPane.add(btnCadastrar);
		
		planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}
}
