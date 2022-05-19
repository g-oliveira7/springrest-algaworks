package com.brgabrieldeoliveira.springrestalgaworks.api.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.brgabrieldeoliveira.springrestalgaworks.api.exceptions.models.StandardValidationError;
import com.brgabrieldeoliveira.springrestalgaworks.api.exceptions.models.ValidationError;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardValidationError> handleArgumentNotValid(MethodArgumentNotValidException e,
			HttpServletRequest req) {
		final List<ValidationError> errors = new ArrayList<>();

		e.getBindingResult().getFieldErrors().forEach(fieldError -> {
			errors.add(new ValidationError(fieldError.getField(), fieldError.getDefaultMessage()));
		});

		final StandardValidationError error = new StandardValidationError(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(), 
				"Argumento inválido", 
				req.getRequestURI());

		error.getErros().addAll(errors);

		return ResponseEntity.badRequest().body(error);
	}
	
}
