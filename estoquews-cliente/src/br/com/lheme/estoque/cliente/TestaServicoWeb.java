package br.com.lheme.estoque.cliente;

public class TestaServicoWeb {

	public static void main(String[] args) {
		
		EstoqueWS cliente = new EstoqueWS_Service().getEstoqueWSImplPort();
		
		Filtros filtros = new Filtros();
		
		Filtro filtro = new Filtro();
		filtro.setNome("Iphone");
		filtro.setTipo(TipoItem.CELULAR.toString());
		
		filtros.getFiltro().add(filtro);
		
		ListaItens itens = cliente.todosOsItens(filtros);
		
		itens.getItem().forEach(i -> System.out.println(i.getNome()));
	}
}
