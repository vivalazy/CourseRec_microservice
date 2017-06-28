package service.models;

/**
 * Created by kennybastani on 8/17/15.
 */
public class Genre {
    String name;
    private Long id;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
