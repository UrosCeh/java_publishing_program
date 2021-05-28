/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.ArrayList;

/**
 *
 * @author hatch
 */
public interface Repository<T> {
    public ArrayList<T> getAll(T t,String where, String orderby, String innerJoin) throws Exception;
    
    public T get(T t,String innerJoin ,String where) throws Exception;
    
    public boolean add(T t, String table, String columns, String values) throws Exception;
    
    public boolean update(T t, String values, String where)throws Exception;
    
    public boolean delete(T t,String table, String where)throws Exception;
    
    public void addWithGenKeys(T t, String table, String columns, String values) throws Exception;
}
