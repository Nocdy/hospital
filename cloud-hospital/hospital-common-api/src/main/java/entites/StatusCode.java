package entites;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * 描述业务状态码
 *
 * @author Nocdy
 * @date 2021年 09月07日 12:19:48
 */

@Component
public class StatusCode {

    public enum Status{
        //业务失败
       ERROR(1001,"业务失败"),
       //业务成功
       SUCCESS(1002,"业务成功");

       private  int code;
       private String message;
       Status(int code,String message){
            this.code=code;
            this.message=message;
       }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
