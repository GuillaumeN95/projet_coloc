package dao;

import java.util.List;

import model.Message;

public interface IDAOMessage extends IDAO<Message,Integer>{

	public List<Message> findAllByIdDestinataire(int idDestinataire);
	public List<Message> findAllByIdEmetteur(int idEmetteur);
}
