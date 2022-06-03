package com.ayush.specialization;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.ayush.entity.Specialization;
import com.ayush.repo.SpecializationRepo;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SpecializationRepositoryTest {
	
	@Autowired
	private SpecializationRepo repo;
	
	/**
	 * Test save operation
	 */
	@Test
	@Order(1)
	public void testSpecCreate() {
		Specialization spec=new Specialization(null,"CRDLS","Cardiologist", "Related To Heart");
		spec= repo.save(spec);
		assertNotNull(spec.getId() , "Spec is Not Created");
	}
	
	/**
	 * Test Display all operation
	 */
	@Test
	@Order(2)
	public void testSpecFetchAll() {
		List list= repo.findAll();
		assertNotNull(list);
		assertThat(list.size()>0);
	}
	
}
