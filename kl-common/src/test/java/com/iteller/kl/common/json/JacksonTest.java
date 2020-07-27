package com.iteller.kl.common.json;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author iTeller_zc (zhangchao@elextec.com)
 * @date 2020/7/27 19:12
 * description
 **/
public class JacksonTest {

    @Test
    public void testJsonGenerator() throws IOException {
        JsonFactory factory = new JsonFactory();

        //auto close sample
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)){
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", "iTeller");
            jsonGenerator.writeStringField("age", "30");
            jsonGenerator.writeEndObject();
        }

        //same as
       /* JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8);
        try{
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", "iTeller");
            jsonGenerator.writeStringField("age", "30");
            jsonGenerator.writeEndObject();
        }finally {
            jsonGenerator.close();
        }*/
    }

    @Test
    public void testWriteJsonKey() throws IOException {
        JsonFactory factory = new JsonFactory();

        //auto close sample
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)){
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName("keyName");
            jsonGenerator.writeEndObject();
        }

    }

    @Test
    public void testWriteJsonValue() throws IOException {
        JsonFactory factory = new JsonFactory();

        //auto close sample
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)){
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName("age");
            jsonGenerator.writeNumber(30);
            jsonGenerator.writeEndObject();
        }

    }

    @Test
    public void testWriteJson() throws IOException {
        JsonFactory factory = new JsonFactory();

        //auto close sample
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)){
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", "iTeller_zc");

            //json
            jsonGenerator.writeFieldName("person");
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName("nickName");
            jsonGenerator.writeString("zc");
            jsonGenerator.writeEndObject();

            jsonGenerator.writeEndObject();
        }
    }

    @Test
    public void testWriteJsonArray() throws IOException {
        JsonFactory factory = new JsonFactory();

        //auto close sample
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)){
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", "iTeller_zc");

            //json array
            jsonGenerator.writeFieldName("arrays");
            jsonGenerator.writeStartArray();

            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName("nickName");
            jsonGenerator.writeString("zc");
            jsonGenerator.writeEndObject();

            jsonGenerator.writeEndArray();

            jsonGenerator.writeEndObject();
        }
    }

    @Test
    public void testWriteJsonArray2() throws IOException {
        JsonFactory factory = new JsonFactory();

        //auto close sample
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)){
            jsonGenerator.writeStartObject();

            //json array
            jsonGenerator.writeFieldName("arrays");
            jsonGenerator.writeArray(new int[]{1,2,3,4,5}, 2,3 );


            jsonGenerator.writeEndObject();
        }
    }

    @Test
    public void testWriteNull() throws IOException {
        JsonFactory factory = new JsonFactory();

        //auto close sample
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)){
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", "iTeller");
            jsonGenerator.writeFieldName("age");
            jsonGenerator.writeNull();

            jsonGenerator.writeEndObject();
        }
    }
}
