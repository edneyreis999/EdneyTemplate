package br.com.edney.project.alfa.TemplateGraphQL.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Document
public abstract class BaseEntity {
    @Id
    @Getter
    private String id;
}
