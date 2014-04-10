package desenv.manager.auxiliar;

import javax.annotation.PostConstruct;

public interface IManagerBean {

	@PostConstruct
	public abstract void load();
	public abstract void novo();
	public abstract void pesquisar();
	public abstract void reset();
	abstract void carregarLista();
}
