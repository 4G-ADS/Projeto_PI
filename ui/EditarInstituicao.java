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

import com.fafica.projeto_pi.excecoes.InstituicacaoNaoEncontrada;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class EditarInstituicao extends JFrame {

	private JPanel contentPane;
	private Instituicao instituicaoProvisoria;
	private Reserva reservaProvisoria;
	private JLabel labelCarregarNome;
	private JLabel labelCarregarTipo;
	private JLabel labelCarregarCNPJ;
	private JLabel labelCarregarID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarInstituicao frame = new EditarInstituicao(null,null);
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
	public EditarInstituicao(Instituicao instituicao,Reserva reserva) {
		instituicaoProvisoria = instituicao;
		reservaProvisoria = reserva;
		setTitle("Editar Institui\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelID = new JLabel("ID:");
		
		JLabel labelNome = new JLabel("Nome:");
		
		JLabel labelTipo = new JLabel("Tipo:");
		
		JLabel labelCnpj = new JLabel("CNPJ:");
		
		carregarCaracteristicas();
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("novo nome");
				instituicaoProvisoria.setNome(nome);
				labelCarregarNome.setText(instituicaoProvisoria.getNome());
			}
		});
		
		JButton buttonEditarTipo = new JButton("Editar");
		buttonEditarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = JOptionPane.showInputDialog("novo tipo");
				instituicaoProvisoria.setTipo(tipo);
				labelCarregarTipo.setText(tipo);
			}
		});
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
					try {
						Fachada.getInstace().editarInstituicao(instituicaoProvisoria);
						dispose();
						new MenuInstituicao(reservaProvisoria).setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstituicacaoNaoEncontrada e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(314)
							.addComponent(buttonVoltar, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(labelID, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelTipo)
								.addComponent(labelCnpj)
								.addComponent(labelNome))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(labelCarregarCNPJ)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(labelCarregarTipo, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
										.addComponent(labelCarregarNome, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(buttonEditarNome, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addComponent(buttonEditarTipo, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
									.addGap(164))
								.addComponent(labelCarregarID, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelID, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelCarregarID))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelCarregarNome, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
							.addGap(10))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(buttonEditarNome)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelTipo, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelCarregarTipo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonEditarTipo))
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelCnpj, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelCarregarCNPJ, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addGap(103)
					.addComponent(buttonVoltar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void carregarCaracteristicas(){
		
		labelCarregarNome = new JLabel(instituicaoProvisoria.getNome());
		
		labelCarregarTipo = new JLabel(instituicaoProvisoria.getTipo());
		
		labelCarregarCNPJ = new JLabel(""+instituicaoProvisoria.getCnpj());

		labelCarregarID = new JLabel(""+instituicaoProvisoria.getIdInstituicao());
	}
}
