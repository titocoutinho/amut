package desenv.modelo.persistencia;

import java.util.HashMap;
import java.util.Map;

import desenv.modelo.auxiliar.GenericDAO;
import desenv.modelo.auxiliar.IGenericDAO;
import desenv.modelo.entidade.Municipio;

public class MunicipioDAO extends GenericDAO<Municipio> implements
		IGenericDAO<Municipio> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> parameters = new HashMap<String, Object>();

	public MunicipioDAO() {
		super(Municipio.class);
	}
	public Municipio pesquisaPorNome(String nome){
		parameters.clear();
		parameters.put("nomeMunicipio", nome+"%");
		return findOneResult(Municipio.MUNICIPIO_POR_NOME, parameters);
		//String consulta  
		
		//="SELECT o FROM Municipio o where translate(UPPER(o.nome),'аимсзюхлрыбйнтшцудкожэгяYщ','AEIOUAEIOUAEIOUAOAEIOUCNYY') like  '" + nome.toUpperCase() + "%'";
		
// select o From Municipio o where translate(UPPER(o.nome),'аимсзюхлрыбйнтшцудкожэгяYщ','AEIOUAEIOUAEIOUAOAEIOUCNYY') like ':nomeMunicipio'		
		//Query q = getEm().createQuery(consulta);
	}

}
