package org.acme;

import javax.json.bind.annotation.JsonbPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonbPropertyOrder({"id", "nombre","extension","borrable"})
public class Documento {
    public int id;
    public String nombre;
    public String extension;
    public boolean borrable;

    @Override
    public String toString(){
        return "{\"id\":"+id+"\"nombre\":\""+nombre+"\", \"extension\":\""+extension+"\", \"borrable\": "+borrable+"\"}";
    }
}
