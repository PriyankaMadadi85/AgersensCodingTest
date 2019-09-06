package com.agersens.demo.service;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.agersens.model.AnimalData;
import com.agersens.util.AgersensLog;

@Service
public class FireBaseAPIConsumerServiceImpl implements FireBaseAPIConsumerService{

	private final RestTemplate restTemplate;

	public FireBaseAPIConsumerServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@RequestMapping(method = RequestMethod.PATCH,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/location")
	public void patchAnimalData(@RequestBody Map<String, AnimalData> inputRequest) throws Exception {
		AgersensLog.writeToLog("Calling Agersens Fire Base API >> ");
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(1000);

		restTemplate.setRequestFactory(requestFactory);
		Map<String, AnimalData> updatedData = restTemplate.patchForObject("https://agersens-test.firebaseio.com/animals.json", inputRequest, Map.class);
		System.out.println("Updated Animal Batch as following >> "+updatedData);
		AgersensLog.writeToLog("Updated Animal Batch as following >> "+updatedData);
		
	}

}
