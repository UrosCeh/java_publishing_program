/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.communication;

import domain.classes.Autor;
import java.io.Serializable;

/**
 *
 * @author hatch
 */
public class Request implements Serializable {
    Operation operation;
//    String arguments;
    Object object;
    Autor autor;
    
    public Request() {
    }

    public Request(Operation operation, Object object, Autor autor) {
        this.operation = operation;
        this.object = object;
        this.autor = autor;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
//
//    public String getArguments() {
//        return arguments;
//    }
//
//    public void setArguments(String arguments) {
//        this.arguments = arguments;
//    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
