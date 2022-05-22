package com.example.prototype.Login;

import com.example.prototype.member.Member;
import com.example.prototype.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loginId, String password){
//        Optional<Member> findMember =memberRepository.findByLoginId(loginId);
//        Member member = findMember.get();
//        if()

        return memberRepository.findByLoginId(loginId)
                .filter(m->m.getPassword().equals(password))
                .orElse(null);
    }
}