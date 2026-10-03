package com.realstate.RS.thread;

public class PropertyTransactionThread implements Runnable {

    private static int transactionCount = 0;

    private final String tenantName;

    public PropertyTransactionThread(String tenantName) {
        this.tenantName = tenantName;
    }

    // synchronized prevents two threads from updating
    // transactionCount at the same time
    private static synchronized void processTransaction(
            String tenantName) {

        transactionCount++;

        System.out.println(
                "Transaction processed for: "
                + tenantName
                + " | Transaction No: "
                + transactionCount
                + " | Thread: "
                + Thread.currentThread().getName()
        );
    }

    @Override
    public void run() {

        processTransaction(tenantName);
    }

    public static void main(String[] args) {

        Thread tenant1 =
                new Thread(
                        new PropertyTransactionThread("Tenant 1"),
                        "Tenant-Thread-1"
                );

        Thread tenant2 =
                new Thread(
                        new PropertyTransactionThread("Tenant 2"),
                        "Tenant-Thread-2"
                );

        Thread tenant3 =
                new Thread(
                        new PropertyTransactionThread("Tenant 3"),
                        "Tenant-Thread-3"
                );

        tenant1.start();
        tenant2.start();
        tenant3.start();

        try {
            tenant1.join();
            tenant2.join();
            tenant3.join();
        } catch (InterruptedException e) {

            System.out.println(
                    "Thread interrupted: "
                    + e.getMessage()
            );
        }

        System.out.println(
                "Total Transactions: "
                + transactionCount
        );
    }
}