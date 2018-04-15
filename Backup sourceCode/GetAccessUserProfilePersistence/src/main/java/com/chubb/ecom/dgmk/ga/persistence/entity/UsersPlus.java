package com.chubb.ecom.dgmk.ga.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.chubb.ecom.dgmk.ga.persistence.util.GAUserProfilePersistenceConstants;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the USERS_PLUS database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = GAUserProfilePersistenceConstants.QUERY_USER_BY_COMMON_USER_GIN, query = "SELECT usersPlus.user FROM UsersPlus usersPlus WHERE usersPlus.char6 = :commonUserGin") })
@Table(name="USERS_PLUS")
public class UsersPlus implements Serializable {
	private static final long serialVersionUID = 1L;

	private String char1;

	private String char10;

	private String char11;

	private String char12;

	private String char13;

	private String char14;

	private String char15;

	private String char16;

	private String char17;

	private String char18;

	private String char19;

	private String char2;

	private String char20;

	private String char21;

	private String char22;

	private String char23;

	private String char24;

	private String char25;

	private String char26;

	private String char27;

	private String char28;

	private String char29;

	private String char3;

	private String char30;

	private String char31;

	private String char32;

	private String char33;

	private String char34;

	private String char35;

	private String char36;

	private String char37;

	private String char38;

	private String char39;

	private String char4;

	private String char40;

	private String char5;

	private String char6;

	private String char7;

	private String char8;

	private String char9;

    @Temporal( TemporalType.DATE)
	private Date date1;

    @Temporal( TemporalType.DATE)
	private Date date2;

    @Temporal( TemporalType.DATE)
	private Date date3;

    @Temporal( TemporalType.DATE)
	private Date date4;

	private BigDecimal number1;

	private BigDecimal number2;

	private BigDecimal number3;

	private BigDecimal number4;

	private BigDecimal number5;

	private BigDecimal number6;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="PERSON_ID")
	private User user;

    public UsersPlus() {
    }

	public String getChar1() {
		return this.char1;
	}

	public void setChar1(String char1) {
		this.char1 = char1;
	}

	public String getChar10() {
		return this.char10;
	}

	public void setChar10(String char10) {
		this.char10 = char10;
	}

	public String getChar11() {
		return this.char11;
	}

	public void setChar11(String char11) {
		this.char11 = char11;
	}

	public String getChar12() {
		return this.char12;
	}

	public void setChar12(String char12) {
		this.char12 = char12;
	}

	public String getChar13() {
		return this.char13;
	}

	public void setChar13(String char13) {
		this.char13 = char13;
	}

	public String getChar14() {
		return this.char14;
	}

	public void setChar14(String char14) {
		this.char14 = char14;
	}

	public String getChar15() {
		return this.char15;
	}

	public void setChar15(String char15) {
		this.char15 = char15;
	}

	public String getChar16() {
		return this.char16;
	}

	public void setChar16(String char16) {
		this.char16 = char16;
	}

	public String getChar17() {
		return this.char17;
	}

	public void setChar17(String char17) {
		this.char17 = char17;
	}

	public String getChar18() {
		return this.char18;
	}

	public void setChar18(String char18) {
		this.char18 = char18;
	}

	public String getChar19() {
		return this.char19;
	}

	public void setChar19(String char19) {
		this.char19 = char19;
	}

	public String getChar2() {
		return this.char2;
	}

	public void setChar2(String char2) {
		this.char2 = char2;
	}

	public String getChar20() {
		return this.char20;
	}

	public void setChar20(String char20) {
		this.char20 = char20;
	}

	public String getChar21() {
		return this.char21;
	}

	public void setChar21(String char21) {
		this.char21 = char21;
	}

	public String getChar22() {
		return this.char22;
	}

	public void setChar22(String char22) {
		this.char22 = char22;
	}

	public String getChar23() {
		return this.char23;
	}

	public void setChar23(String char23) {
		this.char23 = char23;
	}

	public String getChar24() {
		return this.char24;
	}

	public void setChar24(String char24) {
		this.char24 = char24;
	}

	public String getChar25() {
		return this.char25;
	}

	public void setChar25(String char25) {
		this.char25 = char25;
	}

	public String getChar26() {
		return this.char26;
	}

	public void setChar26(String char26) {
		this.char26 = char26;
	}

	public String getChar27() {
		return this.char27;
	}

	public void setChar27(String char27) {
		this.char27 = char27;
	}

	public String getChar28() {
		return this.char28;
	}

	public void setChar28(String char28) {
		this.char28 = char28;
	}

	public String getChar29() {
		return this.char29;
	}

	public void setChar29(String char29) {
		this.char29 = char29;
	}

	public String getChar3() {
		return this.char3;
	}

	public void setChar3(String char3) {
		this.char3 = char3;
	}

	public String getChar30() {
		return this.char30;
	}

	public void setChar30(String char30) {
		this.char30 = char30;
	}

	public String getChar31() {
		return this.char31;
	}

	public void setChar31(String char31) {
		this.char31 = char31;
	}

	public String getChar32() {
		return this.char32;
	}

	public void setChar32(String char32) {
		this.char32 = char32;
	}

	public String getChar33() {
		return this.char33;
	}

	public void setChar33(String char33) {
		this.char33 = char33;
	}

	public String getChar34() {
		return this.char34;
	}

	public void setChar34(String char34) {
		this.char34 = char34;
	}

	public String getChar35() {
		return this.char35;
	}

	public void setChar35(String char35) {
		this.char35 = char35;
	}

	public String getChar36() {
		return this.char36;
	}

	public void setChar36(String char36) {
		this.char36 = char36;
	}

	public String getChar37() {
		return this.char37;
	}

	public void setChar37(String char37) {
		this.char37 = char37;
	}

	public String getChar38() {
		return this.char38;
	}

	public void setChar38(String char38) {
		this.char38 = char38;
	}

	public String getChar39() {
		return this.char39;
	}

	public void setChar39(String char39) {
		this.char39 = char39;
	}

	public String getChar4() {
		return this.char4;
	}

	public void setChar4(String char4) {
		this.char4 = char4;
	}

	public String getChar40() {
		return this.char40;
	}

	public void setChar40(String char40) {
		this.char40 = char40;
	}

	public String getChar5() {
		return this.char5;
	}

	public void setChar5(String char5) {
		this.char5 = char5;
	}

	public String getChar6() {
		return this.char6;
	}

	public void setChar6(String char6) {
		this.char6 = char6;
	}

	public String getChar7() {
		return this.char7;
	}

	public void setChar7(String char7) {
		this.char7 = char7;
	}

	public String getChar8() {
		return this.char8;
	}

	public void setChar8(String char8) {
		this.char8 = char8;
	}

	public String getChar9() {
		return this.char9;
	}

	public void setChar9(String char9) {
		this.char9 = char9;
	}

	public Date getDate1() {
		return this.date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return this.date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public Date getDate3() {
		return this.date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}

	public Date getDate4() {
		return this.date4;
	}

	public void setDate4(Date date4) {
		this.date4 = date4;
	}

	public BigDecimal getNumber1() {
		return this.number1;
	}

	public void setNumber1(BigDecimal number1) {
		this.number1 = number1;
	}

	public BigDecimal getNumber2() {
		return this.number2;
	}

	public void setNumber2(BigDecimal number2) {
		this.number2 = number2;
	}

	public BigDecimal getNumber3() {
		return this.number3;
	}

	public void setNumber3(BigDecimal number3) {
		this.number3 = number3;
	}

	public BigDecimal getNumber4() {
		return this.number4;
	}

	public void setNumber4(BigDecimal number4) {
		this.number4 = number4;
	}

	public BigDecimal getNumber5() {
		return this.number5;
	}

	public void setNumber5(BigDecimal number5) {
		this.number5 = number5;
	}

	public BigDecimal getNumber6() {
		return this.number6;
	}

	public void setNumber6(BigDecimal number6) {
		this.number6 = number6;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}