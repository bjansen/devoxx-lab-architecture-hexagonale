package devoxx.lab.hexagonalarchitecture.courtage.application.quarkus.service;

import devoxx.lab.hexagonalarchitecture.courtage.application.quarkus.adapters.persistence.PortefeuilleRepositoryJpaImpl;
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
	private PortefeuilleRepositoryJpaImpl portefeuilleRepository;
	@Inject
	private ServiceBourseHttpAdapter serviceBourse;
	private Courtage impl = null;

	public ServiceCourtageFactory() {
	}

	public ServiceCourtage get() {
		if (impl == null) {
			impl = new Courtage(portefeuilleRepository, serviceBourse);
		}
		return impl;
	}
}
