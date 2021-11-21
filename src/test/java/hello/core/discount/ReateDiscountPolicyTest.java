package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class ReateDiscountPolicyTest {

    ReateDiscountPolicy discountPolicy = new ReateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o(){
        //given
        Member mebmer = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(mebmer, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x(){
        //given
        Member mebmer = new Member(2L, "memberVIP", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(mebmer, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }

}