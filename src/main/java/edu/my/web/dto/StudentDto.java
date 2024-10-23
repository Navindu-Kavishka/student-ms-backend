package edu.my.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class StudentDto {
    private int id;
    private String name;
    private String age;
    private String contact;
    private String guardianName;
    private String address;
    private String guardianContact;
}
