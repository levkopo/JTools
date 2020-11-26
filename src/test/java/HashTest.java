import static com.github.levkoposc.Tools.*;

public class HashTest {

    public static void main(String[] args) {
        if(!file.addToFile("./file.txt", " world!"))
            println("I can't create file =(");
    }
}
