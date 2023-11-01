package edu.hw2.Task3;

public class DefaultConnectionManager implements ConnectionManager{

    @Override
    public Connection getConnection() {
        double rnd = Math.random() * 100;
        if (rnd > 80) {
            return new FaultyConnection();
        }
        return new StableConnection();
    }
}
