package com.ohgiraffers.sessionlogin.service;

import com.ohgiraffers.sessionlogin.member.dao.MemberMapper;
import com.ohgiraffers.sessionlogin.member.dto.MemberDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class MemberService {
    private final MemberMapper memberMapper;

    private final PasswordEncoder passwordEncoder;//필드에 작성하고 의존성주입

    public MemberService(MemberMapper memberMapper, PasswordEncoder passwordEncoder){//생성자 추가 ,의존성주입
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public void  joinMember(MemberDTO member){
        /*평문으로 된 비밀번호를 암호화한다. */
        member.setPwd(passwordEncoder.encode(member.getPwd()));
        /*tbl-member 테이블에 정보저장*/
        memberMapper.registMember(member);
        /*tbl_member_role 테이블에 권한 정보 저장 */
        memberMapper.addMemberAuthority();
    }
}
