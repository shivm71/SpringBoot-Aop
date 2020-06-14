package com.consumer.Model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Document(value="notification")
public class Notify {
    @Id
    private String productid;
    private ArrayList<String> useridList= new ArrayList<>();
    public Notify(){
//        this.useridList= new ArrayList<>();
    }
    public Notify(NotifyQueueRequest notifyQueueRequest){
//        this.id = notifyQueueRequest.getId();
        this.productid=notifyQueueRequest.getProductid();
//        this.useridList= new ArrayList<>();
        this.useridList.add(notifyQueueRequest.getUserid());
    }
    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public ArrayList<String> getUseridList() {
        return useridList;
    }
    public void setUseridList(ArrayList<String> useridList) {
        this.useridList = useridList;
    }
    public void setuseridList(String userid){

        if(!this.useridList.contains(userid))
                this.useridList.add(userid);
    }
}
