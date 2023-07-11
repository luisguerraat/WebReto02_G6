package com.grupog6.sbconmongodb.Documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Books")
public class Book {
    @Id
    private String id;
    private String name;
    private Integer pages;
    private String author;
    private Double cost;


}
