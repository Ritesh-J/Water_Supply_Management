package com.demo.waterSupply.service;

import com.demo.waterSupply.dto.request.UtilityRequestDTO;
import com.demo.waterSupply.dto.respond.UtilityRespondDTO;
import com.demo.waterSupply.exception.UtilityNotFoundException;
import com.demo.waterSupply.model.UtilityModel;
import com.demo.waterSupply.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtilityService {
    @Autowired
    private UtilityRepository utilityRepository;
    public UtilityModel addUtility(UtilityRequestDTO utilityRequestDTO) {
        UtilityModel utilityModel=new UtilityModel();
//        utilityModel.setUtilityId(utilityRequestDTO.getUtilityId());
        utilityModel.setUtilityName(utilityRequestDTO.getUtilityName());
        return utilityRepository.save(utilityModel);
    }
    public List<UtilityModel> addAllUtility(List<UtilityRequestDTO> utilityRequestDTOS){
        List<UtilityModel> utilityModels=new ArrayList<>();
        for(int i=0;i<utilityRequestDTOS.size();i++)
        {
            UtilityModel utilityModel=new UtilityModel();
//            utilityModel.setUtilityId(utilityRequestDTOS.get(i).getUtilityId());
            utilityModel.setUtilityName(utilityRequestDTOS.get(i).getUtilityName());
            utilityModels.add(utilityModel);
        }
        return utilityRepository.saveAll(utilityModels);
    }
    public UtilityRespondDTO getUtilityById(Long id) {
        Optional<UtilityModel> utilityModel=utilityRepository.findById(id);
        if(utilityModel.isEmpty())
            throw new UtilityNotFoundException("Utility Does not Exist");
        UtilityRespondDTO utilityRespondDTO=new UtilityRespondDTO();
        utilityRespondDTO.setUtilityName(utilityModel.get().getUtilityName());
        return utilityRespondDTO;
    }
    public List<UtilityRespondDTO> getAllUtility(){
        List<UtilityModel> utilityModels=utilityRepository.findAll();
        if(utilityModels.isEmpty())
            throw new UtilityNotFoundException("There is no Utility");
        List<UtilityRespondDTO> utilityRespondDTOS=new ArrayList<>();
        for(int i=0;i<utilityModels.size();i++){
            UtilityRespondDTO utilityRespondDTO=new UtilityRespondDTO();
            utilityRespondDTO.setUtilityName(utilityModels.get(i).getUtilityName());
            utilityRespondDTOS.add(utilityRespondDTO);
        }
        return utilityRespondDTOS;
    }
    public UtilityModel updateUtility(UtilityRequestDTO utilityRequestDTO) {
        UtilityModel utilityModel=utilityRepository.findByUtilityName(utilityRequestDTO.getUtilityName());

//        utilityModel.setUtilityId(utilityRequestDTO.getUtilityId());
        utilityModel.setUtilityName(utilityRequestDTO.getUtilityName());
        return utilityRepository.save(utilityModel);
    }
    public void deleteUtilityById(Long id) {
        Optional<UtilityModel> utilityModel=utilityRepository.findById(id);
        if(utilityModel.isEmpty())
            throw new UtilityNotFoundException("Utility Does not Exist");
        utilityRepository.deleteById(id);
    }

}
