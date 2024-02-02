package com.example.BookMyShow.Services;

import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repositories.UserRep;
import com.example.BookMyShow.RequestDTOs.AddUserReq;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Data
public class UserService {
    @Autowired
    private UserRep userRep;

    public String addUser ( AddUserReq addUserReq){
        User user=User.builder()
                .name(addUserReq.getName())
                .emailId(addUserReq.getEmailId())
                .build();
        userRep.save(user);
        return "New user saved with userId "+ user.getUserId();
    }

}
