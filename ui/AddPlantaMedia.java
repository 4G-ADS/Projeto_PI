package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;

import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.excecoes.IdadeInvalidoException;
import com.fafica.projeto_pi.excecoes.NascenteJaCadastradaException;
import com.fafica.projeto_pi.excecoes.PesquisadorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.PlantaJaCadastradaException;
import com.fafica.projeto_pi.excecoes.SoloJaCadastradoException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.PlantaGrandePorte;
import com.fafica.projeto_pi.modelos.PlantaMedioPorte;
import com.fafica.projeto_pi.modelos.PlantaPequenoPorte;
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AddPlantaMedia extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoEspecie;
	private JTextField campoTamanho;
	private Reserva reservaProvisoria;
	private JLabel planoDeFundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPlantaPequena frame = new AddPlantaPequena(null);
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
	public AddPlantaMedia(Reserva reserva) {
		setTitle("Adicionar Planta Media");
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(43, 46, 59, 22);
		
		campoNome = new JTextField();
		campoNome.setBounds(122, 47, 305, 28);
		campoNome.setColumns(10);
		
		JLabel label_1 = new JLabel("Esp\u00E9cie:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(28, 85, 74, 22);
		
		campoEspecie = new JTextField();
		campoEspecie.setBounds(122, 86, 304, 28);
		campoEspecie.setColumns(10);
		
		JLabel label_2 = new JLabel("Tamanho:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(10, 121, 92, 28);
		
		campoTamanho = new JTextField();
		campoTamanho.setBounds(122, 125, 304, 28);
		campoTamanho.setColumns(10);
		
		JButton buttonAdicionar = new JButton("Adicionar");
		buttonAdicionar.setBounds(967, 651, 97, 29);
		buttonAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
						try {
							
							String nome = campoNome.getText();
							String especie = campoEspecie.getText();
							int tamanho = Integer.parseInt(campoTamanho.getText());				
								
								PlantaMedioPorte planataMedia = new PlantaMedioPorte(especie, nome, tamanho);
								planataMedia.setReserva(reservaProvisoria);
								System.out.println(planataMedia.getNome());
							Fachada.getInstace().cadastrarPlantaMedia(planataMedia);
							
							dispose();
							new MenuPlantaMedia(reservaProvisoria).setVisible(true);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}catch(Exception e2){
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

	
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(label_1);
		contentPane.add(campoEspecie);
		contentPane.add(label_2);
		contentPane.add(campoTamanho);
		contentPane.add(buttonAdicionar);
		contentPane.add(label);
		contentPane.add(campoNome);
		
		planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}
}
