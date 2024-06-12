package com.example.demo.entity;

import com.example.demo.enums.Badge;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document(collection = "User")
public class User {
    @Id
    private Long id;
    private String userName;
    private Integer Score;
    private Set<Badge> badges;

    public User(Long id, String userName) {
        this.id = id;
        this.userName = userName;
        Score = 0;
        badges = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

    public Set<Badge> getBadges() {
        return badges;
    }

    public void setBadges(Set<Badge> badges) {
        this.badges = badges;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Username='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
