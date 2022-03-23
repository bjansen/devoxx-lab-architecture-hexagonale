package devoxx.lab.hexagonalarchitecture.courtage.application.quarkus;

import devoxx.lab.hexagonalarchitecture.courtage.application.quarkus.service.ServiceCourtageFactory;
import devoxx.lab.hexagonalarchitecture.courtage.domain.exception.PortefeuilleDejaExistantException;
import devoxx.lab.hexagonalarchitecture.courtage.domain.exception.PortefeuilleNonGereException;
import devoxx.lab.hexagonalarchitecture.courtage.domain.port.primaire.ServiceCourtage;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

import static java.util.Optional.ofNullable;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Path("/courtage")
public class CourtageResource {
	private final ServiceCourtage serviceCourtage;

	@Inject
	public CourtageResource(ServiceCourtageFactory serviceCourtageFactory) {
		this.serviceCourtage = serviceCourtageFactory.get();
	}

	@POST
	@Path("/portefeuilles/{nomPortefeuille}")
	public Response creationPortefeuille(
		@PathParam(value = "nomPortefeuille") String nomPortefeuille,
		@Context UriInfo uriInfo
	) {
		try {
			serviceCourtage.creerPortefeuille(nomPortefeuille);
		} catch (PortefeuilleDejaExistantException e) {
			return Response.status(BAD_REQUEST).entity("Portefeuille déjà géré").build();
		}
		URI uri = uriInfo.getAbsolutePathBuilder().build();
		return Response.created(uri).build();
	}

	@POST
	@Path("/portefeuilles/{nomPortefeuille}/actions")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response ajoutActionsDansPortefeuille(
		@PathParam(value = "nomPortefeuille") String nomPortefeuille,
		@QueryParam("action") String action,
		@QueryParam("nombre") int nombre
	) {
		try {
			serviceCourtage.ajouteAction(nombre, action, nomPortefeuille);
		} catch (PortefeuilleNonGereException e) {
			return Response.status(Response.Status.NOT_FOUND).entity("Portefeuille non géré").build();
		}
		return Response.ok().build();
	}

	@GET
	@Path("/portefeuilles/{nomPortefeuille}")
	public Response portefeuilleExiste(@PathParam(value = "nomPortefeuille") String nomPortefeuille) {
		if (serviceCourtage.gere(nomPortefeuille)) {
			return Response.ok().build();
		}
		throw new NotFoundException();
	}

	@GET
	@Path("/portefeuilles/{nomPortefeuille}/valorisation")
	public Response calculValorisationPortefeuille(@PathParam(value = "nomPortefeuille") String nomPortefeuille) {
		try {
			return Response.ok(serviceCourtage.calculerValeurPortefeuille(nomPortefeuille).toString()).build();
		} catch (PortefeuilleNonGereException e) {
			throw new NotFoundException();
		}
	}

	@GET
	@Path("/portefeuilles/avoirs")
	public Response valeurEnsemblePortefeuilles() {
		return Response.ok(serviceCourtage.calculerValeurEnsemblePortefeuilles().toString()).build();
	}

	@GET
	@Path("/version")
	@Produces(MediaType.TEXT_PLAIN)
	public String version() {
		return ofNullable(CourtageResource.class.getPackage().getImplementationVersion())
			.orElse("DEV");
	}
}
