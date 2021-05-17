package rs.gaiastudio.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.gaiastudio.model.Candle;

public interface CandleRepository extends JpaRepository<Candle, Long>{
	
	List<Candle> findByType(String type);
	
	
}
