package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;

import com.fafica.projeto_pi.excecoes.PesquisadorNaoEncontradoException;
import com.fafica.projeto_pi.excecoes.ReservaNaoEncontradaException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.Reserva;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTree;
import javax.swing.ImageIcon;

public class MenuPesquisador extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private JTable table;
	private String[][] listaPesquisadorTabela = new String[100][2];
	private String colunas []= {"ID", "Pesquisadores"};	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPesquisador frame = new MenuPesquisador(null);
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
	public MenuPesquisador(Reserva reserva) {
		setTitle("Menu Pesquisador");
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblPesquisador = new JLabel("Pesquisador");
		lblPesquisador.setBounds(10, 12, 128, 29);
		lblPesquisador.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(991, 657, 73, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
			}
		});
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconAdd.png"));
		btnAdd.setBounds(394, 57, 69, 53);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AddPesquisador(reservaProvisoria).setVisible(true);
			}
		});
		
		JButton btnPerfil = new JButton("");
		btnPerfil.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconEditar.png"));
		btnPerfil.setBounds(394, 185, 69, 53);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idPesquisador = Integer.parseInt(table.getValueAt(table.getSelectedColumn(), 0).toString());
				Pesquisador pesquisador = null;
				
				try {
					pesquisador = Fachada.getInstace().procurarPesquisador(idPesquisador);
					dispose();
					new EditarPesquisador(pesquisador, reservaProvisoria).setVisible(true);
					
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
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconRemover.png"));
		button.setBounds(394, 121, 69, 53);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluirPesquisador();
				dispose();
				new MenuPesquisador(reservaProvisoria).setVisible(true);;
			}
		});
		
		
		carregarTabela();	
		
		table = new JTable(listaPesquisadorTabela,colunas);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(489, 54, 575, 525);
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(lblPesquisador);
		contentPane.add(btnVoltar);
		contentPane.add(btnAdd);
		contentPane.add(btnPerfil);
		contentPane.add(button);
		contentPane.add(scrollPane);
		
		JLabel planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}
	
	public void carregarTabela(){
		try {
			ArrayList<Pesquisador> listaPesquisador = Fachada.getInstace().listarPesquisador(reservaProvisoria.getIdReserva());
			listaPesquisadorTabela = new String[100][2];
			int contador =0;
			
			for (int i = 0; i < listaPesquisadorTabela.length; i++) {
				if(i < listaPesquisador.size()){
					System.out.println(reservaProvisoria.toString());
					System.out.println(listaPesquisador.toString());
					if(listaPesquisador.get(i).getReserva().getIdReserva() == reservaProvisoria.getIdReserva()){
				String id = String.valueOf(listaPesquisador.get(i).getIdPesquisador());
				String nome = listaPesquisador.get(i).getNome();
				listaPesquisadorTabela[contador][0] = id;
				listaPesquisadorTabela[contador][1] = nome;
				contador++;
					}
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ReservaNaoEncontradaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		
	}
	
	public void excluirPesquisador(){

		try {
			
			int idPesquisador = Integer.parseInt(table.getValueAt(table.getSelectedColumn(), 0).toString());
			Fachada.getInstace().removerPesquisador(idPesquisador);
			carregarTabela();
			table.updateUI();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PesquisadorNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
