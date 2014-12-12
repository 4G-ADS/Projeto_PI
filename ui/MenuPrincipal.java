package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.fafica.projeto_pi.excecoes.PesquisadorNaoEncontradoException;
import com.fafica.projeto_pi.excecoes.ReservaNaoEncontradaException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Administrador;
import com.fafica.projeto_pi.modelos.Instituicao;
import com.fafica.projeto_pi.modelos.NascenteAgua;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.ImageIcon;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Administrador administrador;
	private String colunas []= {"ID", "Reservas"};
	private String[][] listaReservaTabela = new String[100][2];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal(null);
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
	public MenuPrincipal(Administrador adm) {
		setTitle("Menu Principal");
		administrador = adm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JButton btnCarregar = new JButton("Carregar Reserva");
		btnCarregar.setBounds(915, 651, 149, 29);
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int id = Integer.parseInt((table.getValueAt(table.getSelectedRow(), 0).toString()));
					
					System.out.println(id);	
					Reserva reservaProvisoria = Fachada.getInstace().procurarReserva(id);
					
					dispose();
					new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ReservaNaoEncontradaException e1) {
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
		
		JButton btnCriarReserva = new JButton("");
		btnCriarReserva.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconAdd.png"));
		btnCriarReserva.setBounds(455, 68, 63, 40);
		btnCriarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new CadastrarReserva(administrador).setVisible(true);
			}
		});
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconSair.png"));
		btnSair.setBounds(981, 8, 74, 49);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Login().setVisible(true);
				
			}
		});
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(10, 8, 118, 29);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new EditarAdministrador(administrador).setVisible(true);
			}
		});
		
		carregarTabela();
		
		table = new JTable(listaReservaTabela,colunas);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(539, 68, 525, 575);
		scrollPane.setViewportView(table);
		
		JButton buttonExcluirReserva = new JButton("");
		buttonExcluirReserva.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconRemover.png"));
		buttonExcluirReserva.setBounds(455, 119, 63, 39);
		buttonExcluirReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluirReserva();
				dispose();
				new MenuPrincipal(administrador).setVisible(true);;
			}
		});
		
		JLabel lblNewLabel = new JLabel("Bem vindo:");
		lblNewLabel.setBounds(180, 11, 74, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel labelBemVindo = new JLabel(administrador.getNome());
		labelBemVindo.setBounds(272, 11, 284, 19);
		labelBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.setLayout(null);
		contentPane.add(btnPerfil);
		contentPane.add(btnCriarReserva);
		contentPane.add(buttonExcluirReserva);
		contentPane.add(lblNewLabel);
		contentPane.add(labelBemVindo);
		contentPane.add(btnSair);
		contentPane.add(scrollPane);
		contentPane.add(btnCarregar);
		
		JLabel planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 720);
		contentPane.add(planoDeFundo);
	}
	
	
	public void carregarTabela(){
		
		try {
			ArrayList<Reserva> listaReserva = Fachada.getInstace().listarReserva();
			for (int i = 0; i < listaReservaTabela.length; i++) {
				if(i < listaReserva.size()){
					if(administrador.getId() == listaReserva.get(i).getIdAdm()){
				String id = String.valueOf(listaReserva.get(i).getIdReserva());
				String nome = listaReserva.get(i).getNome();
				listaReservaTabela[i][0] = id;
				listaReservaTabela[i][1] = nome;
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
	
	
	public void excluirReserva(){	
		try {
			int idReserva = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
			
			ArrayList<Pesquisador> listaPesquisador = Fachada.getInstace().listarPesquisador(idReserva);
			ArrayList<Solo> listaSolo = Fachada.getInstace().listarSolo(idReserva);
			ArrayList<NascenteAgua> listaAgua = Fachada.getInstace().listarNascente(idReserva);
			ArrayList<PlantaPequenoPorte> listaPlantaPequena = Fachada.getInstace().listarPlantaPequena(idReserva);
			ArrayList<PlantaMedioPorte> listaPlantaMedio = Fachada.getInstace().listarPlantaMedia(idReserva);
			ArrayList<PlantaGrandePorte> listaPlantaGrande = Fachada.getInstace().listarPlantaGrande(idReserva);
			ArrayList<Instituicao> listaInstituicao = Fachada.getInstace().listarInstituicao(idReserva);
			
			for (Instituicao instituicao : listaInstituicao) {
				Fachada.getInstace().removerInsituicao(instituicao.getIdInstituicao());
			}
			for (Pesquisador pesquisador : listaPesquisador) {
				Fachada.getInstace().removerPesquisador(pesquisador.getIdPesquisador());
			}
			
			for (Solo solo : listaSolo) {
				Fachada.getInstace().removerSolo(solo.getIdSolo());
			}
			
			for (NascenteAgua nascenteAgua : listaAgua) {
				Fachada.getInstace().removerNascente(nascenteAgua.getIdAgua());
			}
			
			for (PlantaPequenoPorte plantaPequenoPorte : listaPlantaPequena) {
				Fachada.getInstace().removerPlantaPequenoPorte(plantaPequenoPorte.getIdPlantaPequenaPorte());
			}
			
			for (PlantaMedioPorte plantaMedioPorte : listaPlantaMedio) {
				Fachada.getInstace().removerPlantaMedioPorte(plantaMedioPorte.getIdPlantaMedioPorte());
			}
			
			for (PlantaGrandePorte plantaGrandePorte : listaPlantaGrande) {
				Fachada.getInstace().removerPlantaGrandePorte(plantaGrandePorte.getIdPantaGrandePorte());
			}
			
			Fachada.getInstace().removerReserva(idReserva);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReservaNaoEncontradaException e) {
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
