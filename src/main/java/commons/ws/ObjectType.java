package commons.ws;

/**
 * Created by sara on 5/20/2016.
 */
public enum ObjectType {
    USER_DTO(0),DEVICE_DTO(1);
    private int type;
    private ObjectType(int type){this.type=type;}
    public static ObjectType valueOf(int value) {
        return ObjectType.values()[value];
    }
}
