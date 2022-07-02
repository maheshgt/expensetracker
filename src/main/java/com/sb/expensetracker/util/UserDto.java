package com.sb.expensetracker.util;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private  String name;
    private String password;
    private String email;
    private Long age;
}
