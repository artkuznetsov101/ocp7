package ocp7.nio;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class OCPWatchService {
    public static void main(String args[]) {
        WatchService watchService = null;
        try {
            watchService = FileSystems.getDefault().newWatchService();
            Path dir1 = Paths.get("c:\\!");
            dir1.register(watchService, ENTRY_MODIFY, ENTRY_DELETE, ENTRY_CREATE);
            WatchKey watchKey = null;
            while (true) {
                watchKey = watchService.take();
                for (WatchEvent<?> watchEvent : watchKey.pollEvents()) {
                    WatchEvent.Kind<?> kind = watchEvent.kind();
                    Path path = ((WatchEvent<Path>) watchEvent).context();
                    if (kind == OVERFLOW) {
                        continue;
                    } else if (kind == ENTRY_CREATE) {
                        System.out.format("\nCreate - %s", path);
                    } else if (kind == ENTRY_MODIFY) {
                        System.out.format("\nModify - %s", path);
                    } else if (kind == ENTRY_DELETE) {
                        System.out.format("\nDelete - %s", path);
                    }
                }
                if (!watchKey.reset()) {
                    break;
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        } catch (InterruptedException ioe) {
            System.out.println(ioe.toString());
        } finally {
            try {
                watchService.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
