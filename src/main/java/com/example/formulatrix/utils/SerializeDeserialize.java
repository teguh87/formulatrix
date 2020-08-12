package com.example.formulatrix.utils;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import com.example.formulatrix.models.*;

public class SerializeDeserialize {

    public static Register xmlSerialize(String itemContent) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Register.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(itemContent);
        Register register = (Register) unmarshaller.unmarshal(reader);

        return register;
    }

    public static Register jsonSerialize(String itemContent) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // read json from item content
        Register register = mapper.readValue(itemContent, Register.class);
        return register;
    }

    public static String xmlDeserialize(Register reg) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Register.class);
        Marshaller m = context.createMarshaller();

        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

        StringWriter sw = new StringWriter();
        m.marshal(reg, sw);
        return sw.toString();
    }

    public static String jsonDeserialize(Register reg) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(reg);
    }

}