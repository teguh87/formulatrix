package com.example.formulatrix.services;

import com.example.formulatrix.utils.*;

public interface IRegisterService {

    public void register(String itemName, String itemContent, int itemType) throws ItemTypeNotFoundException, IllegalOperationException, Exception;

    public String retrival(String itemName) throws Exception;

    public int getType(String itemName);
    
    public void deRegister(String itemName);
}