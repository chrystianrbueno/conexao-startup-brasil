package br.unisinos.startup.connection.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntrepreneurModel {
    String id;
    String name;
    Integer age;
    String city;
    String username;
    String password;
    String mail;
}
