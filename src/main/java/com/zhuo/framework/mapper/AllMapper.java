package com.zhuo.framework.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhuo.framework.model.Comment;
import com.zhuo.framework.model.Post;
import com.zhuo.framework.model.Relation;
import com.zhuo.framework.model.User;

/**
 * Created by liuchen on 18/2/24.
 */
public interface AllMapper {

    @Select("select * from user where id = #{id}")
    User getUser(int id);

    @Select("select * from post where id = #{id}")
    Post getPost(int id);

    @Select("select * from post where user_id <> #{userId} order by id desc limit #{count} offset #{offset}")
    List<Post> getPostListWithPage(@Param("userId") int userId, @Param("offset") int offset, @Param("count") int count);

    @Insert("insert into post (user_id, content, img_index) values (#{post.userId},#{post.content},#{post.imgIndex})")
    int createPost(@Param("post") Post post);

    @Options(useGeneratedKeys = true, keyProperty = "comment.id")
    @Insert("insert into comment (author_id, post_id, user_id, content) values (#{comment.authorId},#{comment.postId},#{comment.userId},#{comment.content})")
    int createComment(@Param("comment") Comment comment);

    @Select("select * from comment where id = #{id}")
    Comment getComment(int id);

    @Select("select * from comment where post_id = #{postId} order by id desc")
    List<Comment> getCommentList(@Param("postId") int postId);

    @Insert("insert into relation (user_id, friend_id, status, request_comment_id) values (#{relation.userId},#{relation.friendId},#{relation.status},#{relation.requestCommentId})")
    int createRelation(@Param("relation") Relation relation);

    @Select("select * from relation where user_id = #{userId} and friendId = #{friendId}")
    Relation getSingleRelation(@Param("userId") int userId, @Param("friendId") int friendId);

    @Select("select * from relation where user_id = #{userId} and status = #{status}")
    List<Relation> getFriends(@Param("userId") int userId, @Param("status") int status);
}
