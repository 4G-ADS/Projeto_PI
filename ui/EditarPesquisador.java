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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelCPF = new JLabel("CPF:");
		
		JLabel labelNome = new JLabel("Nome:");
		
		JLabel labelProfisso = new JLabel("Profissão");
		
		JLabel labelIdade = new JLabel("Idade:");
		
		JLabel labelID = new JLabel("ID");
		
		carregarCaracteristicas();
		
		JButton btnAlterar = new JButton("Alterar");
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
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("novo nome");
				pesquisadorTemporario.setNome(nome);
				labelCarregarNome.setText(pesquisadorTemporario.getNome());
			}
		});
		
		JButton buttonEditarIdade = new JButton("Editar");
		buttonEditarIdade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idade = Integer.parseInt(JOptionPane.showInputDialog("nova idade"));
				pesquisadorTemporario.setIdade(idade);
				labelCarregarIdade.setText(""+pesquisadorTemporario.getIdade());
			}
		});
		
		JButton buttonProfissao = new JButton("Editar");
		buttonProfissao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String profissao = JOptionPane.showInputDialog("nova profissoa");
				pesquisadorTemporario.setProfissao(profissao);
				labelCarregarProfissao.setText(pesquisadorTemporario.getProfissao());
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addComponent(labelID, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(labelCarregarId, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(labelIdade, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(labelCarregarIdade, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(66)
							.addComponent(buttonEditarIdade, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(334)
							.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(30)
									.addComponent(labelCPF, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(labelCarregarCPF, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(17)
									.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(labelCarregarNome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(labelProfisso, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(25)
									.addComponent(labelCarregarProfissao, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(48)
									.addComponent(buttonProfissao, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGap(48)
									.addComponent(buttonEditarNome, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(4, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelID)
						.addComponent(labelCarregarId, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelCPF, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelCarregarCPF, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelCarregarNome, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
						.addComponent(buttonEditarNome))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelIdade, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addComponent(labelCarregarIdade, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(buttonEditarIdade)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(labelProfisso, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(buttonProfissao)))
							.addGap(71)
							.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(labelCarregarProfissao, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void carregarCaracteristicas(){
		
		
		labelCarregarId = new JLabel(""+ pesquisadorTemporario.getIdPesquisador());
		
		labelCarregarNome = new JLabel(pesquisadorTemporario.getNome());
		
		labelCarregarCPF = new JLabel(""+pesquisadorTemporario.getCpf());
		
		labelCarregarIdade = new JLabel(""+pesquisadorTemporario.getIdade());
		
		labelCarregarProfissao = new JLabel(pesquisadorTemporario.getProfissao());
	}
}
