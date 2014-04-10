package desenv.modelo.persistencia;

import java.io.File;

import desenv.modelo.auxiliar.GenericDAO;
import desenv.modelo.auxiliar.IGenericDAO;
import desenv.modelo.entidade.Galeria;
import desenv.util.Contexto;

public class GaleriaDAO extends GenericDAO<Galeria> implements
		IGenericDAO<Galeria> {

	private static final long serialVersionUID = 1L;

	private static StringBuffer diretorioGaleria;

	public GaleriaDAO() {
		super(Galeria.class);
	}

	@Override
	public void save(Galeria entity) {

		super.save(entity);
		criarVerificarDiretorio(entity);
	}

	public static void criarVerificarDiretorio(Galeria objeto) {
		
		diretorioGaleria = new StringBuffer();
		diretorioGaleria
				.append(new ParametroDAO().getBuscaPorParametro("fotos"))
				.append("/").append(objeto.getId());
		
		
		File file = new File(Contexto.gerURL(diretorioGaleria.toString()));
		if (!file.exists()) {
			file.mkdirs();
		}

	}
public static void main(String[] args) {
	Galeria o = new Galeria();
	o.setId(1l);
	criarVerificarDiretorio(o);
}
}
