package ru.sb2.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.xml.sax.SAXException;
import ru.sb2.test.services.ValuteService;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@SpringBootApplication
public class TestApplication {


	private static ValuteService valuteService;

	@Autowired
	public TestApplication(ValuteService valuteService1) {
		TestApplication.valuteService = valuteService1;
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SpringApplication.run(TestApplication.class, args);
		valuteService.downLoadValuteCourse();
	}

}
