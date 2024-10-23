package edu.my.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {
    private String name;
    private String age;
    private String contact;
    private String guardianName;
    private String address;
    private String guardianContact;
}
