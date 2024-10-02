package com.study.order_management_service.member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long id);
}
