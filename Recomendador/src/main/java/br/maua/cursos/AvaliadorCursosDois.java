package br.maua.cursos;

import br.maua.Recomendador;
import br.maua.RecomendadorBuilder;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

import java.io.IOException;

public class AvaliadorCursosDois {

    public static void main(String[] args) throws IOException, TasteException {

        // Fixa o valor randômico da análise
        RandomUtils.useTestSeed();  // Impede que a média mude. Será sempre o mesmo valor

        // Modelo de Análise
        DataModel cursos = new Recomendador().getModeloDeCursosDois();

        RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
        // Construtor de Recomendações
        RecommenderBuilder builder = new RecomendadorBuilder();
        // 90% para treinar e 10% para testar
        double error = evaluator.evaluate(builder, null, cursos, 0.9, 1.0);

        System.out.println(error);
    }
}

