package com.agersens.demo.service;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

import com.agersens.model.AnimalData;

public interface FireBaseAPIConsumerService {

	void patchAnimalData(@RequestBody Map<String, AnimalData> inputRequest) throws Exception;
}
