package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import com.fafica.projeto_pi.excecoes.PlantaNaoEncontradaException;
import com.fafica.projeto_pi.excecoes.ReservaNaoEncontradaException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class MenuPlantaMedia extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private JTable table;
	private String[][] listaPlantaTabela = new String[100][2];
	private String colunas[] = { "ID", "Plantas" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPlantaMedia frame = new MenuPlantaMedia(null);
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
	public MenuPlantaMedia(Reserva reserva) {
		setTitle("Menu Planta Media");
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);

		JLabel lblPlanta = new JLabel("Planta Medio Porte");
		lblPlanta.setBounds(10, 11, 211, 27);
		lblPlanta.setFont(new Font("Lucida Grande", Font.BOLD, 22));

		JButton button = new JButton("Voltar");
		button.setBounds(981, 623, 73, 29);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
			}
		});

		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconAdd.png"));
		button_1.setBounds(390, 83, 63, 44);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AddPlantaMedia(reservaProvisoria).setVisible(true);

			}
		});

		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconEditar.png"));
		button_2.setBounds(390, 193, 63, 44);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 perfil();
			}
		});

		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\iconRemover.png"));
		button_3.setBounds(392, 138, 61, 44);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				excluirPlanta();
				dispose();
				new MenuPlantaMedia(reservaProvisoria).setVisible(true);
				;
			}
		});

		preenceherTabelaPlantasMedioPorte();
		
		table = new JTable(listaPlantaTabela, colunas);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(479, 87, 575, 525);
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(button);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(button_3);
		contentPane.add(scrollPane);
		contentPane.add(lblPlanta);
		
		JLabel planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}



	public void preenceherTabelaPlantasMedioPorte() {
		try {
			listaPlantaTabela = new String[100][2];
			ArrayList<PlantaMedioPorte> listaPlantaMedia = Fachada.getInstace()
					.listarPlantaMedia(reservaProvisoria.getIdReserva());
			int contador = 0;
			for (int i = 0; i < listaPlantaTabela.length; i++) {
				if (listaPlantaMedia.size() > i) {
					if (listaPlantaMedia.get(i).getReserva().getIdReserva() == reservaProvisoria
							.getIdReserva()) {
						String id = String.valueOf(listaPlantaMedia.get(i)
								.getIdPlantaMedioPorte());
						String nome = listaPlantaMedia.get(i).getNome();

						listaPlantaTabela[contador][0] = id;
						listaPlantaTabela[contador][1] = nome;
						contador++;
					}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void excluirPlanta() {

		try {
			int idPlanta = Integer.parseInt(table.getValueAt(
					table.getSelectedRow(), 0).toString());
	
				Fachada.getInstace().removerPlantaMedioPorte(idPlanta);
				preenceherTabelaPlantasMedioPorte();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PlantaNaoEncontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void perfil(){

		try {
			int idPlanta = Integer.parseInt(table.getValueAt(table.getSelectedColumn(), 0).toString());
			ArrayList<PlantaMedioPorte> listaPlantaMedia = Fachada.getInstace().listarPlantaMedia();
			
			for (PlantaMedioPorte plantaMedioPorte : listaPlantaMedia) {
				if(idPlanta == plantaMedioPorte.getIdPlantaMedioPorte()){
					JOptionPane.showMessageDialog(null, "ID: " + plantaMedioPorte.getIdPlantaMedioPorte() + "\n" +
														 "Nome: " + plantaMedioPorte.getNome() + "\n" +
														 "Especie: " + plantaMedioPorte.getEspecie() + "\n" +
														 "Tamanho: " + plantaMedioPorte.getTamanho());
					break;
				}
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
