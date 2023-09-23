package com.capgemini.redis.aplicacao;

import redis.clients.jedis.Jedis;

import java.util.Set;

import redis.clients.jedis.Connection;

class FiltroNotas {
	public Set<String> filtrarResultados(int mes, int ano) {
		String chave = "resultado:*-%02d-%04d:prova";
        Jedis jedis = new Jedis("redis://default:DonYs4tlZbfRW8Q3YQjTDOGzzBiwtk4F@redis-18456.c282.east-us-mz.azure.cloud.redislabs.com:18456");
        Connection connection = jedis.getConnection();
        
        Set<String> resultado = jedis.keys(String.format(chave, mes, ano));
        
        if(resultado.size() > 0) {
        	for(String ch : resultado) {
        		System.out.println(String.format("%s -> %s", ch, jedis.get(ch)));
        	}
        }
        
        
        jedis.close();
        connection.close();
        
        return resultado;
	}
}

public class AppRedis05 {
	public static void main(String[] args) {
		int mes = 9;
		int ano = 2023;
		
		Set<String> chaves = new FiltroNotas().filtrarResultados(mes, ano);
		System.out.println(chaves);
	}
}





