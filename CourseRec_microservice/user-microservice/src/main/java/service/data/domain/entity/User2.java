package service.data.domain.entity;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.*;

import java.io.Serializable;
import java.util.Set;

@NodeEntity
public class User2 implements Serializable {
    
	private static final long serialVersionUID = -100759321281659379L;

	@GraphId
	Long id;

    private String password;
	private String age;
	private String gender;
	private String occupation;
	private String zipcode;

	public User2() { }

	@Fetch
	@RelatedTo(type = "FOLLOWS", direction = Direction.OUTGOING, elementClass = User2.class)
	Set<User2> follows;

	@Fetch
	@RelatedTo(type = "FOLLOWS", direction = Direction.INCOMING, elementClass = User2.class)
	Set<User2> followers;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Long getId() {
		return id;
	}

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User2 user2 = (User2) o;

        if (id != null ? !id.equals(user2.id) : user2.id != null) return false;
        if (age != null ? !age.equals(user2.age) : user2.age != null) return false;
        if (gender != null ? !gender.equals(user2.gender) : user2.gender != null) return false;
        if (occupation != null ? !occupation.equals(user2.occupation) : user2.occupation != null) return false;
        if (zipcode != null ? !zipcode.equals(user2.zipcode) : user2.zipcode != null) return false;
        if (follows != null ? !follows.equals(user2.follows) : user2.follows != null) return false;
        return !(followers != null ? !followers.equals(user2.followers) : user2.followers != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (occupation != null ? occupation.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (follows != null ? follows.hashCode() : 0);
        result = 31 * result + (followers != null ? followers.hashCode() : 0);
        return result;
    }
}
