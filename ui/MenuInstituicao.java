package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fafica.projeto_pi.excecoes.InstituicacaoNaoEncontrada;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.Reserva;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.StreamCorruptedException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class MenuInstituicao extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private JTable table;
	private String []colunas ={"ID","nome"};
	private String[][] linhas = new String[100][2];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInstituicao frame = new MenuInstituicao(null);
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
	public MenuInstituicao(Reserva reserva) {
		setTitle("Menu Institui\u00E7\u00E3o");
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblPesquisado = new JLabel("Instituicao");
		lblPesquisado.setBounds(24, 21, 128, 29);
		lblPesquisado.setFont(new Font("Dialog", Font.BOLD, 22));
		
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconAdd.png"));
		button.setBounds(454, 41, 58, 50);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new CadastrarInstituicao(reservaProvisoria).setVisible(true);
			}
		});
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconRemover.png"));
		button_1.setBounds(454, 102, 58, 50);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int idInstituicao = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
					Instituicao instituicao = null;
					instituicao = Fachada.getInstace().procurarInstituicao(idInstituicao);
					
					dispose();
					new EditarInstituicao(instituicao,reservaProvisoria).setVisible(true);
				} catch (SQLException e1) {
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
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconPerfil.png"));
		button_2.setBounds(454, 163, 58, 50);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				dispose();
				new MenuInstituicao(reservaProvisoria);
			}
		});
		
		
		
		JButton button_3 = new JButton("Voltar");
		button_3.setBounds(978, 651, 73, 29);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
			}
		});
		
		carregarTabela();
		
		table = new JTable(linhas,colunas);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(525, 41, 525, 575);
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(lblPesquisado);
		contentPane.add(button);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(scrollPane);
		contentPane.add(button_3);
		
		JLabel planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	
	}
	
	public void carregarTabela(){
		try {
			linhas = new String [100][2];
			ArrayList<Instituicao> lista = Fachada.getInstace().listarInstituicao(reservaProvisoria.getIdReserva());
			int contador = 0;
			
			for (int i = 0; i < linhas.length; i++) {
				if(i < lista.size()){
					if(lista.get(i).getReserva().getIdReserva() == reservaProvisoria.getIdReserva()){
						String id = String.valueOf(lista.get(i).getIdInstituicao());
						String nome = lista.get(i).getNome();
						linhas[contador][0] = id;
						linhas[contador][1] = nome;
						contador++;
					}
				}
				
			} 
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluir(){

		int idInstituicao = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
		try {
			Fachada.getInstace().removerInsituicao(idInstituicao);
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
}
