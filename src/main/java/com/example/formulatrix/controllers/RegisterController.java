package com.example.formulatrix.controllers;

import com.example.formulatrix.dto.ContentDTO;
import com.example.formulatrix.services.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.http.HttpStatus;

import com.example.formulatrix.utils.*;

import org.springframework.http.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;

@RestController
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    public IRegisterService registerService;

    @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity register(ContentDTO content){  
        try {
            registerService.register(content.getItemName(), content.getItemContent(), content.getItemType());
            return ResponseEntity.ok().build();
        } catch (ItemTypeNotFoundException | IllegalOperationException e) {
            logger.info(DisplayException.getStackTrace(e));
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(DisplayException.getStackTrace(e));
        } catch (Exception e) {
            logger.info(DisplayException.getStackTrace(e));
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(DisplayException.getStackTrace(e));
        }
    }

    @GetMapping("/register/retrival/{itemName}")
    public ResponseEntity retrival(@PathVariable String itemName){
       try {
          return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(registerService.retrival(itemName));
       } catch (Exception e) {
          logger.info(DisplayException.getStackTrace(e));
          return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(DisplayException.getStackTrace(e));
          }
    }

    @GetMapping("/register/itemType/{itemName}")
    public ResponseEntity getItemType(@PathVariable String itemName) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(registerService.getType(itemName));
    }

    @DeleteMapping("/register/unregister/{itemName}")
    public ResponseEntity deRegister(@PathVariable String itemName) {
        try {
            registerService.deRegister(itemName);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.info(DisplayException.getStackTrace(e));
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(DisplayException.getStackTrace(e));
            
        }
    }
}