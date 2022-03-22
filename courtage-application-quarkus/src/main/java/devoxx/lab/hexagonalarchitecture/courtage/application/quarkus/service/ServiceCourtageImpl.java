package devoxx.lab.hexagonalarchitecture.courtage.application.quarkus.service;

import devoxx.lab.hexagonalarchitecture.courtage.domain.port.primaire.Courtage;
import devoxx.lab.hexagonalarchitecture.courtage.domain.port.secondaire.PortefeuilleRepository;
import devoxx.lab.hexagonalarchitecture.courtage.domain.port.secondaire.ServiceBourse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ServiceCourtageImpl extends Courtage {
	@Inject
	public ServiceCourtageImpl(PortefeuilleRepository portefeuilleRepository, ServiceBourse serviceBourse) {
		super(portefeuilleRepository, serviceBourse);
	}
}
