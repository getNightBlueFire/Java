import java.time.LocalDate;
import java.util.List;

public class User {

    private Twit system;
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Twit getSystem() {
        return system;
    }

    public void setSystem(Twit system) {
        this.system = system;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void add(Comment comment) {
        comment.setOwner(this);
        system.getComments().add(comment);
    }

    public void add(String from, String to) {
        Comment comment = new Comment(from);
        comment.setOwner(this);
        Comment parent = system.find(system.getComments(), to);
        comment.setParent(parent);
        parent.getComments().add(comment);

    }

    public void edit(String from, String to) {
        Comment comment = system.find(system.getComments(), from);
        comment.setData(to);
        comment.setDate(LocalDate.now());
    }

    public void like(String data) {
        List<User> likes = system.find(system.getComments(), data).getLikes();
        clickOn(likes);
    }

    public void dislike(String date) {
        List<User> dislikes = system.find(system.getComments(), date).getDislikes();
        clickOn(dislikes);
    }

    private void clickOn(List<User> list) {
        if (list.contains(this)) {
            list.remove(this);
        } else {
            list.add(this);
        }
    }
}
