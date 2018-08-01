package com.example.demo.util;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonHelper {
	private ObjectMapper mapper;

	public JsonHelper() {
		mapper = new ObjectMapper();
//		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public JsonHelper(JsonInclude.Include include) {
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(include);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public String toJson(Object object) throws JsonProcessingException {
		return mapper.writeValueAsString(object);
	}

	public <T> T fromJson(String json, Class<T> cls) throws Exception{
		return mapper.readValue(json, cls);
	}

	public <T> T fromJson(String json, @SuppressWarnings("rawtypes") TypeReference valueTypeRef) throws IOException {
		return mapper.readValue(json, valueTypeRef);
	}
}
