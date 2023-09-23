package com.capgemini.redis.aplicacao;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Connection;

public class AppRedis07 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("redis://default:5taVgpR2Zf8hZOYAgzd2YJYXSPTSqpBh@redis-12813.c282.east-us-mz.azure.cloud.redislabs.com:12813");
        Connection connection = jedis.getConnection();

        // Armazenando coleções do tipo Map
        String cpfCliente = "12345678901";
        String nomeCliente = "Armarinhos Fernando";
        String telefone = "3266-1000";
        
        // Armazenando todos os dados em um único objeto: uso do Map<>
        Map<String, String> cliente = new HashMap<String, String>() {
			private static final long serialVersionUID = 7636297425612095237L;

			{
        		put("cpf", cpfCliente);
        		put("nome", nomeCliente);
        		put("telefone", telefone);
        	}
        };
        
        String chave = "cliente:" +cpfCliente + ":ativo";
        
        
        // armazenando Map no Redis: HMSET
        String resultado = jedis.hmset(chave, cliente);
        System.out.println(resultado);
        
        // retornando os campos do Map armazenado:
        List<String> campos = jedis.hmget(chave, "cpf", "nome");
        System.out.println(campos);
        
        jedis.close();
        connection.close();
    }
}
