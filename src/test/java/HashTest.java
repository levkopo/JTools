import com.github.levkoposc.Tools;

import java.util.function.Consumer;

public class HashTest extends Tools {

    public static void main(String[] args) {
        boolean bool = atomic(HashTest::get, (i)->{
            return i == 1;
        });

        println(bool);
    }

    public static boolean get(Consumer<Integer> consumer){
        consumer.accept(1);

        return true;
    }
}
