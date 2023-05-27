package com.example.controller;


import com.example.board.controller.*;
import com.example.comment.controller.*;
import com.example.scrab.controller.ScrabAddController;
import com.example.scrab.controller.ScrabDeleteController;
import com.example.scrab.controller.ScrabListController;
import com.example.user.controller.SignInController;
import com.example.user.controller.SignUpController;

public class MapperServlet {

    public static ProcessController getMapper(String cmd) {
        ProcessController processController = null;
        //================================================================
        //------------------Board Directory-------------------------------
        //================================================================
        if(cmd.equalsIgnoreCase("BoardList")){
            processController = new BoardListController("board.jsp", false);
        }
        if(cmd.equalsIgnoreCase("BoardInsert")){
//            System.out.println("MapperServlet.getMapper_____BOARDINSERT");
            processController = new BoardInsertController("BoardList.do?cmd=BoardList", true);
        }
        if (cmd.equalsIgnoreCase("BoardInfo")) {
            processController = new BoardInfoController("info.jsp", false);
        }
        if (cmd.equalsIgnoreCase("BoardDelete")) {
            processController = new BoardDeleteController("BoardList.do?cmd=BoardList", false);
        }
        if (cmd.equalsIgnoreCase("BoardModify")) {
            processController = new BoardModifyController("edit.jsp", false);
        }
        if (cmd.equalsIgnoreCase("BoardUpdate")) {
            processController = new BoardUpdateController("BoardList.do?cmd=BoardList", false);
        }
        if (cmd.equals("hit")) {
            processController = new HitController("", true);
        }
        if (cmd.equals("Good")){
            processController = new GoodController("", true);
        }
        //================================================================
        //------------------User Directory--------------------------------
        //================================================================
        if (cmd.equalsIgnoreCase("SignIn")) {
            System.out.println("signIn");
            processController = new SignInController("",true);
        }
        if (cmd.equalsIgnoreCase("SignUp")) {
            System.out.println("signUP");
            processController = new SignUpController("signup.jsp", true);
        }
        //================================================================
        //-----------------Scrab Directory------------------------------
        //================================================================
        if (cmd.equalsIgnoreCase("ScrabList")) {
            processController = new ScrabListController("mypage.jsp", false);
        }
        if (cmd.equalsIgnoreCase("ScrabAdd")) {
            processController = new ScrabAddController("ScrabList.do?cmd=ScrabList", true);
        }
        if (cmd.equalsIgnoreCase("ScrabDel")) {
            processController = new ScrabDeleteController("ScrabList.do?cmd=ScrabList", true);
        }
        //================================================================
        //-----------------Comment Directory------------------------------
        //================================================================
        if (cmd.equalsIgnoreCase("Comment")) {
//            System.out.println("mapperServlet");
            processController = new CommentListController("reply/replyView.jsp", false);
        }
        if(cmd.equalsIgnoreCase("InsertComment")){
            processController = new CommentInsertController("Comment.do?cmd=Comment", true);
        }
        if (cmd.equalsIgnoreCase("UpdateComment")) {
//            System.out.println("------MapperServlet.getMapper(UpdateComment)------");
            processController = new CommentUpdateController("Comment.do?cmd=Comment",true);
        }
        if (cmd.equalsIgnoreCase("DeleteComment")) {
            processController = new CommentDeleteController("Comment.do?cmd=Comment", true);
        }
        if (cmd.equalsIgnoreCase("InsertReplyComment")) {
            processController = new ReplyCommentInsertController("Comment.do?cmd=Comment", true);
        }

        return processController;
    }

}
