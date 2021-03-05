package br.maua;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

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
        DataModel produtos = new Recomendador().getModeloDeProdutos();
        // Recomendador
        Recommender recommender = new RecomendadorDeProdutosBuilder().buildRecommender(produtos);

        // Recomendando no máximo 3 items para o usuário 2
        List<RecommendedItem> recommendations = recommender.recommend(2, 3);
        for ( RecommendedItem recommendation : recommendations ) {
            System.out.println(recommendation);
        }
    }
}
