package com.beeva.validation;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Constraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * Annotation for Cardholder.
 * 
 * @author BEEVA
 * 
 */
@Documented
@Constraint(validatedBy = {})
@Target({ FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Size(max = AccountNumber.MAX)
@Pattern(regexp = "^$|([0-9]*)")
@NotBlank
public @interface AccountNumber {

	int MAX = 30;

	/**
	 * @return
	 */
	String message() default "{name.validation.error}";

	/**
	 * @return
	 */
	Class<?>[] groups() default {};

	/**
	 * @return
	 */
	Class<?>[] payload() default {};

}
