package com.spark.custompatterns.utils;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.ho.yaml.YamlDecoder;
import org.ho.yaml.YamlStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.spark.custompatterns.model.Declaration;
import com.spark.custompatterns.model.JobConfig;

public class ParserService  {
public static  <T extends DataInputStream, B extends Declaration> B parseSingleDeclarationStream(T inputStream,
		Class<B> className) throws IOException {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

    B message = gson.fromJson(reader, className);


    reader.close();
    return message;
}

public static <T extends JobConfig> List<T> getLocalFSJobList(String path,
		Class<T> className) throws FileNotFoundException {
    List<T> list = new ArrayList<>();
    DataInputStream dataStream = new DataInputStream(
            new FileInputStream(path));
    YamlDecoder dec = new YamlDecoder(dataStream);
    YamlStream<T> stream = dec.asStreamOfType(className);
    while (stream.hasNext()) {
        T item = stream.next();
        list.add(item);
    }
    return list;

}

}
