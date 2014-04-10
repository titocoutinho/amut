package desenv.controle.auxiliar;

import java.util.List;

public interface IGenericFacade<T> {

	public abstract void salvar(T entidade);

	public abstract void atualizar(T entidade);

	public abstract T procurar(Long entidadeID);


	public abstract List<T> listarTudo();

	public abstract void deletePerson(T entidade);
}