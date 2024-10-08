package io.temporal.samples.moneytransfer.helper;

import java.util.HashMap;
import java.util.Map;

public class ServerInfo {

    public static String getCertPath() {
        return System.getenv("TEMPORAL_CERT_PATH") != null ? System.getenv("TEMPORAL_CERT_PATH") : "";
    }

    public static String getKeyPath() {
        return System.getenv("TEMPORAL_KEY_PATH") != null ? System.getenv("TEMPORAL_KEY_PATH") : "";
    }

    public static String getNamespace() {
        String namespace = System.getenv("TEMPORAL_NAMESPACE");
        return namespace != null && !namespace.isEmpty() ? namespace : "default";
    }

    public static String getAddress() {
        String address = System.getenv("TEMPORAL_ADDRESS");
        return address != null && !address.isEmpty() ? address : "localhost:7233";
    }

    public static String getTaskqueue() {
        String taskqueue = System.getenv("TEMPORAL_MONEYTRANSFER_TASKQUEUE");
        return taskqueue != null && !taskqueue.isEmpty() ? taskqueue : "MoneyTransfer";
    }

    public static int getWorkflowSleepDuration() {
        String workflowSleepDurationString = System.getenv("TEMPORAL_MONEYTRANSFER_SLEEP");
        int workflowSleepDuration = 0;
        if (workflowSleepDurationString != null && !workflowSleepDurationString.isEmpty()) {
            try {
                workflowSleepDuration = Integer.parseInt(workflowSleepDurationString);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing environment variable as an integer: " + e.getMessage());
            }
        }
        return workflowSleepDuration != 0 ? workflowSleepDuration : 5;
    }

    public static Map<String, String> getServerInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("certPath", getCertPath());
        info.put("keyPath", getKeyPath());
        info.put("namespace", getNamespace());
        info.put("address", getAddress());
        info.put("taskQueue", getTaskqueue());
        return info;
    }
}
