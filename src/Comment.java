import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Comment {

    public Comment getParent() {
        return parent;
    }

    public Comment setParent(Comment parent) {
        this.parent = parent;
        return this;
    }

    private Comment parent = null;
    private String data;
    private LocalDate date;
    private final List<User> likes;
    private final List<User> dislikes;
    private User owner;
    private final List<Comment> comments;

    public Comment(String data) {
        this.likes = new ArrayList<>();
        this.dislikes = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.data = data;
        this.date = LocalDate.now();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getLikes() {
        return likes;
    }

    public List<User> getDislikes() {
        return dislikes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        String t = String.format("*  |- %5s сделал твит: %50s            *\r\n", owner.getName(), data);
        String t1 = "*  |-                                                                                  *\r\n";
        String t2 = String.format(
                "*  |- %10s               \uD83D\uDC4D %2d                        \uD83D\uDC4E %2d                      *",
                date.toString(), likes.size(), dislikes.size());


        return t + t1 + t2;
    }

    public static void list(List<Comment> comments) {
        for (Comment comment : comments) {
            System.out.println(comment.toString().replace("- ", dash(line(comment, 0))));
            if (!comment.getComments().isEmpty() || comment.getComments() == null) {
                list(comment.getComments());
            }
        }
    }

    private static int line(Comment comment, int i) {
        if (comment.getParent() != null) {
            line(comment.getParent(), i++);
        }
        return i;
    }

    private static String dash(int i) {
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < i + 1; j++) {
            str.append("--");
        }
        return str.toString();
    }

}
