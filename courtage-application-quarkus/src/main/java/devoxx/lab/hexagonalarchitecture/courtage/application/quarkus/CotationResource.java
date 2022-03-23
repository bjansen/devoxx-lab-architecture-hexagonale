package devoxx.lab.hexagonalarchitecture.courtage.application.quarkus;

import devoxx.lab.hexagonalarchitecture.courtage.application.quarkus.adapters.rest.BourseClientApi;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/cotation")
public class CotationResource {
	@Inject
	@RestClient
	BourseClientApi bourseClientApi;

	@GET
	@Path("{action}")
	public String getCours(@PathParam("action") String action) {
		return bourseClientApi.recupererCoursAsString(action);
	}
}
