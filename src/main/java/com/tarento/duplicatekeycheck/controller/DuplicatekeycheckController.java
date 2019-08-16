package com.tarento.duplicatekeycheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarento.duplicatekeycheck.domain.ApplicationResponse;
import com.tarento.duplicatekeycheck.domain.Employee;
import com.tarento.duplicatekeycheck.service.KeyCheckService;
import com.tarento.duplicatekeycheck.util.ServerResponseCode;

@RestController
@RequestMapping("/duplicatecheck")
public class DuplicatekeycheckController extends BaseController{
	
	private final KeyCheckService keyCheckService;

    @Autowired
    DuplicatekeycheckController(final KeyCheckService keyCheckService) {
        this.keyCheckService = keyCheckService;
    }

    @PostMapping
    ApplicationResponse createEmployee(@RequestBody Employee employee) {
    	boolean ifDuplicateEmployee = keyCheckService.createEmployee(employee);
    	if(ifDuplicateEmployee == false) {
    		return getServerResponse(ServerResponseCode.CREATED,employee);
    	}
        return getServerResponse(ServerResponseCode.SUCCESS,employee);
    }

}
