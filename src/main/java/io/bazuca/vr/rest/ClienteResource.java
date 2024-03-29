package io.bazuca.vr.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.bazuca.vr.dto.ClienteDTO;
import io.bazuca.vr.model.Cliente;
import io.bazuca.vr.service.ClienteService;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

	@Inject
	ClienteService clienteService;

	@POST
	public Response cria(Cliente cliente) {
		clienteService.cria(cliente);
		return Response.status(201).build();
	}

	@PUT
	@Path("{id}/primeiroacesso")
	public Response atualizaPriAcesso(@PathParam("id") Integer id, ClienteDTO clienteDTO) {
		clienteService.atualizaPriAcesso(id, clienteDTO.isPrimeiroAcesso());
		return Response.status(204).build();
	}

	@PUT
	@Path("{id}/cartaobloqueado")
	public Response atualizaBloqueio(@PathParam("id") Integer id, ClienteDTO clienteDTO) {
		clienteService.atualizaBloqueio(id, clienteDTO.isCartaoBloqueado());
		return Response.status(204).build();
	}

	@GET
	@Path("{id}")
	public Cliente porId(@PathParam("id") Integer id) {
		return clienteService.porId(id);
	}

	@DELETE
	@Path("{id}")
	public void remove(@PathParam("id") Integer id) {
		Cliente cliente = clienteService.porId(id);
		if (cliente == null) {
			throw new WebApplicationException(404);
		}
		clienteService.removePorId(id);
	}
}