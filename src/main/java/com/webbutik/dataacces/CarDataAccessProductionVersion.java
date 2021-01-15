package com.webbutik.dataacces;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.webbutik.domain.Car;
import com.webbutik.services.CarExist;
import com.webbutik.services.CarNotFound;

/**
 * 
 * @author danijela repository av tabell car implementation av interface
 *
 */
@Repository
public class CarDataAccessProductionVersion implements CarDataAccess {

	/**
	 * Anvanda HibernateTemplate class method att persist the objekt av Car klass
	 */
	@Autowired
	private HibernateTemplate template;
	
	// Dessa två metoder är DRY designmönster
	/**
	 * Hjälp metoden pga regNr
	 * @param regNr Registration nummer
	 * @return List av bilar pga registration nummer
	 */
	public List<Car> hamtaMedRegNr(String regNr){
		List<Car> results = template.execute(session -> {
			Query<Car> q = session.createQuery("from Car where regNr=:regNr");
			q.setParameter("regNr", regNr);
			return q.list();
		});
		return results;
	}
	
	/**
	 * Hjälp metoden pga id
	 * @param id Id av bi i tabell car
	 * @return List av bilar pga id av bil
	 */
	public List<Car> hamtaMedId(int id){
		List<Car> results = template.execute(session -> {
			Query<Car> q = session.createQuery("from Car where id=:id");
			q.setParameter("id", id);
			return q.list();
		});
		return results;
	}
	

	/**
	 * Metod for att spara car
	 * @throws CarFoundException Om bilen finns i tabell kastar metod exception
	
	 */
	@Override
	public void insert(Car bil) throws CarFoundException {
//		List<Car> results = template.execute(session -> {
//			Query<Car> q = session.createQuery("from Car where regNr=:regNr");
//			q.setParameter("regNr", bil.getRegNr());
//			return q.list();
//		});
		List<Car> results = hamtaMedRegNr(bil.getRegNr());
		if (results.size() == 0)
		this.template.save(bil);
		else
			throw new CarFoundException();
	}

	/**
	 * Metod for att radera bil pga id
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public void remove(int id) throws CarNotFoundException {
//		List<Car> results = template.execute(session -> {
//			Query<Car> q = session.createQuery("from Car where id=:id");
//			q.setParameter("id", id);
//			return q.list();
//		});
		List<Car> results = hamtaMedId(id);
		if (results.size() == 1)
			template.delete(results.get(0));
		else
			throw new CarNotFoundException();
	}

	/**
	 * Metod for att radera bil pga register nummer
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public void removeByRegNr(String regNr) throws CarNotFoundException {

//		List<Car> results = template.execute(session -> {
//			Query<Car> q = session.createQuery("from Car where regNr=:regNr");
//			q.setParameter("regNr", regNr);
//			return q.list();
//		});
		List<Car> results = hamtaMedRegNr(regNr);
		if (results.size() == 1)
			template.delete(results.get(0));
		else
			throw new CarNotFoundException();
	}

	/**
	 * Uppdatera pris
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public void updatePrice(Car car, int price) throws CarNotFoundException {
		
//		List<Car> results = template.execute(session -> {
//			Query<Car> q = session.createQuery("from Car where regNr=:regNr");
//			q.setParameter("regNr", car.getRegNr());
//			return q.list();
//		});
		List<Car> results = hamtaMedRegNr(car.getRegNr());
		if (results.size() == 1)
		{
		template.execute(session -> {
			Query<Car> q = session.createQuery("update Car set price= :price where regNr= :regNr");

			q.setParameter("price", price);
			q.setParameter("regNr", car.getRegNr());

			return q.executeUpdate();

		});}
		else
			throw new CarNotFoundException();
	}

	/**
	 * Uppdatera kilometer
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public void updateKilometer(Car car, int kilometer) throws CarNotFoundException {
//		List<Car> results = template.execute(session -> {
//			Query<Car> q = session.createQuery("from Car where regNr=:regNr");
//			q.setParameter("regNr", car.getRegNr());
//			return q.list();
//		});
		
		List<Car> results = hamtaMedRegNr(car.getRegNr());
		if (results.size() == 1)
		{
		template.execute(session -> {
			Query<Car> q = session.createQuery("update Car set kilometer= :kilometer where regNr= :regNr");

			q.setParameter("kilometer", kilometer);
			q.setParameter("regNr", car.getRegNr());
			return q.executeUpdate();
		});}
		else
			throw new CarNotFoundException();
	}

	/**
	 * Att andra status fran nya till ej nya
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */

	@Override
	public void updateIsNew(Car car, boolean isNew) throws CarNotFoundException {
//		List<Car> results = template.execute(session -> {
//			Query<Car> q = session.createQuery("from Car where regNr=:regNr");
//			q.setParameter("regNr", car.getRegNr());
//			return q.list();
//		});
		
		List<Car> results = hamtaMedRegNr(car.getRegNr());
		if (results.size() == 1)
		{
		template.execute(session -> {
			Query<Car> q = session.createQuery("update Car set isNew= :isNew where regNr= :regNr");
			q.setParameter("isNew", isNew);
			q.setParameter("regNr", car.getRegNr());
			return q.executeUpdate();
		});}
		else
			throw new CarNotFoundException();

	}

	/**
	 * Att andra status or mojligt att hyra en bil eller ej
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */

	@Override
	public void updateIsRentable(Car car, boolean isRentable) throws CarNotFoundException {
//		List<Car> results = template.execute(session -> {
//			Query<Car> q = session.createQuery("from Car where regNr=:regNr");
//			q.setParameter("regNr", car.getRegNr());
//			return q.list();
//		});
		List<Car> results = hamtaMedRegNr(car.getRegNr());
		if (results.size() == 1)
		{
		template.execute(session -> {
			Query<Car> q = session.createQuery("update Car set isRentable= :isRentable where regNr= :regNr");

			q.setParameter("isRentable", isRentable);
			q.setParameter("regNr", car.getRegNr());
			return q.executeUpdate();
		});}
		else
			throw new CarNotFoundException();

	}

	/**
	 * Metoden ger tillbaka en bil pga id
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public Car findById(int id) throws CarNotFoundException {
//		List<Car> results = template.execute(session -> {
//			Query<Car> q = session.createQuery("from Car where id=:id");
//			q.setParameter("id", id);
//			return q.list();
//		});
		List<Car> results = hamtaMedId(id);
		if (results.size() == 1)
			return results.get(0);
		else
			throw new CarNotFoundException();
	}

	/**
	 * Metoden returnerar en bil pga registrer nummer
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public Car findByRegNr(String regNr) throws CarNotFoundException {
//		List<Car> results = template.execute(session -> {
//			Query<Car> q = session.createQuery("from Car where regNr=:regNr");
//			q.setParameter("regNr", regNr);
//			return q.list();
//		});
		List<Car> results = hamtaMedRegNr(regNr);
		
		if (results.size() == 1)
			return results.get(0);
		else
			throw new CarNotFoundException();
	}

	/**
	 * Hittar alla bilar som finns i tabell car
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */

	@Override
	public List<Car> findAll() throws CarNotFoundException{

		List<Car> results = template.execute(session ->  session.createQuery("from Car").list());
			
		if (results.size() >=1)
			return results;
		else
			throw new CarNotFoundException();
	

	}

	/**
	 * Hittar alla bilar som ar samma brand i tabell car
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> findByBrand(String brandName) throws CarNotFoundException {
		List<Car> results = template.execute(session -> {
			Query<Car> q = session.createQuery("from Car where brandName=:brandName");
			q.setParameter("brandName", brandName);
			return q.list();
		});
		
		if (results.size() >=1)
			return results;
		else
			throw new CarNotFoundException();
	}

	
	/**
	 * Hittar alla bilar som ar samma brand och samma model i tabell car
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> findByBrandAndModel(String brandName, String modelName) throws CarNotFoundException {
		List<Car> results = template.execute(session -> {
			Query<Car> q = session.createQuery("from Car where brandName=:brandName and modelName=:modelName");
			q.setParameter("brandName", brandName);
			q.setParameter("modelName", modelName);
			return q.list();
		});
	//	return results;
		if (results.size() >=1)
			return results;
		else
			throw new CarNotFoundException();
	

	}

	/**
	 * Hittar alla bilar som ar biligare an onskade pris
	* @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> findBelowPrice(int price) throws CarNotFoundException {
		List<Car> results = template.execute(session -> {
			Query<Car> q = session.createQuery("from Car where price < :price");
			q.setParameter("price", price);
			return q.list();
		});
		if (results.size() >=1)
			return results;
		else
			throw new CarNotFoundException();
	}

	/**
	 * Hittar alla bilar som har kilometer mindre an onskade kilometer
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> findBelowKilometer(int kilometer) throws CarNotFoundException {
		List<Car> results = template.execute(session -> {
			Query<Car> q = session.createQuery("from Car where kilometer < :kilometer");
			q.setParameter("kilometer", kilometer);
			return q.list();
		});
		if (results.size() >=1)
			return results;
		else
			throw new CarNotFoundException();
	}

	/**
	 * Hittar alla bilar som ar automatik/ej automatik
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> findByAutomatic(boolean automatik) throws CarNotFoundException {
		List<Car> results = template.execute(session -> {
			Query<Car> q = session.createQuery("from Car where automatic= :automatik");
			q.setParameter("automatik", automatik);
			return q.list();
		});
		if (results.size() >=1)
			return results;
		else
			throw new CarNotFoundException();
	}

	/**
	 * Hittar alla bilar som ar rentable/ej rentable
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> findByRentable(boolean kanHyra) throws CarNotFoundException {
		List<Car> results = template.execute(session -> {
			Query<Car> q = session.createQuery("from Car where isRentable= :kanHyra");
			q.setParameter("kanHyra", kanHyra);
			return q.list();
		});
		if (results.size() >=1)
			return results;
		else
			throw new CarNotFoundException();
	}

	/**
	 * Hittar alla bilar som har navigation
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> findByNavigation(boolean haNavigation) throws CarNotFoundException {
		List<Car> results = template.execute(session -> {
			Query<Car> q = session.createQuery("from Car where navigation= :haNavigation");
			q.setParameter("haNavigation", haNavigation);
			return q.list();
		});
		if (results.size() >=1)
			return results;
		else
			throw new CarNotFoundException();
	}

	/**
	 * Hittar alla bilar som är nya eller begagnad
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> findByNew(boolean nya) throws CarNotFoundException {
		List<Car> results = template.execute(session -> {
			Query<Car> q = session.createQuery("from Car where isNew= :nya");
			q.setParameter("nya", nya);
			return q.list();
		});
		if (results.size() >=1)
			return results;
		else
			throw new CarNotFoundException();
	}

	/**
	 * Hittar alla bilar som anvander samma fuel
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllCarByFuel(String fuel) throws CarNotFoundException {
		List<Car> results = template.execute(session -> {
			Query<Car> q = session.createQuery("from Car where fuel=:fuel");
			q.setParameter("fuel", fuel);
			return q.list();
		});
		if (results.size() >=1)
			return results;
		else
			throw new CarNotFoundException();
	}

	/**
	 * Hittar alla bilar som ar samma brand och anvander samma fuel
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllCarByBrandAndFuel(String brandName, String fuel) throws CarNotFoundException {
		List<Car> results = template.execute(session -> {
			Query<Car> q = session.createQuery("from Car where brandName=:brandName and fuel=:fuel");
			q.setParameter("brandName", brandName);
			q.setParameter("fuel", fuel);
			return q.list();
		});
		if (results.size() >=1)
			return results;
		else
			throw new CarNotFoundException();

	}

	/**
	 * Hittar alla bilar som ar samma brand och model samt anvander samma fuel
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllCarByBrandAndModelAndFuel(String brandName, String modelName, String fuel) throws CarNotFoundException {
		List<Car> results = template.execute(session -> {
			Query<Car> q = session
					.createQuery("from Car where brandName=:brandName and modelName=:modelName and fuel=:fuel");
			q.setParameter("brandName", brandName);
			q.setParameter("modelName", modelName);
			q.setParameter("fuel", fuel);
			return q.list();
		});
		if (results.size() >=1)
			return results;
		else
			throw new CarNotFoundException();
	}

	/**
	 * Hittar alla bilar som är gjord samma ar
	 * @throws CarNotFoundException Om bil finns inte i tabell kastar metoden exception
	 */
	@Override
	public List<Car> getAllCarByYear(int year) throws CarNotFoundException {
		List<Car> results = template.execute(session -> {
			Query<Car> q = session.createQuery("from Car where yearProduce = :year");
			q.setParameter("year", year);
			return q.list();
		});
	
		if (results.size() >=1)
			return results;
		else
			throw new CarNotFoundException();
	}

}
