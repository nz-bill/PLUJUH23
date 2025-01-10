package com.example.SpringSecurityEx1;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecureDataService {

    private final SecureDataRepository repository;

    public SecureDataService(SecureDataRepository repository){
        this.repository = repository;
    }

    public SecureData saveData(String value){
        SecureData data = new SecureData();

        data.setEncryptedValue(value);
        return repository.save(data);
    }

    public List<SecureData> getAllData(){
        return repository.findAll();
    }

}
