package gr.manousos.extinguisher.repository;

import java.util.Calendar;

import gr.manousos.extinguisher.model.Extinguisher;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans-test-tx.xml" })
@Transactional
public class TestExtinguiesherPsRepository {
	private static final String SN = "YZT123";
	@Autowired
	private ExtinguiesherPsRepository repository;

	@Test
	public void testCreateSimpleExtinguisher() {
		Extinguisher entity = new Extinguisher();
		entity.setBottlePartNumber(SN);
		entity.setContentItem("contentItem");
		entity.setContentWeightVolume(5);
		entity.setIncrementNumber(1);
		entity.setManufacture("manufacture");
		entity.setYearBuild(Calendar.getInstance().get(Calendar.YEAR));
		Extinguisher saved = repository.save(entity);

		Assert.assertEquals(saved, repository.findOne(saved.getId()));
	}

	@Test
	public void getBySn() {
		Extinguisher ex = repository.findBybottlePartNumber(SN);
		Assert.assertNull(ex);
	}
}
