package io.liquichain.rate;

import java.util.Map;
import java.time.Instant;

import org.meveo.service.script.Script;
import org.meveo.admin.exception.BusinessException;
import io.liquichain.api.payment.ConversionRateScript;


public class ExchangeRateProvider extends Script {
		
    private String fromCurrency;
    private String toCurrency;
    private Instant fromDate;
    private Instant toDate;
    private long maxValues;
    private String result;

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency=fromCurrency;
    }
  
    public void setToCurrency(String toCurrency) {
        this.toCurrency=toCurrency;
    }
  
    public void setFromDate(Instant fromDate) {
        this.fromDate=fromDate;
    }
  
    public void setToDate(Instant toDate) {
        this.toDate=toDate;
    }
  
    public void setMaxValues(long maxValues){
        this.maxValues = maxValues;
    }
  
    public String getResult() {
        return result;
    }
  
  
	@Override
	public void execute(Map<String, Object> parameters) throws BusinessException {
		result="{"
          +"from=\""+fromDate+"\",\n"
          +"to=\""+toDate+"\",\n"
          +"data=[\n"
          +"{\"timestamp\":System.currentTimeMillis(),\"value\":"+ConversionRateScript.LCN_TO_EUR+"}\n"
          +"]\n"
          +"}";
	}
}
