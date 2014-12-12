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
		setBounds(100, 100, 321, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelID = new JLabel("ID:");
		labelID.setBounds(52, 23, 18, 16);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(29, 50, 41, 16);
		
		JLabel labelTipo = new JLabel("Tipo:");
		labelTipo.setBounds(38, 81, 32, 16);
		
		JLabel labelCnpj = new JLabel("CNPJ:");
		labelCnpj.setBounds(36, 118, 34, 16);
		
		carregarCaracteristicas();
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.setBounds(178, 41, 89, 29);
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("novo nome");
				instituicaoProvisoria.setNome(nome);
				labelCarregarNome.setText(instituicaoProvisoria.getNome());
			}
		});
		
		JButton buttonEditarTipo = new JButton("Editar");
		buttonEditarTipo.setBounds(178, 76, 89, 29);
		buttonEditarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = JOptionPane.showInputDialog("novo tipo");
				instituicaoProvisoria.setTipo(tipo);
				labelCarregarTipo.setText(tipo);
			}
		});
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(163, 152, 104, 29);
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
		contentPane.setLayout(null);
		contentPane.add(buttonVoltar);
		contentPane.add(labelID);
		contentPane.add(labelTipo);
		contentPane.add(labelCnpj);
		contentPane.add(labelNome);
		contentPane.add(labelCarregarCNPJ);
		contentPane.add(labelCarregarTipo);
		contentPane.add(labelCarregarNome);
		contentPane.add(buttonEditarNome);
		contentPane.add(buttonEditarTipo);
		contentPane.add(labelCarregarID);
	}
	
	public void carregarCaracteristicas(){
		
		labelCarregarNome = new JLabel(instituicaoProvisoria.getNome());
		labelCarregarNome.setBounds(82, 50, 96, 14);
		
		labelCarregarTipo = new JLabel(instituicaoProvisoria.getTipo());
		labelCarregarTipo.setBounds(82, 81, 96, 14);
		
		labelCarregarCNPJ = new JLabel(""+instituicaoProvisoria.getCnpj());
		labelCarregarCNPJ.setBounds(82, 118, 96, 14);

		labelCarregarID = new JLabel(""+instituicaoProvisoria.getIdInstituicao());
		labelCarregarID.setBounds(99, 23, 46, 16);
	}
}
