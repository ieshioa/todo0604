package com.green.todo.notice;

import com.green.todo.notice.model.req.NoticeListPostReq;
import com.green.todo.notice.model.req.NoticePostReq;
import com.green.todo.notice.model.res.NoticeGetRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    String getUserName(long userId);
    String getCalendarName(long calendarId);
    String getBoardName(long boardId);
    int insertNotice(NoticePostReq p);
    int insertNoticeList(NoticeListPostReq p);
    List<Long> getCalendarMember(long calendarId);
    List<NoticeGetRes> getNoticeList (long signedUserId);
}
