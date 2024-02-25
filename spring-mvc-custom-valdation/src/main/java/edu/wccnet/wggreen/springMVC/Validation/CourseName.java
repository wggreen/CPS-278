package edu.wccnet.wggreen.springMVC.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseNameConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseName {
	
	public String[] value() default {"CPS", "CIS", "CNT"};
	public String message() default "course has to start with CPS, CIS, or CNT";
	public Class<?>[] groups() default{};
	public Class<? extends Payload>[] payload() default{};
}
