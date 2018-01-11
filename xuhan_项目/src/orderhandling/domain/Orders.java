package orderhandling.domain;

public class Orders {
    private int oid;
    private int state;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", state=" + state +
                '}';
    }

    public Orders() {
    }
}
