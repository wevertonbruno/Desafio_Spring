package br.com.meli.grupo1.desafio_spring.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class Util para tratar leitura e escrita em arquivos Json
 * @author Weverton Bruno
 */
public class JsonUtil {

    private static ObjectMapper MAPPER = new ObjectMapper();

    /**
     * Ler um arquivo json e retorna uma instancia do tipo classType
     * @param path
     * @param classType
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T read(String path, Class<T> classType) throws IOException {
        return MAPPER.readValue(
                new URL(path), classType);
    }

    /**
     * Ler um arquivo json e retorna uma lista de instancias do tipo classType
     * @param path
     * @param classType
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> List<T> readAsList(String path, Class<T[]> classType) throws IOException {
        return new ArrayList<>(Arrays.asList(read(path, classType)));
    }

    /**
     * Salva um objeto da class T em um arquivo json no diretorio path
     * @param path
     * @param payload
     * @param <T>
     * @throws IOException
     */
    public static <T> void saveAsFile(String path, T payload) throws IOException {
        MAPPER.writeValue(new File(new URL(path).getFile()), payload);
    }
}
