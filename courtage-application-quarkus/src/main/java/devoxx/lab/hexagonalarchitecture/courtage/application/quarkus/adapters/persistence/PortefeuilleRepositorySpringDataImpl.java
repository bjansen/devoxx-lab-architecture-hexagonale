package devoxx.lab.hexagonalarchitecture.courtage.application.quarkus.adapters.persistence;

import devoxx.lab.hexagonalarchitecture.courtage.domain.model.Portefeuille;
import devoxx.lab.hexagonalarchitecture.courtage.domain.port.secondaire.PortefeuilleRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.stream.Stream;

@ApplicationScoped
public class PortefeuilleRepositorySpringDataImpl implements PortefeuilleRepository {
	private final EntityManager em;

	public PortefeuilleRepositorySpringDataImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public boolean existe(String nomPortefeuille) {
		try {
			em.getReference(Portefeuille.class, nomPortefeuille);
			return true;
		} catch (EntityNotFoundException e) {
			return false;
		}
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
