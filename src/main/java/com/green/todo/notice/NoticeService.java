package com.green.todo.notice;

import com.green.todo.notice.model.NoticeContent;
import com.green.todo.notice.model.req.NoticeListPostReq;
import com.green.todo.notice.model.req.NoticePostReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper mapper;
    NoticeContent contents = new NoticeContent();
    public void newMemberNotice(long calendarId, long newUserId) {
        contents.setCalendarName(mapper.getCalendarName(calendarId));
        contents.setNewUserName(mapper.getUserName(newUserId));
        
        NoticePostReq p1 = new NoticePostReq();
        p1.setCalendarId(calendarId);
        p1.setContent(contents.getNewMemToOther());
        mapper.insertNotice(p1);
        List<Long> member = mapper.getCalendarMember(calendarId);
        for(long mem : member) {
            NoticeListPostReq p = new NoticeListPostReq(p1.getNoticeId(), mem);
            mapper.insertNoticeList(p);
        }

        NoticePostReq p2 = new NoticePostReq();
        p2.setCalendarId(calendarId);
        p2.setContent(contents.getNewMemToOne());
        mapper.insertNotice(p2);  // 초대당한 사람한테 보내기
        NoticeListPostReq p = new NoticeListPostReq(p2.getNoticeId(), newUserId);
        mapper.insertNoticeList(p);
    }
}
