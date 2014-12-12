package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.fafica.projeto_pi.excecoes.PesquisadorNaoEncontradoException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Font;

public class EditarPesquisador extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private Pesquisador pesquisadorTemporario;
	private JLabel labelCarregarId;
	private JLabel labelCarregarNome;
	private JLabel labelCarregarCPF;
	private JLabel labelCarregarIdade;
	private JLabel labelCarregarProfissao;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarPesquisador frame = new EditarPesquisador(null, null);
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
	public EditarPesquisador(Pesquisador pesquisador, Reserva reserva) {
		pesquisadorTemporario = pesquisador;
		reservaProvisoria = reserva;
		setTitle("Editar Pesquisador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCPF.setBounds(377, 70, 46, 22);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNome.setBounds(377, 103, 65, 23);
		
		JLabel labelProfisso = new JLabel("Profiss\u00E3o:");
		labelProfisso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelProfisso.setBounds(377, 163, 95, 29);
		
		JLabel labelIdade = new JLabel("Idade:");
		labelIdade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelIdade.setBounds(377, 130, 65, 33);
		
		JLabel labelID = new JLabel("ID:");
		labelID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelID.setBounds(377, 43, 33, 22);
		
		carregarCaracteristicas();
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(978, 651, 86, 29);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						
						Fachada.getInstace().editarPesquisador(pesquisadorTemporario);
						dispose();
						new MenuPesquisador(reservaProvisoria).setVisible(true);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (PesquisadorNaoEncontradoException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					

			}
		});
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.setBounds(963, 97, 89, 29);
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("novo nome");
				pesquisadorTemporario.setNome(nome);
				labelCarregarNome.setText(pesquisadorTemporario.getNome());
			}
		});
		
		JButton buttonEditarIdade = new JButton("Editar");
		buttonEditarIdade.setBounds(963, 134, 89, 29);
		buttonEditarIdade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idade = Integer.parseInt(JOptionPane.showInputDialog("nova idade"));
				pesquisadorTemporario.setIdade(idade);
				labelCarregarIdade.setText(""+pesquisadorTemporario.getIdade());
			}
		});
		
		JButton buttonProfissao = new JButton("Editar");
		buttonProfissao.setBounds(963, 167, 89, 29);
		buttonProfissao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String profissao = JOptionPane.showInputDialog("nova profissoa");
				pesquisadorTemporario.setProfissao(profissao);
				labelCarregarProfissao.setText(pesquisadorTemporario.getProfissao());
			}
		});
		contentPane.setLayout(null);
		contentPane.add(labelID);
		contentPane.add(labelCarregarId);
		contentPane.add(labelIdade);
		contentPane.add(labelCarregarIdade);
		contentPane.add(buttonEditarIdade);
		contentPane.add(btnAlterar);
		contentPane.add(labelCPF);
		contentPane.add(labelCarregarCPF);
		contentPane.add(labelNome);
		contentPane.add(labelCarregarNome);
		contentPane.add(labelProfisso);
		contentPane.add(labelCarregarProfissao);
		contentPane.add(buttonProfissao);
		contentPane.add(buttonEditarNome);
		
		JLabel planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}

	public void carregarCaracteristicas(){
		
		
		labelCarregarId = new JLabel(""+ pesquisadorTemporario.getIdPesquisador());
		labelCarregarId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarId.setBounds(478, 43, 446, 18);
		
		labelCarregarNome = new JLabel(pesquisadorTemporario.getNome());
		labelCarregarNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarNome.setBounds(478, 101, 446, 26);
		
		labelCarregarCPF = new JLabel(""+pesquisadorTemporario.getCpf());
		labelCarregarCPF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarCPF.setBounds(478, 70, 446, 22);
		
		labelCarregarIdade = new JLabel(""+pesquisadorTemporario.getIdade());
		labelCarregarIdade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarIdade.setBounds(478, 134, 73, 24);
		
		labelCarregarProfissao = new JLabel(pesquisadorTemporario.getProfissao());
		labelCarregarProfissao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarProfissao.setBounds(478, 163, 446, 29);
	}
}
