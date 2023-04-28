package sk.posam.fsa.boot.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="play")
public class Play {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="play_id")
    private long Id;
@Column
    private String name;
    @JsonIgnore
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER

    )
    @JoinTable(
            name = "play_actor",
            joinColumns = @JoinColumn(name = "play_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;
    @Column
    private LocalTime duration;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    public Play() {
    }

    public Play(String name, List<Actor> actors, LocalTime duration) {
        this.name = name;
        this.actors = actors;
        this.duration = duration;
    }
    public Play(String name, LocalTime duration) {
        this.name = name;
        this.actors = new ArrayList<>();
        this.duration = duration;
    }
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addActor (Actor actor) {
        if(actor != null) {
            actors.add(actor);
        }
    }

    public List<Actor> getActors () {
        return new ArrayList<>(this.actors);
    }

    @Override
    public String toString() {
        return "Play{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", actors=" + actors +
                ", duration=" + duration +
                ", category=" + category +
                '}';
    }
}
