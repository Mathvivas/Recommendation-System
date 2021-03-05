package br.maua;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*
    4 Usuários
    9 items avaliados

    1º coluna: Usuário
    2º coluna: Items
    3º coluna: Avaliação
*/

public class RecomendaProdutos {
    public static void main(String[] args) throws IOException, TasteException {
        File file = new File("dados.csv");
        // Modelo de Análise
        DataModel model = new FileDataModel(file);

        // Algoritmo de Similaridade
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        // Proximidade
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
        // Recomendador
        GenericUserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

        // Recomendando no máximo 3 items para o usuário 2
        List<RecommendedItem> recommendations = recommender.recommend(2, 3);
        for ( RecommendedItem recommendation : recommendations ) {
            System.out.println(recommendation);
        }
    }
}
