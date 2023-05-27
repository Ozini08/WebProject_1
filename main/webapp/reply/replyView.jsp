<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .list_cmt {
            overflow: auto;
        }
    </style>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="/css/reply.css" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(function () {
            $("#comment-input").on('input', function () {
                var text = $(this).val();
                var byteCount = calculateByteCount(text);
                $(".txt_byte").text(byteCount);
            });

            // Function to calculate the byte count of the given text
            function calculateByteCount(text) {
                var byteCount = 0;
                for (var i = 0; i < text.length; i++) {
                    var charCode = text.charCodeAt(i);
                    byteCount += (charCode > 128) ? 2 : 1;
                }
                return byteCount;
            }


            //댓글 작성(insert)
            $("button#save").click(function () {
                // 제약사항
                $("form").submit();
            });
            //답글 구현중
            $(".comment_link").click(function (){
                var commentBody = $(this).closest(".list_cmt").find(".cmt_body");
                var commentMode = commentBody.find(".comment_mode");
                var commentForm = $("<div class='comment-form'></div>");
                var textarea = $("<textarea class='tf_cmt' cols='100' rows='5' title='답글 입력' name='contents'></textarea>");
                var submitBtn = $("<button class='btn_cmt'>등록</button>");
                var parentno = commentBody.data("comment-id");

                commentForm.append(textarea, submitBtn);
                commentMode.html(commentForm);
                submitBtn.click(function (e) {
                    e.preventDefault();
                    var comentReply = commentMode.find("textarea").val().trim();
                    alert(comentReply);
                    alert(parentno);
                    $.ajax({
                        url: "${pageContext.request.contextPath}/InsertReplyComment.do",
                        type: "POST",
                        data: {cmd: 'InsertReplyComment', parentno: parentno, contents: comentReply},
                        success: function (data) {
                            location.reload();
                            <%--document.location.href = '${pageContext.request.contextPath}/Comment.do?cmd=Comment';--%>
                        },
                        error: function () {
                            console.log("답글 추가 실패");
                        }
                    });
                });
            });
            //댓글 수정(update)
            $(".edit-link").click(function (e) {
                e.preventDefault();
                var commentBody = $(this).closest(".list_cmt").find(".cmt_body");
                var editMode = commentBody.find(".edit-mode");
                var viewMode = commentBody.find(".txt_desc");
                var editLink = $(this);
                var commentNo = commentBody.data("comment-id");

                viewMode.hide();
                editMode.val(viewMode.text().trim()).show();
                editLink.hide();

                var saveLink = $("<a href='#none' class='save-link'>저장</a>").hide();
                commentBody.append(saveLink);

                saveLink.click(function (e) {
                    e.preventDefault();
                    var editedContent = editMode.find("textarea").val().trim();
                    // alert(editedContent);
                    viewMode.text(editedContent).show();
                    editMode.hide();
                    editLink.show();
                    saveLink.remove();
                    $.ajax({
                        url: "${pageContext.request.contextPath}/UpdateComment.do",
                        type: "POST",
                        data: {cmd: 'UpdateComment', commentno: commentNo, contents: editedContent},//data,
                        success: function (data) {
                            console.log(data)
                            // 서버 응답 처리
                            document.location.href = '${pageContext.request.contextPath}/Comment.do?cmd=Comment';
                            console.log("댓글 수정 성공");
                        },
                        error: function () {
                            console.log("댓글 수정 실패");
                        }
                    });
                });

                $(this).after(saveLink); // 수정 링크 다음에 저장 링크 추가

                saveLink.show();
            });
            //댓글 삭제(delete)
            $(".delete-link").click(function (e) {
                e.preventDefault();
                var commentNo = $(this).data("commentno");
                // 서버로 삭제 요청 전송
                $.ajax({
                    url: "${pageContext.request.contextPath}/DeleteComment.do",
                    type: "POST",
                    data: {
                        cmd: "DeleteComment",
                        commentno: commentNo
                    },
                    success: function (data) {
                        console.log(data);
                        // 서버 응답 처리
                        // 필요한 동작 수행
                        // console.log("댓글 삭제 성공");
                        alert("댓글 삭제 성공");
                        location.reload();
                    },
                    error: function () {
                        // console.log("댓글 삭제 실패");
                        alert("댓글 삭제 실패");
                    }
                });
            });
        });
    </script>
</head>
<body>
<!-- 덧글 div  /selectCommentList/-->
<div class="cmt_comm">
    <form action="${pageContext.request.contextPath}/InsertComment.do?cmd=InsertComment" method="post">
        <!-- enctype="multipart/form-data">-->
        <fieldset class="fld_cmt" style="width: 1000px;">
            <legend class="screen_out">댓글 작성</legend>
            <textarea id="comment-input" class="tf_cmt" cols="115" rows="5" title="한줄 토크를 달아주세요" text="한줄 토크를 달아주세요! (300자)" name="contents"></textarea>

            <button id="save" type="submit" class="btn_cmt">등록</button>
            <p class="info_append">
                <span class="screen_out">입력된 바이트 수 : </span>
                <span class="txt_byte">0</span> / 300자
                <span class="txt_bar">|</span>
                <a href="#none">댓글 운영원칙</a>
            </p>
        </fieldset>
    </form>
    <br>
    <c:forEach var="commentList" items="${selectCommentList}">
        <div class="list_cmt" style="width: 1000px; float: left; height: auto">
            <div class="cmt_head"></div>
            <div class="cmt_body" data-comment-id="${commentList.commentno}">
                <span class="info_append">
                    <span class="txt_name">${commentList.writer}</span>
                    <span class="txt_bar">|</span>
                    <span class="txt_time">${commentList.writedate}</span>
                </span>
                <p class="txt_desc" style="font-size: 14px">
                        ${commentList.contents}
                </p>
                <div class="edit-mode" style="display: none">
                    <textarea class="edit-mode" cols="90" rows="3" title="수정내용입력"
                              name="contents">${commentList.contents}</textarea>
                </div>
                <div class="comment_mode">

                </div>
            </div>
            <div class="cmt_foot" style="margin-left: -30px">
                <a href="#" class="comment_link" data-parentno="${commentList.commentno}">답글</a>
                <span class="txt_bar">|</span>
                <a href="#" class="edit-link">수정</a>
                <span class="txt_bar">|</span>
                <a href="#" class="delete-link" data-commentno="${commentList.commentno}">삭제</a>
                    <%--                <a href="#none" >삭제</a>--%>
            </div>
        </div>
    </c:forEach>
</div>
