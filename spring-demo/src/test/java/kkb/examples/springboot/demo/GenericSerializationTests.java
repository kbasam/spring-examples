package kkb.examples.springboot.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import kkb.examples.springboot.demo.dto.generic.GenericRequest;
import kkb.examples.springboot.demo.dto.generic.SimpleDataPayload;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenericSerializationTests {

    @Test
    @SuppressWarnings("unchecked")
    public void testReadWrite() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        GenericRequest<SimpleDataPayload> request = new GenericRequest("xxx", new SimpleDataPayload("zzz"));
        String jsonData = objectMapper.writeValueAsString(request);

        assertNotNull(jsonData);

        GenericRequest genericRequest = objectMapper.readValue(jsonData, GenericRequest.class);
        assertNotNull(genericRequest);
        assertTrue(genericRequest.getData() instanceof SimpleDataPayload);
    }

}
