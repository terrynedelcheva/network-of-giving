package com.vmware.talentboost.finaltask.networkofgiving.service;

import com.vmware.talentboost.finaltask.networkofgiving.model.Charity;

import java.util.List;

public interface ICharityService {
    Charity create(Charity charity);
    void update(Long id, Charity charity);
    void delete(Long id);
    List<Charity> getAllCharities();
    Charity get(Long id);
}
