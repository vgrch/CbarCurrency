package az.cbar.convertor.service;

import az.cbar.convertor.domain.ValCurs;
import az.cbar.convertor.domain.ValType;
import az.cbar.convertor.domain.Valute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CurrencyConvertor {

    private  static final Logger logger = LoggerFactory.getLogger(CurrencyConvertor.class);


    public static double calculate(String code,double amount,String date){

        String date_ = null;

        if (date!= null) {
            date_=date;
        }

        ValCurs curs = null;

        curs =  getCurs(date_);

        if (curs == null) return -1;
        if (amount <= 0) return -1;


        for (ValType valType:curs.getValType()){

            if (valType.getType().equals("Xarici valyutalar")){
                for (Valute valute:valType.getValute()){
                    if (valute.getCode().equals(code)){
                       return Double.parseDouble(valute.getValue()) * amount;
                    } else continue;
                }
                break;
            } else continue;

        }
        return -1;
    }

    public  static ValCurs getCurs(String date){
        String date_ = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")).toString();
        ValCurs valCurs = null;
        try {
            if (date != null && date.matches("([0-9]{2}.[0-9]{2}.[0-9]{4})")) {
                date_ = date;
            }
        }catch (Exception ex){
            date_ = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")).toString();
        }

        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://www.cbar.az/currencies/"+date_+".xml";
             valCurs = restTemplate.getForObject(url, ValCurs.class);
        }catch (Exception ex){
        logger.error(ex.getMessage());
        } finally {
            return valCurs;
        }
    }

    public static void main(String[] args) {
        double result = calculate("USD", 100,null);

        if (result != -1 ) logger.info(String.valueOf(result));
        else logger.info("SMTH went wrong");

        return;

    }
}