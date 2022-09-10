package ar.main.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class Main {

  public static void main(String[] args) {
    // sudo docker run -d --name some-redis -p 6379:6379 redis
    // sudo docker stop some-redis
    // sudo docker start some-redis
    // sudo docker restart some-redis
    // sudo docker rm some-redis
    // docker ps -a (para ver los stopeados tambien)

    // docker network create -d bridge redisnet
    // sudo docker run -d --name some-redis -p 6379:6379 --network redisnet redis
    // sudo docker run -it --network redisnet --rm redis redis-cli -h some-redis

    // Jedis jedis = new Jedis("localhost", 6379); // 6379 por by default
    // jedis.set("events/city/rome", "32,15,223,828");

    // String cachedResponse = jedis.get("events/city/rome");
    // System.out.println(cachedResponse);

    Jedis jedis = new Jedis("localhost", 6379);

//    jedis.sadd("planets", "Venus");
//    jedis.sismember("planets", "Venus");
//    jedis.lpush("k1", "12", "13", "14");

    Transaction tx = jedis.multi();
    tx.set("a1", "bla");
    tx.set("a2", "ble");
    tx.exec();

  }

}
