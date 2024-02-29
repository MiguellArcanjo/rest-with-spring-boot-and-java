package br.com.erudio.restwithspringbootandjava;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Greeting {

    private final long id;
    private final String content;

}
