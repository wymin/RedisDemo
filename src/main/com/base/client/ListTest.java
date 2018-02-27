package base.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * <h3>List数据类型demo</h3>
 * method：
 * <br>1.rpush(key,value)往集合右边推一个值
 * <br>2.lpush(key,value)往集合左边推一个值
 * <br>3.rpop(key)获取集合最右端的值
 * <br>4.lpop(key)获取集合最左端的值
 * <br>5.lrange(key,startIndex,endIndex)获取给定范围内的值,(0,-1)为所有
 * <br>6.lindex(key,index)获取指定位置的值
 * @Author: wymin
 */
public class ListTest {

    public static void main(String[] args){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);//最大连接数
        JedisPool pool = new JedisPool(config,"192.168.232.128",6379);
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            jedis.rpush("str","1");
            System.out.println(jedis.lrange("str",0,-1));
        }catch (Exception e){
            System.out.println("失败："+e);
        }finally {
            if(null!=jedis){
                jedis.close();
            }
        }
    }
}
