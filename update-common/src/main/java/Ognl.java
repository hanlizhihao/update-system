import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * Created by
 * User: fengjian
 * Date: 2014/12/25
 * Time: 19:36
 */
public class Ognl {

    /**
     * test for Map,Collection,String,Array isEmpty
     * @param o
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object o) throws IllegalArgumentException {
        if(o == null) return true;

        if(o instanceof String) {
            if(((String)o).length() == 0){
                return true;
            }
        } else if(o instanceof Collection) {
            if(((Collection)o).isEmpty()){
                return true;
            }
        } else if(o.getClass().isArray()) {
            if(Array.getLength(o) == 0){
                return true;
            }
        } else if(o instanceof Map) {
            if(((Map)o).isEmpty()){
                return true;
            }
        }else {
            return false;
        }

        return false;
    }

    /**
     * test for Map,Collection,String,Array isNotEmpty
     * @param o
     * @return
     */
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    public static boolean isNotNull(Object o){
        return o != null;
    }

    public static void main(String[] args) {
        System.out.println(isNotNull(""));
    }
}
