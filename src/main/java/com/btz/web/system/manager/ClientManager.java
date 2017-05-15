package com.btz.web.system.manager;

import com.btz.web.system.manager.pojo.Client;
import org.baron.framework.utils.ContextHolderUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 单例模式最佳实践
 * Created by User on 2017/5/15.
 */
public class ClientManager {

    //用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值。
    private static volatile ClientManager instance;

    private ConcurrentHashMap<String,Client> onlineClient = new ConcurrentHashMap<String, Client>();
    private ClientManager(){

    }
    public static ClientManager getInstance(){
        // 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
        if (instance == null) {
            //同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
            synchronized (ClientManager.class) {
                //未初始化，则初始instance变量
                if (instance == null) {
                    instance = new ClientManager();
                }
            }
        }
        return instance;
    }

    /**
     *
     * @param sessionId
     * @param client
     */
    public void addClinet(String sessionId,Client client){
        Client old=onlineClient.get(sessionId);
        if(old==null){
            onlineClient.putIfAbsent(sessionId, client);
        }else{
            onlineClient.replace(sessionId,old,client);
        }
    }

    /**
     * sessionId
     */
    public void removeClinet(String sessionId){
        onlineClient.remove(sessionId);
    }
    /**
     *
     * @param sessionId
     * @return
     */
    public Client getClient(String sessionId){
        return StringUtils.isEmpty(sessionId)?null:onlineClient.get(sessionId);
    }
    /**
     *
     * @return
     */
    public Client getClient(){
        return onlineClient.get(ContextHolderUtils.getSession().getId());
    }
    /**
     *
     * @return
     */
    public Collection<Client> getAllClient(){
        return onlineClient.values();
    }



}
