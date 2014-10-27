package com.fafica.projeto_pi.repositorio.irepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import com.fafica.projeto_pi.modelos.ReservaCaracteristicas;
import com.fafica.projeto_pi.modelos.ReservaRecursos;

public interface IRepositorioReservaCaracteristicas {

	public void cadastrarReservaCaracteristicas(ReservaCaracteristicas reservaCaracteristicas) throws SQLException;
	public ReservaRecursos procurarReservaCaracteristicas(int idReserva);
	public ArrayList<ReservaCaracteristicas> listarReservaCaracteristicas() throws SQLException;
	public void editarReservaCaracteristicas(ReservaCaracteristicas reservaCaracteristicas);
	public void removerReservaCaracteristicas(int idReserva);
	public boolean existeReservaCaracteristicas(int idReserva);
}
