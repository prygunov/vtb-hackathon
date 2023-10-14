package ru.vtb.hackathon.entity;

import java.util.Set;

public interface Commentable {
    Set<CommentEntity> getComments();
}
