package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private static final Logger LOGGER = LogManager.getLogger();
    private final ConnectionManager manager;
    private final int maxAttempts;

    private static ConnectionException exc = null;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        for (int attempts = 0; attempts < maxAttempts; attempts++) {
            try (Connection connection = manager.getConnection()) {
                if (connection instanceof StableConnection) {
                    connection.execute(command);
                    return;
                }
            } catch (Exception e) {
                if (exc != null) {
                    e.addSuppressed(exc);
                    exc.printStackTrace();
                    e.printStackTrace();
                } else {
                    exc = (ConnectionException) e;
                    e.printStackTrace();
                }
            }
        }
        manager.getConnection();

    }
}
