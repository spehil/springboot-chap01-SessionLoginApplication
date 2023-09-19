package com.ohgiraffers.sessionlogin.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class MemberDTO {
    private int no;
    private String id;
    private String pwd;
    private String tempPwdYn;
    private Date pwdChangeDatetime;
    private String pwdExpDate;
    private String name;
    private Date registDatetime;

    /*MemberRole을 참조하기위한 필드 작성 하나의 Member는 여러개의 MemberRole을 가질수있다*/
    /*한 멤버는 여러 권한을 가질수 있다.*/
    private List<MemberRoleDTO> memberRoleList;



}
