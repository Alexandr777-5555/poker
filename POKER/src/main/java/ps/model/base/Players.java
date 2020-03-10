package ps.model.base;

import java.util.List;

public class Players {

    private List<Player> list;

    public Players() {
    }

    public Players(List<Player> list) {
        this.list = list;
    }

    public List<Player> getList() {
        return list;
    }

    public void setList(List<Player> list) {
        this.list = list;
    }
}
