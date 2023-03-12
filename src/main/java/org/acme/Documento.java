package org.acme;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Documento {
    public String nombre;
    public String extension;
    public boolean borrable;

    @Override
    public String toString(){
        return "{\"nombre\":\""+nombre+"\", \"extension\":\""+extension+"\", \"borrable\": "+borrable+"\"}";
    }
}
