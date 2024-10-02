package com.study.order_management_service.member;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.join(member);
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id);
    }
}
