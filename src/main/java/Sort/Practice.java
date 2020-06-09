package Sort;




public class Practice{

    private volatile static Practice instance = null;
    private Practice(){}
    public static Practice getInstance(){
        if (instance == null){
            synchronized (Practice.class){
                if (instance == null){
                    instance = new Practice();
                }
            }
        }
        return instance;
    }
}

class InnerSingleTon{
    private InnerSingleTon(){}
    public static InnerSingleTon getInstance(){ return inner.instance;}
    public static class inner{
        private static final InnerSingleTon instance = new InnerSingleTon();
    }
}
