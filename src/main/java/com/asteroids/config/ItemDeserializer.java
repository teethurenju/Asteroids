package com.asteroids.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.asteroids.model.AsteroidsModel;
import com.asteroids.model.Astroid;
import com.asteroids.model.Links;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class ItemDeserializer extends StdDeserializer<AsteroidsModel> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1246090883959768443L;

	public ItemDeserializer() {
        this(null);
    }

    public ItemDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public AsteroidsModel deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Links links = objectMapper.readValue(String.valueOf(node.get("links")), new TypeReference<>() {
        });
        LinkedHashMap<String, ArrayList<Astroid>> near_earth_objects = objectMapper.readValue(String.valueOf(node.get("near_earth_objects")), new TypeReference<>() {
        });
        int element_count = node.get("element_count").asInt();
        return new AsteroidsModel(links, element_count, near_earth_objects);
    }

}
