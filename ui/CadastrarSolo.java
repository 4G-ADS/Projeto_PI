package com.fafica.projeto_pi.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import java.sql.SQLException;
import java.util.ArrayList;

public class CadastrarSolo extends JFrame {

	private JPanel contentPane;
	private JTextField btnTipo;
	private JTextField btnTamanho;
	private JTextField btnRecursos;
	private Reserva reservaProvisoria;

	
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
		setBounds(100, 100, 451, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setBounds(36, 31, 32, 16);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setBounds(275, 31, 62, 16);
		
		JLabel lblRecursos = new JLabel("Recursos:");
		lblRecursos.setBounds(17, 65, 61, 16);
		
		btnTipo = new JTextField();
		btnTipo.setBounds(78, 25, 187, 28);
		btnTipo.setColumns(10);
		
		btnTamanho = new JTextField();
		btnTamanho.setBounds(340, 25, 86, 28);
		btnTamanho.setColumns(10);
		
		btnRecursos = new JTextField();
		btnRecursos.setBounds(78, 59, 348, 28);
		btnRecursos.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(322, 98, 104, 29);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			try {
				String tipo = btnTipo.getText();
				Double tamanho = Double.parseDouble(btnTamanho.getText());
				String recursos = btnRecursos.getText();
				
				Solo solo = new Solo(tipo, tamanho, recursos);
				solo.setReserva(reservaProvisoria);
				Fachada.getInstace().cadastrarSolo(solo);
				dispose();
				new CadastrarNascente(reservaProvisoria).setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}catch(Exception e2){
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	
				
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
	}
	
}
