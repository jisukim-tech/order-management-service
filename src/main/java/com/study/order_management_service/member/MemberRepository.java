package com.study.order_management_service.member;

public interface MemberRepository {
    void join(Member member);
    Member findById(Long id);
}
