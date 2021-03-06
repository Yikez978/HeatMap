package eu.standardcode.heatmap.model;
// Generated Nov 12, 2011 6:14:32 PM by Hibernate Tools 3.2.1.GA

import java.util.HashSet;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "heatmap", uniqueConstraints =
@UniqueConstraint(columnNames = "session"))
public class User implements java.io.Serializable {

    private Integer id;
    private String session;
    private long appear;
    private Set<Mouseup> mouseups = new HashSet<Mouseup>(0);
    private Set<Mousemove> mousemoves = new HashSet<Mousemove>(0);
    private Set<Mousedown> mousedowns = new HashSet<Mousedown>(0);

    public User() {
    }

    public User(String session) {
        this.session = session;
        this.appear = System.currentTimeMillis();
    }

    public User(String session, long appear, Set<Mouseup> mouseups, Set<Mousemove> mousemoves, Set<Mousedown> mousedowns) {
        this.session = session;
        this.appear = appear;
        this.mouseups = mouseups;
        this.mousemoves = mousemoves;
        this.mousedowns = mousedowns;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "session", unique = true, nullable = false, length = 45)
    public String getSession() {
        return this.session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    @Column(name = "appear", nullable = false)
    public long getAppear() {
        return this.appear;
    }

    public void setAppear(long appear) {
        this.appear = appear;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Mouseup> getMouseups() {
        return this.mouseups;
    }

    public void setMouseups(Set<Mouseup> mouseups) {
        this.mouseups = mouseups;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Mousemove> getMousemoves() {
        return this.mousemoves;
    }

    public void setMousemoves(Set<Mousemove> mousemoves) {
        this.mousemoves = mousemoves;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Mousedown> getMousedowns() {
        return this.mousedowns;
    }

    public void setMousedowns(Set<Mousedown> mousedowns) {
        this.mousedowns = mousedowns;
    }
}
