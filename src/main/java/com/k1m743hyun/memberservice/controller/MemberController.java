package com.k1m743hyun.memberservice.controller;

import com.k1m743hyun.memberservice.domain.dto.MemberDto;
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
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public void create(@RequestBody MemberDto requestDto) {
        memberService.join(requestDto);
    }

    @GetMapping("/{memberId}")
    public MemberDto getMember(@PathVariable String memberId) {
        return memberService.getMember(memberId);
    }

    @GetMapping
    public List<MemberDto> getMembers() {
        return memberService.getMembers();
    }
}