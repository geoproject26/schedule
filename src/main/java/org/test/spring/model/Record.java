package org.test.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "event")
    private String event;

    @Column(name = "time")
    private String time;

    @Column(name = "priority")
    private String priority;

    @Override
    public String toString() {
        return "Records{" +
                "id=" + id +
                ", event='" + event + '\'' +
                ", time='" + time + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}