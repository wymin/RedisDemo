package base.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * String类型数据demo
 * @Author: wymin
 * @Date: 11:24 2018/2/27
 */
public class StringTest {

    public static void main(String[] args){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);//最大连接数
        JedisPool pool = new JedisPool(config,"192.168.232.128",6379);
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            jedis.set("name", "wym");
            System.out.println(jedis.get("name"));
        }catch (Exception e){
            System.out.println("失败："+e);
        }finally {
            if(null!=jedis){
                jedis.close();
            }
        }
    }

}
