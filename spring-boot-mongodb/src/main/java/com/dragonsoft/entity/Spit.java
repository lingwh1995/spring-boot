package com.dragonsoft.entity;

import org.springframework.data.annotation.Id;

/**
 * @author ronin
 */
public class Spit {
    @Id
    private String _id;
    private String messge;
    private String visited;

    public Spit() {
    }

    public Spit(String _id, String messge, String visited) {
        this._id = _id;
        this.messge = messge;
        this.visited = visited;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
    }

    public String getVisited() {
        return visited;
    }

    public void setVisited(String visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Spit{" +
                "_id='" + _id + '\'' +
                ", messge='" + messge + '\'' +
                ", visited='" + visited + '\'' +
                '}';
    }
}
