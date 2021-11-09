package com.drm.learning.javatokt.domain.java;

import java.util.Date;
import lombok.Data;

@Data
public class PersonJava {
  private String name;
  private String address;
  private String zipCode;
  private Integer age;
  private Date birthDate;
}
