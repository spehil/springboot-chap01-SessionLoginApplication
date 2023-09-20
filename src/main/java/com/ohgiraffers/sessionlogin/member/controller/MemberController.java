package com.ohgiraffers.sessionlogin.member.controller;

import com.ohgiraffers.sessionlogin.member.dto.CustomUser;
import com.ohgiraffers.sessionlogin.member.dto.MemberDTO;
import com.ohgiraffers.sessionlogin.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
    private  final MemberService memberService;
    private  final MessageSourceAccessor messageSourceAccessor;
    public MemberController(MemberService memberService, MessageSourceAccessor messageSourceAccessor){
        this.memberService = memberService;
        this.messageSourceAccessor = messageSourceAccessor;
    }



    @GetMapping("login")
    public void  loginPage(){

    }
    @GetMapping("/mypage")
    public void mypage(@AuthenticationPrincipal CustomUser user){
        log.info("로그인 한 유저의 번호 : {}", user.getNo());
        log.info("로그인 한 유저의 이름: {}", user.getName());
        log.info("로그인 한 유저의 등록일: {}", user.getRegistDate());
    }

    @GetMapping("/join")
    public  void joinPage(){

        }
    @PostMapping("/join")
    public String memberJoin(@ModelAttribute MemberDTO member, RedirectAttributes rttr) {

        memberService.joinMember(member);

        //redirect는 다시금 요청이 발생해서 model에 담아도 소용이 없음.
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.join"));
        return "redirect:/member/login";

    }
    }

