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
import javax.swing.JButton;

import com.fafica.projeto_pi.excecoes.AdministradorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.CPFInvalidoException;
import com.fafica.projeto_pi.excecoes.CampoObritarorioInvalidoException;
import com.fafica.projeto_pi.excecoes.IdadeInvalidoException;
import com.fafica.projeto_pi.excecoes.NascenteJaCadastradaException;
import com.fafica.projeto_pi.excecoes.PesquisadorJaCadastradoException;
import com.fafica.projeto_pi.excecoes.PlantaJaCadastradaException;
import com.fafica.projeto_pi.excecoes.SoloJaCadastradoException;
import com.fafica.projeto_pi.fachada.Fachada;
import com.fafica.projeto_pi.modelos.Pesquisador;
import com.fafica.projeto_pi.modelos.Reserva;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class AddPesquisador extends JFrame {

	private JPanel contentPane;
	private JTextField campoCFP;
	private JTextField campoIdade;
	private JTextField campoProfissao;
	private JTextField campoNome;
	private Reserva reservaProvisoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPesquisador frame = new AddPesquisador(null);
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
	public AddPesquisador(Reserva reserva) {
		setTitle("Adicionar Pesquisador");
		reservaProvisoria = reserva;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("CPF:");
		label.setBounds(41, 69, 27, 16);
		
		JLabel label_3 = new JLabel("Nome:");
		label_3.setBounds(27, 18, 41, 16);
		
		JLabel label_1 = new JLabel("Idade:");
		label_1.setBounds(242, 63, 41, 16);
		
		JLabel label_2 = new JLabel("Profiss\u00E3o:");
		label_2.setBounds(6, 113, 62, 16);
		
		campoCFP = new JTextField();
		campoCFP.setBounds(74, 57, 134, 28);
		campoCFP.setColumns(10);
		
		campoIdade = new JTextField();
		campoIdade.setBounds(283, 57, 75, 28);
		campoIdade.setColumns(10);
		
		campoProfissao = new JTextField();
		campoProfissao.setBounds(74, 101, 284, 28);
		campoProfissao.setColumns(10);
		
		campoNome = new JTextField();
		campoNome.setBounds(74, 6, 284, 28);
		campoNome.setColumns(10);
		
		JButton buttonAdd = new JButton("Adicionar");
		buttonAdd.setBounds(238, 141, 120, 29);
		buttonAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {


					try {

						String nome = campoNome.getText();
						String profissao = campoProfissao.getText();
						int idade = Integer.parseInt(campoIdade.getText());
						String cpf = campoCFP.getText();
						
						
						Pesquisador pesquisador = new Pesquisador(nome, cpf, idade, profissao);
						pesquisador.setReserva(reservaProvisoria);
						Fachada.getInstace().cadastrarPesquisador(pesquisador);
						
						dispose();
						 new MenuPesquisador(reservaProvisoria);
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
		contentPane.add(label_3);
		contentPane.add(campoNome);
		contentPane.add(label);
		contentPane.add(campoCFP);
		contentPane.add(label_1);
		contentPane.add(campoIdade);
		contentPane.add(campoProfissao);
		contentPane.add(label_2);
		contentPane.add(buttonAdd);
	}

}
