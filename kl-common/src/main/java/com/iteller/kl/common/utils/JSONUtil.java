package com.iteller.kl.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iteller.kl.common.enums.KlExceptionEnums;
import com.iteller.kl.common.exception.KlException;

import java.io.IOException;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 20:17
 * description:
 */
public class JSONUtil {

    public static <T> T toObj(String json, TypeReference<T> type) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            throw new KlException(KlExceptionEnums.JSON_EXCEPTION, e);
        }
    }

    public static String toStr(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new KlException(KlExceptionEnums.JSON_EXCEPTION, e);
        }
    }

    /**
     * jsonNode
     * @param jsonStr
     * @param childKey
     * @return
     */
    public static JsonNode childJsonNode(String jsonStr, String childKey){
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(jsonStr);
            return rootNode.path(childKey);
        } catch (IOException e) {
            throw new KlException(KlExceptionEnums.JSON_EXCEPTION, e);
        }
    }
}
