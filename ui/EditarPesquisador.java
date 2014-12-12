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
		setBounds(100, 100, 316, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setBounds(45, 45, 27, 16);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(26, 72, 46, 16);
		
		JLabel labelProfisso = new JLabel("Profissão:");
		labelProfisso.setBounds(10, 138, 62, 16);
		
		JLabel labelIdade = new JLabel("Idade:");
		labelIdade.setBounds(34, 105, 38, 16);
		
		JLabel labelID = new JLabel("ID");
		labelID.setBounds(53, 18, 19, 16);
		
		carregarCaracteristicas();
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(216, 183, 86, 29);
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
		buttonEditarNome.setBounds(213, 72, 89, 29);
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("novo nome");
				pesquisadorTemporario.setNome(nome);
				labelCarregarNome.setText(pesquisadorTemporario.getNome());
			}
		});
		
		JButton buttonEditarIdade = new JButton("Editar");
		buttonEditarIdade.setBounds(213, 109, 89, 29);
		buttonEditarIdade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idade = Integer.parseInt(JOptionPane.showInputDialog("nova idade"));
				pesquisadorTemporario.setIdade(idade);
				labelCarregarIdade.setText(""+pesquisadorTemporario.getIdade());
			}
		});
		
		JButton buttonProfissao = new JButton("Editar");
		buttonProfissao.setBounds(213, 142, 89, 29);
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
	}

	public void carregarCaracteristicas(){
		
		
		labelCarregarId = new JLabel(""+ pesquisadorTemporario.getIdPesquisador());
		labelCarregarId.setBounds(80, 19, 46, 14);
		
		labelCarregarNome = new JLabel(pesquisadorTemporario.getNome());
		labelCarregarNome.setBounds(80, 73, 73, 14);
		
		labelCarregarCPF = new JLabel(""+pesquisadorTemporario.getCpf());
		labelCarregarCPF.setBounds(80, 46, 73, 14);
		
		labelCarregarIdade = new JLabel(""+pesquisadorTemporario.getIdade());
		labelCarregarIdade.setBounds(80, 106, 46, 14);
		
		labelCarregarProfissao = new JLabel(pesquisadorTemporario.getProfissao());
		labelCarregarProfissao.setBounds(81, 139, 72, 14);
	}
}
