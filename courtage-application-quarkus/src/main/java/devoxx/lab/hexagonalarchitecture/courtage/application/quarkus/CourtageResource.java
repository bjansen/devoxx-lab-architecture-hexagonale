package devoxx.lab.hexagonalarchitecture.courtage.application.quarkus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static java.util.Optional.ofNullable;

@Path("/courtage")
public class CourtageResource {
	@GET
	@Path("/version")
	@Produces(MediaType.TEXT_PLAIN)
	public String version() {
		return ofNullable(CourtageResource.class.getPackage().getImplementationVersion())
			.orElse("DEV");
	}
}