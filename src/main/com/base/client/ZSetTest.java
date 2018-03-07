package base.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <h3>ZSet数据类型demo</h3>
 * <br>┍╍╍zset-key╍╍╍╍╍╍╍zset╍╍┑
 * <br>┝╍╍╍╍╍╍╍╍╍╍┯╍╍╍╍╍╍╍╍╍╍╍╍┥
 * <br>╎ member1  ╎      1     ╎
 * <br>╎ member2  ╎      2     ╎
 * <br>┕╍╍╍╍╍╍╍╍╍╍┷╍╍╍╍╍╍╍╍╍╍╍╍┙
 * method:
 * <br>1.zadd(key,number,value)添加一个有分值的键值对到key中
 * <br>2.zrange(key,startIndex,endIndex)根据所给的范围在有序集合中获取范围内的值
 * <br>3.zrangebyscore(key,minNumber,maxNumber)获取分值范围内的值
 * <br>3.zrem(key,value)如果值存在则删除
 * @Author: wymin
 */
public class ZSetTest {

    public static void main(String[] args){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);//最大连接数
        JedisPool pool = new JedisPool(config,"192.168.232.128",6379);
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            jedis.zadd("zset",1,"wym");
            System.out.println(jedis.get("zset"));
        }catch (Exception e){
            System.out.println("失败："+e);
        }finally {
            if(null!=jedis){
                jedis.close();
            }
        }
    }
}
