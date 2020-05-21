package liner.linked;

/**
 * Created on 2020-05-21
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class SNode<T> {
    T value;
    SNode<T> next;

    public SNode(){
        this(null);
    }

    public SNode(T value){
        this(value,null);
    }

    public SNode(T value, SNode<T> next){
        this.value = value;
        this.next = next;
    }
}
