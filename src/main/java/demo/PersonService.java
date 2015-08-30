package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PersonService {

	@Autowired
	private PersonDao personDao;

	@Transactional(readOnly = false)
	public Person insert(String name) {
		Person person = new Person();
		person.setName(name);
		return personDao.save(person);
	}

	public List<Person> getAll() {
		return personDao.findAll();
	}

}
