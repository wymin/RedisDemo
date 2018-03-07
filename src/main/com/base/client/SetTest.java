package base.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * <h3>Set数据类型demo</h3>
 * method:
 * <br>1.sadd(key,value)给key添加值
 * <br>2.smembers(key)返回key中所有值
 * <br>3.sismember(key,value)判断元素是否存在key中
 * <br>4.srem(key,value)判断元素是否存在key中，若存在则删除
 * @Author: wymin
 */
public class SetTest {

    public static void main(String[] args){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);//最大连接数
        JedisPool pool = new JedisPool(config,"192.168.232.128",6379);
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            jedis.sadd("sets","1");
            System.out.println(jedis.get("sets"));
        }catch (Exception e){
            System.out.println("失败："+e);
        }finally {
            if(null!=jedis){
                jedis.close();
            }
        }
    }
}
