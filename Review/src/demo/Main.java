package demo;

import java.util.ArrayList;

import entity.Member;
import service.MemberServiceImpl;

public class Main{

    public static void main(String[] args){
//        MemberServiceImpl service = new MemberServiceImpl();
		MemberServiceImpl service = MemberServiceImpl.getInstance();
        System.out.println(service.greet(2));
        System.out.println(service.getAll());
        ArrayList<Member> list = service.getAll();
        for(Member member : list){
            System.out.println(member.getId() + "," + member.getName() + "," + member.getEmail());
        }
        // 3�́E11�̉ۑ�
        System.out.println(service.sumOf(3, 5));
    }

}
