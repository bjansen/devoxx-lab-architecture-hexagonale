package devoxx.lab.hexagonalarchitecture.courtage.application.quarkus.service;

import devoxx.lab.hexagonalarchitecture.courtage.application.quarkus.adapters.persistence.PortefeuilleRepositorySpringDataImpl;
import devoxx.lab.hexagonalarchitecture.courtage.application.quarkus.adapters.rest.ServiceBourseHttpAdapter;
import devoxx.lab.hexagonalarchitecture.courtage.domain.port.primaire.Courtage;
import devoxx.lab.hexagonalarchitecture.courtage.domain.port.primaire.ServiceCourtage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Il n'y a pour le moment pas d'équivalent à
 * <code>org.springframework.context.annotation.ComponentScan</code>.
 * L'injection se fait donc "à la main".
 */
@ApplicationScoped
public class ServiceCourtageFactory {

	@Inject
	private PortefeuilleRepositorySpringDataImpl portefeuilleRepository;
	@Inject
	private ServiceBourseHttpAdapter serviceBourse;

	public ServiceCourtageFactory() {
	}

	public ServiceCourtage get() {
		return new Courtage(portefeuilleRepository, serviceBourse);
	}
}
