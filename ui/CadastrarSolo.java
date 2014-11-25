package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.fafica.projeto_pi.controladora.ControladoraReserva;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Reserva;
import com.fafica.projeto_pi.modelos.Solo;
import com.fafica.projeto_pi.repositorioBDR.RepositorioSoloBDR;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class CadastrarSolo extends JFrame {

	private JPanel contentPane;
	private JTextField btnTipo;
	private JTextField btnTamanho;
	private JTextField btnRecursos;
	private Reserva reservaProvisoria;
	private ArrayList<Solo> listaSolo = new ArrayList<Solo>();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarSolo frame = new CadastrarSolo(null);
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
	public CadastrarSolo(Reserva reserva) {
		reservaProvisoria = reserva;
		setTitle("Cadastrar Solo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setBounds(24, 75, 32, 16);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setBounds(263, 75, 62, 16);
		
		JLabel lblRecursos = new JLabel("Recursos:");
		lblRecursos.setBounds(5, 109, 61, 16);
		
		btnTipo = new JTextField();
		btnTipo.setBounds(66, 69, 187, 28);
		btnTipo.setColumns(10);
		
		btnTamanho = new JTextField();
		btnTamanho.setBounds(328, 69, 86, 28);
		btnTamanho.setColumns(10);
		
		btnRecursos = new JTextField();
		btnRecursos.setBounds(66, 103, 348, 28);
		btnRecursos.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(310, 221, 104, 29);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listaSolo.size() == 0){
					
				String tipo = btnTipo.getText();
				Double tamanho = Double.parseDouble(btnTamanho.getText());
				String recursos = btnRecursos.getText();
					
				Solo s = new Solo(tipo, tamanho, recursos);
				listaSolo.add(s);
				
				}
				
				reservaProvisoria.setSolos(listaSolo);
				dispose();
				new CadastrarNascente(reservaProvisoria).setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblRecursos);
		contentPane.add(lblNewLabel);
		contentPane.add(btnCadastrar);
		contentPane.add(btnTipo);
		contentPane.add(lblTamanho);
		contentPane.add(btnTamanho);
		contentPane.add(btnRecursos);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String tipo = btnTipo.getText();
				Double tamanho = Double.parseDouble(btnTamanho.getText());
				String recursos = btnRecursos.getText();
				
				Solo s = new Solo(tipo, tamanho, recursos);
				listaSolo.add(s);	
				
				btnTipo.setText("");
				btnTamanho.setText("");
				btnRecursos.setText("");
			}
		});
		btnNovo.setBounds(193, 224, 104, 29);
		contentPane.add(btnNovo);
	}
	
}
