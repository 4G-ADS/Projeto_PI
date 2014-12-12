package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.excecoes.IdadeInvalidoException;
import com.fafica.projeto_pi.excecoes.NascenteJaCadastradaException;
import com.fafica.projeto_pi.excecoes.PesquisadorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.PlantaJaCadastradaException;
import com.fafica.projeto_pi.excecoes.SoloJaCadastradoException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AddSolo extends JFrame {

	private JPanel contentPane;
	private Reserva reservaProvisoria;
	private JTextField campoTipo;
	private JTextField campoTamanho;
	private JTextField campoRecursos;
	private JLabel planoDeFundo;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSolo frame = new AddSolo(null);
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
	public AddSolo(Reserva reserva) {
		setTitle("Adicionar Solo");
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("Recursos:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(10, 111, 97, 22);
		
		JLabel label_1 = new JLabel("Tipo:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(10, 16, 81, 22);
		
		JButton buttonAdicionar = new JButton("Adicionar");
		buttonAdicionar.setBounds(960, 651, 104, 29);
		buttonAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					try {
						String tipo = campoTamanho.getText();
						String recursos = campoRecursos.getText();
						int tamanho = Integer.parseInt(campoTamanho.getText());
						
						Solo solo = new Solo(tipo, tamanho, recursos);
						solo.setReserva(reservaProvisoria);
						Fachada.getInstace().cadastrarSolo(solo);
						
						dispose();
						new MenuSolo(reservaProvisoria).setVisible(true);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch(Exception e2){
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					

					
			}
		});
		
		campoTipo = new JTextField();
		campoTipo.setBounds(138, 11, 187, 28);
		campoTipo.setColumns(10);
		
		JLabel label_2 = new JLabel("Tamanho:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(9, 60, 98, 26);
		
		campoTamanho = new JTextField();
		campoTamanho.setBounds(138, 63, 187, 28);
		campoTamanho.setColumns(10);
		
		campoRecursos = new JTextField();
		campoRecursos.setBounds(140, 105, 348, 28);
		campoRecursos.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(label_1);
		contentPane.add(campoTipo);
		contentPane.add(label_2);
		contentPane.add(campoTamanho);
		contentPane.add(label);
		contentPane.add(campoRecursos);
		contentPane.add(buttonAdicionar);
		
		planoDeFundo = new JLabel("New label");
		planoDeFundo.setIcon(new ImageIcon("C:\\Users\\paulo_000\\Desktop\\PI\\Projeto\\imgens\\planoDeFundo.png"));
		planoDeFundo.setBounds(0, 0, 1074, 691);
		contentPane.add(planoDeFundo);
	}
}
