package base.client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * <h3>Hash类型数据demo</h3>
 * <br>┍╍╍hash-key╍╍╍╍╍╍╍hash╍╍┑
 * <br>┝╍╍╍╍╍╍╍╍╍╍┯╍╍╍╍╍╍╍╍╍╍╍╍┥
 * <br>╎ sub-key1 ╎  value1    ╎
 * <br>╎ sub-key2 ╎  value2    ╎
 * <br>┕╍╍╍╍╍╍╍╍╍╍┷╍╍╍╍╍╍╍╍╍╍╍╍┙
 * <br>method:
 * <br>1.hset(key,subKey,value)在散列key中添加键值对
 * <br>2.hget(key,subKey)获取散列key中指定散列的值
 * <br>3.hgetAll(key)获取散列中的所有键值对
 * <br>4.hdel(key,subKey)删除散列key中指定散列的值
 * <br>5.hdel(key)删除散列key
 * @Author: wymin
 */
public class HashTest {

    public static void main(String[] args){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);//最大连接数
        JedisPool pool = new JedisPool(config,"192.168.232.128",6379);
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            jedis.hset("hSets","subHSets","111");
            System.out.println(jedis.hget("hSets","subHSets"));
        }catch (Exception e){
            System.out.println("失败："+e);
        }finally {
            if(null!=jedis){
                jedis.close();
            }
        }
    }
}
