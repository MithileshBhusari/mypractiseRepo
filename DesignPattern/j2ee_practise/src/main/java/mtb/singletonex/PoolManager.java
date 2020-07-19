package mtb.singletonex;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author MithileshB
 * @created 19/07/2020 - 7:48 PM
 * @project DesignPattern
 */
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@DependsOn("Configuration")
@Startup
@Singleton
public class PoolManager {
    private Queue<Object> pooledObjects;

    @PostConstruct
    void constructExpensiveObjects(){
        pooledObjects=new LinkedBlockingQueue<>(1_000);
        for(int i=0;i<=1000;i++){
            pooledObjects.offer(new Object());
        }
    }

    @AccessTimeout(value = 30, unit = TimeUnit.SECONDS)
    @Lock(LockType.WRITE)
    public void returnObject(Object object){
        pooledObjects.offer(object);
    }

    @Lock(LockType.READ)
    public Object borrowObject(){
        return pooledObjects.poll();
    }
}
