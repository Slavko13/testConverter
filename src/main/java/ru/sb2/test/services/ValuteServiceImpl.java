package ru.sb2.test.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ru.sb2.test.domains.History;
import ru.sb2.test.domains.Users;
import ru.sb2.test.domains.Valute;
import ru.sb2.test.repositories.ValuteRepository;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

@Service
public class ValuteServiceImpl implements ValuteService {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ValuteRepository valuteRepository;

    @Override
    public Valute findOneValuteByName(String name) {
        return  valuteRepository.findByName(name);
    }


    @Override
    public Iterable getAllValutes() {
        return valuteRepository.findAll();
    }

    @Override
    public boolean downLoadValuteCourse() throws ParserConfigurationException, IOException, SAXException {

        //Created XML document parser
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new InputSource(new StringReader(getValutesFromCFRB())));
        int lengthOfValuteFile = document.getElementsByTagName("Valute").getLength();


        if (lengthOfValuteFile == 0 ) {
            return false;
        }

        //Loop to save all valutes from parser
        for (int i=0; lengthOfValuteFile > i; i++) {
            Valute valute = new Valute();
            valute.setId(Integer.parseInt(document.getElementsByTagName("NumCode").item(i).getTextContent()));
            valute.setCharCode(document.getElementsByTagName("CharCode").item(i).getTextContent());
            valute.setName(document.getElementsByTagName("Name").item(i).getTextContent());
            valute.setValue(Double.parseDouble(document.getElementsByTagName("Value").item(i).getTextContent().replace(",", "."))
                    / Double.parseDouble(document.getElementsByTagName("Nominal").item(i).getTextContent()));
            valuteRepository.save(valute);
        }
        return true;
    }

    private String getValutesFromCFRB() throws IOException {
        String adr= "http://www.cbr.ru/scripts/XML_daily.asp";
        URL url = null;
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        String str;


        StringBuilder stringBuilder = new StringBuilder();
        url = new URL(adr); //создаем URL
        connection = (HttpURLConnection)url.openConnection(); //Open connection to valute site
        bufferedReader = new BufferedReader(new InputStreamReader(
                connection.getInputStream(), "Cp1251")); // Using BufferedReader for strings

        while((str = bufferedReader.readLine()) != null){ // while end of file read strings and adding to Final string
            stringBuilder.append(str);
        }
        bufferedReader.close(); //close buffer thread
        connection.disconnect();
        return stringBuilder.toString();
    }

    private Valute getValuteByName(String name){
        return valuteRepository.findByName(name);
    }


    @Override
    public double convert(String sourceValuteFromFront, String targetValuteFromFront, double sourceValuteValue) {
        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        Valute sourceValute =  getValuteByName(sourceValuteFromFront);
        Valute targetValute = getValuteByName(targetValuteFromFront);

        return Double.parseDouble(decimalFormat.format(sourceValute.getValue()*sourceValuteValue/targetValute.getValue()).replace(",", "."));
    }
}
