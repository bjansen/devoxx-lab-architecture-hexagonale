package devoxx.lab.hexagonalarchitecture.courtage.application.quarkus.adapters;

import devoxx.lab.hexagonalarchitecture.courtage.domain.model.Portefeuille;
import devoxx.lab.hexagonalarchitecture.courtage.domain.port.secondaire.PortefeuilleRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public class PortefeuilleRepositorySpringDataImpl implements PortefeuilleRepository {

	@Override
	public boolean existe(String nomPortefeuille) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sauvegarde(Portefeuille portefeuille) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Optional<Portefeuille> recupere(String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Stream<Portefeuille> recupereTous() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void purge() {
		throw new UnsupportedOperationException();
	}
}
