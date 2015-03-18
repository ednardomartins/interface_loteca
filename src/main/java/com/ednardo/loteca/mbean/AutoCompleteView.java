package com.ednardo.loteca.mbean;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 

import org.primefaces.event.SelectEvent;
 
@ManagedBean
public class AutoCompleteView {
     
    private String txt1;
     
    private Date date3;
     
    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add(query + i);
        }
         
        return results;
    }
     
     
    public void onItemSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }
 
    public String getTxt1() {
        return txt1;
    }
 
    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }
    
    public Date getDate3() {
        return date3;
    }
 
    public void setDate3(Date date3) {
        this.date3 = date3;
    }
 
}