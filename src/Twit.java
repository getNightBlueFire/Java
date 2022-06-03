import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Twit {
    private final List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public Twit() {
        this.comments = new ArrayList<>();
    }

    public void registration(User user) {
        user.setSystem(this);
    }

    public Comment find(List<Comment> list, String data) {
        for (Comment c: list) {
            if (c.getData().equals(data))
                return c;
            for (Comment d: c.getComments()) {
                if (d.getData().equals(data))
                    return d;
                for (Comment x: d.getComments()
                     ) {
                    if (x.getData().equals(data))
                        return x;
                }
            }

        }
        return null;
    }



    @Override
    public String toString() {
        return String.format("*" + comments +
                '*');
    }

    public void board() {
        Comment.list(this.comments);
    }


}
