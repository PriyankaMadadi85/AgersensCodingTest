package com.agersens.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.agersens.demo.service.FireBaseAPIConsumerService;
import com.agersens.model.AnimalData;
import com.agersens.util.AgersensLog;

@RestController
@Validated
public class AnimalLocationController {

	@Autowired
	FireBaseAPIConsumerService fireBaseService;

	public AnimalLocationController() {
	}

	@RequestMapping(value = "/animals", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<String> postAnimalLocation(@Valid @RequestBody Map<String, AnimalData> animalDataJson) {

		AgersensLog.writeToLog("Recieved Animal Batch Request :: ");

		animalDataJson.forEach((k, v) -> {
						
			AgersensLog.writeToLog("Key >> " + k + " Name >> " + v.getName());
			AgersensLog.writeToLog("Cordinates of animal >> " + v.getName() + " :: Latitude >> " + v.getLocation().getLat()
					+ " Longitude >> " + v.getLocation().getLng());
		});

		try {
			fireBaseService.patchAnimalData(animalDataJson);
			AgersensLog.writeToLog("Completed Batch Processing");
			return ResponseEntity.status(HttpStatus.OK).body("Succesfully update Animal Batch");
		} catch (Exception e) {
			AgersensLog.writeToLog("Failed to update Animal location");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to update Animal Batch due to : " + e.getMessage());
		}

	}

}
