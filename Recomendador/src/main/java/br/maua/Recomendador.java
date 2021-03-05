package br.maua;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

import java.io.File;
import java.io.IOException;

public class Recomendador {

    public DataModel getModelo(String path) throws IOException {
        File file = new File(path);
        return new FileDataModel(file);
    }

    public DataModel getModeloDeProdutos() throws IOException {
        return getModelo("dados.csv");
    }

    public DataModel getModeloDeCursos() throws IOException {
        return getModelo("cursos.csv");
    }
}
