package com.demo.waterSupply.service;

import com.demo.waterSupply.dto.request.UtilityRequestDTO;
import com.demo.waterSupply.dto.respond.UtilityRespondDTO;
import com.demo.waterSupply.exception.EntityExistsException;
import com.demo.waterSupply.exception.EntityNotFoundException;
import com.demo.waterSupply.model.UtilityModel;
import com.demo.waterSupply.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtilityService {
    @Autowired
    private UtilityRepository utilityRepository;
    public UtilityModel addUtility(UtilityRequestDTO utilityRequestDTO) {
        if(utilityRepository.existsByUtilityName(utilityRequestDTO.getUtilityName()))
            throw new EntityExistsException("Utility Already Exists");
        UtilityModel utilityModel=new UtilityModel();
//        utilityModel.setUtilityId(utilityRequestDTO.getUtilityId());
        utilityModel.setUtilityName(utilityRequestDTO.getUtilityName());
        return utilityRepository.save(utilityModel);
    }
    public List<UtilityModel> addAllUtility(List<UtilityRequestDTO> utilityRequestDTOS){
        List<UtilityModel> utilityModels=new ArrayList<>();
        for(int i=0;i<utilityRequestDTOS.size();i++)
        {
            if(utilityRepository.existsByUtilityName(utilityRequestDTOS.get(i).getUtilityName()))
                throw new EntityExistsException("Utility Already Exists");
            UtilityModel utilityModel=new UtilityModel();
            utilityModel.setUtilityName(utilityRequestDTOS.get(i).getUtilityName());
            utilityModels.add(utilityModel);
        }
        return utilityRepository.saveAll(utilityModels);
    }
    public UtilityRespondDTO getUtilityById(Long id) {
        Optional<UtilityModel> utilityModel=utilityRepository.findById(id);
        if(utilityModel.isEmpty())
            throw new EntityNotFoundException("Utility Does not Exist");
        UtilityRespondDTO utilityRespondDTO=new UtilityRespondDTO();
        utilityRespondDTO.setUtilityId(utilityModel.get().getUtilityId());
        utilityRespondDTO.setUtilityName(utilityModel.get().getUtilityName());
        return utilityRespondDTO;
    }
    public List<UtilityRespondDTO> getAllUtility(){
        List<UtilityModel> utilityModels=utilityRepository.findAll();
        if(utilityModels.isEmpty())
            throw new EntityNotFoundException("There is no Utility");
        List<UtilityRespondDTO> utilityRespondDTOS=new ArrayList<>();
        for(int i=0;i<utilityModels.size();i++){
            UtilityRespondDTO utilityRespondDTO=new UtilityRespondDTO();
            utilityRespondDTO.setUtilityName(utilityModels.get(i).getUtilityName());
            utilityRespondDTO.setUtilityId(utilityModels.get(i).getUtilityId());
            utilityRespondDTOS.add(utilityRespondDTO);
        }
        return utilityRespondDTOS;
    }
    public UtilityModel updateUtility(UtilityModel utilityModel) {
        return utilityRepository.save(utilityModel);
    }
    public void deleteUtilityById(Long id) {
        Optional<UtilityModel> utilityModel=utilityRepository.findById(id);
        if(utilityModel.isEmpty())
            throw new EntityNotFoundException("Utility Does not Exist");
        utilityRepository.deleteById(id);
    }

}
