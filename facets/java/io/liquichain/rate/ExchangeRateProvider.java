package io.liquichain.rate;

import java.util.Map;
import java.time.Instant;

import org.meveo.service.script.Script;
import org.meveo.admin.exception.BusinessException;
import io.liquichain.api.payment.ConversionRateScript;


public class ExchangeRateProvider extends Script {
		
    private String fromCurrency;
    private String toCurrency;
    private String fromDate;
    private String toDate;
    private long maxValues;
    private String result;

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency=fromCurrency;
    }
  
    public void setToCurrency(String toCurrency) {
        this.toCurrency=toCurrency;
    }
  
    public void setFromDate(String fromDate) {
        this.fromDate=fromDate;
    }
  
    public void setToDate(String toDate) {
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
          +"\"from\":\""+fromDate+"\",\n"
          +"\"to\":\""+toDate+"\",\n"
          +"\"data\":[\n"
          +"{\"timestamp\":1649541600000,\"value\":1500},\n"
          +"{\"timestamp\":1649628000000,\"value\":1300},\n"
          +"{\"timestamp\":1649728000000,\"value\":900},\n"
          +"{\"timestamp\":1649828000000,\"value\":1100},\n"
          +"{\"timestamp\":1649928000000,\"value\":1600},\n"
          +"{\"timestamp\":"+System.currentTimeMillis()+",\"value\":"+ConversionRateScript.LCN_TO_EUR+"}\n"
          +"]\n"
          +"}";
	}
}
