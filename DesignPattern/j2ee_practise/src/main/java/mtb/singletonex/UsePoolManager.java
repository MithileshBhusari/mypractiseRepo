package mtb.singletonex;

import javax.inject.Inject;

/**
 * @author MithileshB
 * @created 19/07/2020 - 8:03 PM
 * @project DesignPattern
 */
public class UsePoolManager {

    @Inject
    private PoolManager poolManager;

    public void usePooledObject(){
        Object object = poolManager.borrowObject();

        poolManager.returnObject(object);
    }

}
