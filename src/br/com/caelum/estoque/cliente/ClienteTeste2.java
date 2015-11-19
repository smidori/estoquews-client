package br.com.caelum.estoque.cliente;

import java.net.MalformedURLException;
import java.net.URL;


import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ClienteTeste2 {

	public static void main(String[] args) throws MalformedURLException {
		
		URL url = new URL("http://localhost:8080/estoquews-server/EstoqueWS?wsdl");
        //QName qname = new QName("http://ws.estoque.caelum.com.br/", "EstoqueWSService");
		QName qname = new QName("http://ws.estoque.caelum.com.br/", "EstoqueWS");

        Service service = Service.create(url, qname);

        EstoqueWS cliente = service.getPort(EstoqueWS.class);

        Filtros filtros = new Filtros();
        
        Filtro filtro = new Filtro();
        filtro.setNome("IPhone");
        filtro.setTipo(TipoItem.CELULAR);;

        //ListaItens lista = cliente.todosOsItens(Arrays.<Filtro>asList(filtro));
        filtros.getFiltro().add(filtro);
        ListaItens lista = cliente.todosOsItens(filtros);

        for (Item item : lista.item) {
            System.out.println(item.getNome());
        }
	}
}
