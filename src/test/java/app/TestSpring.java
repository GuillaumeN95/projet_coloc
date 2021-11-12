package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ApplicationConfig;

public class TestSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext spring = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		spring.close();
	}

}
