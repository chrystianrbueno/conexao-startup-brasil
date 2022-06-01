package br.unisinos.startup.connection.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvestorModel {
    private String id;
    private String name;
    private Integer age;
    private String city;
    private String username;
    private String password;
    private String mail;
}
