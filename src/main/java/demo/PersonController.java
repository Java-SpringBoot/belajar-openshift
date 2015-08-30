package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/add/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> insert(@PathVariable String name) {
		
		return new ResponseEntity<>(personService.insert(name),HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
	}

}
