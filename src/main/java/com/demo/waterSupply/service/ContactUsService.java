package com.demo.waterSupply.service;

import com.demo.waterSupply.dto.request.ContactUsDTO;
import com.demo.waterSupply.model.UserModel;
import com.demo.waterSupply.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactUsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationService notificationService;
    public void sendContactUs(ContactUsDTO contactUsDTO){
        List<UserModel> userModels=userRepository.findAll();
        List<String> userEmails=new ArrayList<>();
        for(int i=0;i<userModels.size();i++){
            String role=userModels.get(i).getRoleModel().getRoleName();
            if(role.equals("ADMIN")){
                String email=userModels.get(i).getUserEmail();
                String subject="Water leakage";
                String mail="Dear Admin \n\n"+
                        contactUsDTO.getUserName()+
                        " has following query "+
                        contactUsDTO.getQuery()+" .\n Please Contact him on "
                        +contactUsDTO.getUserEmail()+" \n\n Thank You."+
                        "\n AquaLeaps";
                notificationService.sendMail(email,subject,mail);
            }
        }
    }
}
