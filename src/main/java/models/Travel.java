package models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Collection;

/**
 * Created by acer-pc on 07.03.2017.
 */
@Entity
@Table(name = "travels", schema = "public", catalog = "TravelDB")
public class Travel implements Serializable {
    private Integer id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String info;
    private boolean isActive;
    private Collection<Album> albums;
    private Collection<ChatTravel> chats;
    private Collection<Plan> plans;
    private Collection<PostOfTravel> posts;
    private Collection<UserToTravel> userToTravels;

    public Travel() {
    }

    public Travel(String name, Date startDate, Date endDate, String info, boolean isActive) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.info = info;
        this.isActive = isActive;

    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "travel_seq")
    @SequenceGenerator(name = "travel_seq", sequenceName = "travels_id_seq", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "start_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-M-dd")
    @Temporal(value = TemporalType.DATE )
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    @DateTimeFormat(pattern = "yyyy-M-dd")
    @Temporal(value = TemporalType.DATE )
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "info", nullable = true, length = -1)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "is_active", nullable = false)
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Travel travel = (Travel) o;

        if (id != travel.id) return false;
        if (isActive != travel.isActive) return false;
        if (name != null ? !name.equals(travel.name) : travel.name != null) return false;
        if (startDate != null ? !startDate.equals(travel.startDate) : travel.startDate != null) return false;
        if (endDate != null ? !endDate.equals(travel.endDate) : travel.endDate != null) return false;
        if (info != null ? !info.equals(travel.info) : travel.info != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        return result;
    }

    @OneToMany(mappedBy = "travel")
    public Collection<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Collection<Album> albums) {
        this.albums = albums;
    }

    @OneToMany(mappedBy = "travel")
    public Collection<ChatTravel> getChats() {
        return chats;
    }

    public void setChats(Collection<ChatTravel> chats) {
        this.chats = chats;
    }

    @OneToMany(mappedBy = "travel")
    public Collection<Plan> getPlans() {
        return plans;
    }

    public void setPlans(Collection<Plan> plans) {
        this.plans = plans;
    }

    @OneToMany(mappedBy = "travel")
    public Collection<PostOfTravel> getPosts() {
        return posts;
    }

    public void setPosts(Collection<PostOfTravel> posts) {
        this.posts = posts;
    }

    @OneToMany(mappedBy = "travel")
    public Collection<UserToTravel> getUserToTravels() {
        return userToTravels;
    }

    public void setUserToTravels(Collection<UserToTravel> userToTravels) {
        this.userToTravels = userToTravels;
    }
}
