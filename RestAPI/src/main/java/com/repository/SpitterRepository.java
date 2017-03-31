
package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.domain.Spitter;

public interface SpitterRepository extends JpaRepository<Spitter, Long>{
	public Spitter findByUsername(String username);
}
