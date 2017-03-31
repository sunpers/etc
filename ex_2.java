import java.util.*;
import java.util.concurrent.*;
import static java.util.Arrays.asList;

public class Sums {
    
    static class Sum implements Callable<Long> {
        private final String cmd;
            Sum(String cmd) {
            this.cmd = cmd;
        }
//run system cmd for lun action        
//like create/remove/modify etc
        @Override
        public Long call() {
	    Process ps = Runtime.getRuntime().exec(shpath); 
        }      
    }
    
    public static void main(String[] args) throws Exception {
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List <Future<Long>> results = executor.invokeAll(asList(
            new Sum("lun testcase1"), new Sum("lun testcase2")
        );
        executor.shutdown();
        
    }  
}

