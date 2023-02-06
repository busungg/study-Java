package ch13.code;

class ThreadEx12 {
    public static void main(String[] args) {
        ThreadEx12_1 th1 = new ThreadEx12_1();
        ThreadEx12_2 th2 = new ThreadEx12_2();
        th1.start();
        th2.start();

        try {
            th1.sleep(2000);
        } catch(InterruptedException ex) {}

        System.out.print("<<main종료>>");

    }
}

class ThreadEx12_1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300; i++) {
            System.out.print("-");
        }
        System.out.print("<<th1 종료>>");
    }
}

class ThreadEx12_2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300; i++) {
            System.out.print("|");
        }
        System.out.print("<<th2 종료>>");
    }
}

/*
 * th1이 2초 동안 작업을 멈추고 일시정지 상태에 있도록 하였으니까
 * 쓰레드 th1이 가장 늦게 종료되어야 하는데 결과에서는 제일 먼저 종료되었다.
 * 그 이유는 sleep()이 항상 현재 실행 중인 쓰레드에 대해 작동하기 때문이다.
 * th1.sleep과 같이 호출하였어도 실제로 영향을 받는 것은 main 메서드를 실행하는 main 쓰레드이다.
 * 그래서 sleep()은 static으로 선언되어 있으며 참조변수를 이용해서 호출하기 보다는
 * Thread.sleep(2000);과 같이 해야 한다.
 * 
 * 
 */