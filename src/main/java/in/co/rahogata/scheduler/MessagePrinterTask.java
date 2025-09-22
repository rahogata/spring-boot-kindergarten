package in.co.rahogata.scheduler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessagePrinterTask implements Runnable {

	private final String message;

    public void run() {
        System.out.println(message);
    }

}
