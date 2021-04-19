package com.vmware.talentboost.finaltask.networkofgiving.service;

import com.vmware.talentboost.finaltask.networkofgiving.model.Charity;
import com.vmware.talentboost.finaltask.networkofgiving.repository.CharityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CharityService implements ICharityService {
    @Autowired
    private CharityRepository charityRepository;

    @Override
    public Charity create(Charity charity) {
        return charityRepository.save(charity);
    }

    @Override
    public void update(Long id, Charity charity) {
        Optional<Charity> charityOptional = charityRepository.findById(id);
        if(charityOptional.isPresent()) {
            charity.setId(id);
            charityRepository.save(charity);
        }
    }

    @Override
    public void delete(Long id) {
        if(charityRepository.findById(id).isPresent()) {
            charityRepository.deleteById(id);
        }
    }

    @Override
    public List<Charity> getAllCharities() {
        return charityRepository.findAll();
    }

    @Override
    public Charity get(Long id) {
        return charityRepository.findById(id).orElse(null);
    }

    public List<Charity> findByTitleContaining(String title) {
        List<Charity> charities = charityRepository.findAll();
        return charities.stream().filter(charity -> { return charity.getTitle().contains(title); }).collect(Collectors.toList());
    }
}
