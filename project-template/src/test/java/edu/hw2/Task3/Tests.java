package edu.hw2.Task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {

    @Test
    @DisplayName("DefaultConnectionManager - Connection")
    void getDefaultConnectionManage() {
        ConnectionManager connectionManager = new DefaultConnectionManager();
        assertThat(connectionManager.getConnection()).isInstanceOf(Connection.class);
    }

    @Test
    @DisplayName("FaultyConnectionManager - FaultyConnection")
    void getFaultyConnectionManager() {
        ConnectionManager connectionManager = new FaultyConnectionManager();
        assertThat(connectionManager.getConnection()).isInstanceOf(FaultyConnection.class);
    }
}
