package me.code.webservicesspringbootcaching;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    private String name;

    private String description;
    private boolean completed;

}
