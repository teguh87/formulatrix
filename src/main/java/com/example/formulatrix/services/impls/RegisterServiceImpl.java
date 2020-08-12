package com.example.formulatrix.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import javax.xml.bind.UnmarshalException;


import com.example.formulatrix.models.*;
import com.example.formulatrix.entities.*;
import com.example.formulatrix.repositories.ContentRepository;
import com.example.formulatrix.services.IRegisterService;
import com.example.formulatrix.utils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class RegisterServiceImpl implements IRegisterService
{
    private static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);


    @Autowired
    private ContentRepository contentRepository; // need defined the data repository

    // @Autowired
    // private CacheManager cacheManager;

    /**
     * @param String itemName
     * @param String itemContent
     * @param int itemTypa
     * 
     * @return 
     * 
     * this used for saving the register item 
     * register must be saperated by two item types
     * the first one is Json 
     * and the second is xml 
     * we need validate if record has been exist 
     * if exist the item need valid as record type either it defined as json or xml
     * it can update if record item type same as the new register item 
     */
    @Override
    public void register (String itemName, String itemContent, int itemType) throws ItemTypeNotFoundException, 
        IllegalOperationException, UnmarshalException, Exception {
        Register register = null;
        if(itemType == 1) {
            register = SerializeDeserialize.jsonSerialize(itemContent);
        } else if (itemType == 2) {
            register = SerializeDeserialize.xmlSerialize(itemContent);
        } else {
            throw new ItemTypeNotFoundException("Item type not found");
        }
        
        if(register != null) {
            Optional<ContentEntity> optContent = contentRepository.findByItemName(itemName);
            if(optContent.isPresent()) {
                ContentEntity entity = (ContentEntity) optContent.get();
                RegisterEntity registerFounded = (RegisterEntity) entity.getItemContent();
                if(entity.getItemType() == itemType && !register.getEmail().equals(registerFounded.getEmail())) {
                    // content.setItemContent(register);
                    // contentRepository.save(content);   
                    registerFounded.setEmail(register.getEmail());
                    registerFounded.setFirstname(register.getFirstname());
                    registerFounded.setLastname(register.getLastname());
                    registerFounded.setAddress(register.getAddress());
                    registerFounded.setPassword(register.getPassword());
                    registerFounded.setPhoneNumber(register.getPhoneNumber());

                    entity.setItemContent(registerFounded);
                    contentRepository.save(entity); 
                } else {
                    throw new IllegalOperationException ("Could not overwrite item content");
                }
            } else {
                RegisterEntity registerEntity = new RegisterEntity();
                registerEntity.setEmail(register.getEmail());
                registerEntity.setFirstname(register.getFirstname());
                registerEntity.setLastname(register.getLastname());
                registerEntity.setAddress(register.getAddress());
                registerEntity.setPassword(register.getPassword());
                registerEntity.setPhoneNumber(register.getPhoneNumber());

                ContentEntity entity = new ContentEntity(itemName, registerEntity, itemType);
                
                contentRepository.save(entity); 

            }
        }
        
    }

    /**
     * @param String itemName
     * @return Content 
     * 
     * Retrived item content based on item name
     */
    @Cacheable(value = "contents")
    @Override
    public String retrival(String itemName) throws Exception {
        Optional<ContentEntity> optContent = contentRepository.findByItemName(itemName);
        if(optContent.isPresent()) {
           ContentEntity entity = (ContentEntity) optContent.get();
           logger.info("register: " + entity.toString());
           RegisterEntity registerEntity = entity.getItemContent();
           
           final Register register = new Register(
               registerEntity.getFirstname(),
               registerEntity.getLastname(),
               registerEntity.getEmail(),
               registerEntity.getPassword(),
               registerEntity.getPhoneNumber(),
               registerEntity.getAddress()
           );
           
           if(entity.getItemType().equals(1)) {
               return SerializeDeserialize.jsonDeserialize(register);
           } else {
               return SerializeDeserialize.xmlDeserialize(register);
           }
        }
        return null;
    }

    /**
     * @param String item name
     * @return int
     * 
     * Getting item type based on item name
     */
    @Override
    public int getType(String itemName) {
        Optional<ContentEntity> optContent = contentRepository.findByItemName(itemName);
        if(optContent.isPresent()) {
            ContentEntity content = (ContentEntity) optContent.get();
            return content.getItemType();
        }
        return 0;
    }

    /**
     * @param String itemName
     * 
     * Unregister the item content by deleting the item content 
     * based on item name
     */
    @CacheEvict(value = "contents")
    @Override
    public void deRegister(String itemName) {
        Long delete = contentRepository.deleteByItemName(itemName);
    }
}