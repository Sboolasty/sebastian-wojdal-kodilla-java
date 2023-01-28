
package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {

    private List<ForumUser> users;

    public Forum() {
        users = new ArrayList<>();
    }

    public List<ForumUser> getUserList() {
        return users;
    }


}