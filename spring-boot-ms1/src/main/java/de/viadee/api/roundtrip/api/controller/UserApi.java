package de.viadee.api.roundtrip.api.controller;

import de.viadee.api.roundtrip.api.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@Tag(name = "User API", description = "User Management API")
interface UserApi {

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<User> findAll();

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	User findById(@PathVariable String id);

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	User save(@RequestBody User user);

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	User update(@PathVariable String id, @RequestBody User user);

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void delete(@PathVariable String id);
}
