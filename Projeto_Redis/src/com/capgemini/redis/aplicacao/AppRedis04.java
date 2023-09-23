package com.capgemini.redis.aplicacao;

import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;

public class AppRedis04 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://default:DonYs4tlZbfRW8Q3YQjTDOGzzBiwtk4F@redis-18456.c282.east-us-mz.azure.cloud.redislabs.com:18456");
        Connection connection = jedis.getConnection();

        String dataProva1 = "31-08-2023";
        String dataProva2 = "28-08-2023";
        String dataProva3 = "04-09-2023";
        String dataProva4 = "07-09-2023";

        String[] datas = { dataProva1, dataProva2, dataProva3, dataProva4 };        
        String[] notas = { "8.5", "6.5", "10.0", "9.0" };        
        String[] chaves = new String[4];
        
        // definindo valores para as chaves 
        for (int i = 0; i < chaves.length; i++) {
			chaves[i] = String.format("resultado:%s:prova", datas[i]);
			
			// armazenando valores para cada chave
			System.out.println(jedis.set(chaves[i], notas[i]));

		}
        
        jedis.close();
        connection.close();
    }
}

