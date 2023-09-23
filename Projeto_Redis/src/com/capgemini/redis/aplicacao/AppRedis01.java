package com.capgemini.redis.aplicacao;
import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;

public class AppRedis01 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://default:DonYs4tlZbfRW8Q3YQjTDOGzzBiwtk4F@redis-18456.c282.east-us-mz.azure.cloud.redislabs.com:18456");
        Connection connection = jedis.getConnection();

        System.out.println(jedis.echo("Apresentando o Jedis:"));
        
        // obtendo e apresentando o valor associado a uma chave
        String valor = jedis.get("empresa");
        System.out.println("empresa: " + valor);
        
        jedis.close();
        connection.close();
    }
}
