package br.unisinos.startup.connection.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectModel {
    private String id;
    private String name;
    private String status;
    private String description;
}
