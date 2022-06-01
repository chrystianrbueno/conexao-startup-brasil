package br.unisinos.startup.connection.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectModel {
    @Id
    private String id;
    private String name;
    private String status;
    private String description;
}
