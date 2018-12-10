package com.zhuo.framework.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhuo.framework.mapper.AllMapper;
import com.zhuo.framework.model.Chat;
import com.zhuo.framework.model.Comment;
import com.zhuo.framework.model.FriendStatus;
import com.zhuo.framework.model.Post;
import com.zhuo.framework.model.Relation;
import com.zhuo.framework.model.Result;
import com.zhuo.framework.model.User;

/**
 * @author liuchen <liuchen03@kuaishou.com>
 * Created on 2018-12-07
 */
@Controller
@RequestMapping("/")
public class AllController {

    @Autowired
    private AllMapper allMapper;

    @RequestMapping("/user/get")
    @ResponseBody
    public Object getUser(@RequestParam("id") int id) {
        Map<String, Object> map = Result.success();
        map.put("result", allMapper.getUser(id));
        return map;
    }

    @RequestMapping("/post/add")
    @ResponseBody
    public Object addPost(@RequestParam("userId") int userId,
                          @RequestParam("content") String content,
                          @RequestParam("imgIndex") int imgIndex) {
        Post post = Post.fromRaw(userId, content, imgIndex);
        allMapper.createPost(post);
        return Result.success();
    }

    @RequestMapping("/post/get")
    @ResponseBody
    public Object getPost(@RequestParam("id") int id) {
        return Result.successWithData(allMapper.getPost(id));
    }

    @RequestMapping("/post/list")
    @ResponseBody
    public Object getPost(@RequestParam("userId") int userId,
                          @RequestParam("page") int page,
                          @RequestParam("pageSize") int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (page <= 0) {
            page = 1;
        }
        int offset = (page - 1) * pageSize;
        map.put("list", allMapper.getPostListWithPage(userId, offset, pageSize));
        map.put("pageSize", pageSize);
        return Result.successWithData(map);
    }

    @RequestMapping("/comment/add")
    @ResponseBody
    public Object addComment(@RequestParam("postId") int postId,
                             @RequestParam("content") String content,
                             @RequestParam("userId") int userId) {
        int authorId = allMapper.getPost(postId).getUserId();
        Comment comment = Comment.fromRaw(authorId, postId, userId, content);
        allMapper.createComment(comment);
        int commentId = comment.getId();
        try {
            Relation relation = Relation.fromRaw(authorId, userId, FriendStatus.REQUEST.getValue(), commentId);
            allMapper.createRelation(relation);
        } catch (Exception e) {
            System.out.println("exist values.");
        }
        return Result.success();
    }

    @RequestMapping("/comment/list")
    @ResponseBody
    public Object getCommentList(@RequestParam("postId") int postId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", allMapper.getCommentList(postId));
        return Result.successWithData(map);
    }

    @RequestMapping("/comment/get")
    @ResponseBody
    public Object getComment(@RequestParam("id") int id) {
        return Result.successWithData(allMapper.getComment(id));
    }

    @RequestMapping("/chat/list")
    @ResponseBody
    public Object getChatList(@RequestParam("userId") int userId) {
        List<Relation> list = allMapper.getFriends(userId, FriendStatus.REQUEST.getValue());
        List<Chat> chatList = list.stream().map(relation -> {
            Comment comment = allMapper.getComment(relation.getRequestCommentId());
            User user = allMapper.getUser(comment.getUserId());
            return Chat.fromCommentAndUser(user, comment, false);
        }).collect(Collectors.toList());
        for (int i = 5; i < 15; i++) {
            Comment comment = Comment.fromRaw(userId, userId, i, "你好呀");
            comment.setRead(true);
            comment.setCreateTime(new Date());
            User user = allMapper.getUser(comment.getUserId());
            chatList.add(Chat.fromCommentAndUser(user, comment, true));
        }
        return Result.successWithData(chatList);
    }


    @RequestMapping("/relation/getFriends")
    @ResponseBody
    public Object getFriends(@RequestParam("userId") int userId) {
        /*
        return Result.successWithData(allMapper.getFriends(userId, ));
        */
        return null;
    }
}
