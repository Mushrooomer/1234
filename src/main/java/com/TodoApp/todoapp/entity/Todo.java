package com.TodoApp.todoapp.entity;




import javax.persistence.*;



@Entity
@Table(name = "TODOs")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "day", nullable = false)
    private String day;

    @Column(name = "time", nullable = false)
    private String time;

    public Todo() {
    }

    public Todo(long id, String title, String day, String time) {
        this.id = id;
        this.title = title;
        this.day = day;
        this.time = time;
    }

    public Todo(String title, String day, String time) {
        this.title = title;
        this.day = day;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
