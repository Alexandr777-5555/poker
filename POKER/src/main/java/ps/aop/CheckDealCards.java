package ps.aop;

public class CheckDealCards {

    public void beforeDealCards(){

        System.out.println("перед раздачей");
    }


    public void afterDealCards(){
        System.out.println("после раздачи карт");
    }
}
