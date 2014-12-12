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
import javax.swing.ImageIcon;
import java.awt.Font;

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
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel labelID = new JLabel("ID:");
		labelID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelID.setBounds(466, 43, 46, 29);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNome.setBounds(466, 83, 65, 25);
		
		JLabel labelTipo = new JLabel("Tipo:");
		labelTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelTipo.setBounds(466, 119, 53, 29);
		
		JLabel labelCnpj = new JLabel("CNPJ:");
		labelCnpj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCnpj.setBounds(466, 159, 65, 29);
		
		carregarCaracteristicas();
		
		JButton buttonEditarNome = new JButton("Editar");
		buttonEditarNome.setBounds(975, 85, 89, 29);
		buttonEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = JOptionPane.showInputDialog("novo nome");
				instituicaoProvisoria.setNome(nome);
				labelCarregarNome.setText(instituicaoProvisoria.getNome());
			}
		});
		
		JButton buttonEditarTipo = new JButton("Editar");
		buttonEditarTipo.setBounds(975, 123, 89, 29);
		buttonEditarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = JOptionPane.showInputDialog("novo tipo");
				instituicaoProvisoria.setTipo(tipo);
				labelCarregarTipo.setText(tipo);
			}
		});
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.setBounds(960, 651, 104, 29);
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
		
		JLabel imgem = new JLabel("New label");
		imgem.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\User-icon.png"));
		imgem.setBounds(0, 21, 461, 512);
		contentPane.add(imgem);
		
		JLabel planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}
	
	public void carregarCaracteristicas(){
		
		labelCarregarNome = new JLabel(instituicaoProvisoria.getNome());
		labelCarregarNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarNome.setBounds(541, 88, 427, 20);
		
		labelCarregarTipo = new JLabel(instituicaoProvisoria.getTipo());
		labelCarregarTipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarTipo.setBounds(538, 126, 430, 22);
		
		labelCarregarCNPJ = new JLabel(""+instituicaoProvisoria.getCnpj());
		labelCarregarCNPJ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarCNPJ.setBounds(541, 166, 427, 22);

		labelCarregarID = new JLabel(""+instituicaoProvisoria.getIdInstituicao());
		labelCarregarID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCarregarID.setBounds(541, 46, 427, 23);
	}
}
