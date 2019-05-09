/**
 * Created by Martin on 2019/5/1.
 */
public class myThread extends Thread {
    Integer index;
    private static Integer ticketNum = 1000;
    public static String str = new String("");

    public myThread(Integer index) {
        this.index = index;
    }

    @Override
    public void run() {
        boolean flag = true;

        while (flag) {
            try {
                Thread.sleep(500L);
            }catch (Exception e){

            }
            int i = getTicketNum() - 1;
            synchronized (str){
                if (i > 0) {
                    System.out.println("第" + getIndex() + "个线程卖出了第" + i + "张票");
                    setTicketNum(i);
                }
            }


        }
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }
}
