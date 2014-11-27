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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCarregar = new JButton("Carregar Reserva");
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
		
		JButton btnCriarReserva = new JButton("Criar Reserva");
		btnCriarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new CadastrarReserva(administrador).setVisible(true);
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Login().setVisible(true);
				
			}
		});
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new EditarAdministrador(administrador).setVisible(true);
			}
		});
		
		carregarTabela();
		
		table = new JTable(listaReservaTabela,colunas);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		
		JButton buttonExcluirReserva = new JButton("Excluir");
		buttonExcluirReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluirReserva();
				dispose();
				new MenuPrincipal(administrador).setVisible(true);;
			}
		});
		
		JLabel lblNewLabel = new JLabel("Bem vindo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel labelBemVindo = new JLabel(administrador.getNome());
		labelBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnPerfil)
						.addComponent(btnCriarReserva, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(buttonExcluirReserva, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(labelBemVindo)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSair))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(212, Short.MAX_VALUE)
					.addComponent(btnCarregar)
					.addGap(93))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnPerfil))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addComponent(btnCriarReserva)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(buttonExcluirReserva)
							.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addComponent(btnCarregar))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(labelBemVindo))
					.addContainerGap(221, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
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
