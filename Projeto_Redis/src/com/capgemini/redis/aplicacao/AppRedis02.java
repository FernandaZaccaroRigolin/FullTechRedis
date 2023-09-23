package com.capgemini.redis.aplicacao;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Connection;

public class AppRedis02 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://default:DonYs4tlZbfRW8Q3YQjTDOGzzBiwtk4F@redis-18456.c282.east-us-mz.azure.cloud.redislabs.com:18456");
        Connection connection = jedis.getConnection();

        String chave = "empresa:nome"; // chave usada no programa
        
        // adicionando uma nova chave
        String resultado = jedis.set(chave, "Cagemini S/A.");
        System.out.println(resultado);
        
        System.out.println(jedis.get(chave));
        
        // removendo a chave criada anteriormente
        long removeu = jedis.del("empresa");
        System.out.println("Removeu 'empresa'? " + removeu);
        
        jedis.close();
        connection.close();
    }
}

