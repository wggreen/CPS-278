package edu.wccnet.wggreen.springMVC.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseNameConstraintValidator implements ConstraintValidator<CourseName, String> {

	public String[] prefixCourseName;

	public void initialize(CourseName courseName) {
		prefixCourseName = courseName.value();
	}

	@Override
	public boolean isValid(String userInput, ConstraintValidatorContext context) {

		boolean result;

		if (userInput != null) {
			for (String eachPrefix : prefixCourseName) {
				result = userInput.startsWith(eachPrefix);
				if (result) {
					return result;
				}
			}
			return false;
		} else {
			return true;
		}
	}
}
