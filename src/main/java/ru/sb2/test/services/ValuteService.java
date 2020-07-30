package ru.sb2.test.services;

import org.xml.sax.SAXException;
import ru.sb2.test.domains.History;
import ru.sb2.test.domains.Users;
import ru.sb2.test.domains.Valute;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface ValuteService {
    boolean downLoadValuteCourse() throws IOException, SAXException, ParserConfigurationException;
    Iterable getAllValutes();
    Valute findOneValuteByName(String name);
    double convert(String sourceValute, String targetValute, double sourceValuteValue);

}
