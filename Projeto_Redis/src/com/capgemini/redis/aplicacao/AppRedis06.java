package com.capgemini.redis.aplicacao;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Connection;

public class AppRedis06 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://default:DonYs4tlZbfRW8Q3YQjTDOGzzBiwtk4F@redis-18456.c282.east-us-mz.azure.cloud.redislabs.com:18456");
        Connection connection = jedis.getConnection();

        String chave = "resultado:30-08-2023:prova";
        String[] notas = { "8.5", "5.0" };
        
        // Armazenando diferentes valores sob a mesma chave: comando HSET
        // Não podemos usar chaves existentes, criadas sem o hash
        long resultado1 = jedis.hset(chave, "aprovado", notas[0]);
        long resultado2 = jedis.hset(chave, "reprovado", notas[1]);
        
        String mensagem = String.format("Resultado 1: %d, Resultado 2: %d", resultado1, resultado2);
        System.out.println(mensagem);
        
        // apresentando os valores associados a cada hash da chave informada.
        String aprovado = jedis.hget(chave, "aprovado");
        String reprovado = jedis.hget(chave, "reprovado");
        
        System.out.println("Aluno aprovado com nota " + aprovado);
        System.out.println("Aluno reprovado com nota " + reprovado);
        
        jedis.close();
        connection.close();
    }
}
