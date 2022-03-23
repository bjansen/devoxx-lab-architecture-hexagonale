package devoxx.lab.hexagonalarchitecture.courtage.application.quarkus.adapters.rest;

import devoxx.lab.hexagonalarchitecture.courtage.domain.port.secondaire.ServiceBourse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;

import static java.util.Optional.ofNullable;

@ApplicationScoped
public class ServiceBourseHttpAdapter implements ServiceBourse {
	@Inject
	@RestClient
	BourseClientApi bourseClientApi;

	@Override
	public BigDecimal recupererCours(String action) {
		return ofNullable(bourseClientApi.recupererCoursAsString(action))
			.map(BigDecimal::new)
			.orElseThrow();
	}
}
