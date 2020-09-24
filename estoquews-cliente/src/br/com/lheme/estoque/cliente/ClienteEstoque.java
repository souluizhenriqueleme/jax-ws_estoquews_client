package br.com.lheme.estoque.cliente;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ClienteEstoque {

	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://localhost:8080/estoquews-web/EstoqueWS?wsdl");
		
		QName qName = new QName("http://ws.estoque.lheme.com.br/", "EstoqueWS");
		
		Service service = Service.create(url, qName);
		
		EstoqueWS cliente = service.getPort(EstoqueWS.class);
		
		Filtro filtro = new Filtro();
		filtro.setNome("IPhone");
		filtro.setTipo(TipoItem.CELULAR.toString());
		
		Filtros filtros = new Filtros();
		filtros.getFiltro().add(filtro);
		
		ListaItens listaItens = cliente.todosOsItens(filtros);
		
		listaItens.getItem().forEach(i -> System.out.println(i.getNome()));
		
	}
}
