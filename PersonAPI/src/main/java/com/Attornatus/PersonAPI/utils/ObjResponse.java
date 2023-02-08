package com.Attornatus.PersonAPI.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class ObjResponse {
   public ObjResponse() {
      this.message="";
   }
   private String message;
}
