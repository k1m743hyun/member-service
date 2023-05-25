package com.k1m743hyun.memberservice.controller;

import com.k1m743hyun.memberservice.domain.Member;
import com.k1m743hyun.memberservice.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/new")
    public void create(@RequestBody Member member) {
        memberService.join(member);
    }

    @GetMapping("/{memberId}")
    public Member one(@PathVariable String memberId) {
        return memberService.findAMember(memberId);
    }

    @GetMapping("/all")
    public List<Member> all() {
        return memberService.findMembers();
    }
}