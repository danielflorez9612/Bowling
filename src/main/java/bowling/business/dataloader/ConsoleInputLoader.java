package bowling.business.dataloader;

import lombok.extern.log4j.Log4j2;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleInputLoader implements InputLoader {
    private Scanner scanner;
    public ConsoleInputLoader() {
        scanner = new Scanner(System.in);
        System.out.println("Please enter a player");
    }

    @Override
    public boolean hasNextInput() {
        return scanner.hasNextLine();
    }

    @Override
    public String getLine() {
        String line = scanner.nextLine();
        if (Objects.equals(line, "end"))
            return null;
        return line;
    }

    @Override
    public void finish() {
        scanner.close();
    }
}
