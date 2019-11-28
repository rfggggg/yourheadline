package com.yourheadline.ajaxapi;

import com.yourheadline.dao.FollowDAO;
import com.yourheadline.dao.UserDAO;
import com.yourheadline.dao.UserFollowInfoDAO;
import com.yourheadline.entity.FollowEntity;
import com.yourheadline.entity.UserEntity;
import com.yourheadline.model.UserFollowInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("/api")
@RestController
public class ServletUpdateUser {
    @Autowired
    UserDAO userDAO;
    @Autowired
    FollowDAO followDAO;
    @Autowired
    UserFollowInfoDAO userFollowInfoDAO;

    @PostMapping("/updateUser")
    @ResponseBody
    public Map<String, Object> updateuserinfo(@RequestBody Map<String, String> inMap){
        Map<String, Object> map = new HashMap<>();

        UserEntity u = new UserEntity();
        if (inMap.containsKey("userId")) {
            int userId = Integer.parseInt(inMap.get("userId"));

            List<UserEntity> userinfo = new ArrayList<>();
            userinfo = userDAO.findByUserId(userId);
            if (!userinfo.isEmpty()){
                u = userinfo.get(0);
            }
            if (inMap.containsKey("userName")) {
                u.setUserName(inMap.get("userName"));
            }
            if (inMap.containsKey("birthDate")) {
                String date=inMap.get("birthDate");
                int year=Integer.parseInt(date.substring(0,4));
                int month=Integer.parseInt(date.substring(5,7));
                int day=Integer.parseInt(date.substring(8,10));
                Calendar newday=new GregorianCalendar(year, month-1, day);
                Date newbirthday=new Date(newday.getTimeInMillis());
                u.setBirthDate(newbirthday);
            }
            if(inMap.containsKey("gender")){
                u.setGender(inMap.get("gender"));
            }
            if (inMap.containsKey("email")) {
                u.setEmail(inMap.get("email"));
            }
            if(inMap.containsKey("mobilePhone")) {
                u.setMobilePhone(inMap.get("mobilePhone"));
            }
            userDAO.save(u);
        }
        map.put("user_info", u);
        return map;
    }

    @PostMapping("/updateUser/deletefollow")
    @ResponseBody
    public Map<String, Object> deleteuserfollow(@RequestBody Map<String, String> inMap) {
        Map<String, Object> map = new HashMap<>();
        if (inMap.containsKey("followId")) {
            int followid= Integer.parseInt(inMap.get("followId"));
            FollowEntity fe=followDAO.findById(followid).get();
            followDAO.delete(fe);
//            UserFollowInfo usi=userFollowInfoDAO.findByFollowId(followid).get(0);
//            userFollowInfoDAO.delete(usi);
        }
        return null;
    }

    @PostMapping("/updateUser/updateAvatarLink")
    @ResponseBody
    public Map<String, Object> updateuserAvatarLink(@RequestBody Map<String, String> inMap){
        Map<String, Object> map = new HashMap<>();

        UserEntity u = new UserEntity();
        if (inMap.containsKey("userId")) {
            int userId = Integer.parseInt(inMap.get("userId"));

            List<UserEntity> userinfo = new ArrayList<>();
            userinfo = userDAO.findByUserId(userId);
            if (!userinfo.isEmpty()){
                u = userinfo.get(0);
            }
            if (inMap.containsKey("userAvatarLink")) {
                u.setUserAvatarLink(inMap.get("userAvatarLink"));
            }
            userDAO.save(u);
        }
        map.put("user_info", u);
        return map;
    }
}
