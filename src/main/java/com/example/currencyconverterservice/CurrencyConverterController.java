package com.example.currencyconverterservice;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/currencyconverter")
public class CurrencyConverterController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${interservice.currencyexchangeservice.name}")//=currency-exchange-rate-eks-sevice
	private String curencyExchangeserviceName;

	
	@GetMapping(value="/converter")
	public CurrencyConverterDto  getInfo(
			@RequestParam("fromCurrency") String fromCurrency, 
			@RequestParam("toCurrency") String toCurrency, 
			@RequestParam("units") double units) throws UnknownHostException {

		int targetPort=8080;
		System.out.println("curencyExchangeserviceName:" + curencyExchangeserviceName);
		String url = "http://"+curencyExchangeserviceName +":" 
					+ targetPort+ "/exchanges/converter?fromCurrency=" 
					+fromCurrency + "&toCurrency=" + toCurrency;
		System.out.println("url:" + url);
		// sample request:http://currency-exchange-rate-eks-sevice:8080/exchanges/converter?fromCurrency=USD&toCurrency=INR
		//currency-exchange-rate-eks-sevice is name of the service registered with k8s
		ResponseEntity<CurrencyExchangeRateDto> exchangeRate = restTemplate
                .getForEntity(url,
                		CurrencyExchangeRateDto.class);
		
		return new CurrencyConverterDto(fromCurrency, toCurrency, units*exchangeRate.getBody().getRate() );
	}
}
