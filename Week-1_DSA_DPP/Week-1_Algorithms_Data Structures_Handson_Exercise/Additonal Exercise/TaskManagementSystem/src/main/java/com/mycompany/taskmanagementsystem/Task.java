package com.mycompany.taskmanagementsystem;
class Task {
    int taskId;
    String taskName;
    String status;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    void display() {
        System.out.println(taskId + " | " + taskName + " | " + status);
    }
}
