package com.czg.ajcp.ch04.connection;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author chenzg
 * @date 2019.01.14 13:14
 * @description
 **/
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i =0; i< initialSize;i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(Long mills) throws Exception{
        synchronized (pool){
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            }else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;

                if (!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }

        }
    }
}
