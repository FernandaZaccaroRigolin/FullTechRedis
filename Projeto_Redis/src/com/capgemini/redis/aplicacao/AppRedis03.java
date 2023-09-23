package com.capgemini.redis.aplicacao;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Connection;

public class AppRedis03 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://default:DonYs4tlZbfRW8Q3YQjTDOGzzBiwtk4F@redis-18456.c282.east-us-mz.azure.cloud.redislabs.com:18456");
        Connection connection = jedis.getConnection();

        // Adicionando mais de uma chave
        // comando MSET
        
        String chave1 = "empresa:cliente";
        String valor1 = "Capgemini";
        
        String chave2 = "empresa:escola";
        String valor2 = "Impacta";
        
        String chave3 = "turma:java";
        String valor3 = "26 alunos (colaboradores)";        
        
        String resultado = jedis.mset(
        		chave1, valor1, 
        		chave2, valor2,
        		chave3, valor3);
        
        System.out.println(resultado);
        
        jedis.close();
        connection.close();
    }
}

