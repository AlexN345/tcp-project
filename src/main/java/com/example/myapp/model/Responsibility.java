package com.example.myapp.model;


// сущность обязанности
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "responsibility")
public class Responsibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "responsibility_id")
    private Long responsibilityId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "image")
    private String image;

    /*@OneToMany(mappedBy = "responsibility", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task> tasks;*/

    public Responsibility() {}
    public Responsibility(String name, String image) {
        this.name=name;
        this.image=image;
    }

    // Геттеры и сеттеры
    public Long getResponsibilityId() {
        return responsibilityId;
    }

    public void setResponsibilityId(Long responsibilityId) {
        this.responsibilityId = responsibilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /*public Set<Task> getTasks() {
        return tasks;
    }*/


    @Override
    public String toString() {
        return "Responsibility{" +
                "responsibilityId='" + responsibilityId + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}