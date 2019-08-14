package com.tarento.duplicatekeycheck.service;

import com.tarento.duplicatekeycheck.domain.Employee;

public interface KeyCheckService {

	Employee createRandomMultiplication();
    public boolean checkIfDuplicate(final Employee employee);
}
