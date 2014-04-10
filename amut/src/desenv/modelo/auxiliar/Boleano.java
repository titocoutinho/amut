package desenv.modelo.auxiliar;

public enum Boleano {
	SIM(0), NAO(1);
	
	Integer valor;
	
	Boleano(Integer valor){
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
}
