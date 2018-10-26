package cs425.mp2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Scanner;


public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String... args) throws Exception {
        logger.info("Started at {}...", LocalDateTime.now());

        Scanner input = new Scanner(System.in);
        String cmd;
        Node node = new Node();
        while (true) {
            logger.info("Enter your command (id,list,join,leave): ");
            cmd = input.nextLine();
            logger.trace("User input: {}", cmd);
            switch (cmd.toLowerCase()) {
                case "id":
                    node.printId();
                    break;
                case "list":
                    node.printList();
                    break;
                case "join":
                    node.join();
                    break;
                case "leave":
                    node.leave();
                    break;
                default:
                    logger.warn("Use input invalid");
                    break;
            }
        }
    }
}
