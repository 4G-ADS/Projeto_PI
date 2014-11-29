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
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblPlanta = new JLabel("Planta Medio Porte");
		lblPlanta.setFont(new Font("Lucida Grande", Font.BOLD, 22));

		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPrincipalReserva(reservaProvisoria).setVisible(true);
			}
		});

		JButton button_1 = new JButton("Add");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new AddPlantaMedia(reservaProvisoria).setVisible(true);

			}
		});

		JButton button_2 = new JButton("Perfil");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 perfil();
			}
		});

		JButton button_3 = new JButton("Excluir");
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
		scrollPane.setViewportView(table);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(337)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
										.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
										.addComponent(button_3))
									.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPlanta)
									.addPreferredGap(ComponentPlacement.RELATED)))))
					.addGap(14))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblPlanta, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button_1)
							.addGap(21)
							.addComponent(button_2)
							.addGap(19)
							.addComponent(button_3)))
					.addGap(14)
					.addComponent(button))
		);
		contentPane.setLayout(gl_contentPane);
	}



	public void preenceherTabelaPlantasMedioPorte() {
		try {
			listaPlantaTabela = new String[100][2];
			ArrayList<PlantaMedioPorte> listaPlantaMedia = Fachada.getInstace()
					.listarPlantaMedia();
			int contador = 0;
			for (int i = 0; i < listaPlantaTabela.length; i++) {
				if (listaPlantaMedia.size() > i) {
					if (listaPlantaMedia.get(i).getIdReserva() == reservaProvisoria
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
