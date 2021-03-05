package br.maua;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

import java.io.File;
import java.io.IOException;

public class Recomendador {

    public DataModel getModeloDeProdutos() throws IOException {
        File file = new File("dados.csv");
        return new FileDataModel(file);
    }
}
