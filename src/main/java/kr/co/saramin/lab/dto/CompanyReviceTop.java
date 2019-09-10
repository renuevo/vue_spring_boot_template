package kr.co.saramin.lab.dto;

import lombok.Data;

@Data
public class CompanyReviceTop {
    String word;
    String count = "0";

    public void addCount(){
        int countInt = Integer.parseInt(this.count);
        countInt+=1;
        count = String.valueOf(countInt);
    }
}
