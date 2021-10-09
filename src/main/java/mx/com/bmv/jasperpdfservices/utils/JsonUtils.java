package mx.com.bmv.jasperpdfservices.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonUtils<T> {
    public ObjectNode convertToObjectNodeWithNull(String jsonName, T object) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode result = mapper.createObjectNode();
        result.set(jsonName, mapper.convertValue(object, JsonNode.class) );
        return result;
    }
}

