package devoxx.lab.hexagonalarchitecture.courtage.application.quarkus.adapters;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.math.BigDecimal;

import static java.util.Optional.ofNullable;

@RegisterRestClient(configKey = "bourse-api")
public interface BourseClientApi {
	@GET
	@Path("/cotations/{action}")
	public String recupererCoursAsString(@PathParam("action") String action);
}
