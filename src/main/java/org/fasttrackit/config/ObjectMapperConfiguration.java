package org.fasttrackit.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ObjectMapperConfiguration {


    //staticul se executa primul si apoi restu indiferent unde ar fi
    private static ObjectMapper objectMapper = new ObjectMapper();

    static { // bloc de cod de instanta asta e secont si apoi constructorii
        objectMapper.registerModule(new JavaTimeModule());

    }

// facem doar getter si setteru il facem noi ca sa nu fie modificat
    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
