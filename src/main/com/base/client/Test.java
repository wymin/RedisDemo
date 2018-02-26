package base.client;

import redis.clients.jedis.Jedis;

public class Test {

    public static void main(String[] args){
        try{
            Jedis jedis = new Jedis("192.168.232.128",6379);
            jedis.set("name", "wym");
            System.out.println(jedis.get("name"));
            jedis.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
