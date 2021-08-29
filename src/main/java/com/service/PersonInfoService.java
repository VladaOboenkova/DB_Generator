package com.service;

import com.entity.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.PersonInfoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonInfoService {

    @Autowired
    private final PersonInfoRepository personInfoRepository;

    public PersonInfoService(PersonInfoRepository personInfoRepository) {
        this.personInfoRepository = personInfoRepository;
    }

    public int count() {
        return (int) personInfoRepository.count();
    }

    public void createPersonInfo(PersonInfo personInfo) {
        personInfoRepository.save(personInfo);
    }

    public PersonInfo findById(Long id) {
        return personInfoRepository.findById(id).orElse(null);
    }

    public List<PersonInfo> findAll() {
        return personInfoRepository.findAll();
    }

    public List<PersonInfo> findAllAdults() {return personInfoRepository.findAllAdults();}

    public List<PersonInfo> findAllChildren() {return personInfoRepository.findAllChildren();}

    public List<PersonInfo> findAllWithIntlPassport(Boolean adult){
        if (adult){
            List<PersonInfo> allAdults = findAllAdults();
            List<PersonInfo> allAdultsWithIntlPassport = new ArrayList<>();
            for (PersonInfo p : allAdults) {
                if (p.getIntl_passport_num() != null && p.getIntl_passport_series() != null) {
                    allAdultsWithIntlPassport.add(p);
                }
            }
            return allAdultsWithIntlPassport;
        } else {
            List<PersonInfo> allChildren = findAllChildren();
            List<PersonInfo> allChildrenWithIntlPassport = new ArrayList<>();
            for (PersonInfo p : allChildren) {
                if (p.getIntl_passport_num() != null && p.getIntl_passport_series() != null) {
                    allChildrenWithIntlPassport.add(p);
                }
            }
            return allChildrenWithIntlPassport;
        }
    }
}
